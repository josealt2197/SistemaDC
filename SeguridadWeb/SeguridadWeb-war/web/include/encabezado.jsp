<%-- 
    Document   : encabezado
    Created on : 25/06/2015, 01:12:47 PM
    Author     : barce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="/include/config.jsp" %>
<script type="text/javascript">
    $(document).ready(function () {
        window.onunload = function () {};
        var url = "salir";

        $.ajax({
            type: 'GET',
            cache: false,
            url: url + "!Verificar_Sesion",
            dataType: 'text',
            success: function (resultado) {
                if (resultado == "cerrar")
                    parent.location.href = url;
            }, error: function (xhr, ajaxOptions, thrownError) {
                alert(xhr.responseText);
            }
        });
    });
</script>
<body>
    <!-- jsalazar div style="background-image: url(images/barra_top.png);"-->
    <div style="padding:1%; background-color: #00508d;">
        <center>
            <table style="width: 80%; color: #FFFFFF; font: xx-large serif">
                <tr>
                    <td style="width: 200px"><img src="images/logo_infocoop.png" alt="logo"></td>
                    <td style="font-family:'Verdana'; font-size: 15px; text-align: right;"><div><html:text name="etiqueta.general.titulo"/></div></td>
                    <td>
                        <html:if test="%{#session.nomUsuario==null}">  
                            <script>
                                window.location = "salir";
                            </script>
                        </html:if>
                        <html:else>
                            <div style=" font-family:'Verdana'; font-size: 14px; text-align: right;">
                                <html:property value="#session.nomUsuario"/>,
                                <html:property value="#session.desTipoUsuario" />
                            </div>
                        </html:else>
                    </td>
                    <td>
                        <div style="width: 50px; float:right;">
                            <html:a action="salir">
                                <img src="images/salir.png" alt="" id="logoSalir"/>
                            </html:a>
                        </div>
                    </td>
                </tr>
            </table>
        </center>
    </div>
</body>

