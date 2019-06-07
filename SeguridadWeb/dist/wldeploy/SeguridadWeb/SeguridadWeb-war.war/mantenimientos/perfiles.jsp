<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Perfiles</title>
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
        <link rel="stylesheet" type="text/javascript" href="js/jquery-iu.js" />

        <script type="text/javascript">
            function CargarPerfilModal(id, idsistema, sistema, perfil, estado) {
                $("#idPerfil").val(id);
                $("#perfilInput").val(perfil);
                $("#idSistema").val(idsistema);
                $("#sistemaInput").val(sistema);
                $("#estado_Select").val(estado);
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
                    <h1 class="subtitulos text-center font-weight-bold py-4"><html:text name="etiqueta.mantenimientos.perfiles"/></h1>
                </div>
                <div id="alertasContenedor">
                    <div class="message"><html:actionmessage/></div>
                    <div class="error"><html:actionerror/></div>
                </div>
                <div class="card-body">

                    <div class="row">
                        <div class="col-md-6 text-left">
                            <button class="btn btn-success badge-pill" data-toggle="modal" data-target="#agregar"  style="background-color:#1c94c4; border-color: #1c94c4;">
                                Agregar Perfil</button>
                        </div>

                        <div class="col-md-6 text-right">
                            <html:form action="mantenPerfiles!listarPerfiles" method ="post" cssClass="user">
                                <button class="btn btn-success badge-pill" type="submit" style="background-color:#babe0e; border-color: #babe0e; float:right;">
                                    Actualizar Lista</button>
                                </html:form>

                        </div>
                    </div>
                    <br>
                    <table id="example" class="table table-bordered text-center">
                        <thead>
                            <tr>
                                <th hidden="hidden">ID Perfil</th>
                                <th>Sistema</th>
                                <th>Nombre del Perfil</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <html:iterator  value="listaPerfiles" var="lista" status="estado" >
                                <tr>
                                    <td hidden="hidden"><html:property value="pkIdePerfil"/></td>
                                    <td><html:property value=" fkDcmSistema.nomSistema" /></td>  
                                    <td id="nombreperfil"><html:property value="nomPerfil"/></td> 
                                    <td><html:property value="fkDcmEstado.nomEstado" /></td> 
                                    <td class="text-rght">

                                        <html:form action = "mantenPerfiles!eliminarPerfil" method ="post" cssClass="user">
                                            <input type="text" class="form-control" hidden="hidden" name="idPerfilEliminar" value='<html:property value="pkIdePerfil"/>'>
                                            <button type="submit" class="btn btn-danger badge-pill" style="width:90px" >Eliminar</button>
                                            <button 
                                                type="button"
                                                style="width:90px;" class="btn btn-warning badge-pill" 
                                                data-toggle="modal" data-target="#editar" 
                                                onclick="CargarPerfilModal('<html:property value="pkIdePerfil"/>', '<html:property value="fkDcmSistema"/>', '<html:property value="fkDcmSistema.nomSistema"/>', '<html:property value="nomPerfil"/>', '<html:property value="fkDcmEstado.nomEstado"/>')">Modificar
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
                            <h5 class="modal-title" id="exampleModalLabel">Agregar Perfil de Usuario</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="width:50px;">
                                <span class="xclose" style="width:24px;" aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <html:form action = "mantenPerfiles!agregarPerfil" method ="post" cssClass="addProfile" >
                                <form>
                                    <div class="form-group">
                                        <label for="Sistema">Sistema</label>
                                        <html:select id="cbSistema" name="Cb_Sistema" 
                                                     
                                                     list="%{listaSistemas}"
                                                     listKey="pkIdeSistema"
                                                     listValue="nomSistema"tabindex="0"
                                                     cssClass="form-control" 
                                                     required="required" oninvalid="setCustomValidity('Este campo es requerido')" onchange="try{setCustomValidity('')}catch(e){}"/>
                                    </div>


                                    <div class="form-group">
                                        <label for="PerfilUsuario">Nombre Perfil</label>
                                        <input type="text" class="form-control" name="Input_Perfil" placeholder="Nombre del Perfil" required oninvalid="setCustomValidity('Este campo es requerido')" onchange="try{setCustomValidity('')}catch(e){}">
                                    </div>   
                                    <div class="form-group">
                                        <label for="Estado">Estado</label>
                                        <html:select id="cbEstado" name="Cb_Estado" 
                                                     list="%{listaEstados}"
                                                     listKey="pkIdeEstado"
                                                     listValue="nomEstado"tabindex="0"
                                                     cssClass="form-control" 
                                                     contenteditable="false"
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
                            <h5 class="modal-title" id="exampleModalLabel">Modificar Perfil de Usuario</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close" style="width:50px;">
                                <span class="xclose" style="width:24px;" aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <html:form action = "mantenPerfiles!editarPerfil" method ="post" cssClass="editProfile" >
                                <form>
                                    <div hidden="hidden" class="form-group">
                                        <input type="text" id="idPerfil" class="form-control" name="idperfilModificar" readonly placeholder="ID del Perfil" value="<html:property value="idPerfil"/>">
                                    </div> 
                                    <div hidden="hidden" class="form-group">
                                        <input type="text" id="idsitemaInput" class="form-control" name="idsistemaModificar" readonly placeholder="ID del Sistema" value="<html:property value="idSistema"/>">
                                    </div> 
                                    <div class="form-group">
                                        <label for="Sistema">Sistema</label>
                                        <input type="text" id="sistemaInput" class="form-control" name="sistemaModificar" readonly placeholder="Sistema" value="<html:property value="sistemaInput"/>">
                                    </div>  
                                    <div class="form-group">
                                        <label for="PerfilUsuario">Perfil de Usuario</label>
                                        <input type="text" id="perfilInput" class="form-control" name="perfilModificar" placeholder="Nombre del Perfil" value="<html:property value="perfilInput"/>" required oninvalid="setCustomValidity('Este campo es requerido')" onchange="try{setCustomValidity('')}catch(e){}">
                                    </div>   
                                    <div class="form-group">
                                        <label for="Estado">Estado</label>
                                        <select class="custom-select" id="estado_Select" name="select_Estado" required oninvalid="setCustomValidity('Este campo es requerido')" onchange="try{setCustomValidity('')}catch(e){}">
                                            <html:iterator  id="idUsuario" value="listaEstados" var="lista" status="estado" >
                                                <option value="<html:property value="pkIdeEstado"/>"><html:property value="nomEstado" /></option>
                                            </html:iterator>   
                                        </select>                                   
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
            <!--FIN Modal p/EDITAR-->

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
