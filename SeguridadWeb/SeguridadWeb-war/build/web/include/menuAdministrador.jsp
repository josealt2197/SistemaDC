<%-- 
    Document   : menu
    Created on : 25/06/2015, 01:12:47 PM
    Author     : barce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/include/config.jsp" %>
<!DOCTYPE html>
<html>
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <div id="cssmenu">
            <ul>
                <%-- Principal--%>
                <li class='active'><html:a action="principal!ir"><span><html:text name="etiqueta.general.principal"/></span></html:a></li>
                <%--Fin Principal--%>
                <%--Mantenimientos--%>
                <li class='has-sub'><a href="#"><span><html:text name="etiqueta.general.mantenimientos"/></span></a>
                    <ul>
                        <li><html:a action="mantenUsuarios!listarUsuarios"><span><html:text name="etiqueta.general.usuarios"/></span></html:a></li>
                        <%--<li><html:a action="mantenTiposUsuario!listarTiposUsuario"><span><html:text name="etiqueta.mantenimientos.tiposUsuario"/></span></html:a></li>--%>
                        <li><html:a action="mantenPerfiles!listarPerfiles"><span><html:text name="etiqueta.mantenimientos.perfiles"/></span></html:a></li>
                        <li><html:a action="mantenFuncionarios!listarUsuarios"><span><html:text name="etiqueta.mantenimientos.usuarios"/></span></html:a></li>
                        <li><html:a action="mantenPermisos!listarPermisos"><span><html:text name="etiqueta.mantenimientos.permisos"/></span></html:a></li>
                    </ul>
                </li>
                <%--Fin Mantenimientos--%>
                <%--Tasa de equilibrio--%>
                <li class='has-sub'><a href="#"><span><html:text name="etiqueta.general.tasaEquilibrio"/></span></a>
                     <ul>
                         <li><html:a action="DC.common.TasaEquilibrioAction!ir"><span><html:text name="etiqueta.general.tasaEquilibrioCalculo"/></span></html:a></li>
                         <li><html:a action="mantenRentabilidad!listarhistoricoRentabilidad"><span><html:text name="etiqueta.mantenimientos.rentabilidadInversiones"/></span></html:a></li>
                             
                    </ul>
                </li>
                 <%--Fin  Tasa de equilibrio--%>
                 <%--Ayuda--%>
                <li class='active'><html:a href="#"><span><html:text name="etiqueta.general.ayuda"/></span></html:a>   
                    <ul class="navigation-3">
                        <li><html:a href="ayuda/Manual.pdf"><span><html:text name="etiqueta.general.ayuda.manual"/></span></html:a></li>
                    </ul>
                </li>
                <%--Fin Ayuda--%>
            </ul>
        </div>
    </body>
</html>

