
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Usuarios</title>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
        <link rel="stylesheet" type="text/javascript" href="js/jquery-iu.js" />

        <script type="text/javascript">
            function CargarUsuarioModal(id, nomUsuario, perfil, estado) {
                $("#idUsuario").val(id);
                $("#nomUsuario").val(nomUsuario);
                $("#perfilSelect").val(perfil);
                $("#estadoSelect").val(estado);
            }
        </script>

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
                    <h1 class="subtitulos text-center font-weight-bold py-4"><html:text name="etiqueta.mantenimientos.usuarios"/></h1>
                </div>
                <div id="alertasContenedor">
                    <div class="message"><html:actionmessage/></div>
                    <div class="error"><html:actionerror/></div>
                </div>

                <div class="card-body">

                    <div class="row">
                        <div class="col-md-6 text-rght">
                            <button class="btn btn-success badge-pill" data-toggle="modal" data-target="#agregar"  style="background-color:#1c94c4; border-color: #1c94c4;">
                                Agregar Usuario</button>
                        </div>
                        <div class="col-md-6 text-rght">
                            <html:form action="mantenFuncionarios!listarUsuarios" method ="post" cssClass="user">
                                <button class="btn btn-success badge-pill" type="submit" style="background-color:#babe0e; border-color: #babe0e; float:right;">
                                    Actualizar Lista</button>
                                </html:form>                                         
                        </div>
                    </div>
                    <br>
                    <table id="example" class="table table-bordered text-center">
                        <thead>
                            <tr>
                                <th hidden="hidden">ID Funcionario</th>
                                <th>Nombre Funcionario</th>
                                <th>Usuario</th>
                                <th>Perfil</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <html:iterator  value="listaUsuarios" var="lista" status="estado" >
                                <tr>
                                    <td hidden="hidden"><html:property value="pkIdeFuncionario"/></td>
                                    <td id="nombreusu"><html:property value="nomFuncionarios"/></td>
                                    <td><html:property value="nomUsuario" /></td>
                                    <td><html:property value="fkDcmPerfil.nomPerfil" /></td> 
                                    <td><html:property value="fkDcmEstado.nomEstado" /></td> 
                                    <td class="text-rght">

                                        <html:form action = "mantenFuncionarios!eliminarUsuario" method ="post" cssClass="user">
                                            <input type="text" class="form-control" hidden="hidden" name="idUsuarioEliminar" value='<html:property value="pkIdeFuncionario"/>'>
                                            <button type="submit" class="btn btn-danger badge-pill" style="width:110px" > Eliminar</button>
                                            <%--<html:param name="idUsuarioEliminar" value="pkIdeFuncionario"  />--%>
                                            <button 
                                                type="button"
                                                style="width:110px;" class="btn btn-warning badge-pill" 
                                                data-toggle="modal" data-target="#editar" 
                                                onclick="CargarUsuarioModal('<html:property value="pkIdeFuncionario"/>', '<html:property value="nomUsuario"/>', '<html:property value="fkDcmPerfil.nomPerfil"/>', '<html:property value="fkDcmEstado.nomEstado"/>')" >
                                                Modificar                                     
                                            </button>  
                                        </html:form>

                                    </td>
                                </tr>
                            </html:iterator>     
                        </tbody>
                    </table>

                </div>
            </div>

            <!-- Modal p/AGREGRAR-->
            <div class="modal fade" id="agregar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Usuario</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="width:50px;">
                                <span class="xclose" style="width:24px;" aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <html:form action = "mantenFuncionarios!agregarUsuario" method ="post" cssClass="user">
                                <form>
                                    <div class="form-group">
                                        <label for="NombreFuncionario">Nombre</label>
                                        <input type="text" class="form-control" name="Input_nomFuncionario" placeholder="Nombre Completo" required oninvalid="setCustomValidity('Este campo es requerido')" onchange="try {
                                                    setCustomValidity('')
                                                } catch (e) {
                                                }">
                                    </div>
                                    <div class="form-group">
                                        <label for="NombreUsuario">Usuario</label>
                                        <input type="text" class="form-control" name="Input_nomUsuario" placeholder="Usuario" required oninvalid="setCustomValidity('Este campo es requerido')" onchange="try {
                                                    setCustomValidity('')
                                                } catch (e) {
                                                }">
                                    </div>
                                    <div class="form-group">
                                        <label for="Sistema">Sistema</label>
                                        <html:select id="cbSistema" name="Cb_Sistema"    
                                                     list="%{listaSistemas}"
                                                     listKey="pkIdeSistema"
                                                     listValue="nomSistema"tabindex="0"
                                                     cssClass="form-control" 
                                                     onchange="cargarPerfiles()"
                                                     required="required" oninvalid="setCustomValidity('Este campo es requerido')" 
                                                     onchange="try{setCustomValidity('')}catch(e){}"/>
                                    </div>  

                                    <div class="form-group">
                                        <label for="PerfilUsuario">Perfil de Usuario</label>
                                        <html:select id="cbPerfil" name="Cb_Perfil" 
                                                     list="%{listaPerfiles}"
                                                     listKey="pkIdePerfil"
                                                     listValue="nomPerfil"tabindex="0"
                                                     cssClass="form-control" 
                                                     required="required" oninvalid="setCustomValidity('Este campo es requerido')" 
                                                     onchange="try{setCustomValidity('')}catch(e){}"/>
                                    
                                    </div> 

                                    <div class="form-group">
                                        <label for="Estado">Estado</label>
                                        <html:select id="cbEstado" name="Cb_Estado" 
                                                     list="%{listaEstados}"
                                                     listKey="pkIdeEstado"
                                                     listValue="nomEstado"tabindex="1"
                                                     cssClass="form-control" 
                                                     required="required" oninvalid="setCustomValidity('Este campo es requerido')" onchange="try{setCustomValidity('')}catch(e){}"/>                             
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Volver</button>
                                        <button type="submit" class="btn btn-primary" style="background-color:#009bdd; border-color: #009bdd;" >Guardar</button>
                                    </div>
                                </form>
                            </html:form>
                        </div>


                    </div>
                </div>
            </div>
            <!--FIN Modal p/AGREGRAR-->


            <!-- Modal p/EDITAR-->
            <div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modificar Usuario</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="width:50px;">
                                <span class="xclose" style="width:24px;" aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <html:form action = "mantenFuncionarios!editarUsuario" method ="post" cssClass="user">
                                <form>
                                    <div class="form-group" >
                                        <label for="Labelnombre" hidden="hidden">ID</label>
                                        <input type="text" hidden="hidden" class="form-control" id="idUsuario" name="idUsuarioModificar" value="<html:property value="ideUsuario"/>">
                                    </div>
                                    <div class="form-group">
                                        <label for="Labelnombre">Nombre de Usuario</label>
                                        <input type="text" class="form-control"  id="nomUsuario" name="nomUsuarioModificar"  placeholder="Nombre Completo"  required>
                                    </div>
                                    <div class="form-group">
                                        <label for="Sistema">Sistema</label>
                                        <select class="custom-select" id="sistemaSelect" name="select_Sistema">
                                            <html:iterator  value="listaSistemas" var="lista" status="estado" >
                                                <option value="<html:property value="pkIdeSistema"/>"  ><html:property value="nomSistema" /></option>
                                            </html:iterator>   
                                        </select>
                                    </div>   

                                    <div class="form-group">
                                        <label for="PerfilUsuario">Perfil de Usuario</label>
                                        <select class="custom-select" id="perfilSelect" name="select_Perfil">
                                            <html:iterator  value="listaPerfiles" var="lista" status="estado" >
                                                <option value="<html:property value="pkIdePerfil"/>"  ><html:property value="nomPerfil" /></option>
                                            </html:iterator>   
                                        </select>
                                    </div>

                                    <div class="form-group">
                                        <label for="Estado">Estado</label>
                                        <select class="custom-select" id="estadoSelect" name="select_Estado">
                                            <html:iterator  value="listaEstados" var="lista" status="estado" >
                                                <option value="<html:property value="pkIdeEstado"/>"  ><html:property value="nomEstado" /></option>
                                            </html:iterator>   
                                        </select>                                   
                                    </div> 
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Volver</button>
                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                    </div>
                                </form>
                            </html:form>
                        </div>
                    </div>
                </div>
            </div>
            <!--FIN Modal p/Editar-->
            <br>

            <%@ include file="/include/footer.jsp" %>
        </div>

        <script type="text/javascript">
            $(document).ready(function () {
                $('#example').DataTable({
                    "language": {
                        "url": "//cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json"
                    }

                });
            });
        </script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("#cbEstado > option").each(function () {

                    var optionValue = $(this).val();

                    if (optionValue == 2)
                    {
                        this.hidden = true;
                    }

                });

            });
        </script>

    </body>
</html>
