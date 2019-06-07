package SSW.common;

/**
 *
 * @author mrodriguez
 */

import com.opensymphony.xwork2.ActionContext;
import java.sql.Connection;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.struts2.ServletActionContext;

public class GenerarReporte {

    public static byte[] GenerarReporte(Map parametros, String nom_report) {
        byte[] fichero = null;
        String context = ServletActionContext.getRequest().getScheme() + "://" + ServletActionContext.getRequest().getServerName() + ":" + String.valueOf(ServletActionContext.getRequest().getServerPort()) + ServletActionContext.getRequest().getContextPath();
        try {
            Map session = ActionContext.getContext().getSession();
            parametros.put("P_IMAGEN", context + AppConstants.RUTA_IMAGEN);
            parametros.put("P_USUARIO", session.get("usuario"));
            parametros.put("SUBREPORT_DIR", context + "/reportes/jasper/");
            System.out.println("Ruta: " + context + "/reportes/jasper/" + nom_report + ".jasper");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromLocation(context + "/reportes/jasper/" + nom_report + ".jasper");
            Connection conn = getSLW().getConnection();
            fichero = JasperRunManager.runReportToPdf(jasperReport, parametros, conn);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conn);
            System.out.println("Informe creado..." );
            conn.close();
        } catch (Exception e) {
            System.out.println("Error Generar Reporte: " + e);
        }
        return fichero;
    }
    
    public static void GenerarReporteExcel(HttpServletResponse response, Map parametros, String nom_report) throws ServletException {
        byte[] fichero = null;
        JRXlsExporter exporter = new JRXlsExporter();
        String context = ServletActionContext.getRequest().getScheme() + "://" + ServletActionContext.getRequest().getServerName() + ":" + String.valueOf(ServletActionContext.getRequest().getServerPort()) + ServletActionContext.getRequest().getContextPath();
        try {
            Map session = ActionContext.getContext().getSession();
            parametros.put("P_IMAGEN", context + AppConstants.RUTA_IMAGEN);
            parametros.put("P_USUARIO", session.get("usuario"));
            System.out.println("Ruta: " + context + "/reportes/jasper/" + nom_report + ".jasper");
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromLocation(context + "/reportes/jasper/" + nom_report + ".jasper");
            Connection conn = getSLW().getConnection();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, conn);
            conn.close();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "inline; filename=\"ReporteFormatoExcel.xls\"");
            ServletOutputStream ouputStream = response.getOutputStream();
            exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
            //exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
            exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_GRAPHICS, Boolean.TRUE);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
            exporter.exportReport();
            System.out.println("Excel creado..." );
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ServletException(ex);
        }
    }

    private static DataSource getSLW() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("jdbc/saw");
    }
}
