
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Perfiles</title>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
        <link rel="stylesheet" type="text/javascript" href="js/jquery-iu.js" />

    </head>
    <body>
        <div id="encabezado">
            <%@ include file="/include/encabezado.jsp"%>
            <html:url var="contexto" value="/"/>
            <jq:head locale="es" jqueryui="true" jquerytheme="mytheme" customBasepath="%{contexto}template/themes" />
        </div>
        <div id="principalContenedor">
            <div id='cssmenu' style='background: #009bdd'>
                <html:set name="menu" value="#session.menu"/>
                <html:if test="%{#menu!=null}">
                    <jsp:include page="${menu}" flush="true"/>
                </html:if>       
            </div> 

            <div class="card tablaListado" style="border: none;">
                <div class="card-header"  style="background-color: white; border: none;">
                    <h1 class="subtitulos text-center font-weight-bold py-4"><html:text name="etiqueta.mantenimientos.permisos"/></h1>
                </div>
                <div id="alertasContenedor">
                    <div class="message"><html:actionmessage/></div>
                    <div class="error"><html:actionerror/></div>
                </div>
                <div class="card-body">

                    <div class="row">
                        <div class="col-md-6 text-left">
                            <button class="btn btn-success badge-pill" data-toggle="modal" data-target="#agregar"  style="background-color:#1c94c4; border-color: #1c94c4;">
                                Agregar Permiso</button>
                        </div>

                        <div class="col-md-6 text-right">
                            <html:form action="mantenPerfiles!listarPermisos" method ="post" cssClass="user">
                                <button class="btn btn-success badge-pill" type="submit" style="background-color:#babe0e; border-color: #babe0e; float:right;">
                                    Actualizar Lista</button>
                                </html:form>

                        </div>
                    </div>
                    <br>
                    <table id="example" class="table table-bordered text-center">
                        <thead>
                            <tr>
                                <th hidden="hidden">ID Permiso</th>
                                <th>Sistema</th>
                                <th>Perfiles de Usuario</th>
                                <th>Privilegio</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <html:iterator  value="listaPermisos" var="lista" status="estado" >
                                <tr>
                                    <td hidden="hidden"><html:property value="pkIdePermiso"/></td>
                                    <td><html:property value="fkDcmSistema.nomSistema" /></td>  
                                    <td><html:property value="fkDcmPerfil.nomPerfil" /></td> 
                                    <td><html:property value="fkDcmPrivilegio.nomPrivilegio" /></td> 
                                    <td class="text-rght">
                                        <html:form action = "mantenPermisos!eliminarPermiso" method ="post" cssClass="user">
                                            <input type="text" class="form-control" hidden="hidden" name="idPermisoEliminar" value='<html:property value="pkIdePermiso"/>'>
                                            <button type="submit" class="btn btn-danger badge-pill" style="width:90px" >Eliminar</button>
                                            <button 
                                                type="button"
                                                style="width:90px;" class="btn btn-warning badge-pill" 
                                                data-toggle="modal" data-target="#editar" 
                                                onclick="CargarPermisoModal()">Modificar
                                            </button> 
                                        </html:form>  

                                    </td>
                                </tr>

                            </html:iterator>
                        </tbody>
                    </table>
                </div>
            </div>

            <%@ include file="/include/footer.jsp" %>
        </div>

    </body>
</html>
