<%-- 
    Document   : TasaEquilibrio
    Created on : 26/04/2019, 11:22:57 AM
    Author     : julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
        <link rel="stylesheet" type="text/javascript" href="js/jquery-iu.js" />
    </head>
    <body>
        <div id="encabezado">
            <%@ include file="/include/encabezado.jsp"%>
        </div>
        <div id="principalContenedor">
            <div id='cssmenu' style='background: #009bdd'>
                <html:set name="menu" value="#session.menu"/>
                <html:if test="%{#menu!=null}">
                    <jsp:include page="${menu}" flush="true"/>
                </html:if>       
            </div>   
            <div id="alertasContenedor">
                <div class="message"><html:actionmessage/></div>
                <div class="error"><html:actionerror/></div>
            </div>
            <div id="ContenedorForm">
                <h4 class="subtitulos">
                    <html:text name="etiqueta.general.tasaEquilibrio"/><br>
                    <html:text name="etiqueta.general.tasaEquilibriocalculo"/><br>
                </h4>
                <p>&nbsp;</p>
           
                <div align="center" style="top:200%; ">
                    <html:form action = "!" method ="post" cssClass="user">
                        <form>
                            <div class="form-group">
                                
                                <h3 class="subtitulos"><html:text name="Cualquier otro ingreso, egreso, gasto (Ω)"/></h3><br> 
                                <input name="Cualquier_Egreso" type="number"  step="0.02"  min="1" placeholder="Cualquier otro ingreso, egreso, gasto (Ω)"<span></span>  
                               
                            </div>
                            <p>&nbsp;</p>
                            <div align="center" class="form-group">
                                <h3 class="subtitulos"><html:text name="Resultado"/></h3>
                                <input name="Tasa_quilibrio" type="text"  step="0.02"  min="1" placeholder="Tasa de equilibrio" readonly="true"/>
                                <button type="Calcular" class="btn btn-info btn-lg" >Calcular</button><button type="submit" class="btn btn-info btn-lg" >Guardar</button> 
                            </div>
                        </form>
                    </html:form>
                </div>
                <div style="top:500px; float:left; width:100%; left:0; right:0;">
                    <br /><%@ include file="/include/footer.jsp" %>
                </div>
            </div>
    </body>
</html> 
