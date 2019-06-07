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
                <li class='active'><html:a action="principal!ir"><span><html:text name="etiqueta.general.principal"/></span></html:a></li>             
                <li class='active'><html:a href="#"><span><html:text name="etiqueta.general.ayuda"/></span></html:a>
                    <ul class="navigation-3">
                        <li><html:a href="ayuda/Manual.pdf"><span><html:text name="etiqueta.general.ayuda.manual"/></span></html:a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </body>
</html>

