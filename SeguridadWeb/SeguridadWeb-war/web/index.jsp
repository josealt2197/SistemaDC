<%-- 
    Document   : index
    Created on : 25/06/2015, 10:48:00 AM
    Author     : barce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Asistencia Web</title>
    </head>
    <body>
        <div id="encabezado">
            <%@ include file="/include/encabezadoLogin.jsp"%>  
        </div>
        <div id="principalContenedor">
            <div id='cssmenu' style='background: #009bdd'>
               <br>
            </div>  
            <div id="alertasIngreso" align="center">
                <div class="message"><html:actionmessage/></div>
                <div class="error"><html:actionerror/></div>
            </div>
            <div id="centrarLogin">        
                <html:form action="ingresar">
                    <h5 class="subtitulos"><html:text name="etiqueta.general.titulo"/></h5>
                    <p id="textoLogin"><html:text name="etiqueta.login.usuario"/>
                        <html:textfield name="usuario" cssClass="textboxLogin"/>
                        <html:text name="etiqueta.login.clave"/>
                        <html:password name="clave" cssClass="textboxLogin"/>
                        <html:submit value="Ingresar" cssClass="textboxLogin" onclick="show();"/>
                    </p>
                </html:form> 
            </div>
            <div style="top:500px; position: absolute; left:0; right:0;">
                <%@ include file="/include/footer.jsp" %>
            </div>
        </div>
    </body>
</html>