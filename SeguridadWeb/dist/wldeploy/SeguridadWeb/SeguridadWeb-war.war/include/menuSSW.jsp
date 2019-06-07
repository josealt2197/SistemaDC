<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/include/config.jsp" %>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
    <center>
        <div id="cssmenu">
            <ul>
                <%-- Principal--%>
                <li class='active'><html:a action="principal!ir"><span><html:text name="etiqueta.general.principal"/></span></html:a></li>
                        <%--Fin Principal--%>
                        <%--Mantenimientos--%>
                <li><html:a href="#"><span><html:text name="etiqueta.menu.usuarios"/></span></html:a>
                    <ul>
                        <li><html:a action="mantenFuncionarios!listarUsuarios"><span><html:text name="etiqueta.general.usuarios"/></span></html:a></li>
                        
                    </ul>
                </li>
                <li><html:a action="mantenPerfiles!listarPerfiles"><span><html:text name="etiqueta.menu.perfiles"/></span></html:a></li>
                <li><html:a action="mantenPermisos!listarPermisos"><span><html:text name="etiqueta.menu.permisos"/></span></html:a></li>
                        <%--Fin Mantenimiento--%>
            </ul>
        </div>
    </center>
</body>
</html>

