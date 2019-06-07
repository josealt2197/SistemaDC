<%-- 
    Document   : principal
    Created on : 25/06/2015, 01:12:47 PM
    Author     : barce
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
                <h4 class="subtitulos"></h4>
                <html:text name="etiqueta.general.titulo"/><br>
                <html:text name="etiqueta.general.infocoop"/><br>

                <br>

                <html:form action="ingresar">
                    <p id="textoLogin">
                        <html:text name="Tasa Básica Diaria:"/>
                        <html:textfield name="tipoCambio" cssClass="textboxLogin"/>
                        <html:text name="IPC:"/>
                        <html:textfield name="ipc" cssClass="textboxLogin"/>
                    </p>
                </html:form> 

                <table border="0" align="center">
                    <tr>
                        <td>Logos<td>
                    </tr>
                    <tr>
                        <td style="background-color: #00508d"><img src="images/logo_infocoop.png" style="width: 200px; "alt="logo"><td>
                        <td><img src="images/logo_infocoop2.jpg" style="width: 200px;" alt="logo"><td>
                    </tr>
                    <tr><td><br><br></td></tr>
                    <tr>
                        <td>Colores<td>
                    </tr>
                    <tr>
                        <td style="background-color: #00508d; color:#ffffff ">#00508d<td>
                        <td style="background-color: #009bdd; color:#ffffff ">#009bdd<td>
                    </tr>
                    <tr>
                        <td style="background-color: #1c94c4; color:#ffffff ">#1c94c4<td>
                        <td style="background-color: #d1eef9; color:#000000 ">#d1eef9<td>
                    </tr>
                    <tr>
                        <td style="background-color: #dddddd; color:#000000 ">#dddddd<td>
                        <td style="background-color: #babe0e; color:#000000 ">#babe0e<td>

                    </tr>

                </table>


            </div>

            <div style="top:500px; float:left; width:100%; left:0; right:0;">
                <br /><%@ include file="/include/footer.jsp" %>
            </div>
        </div>
    </body>
</html> 
