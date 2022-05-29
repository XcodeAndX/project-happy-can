<%-- 
    Document   : editarPropietario
    Created on : 16/12/2020, 10:33:23 p. m.
    Author     : HappyCan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Editar Propietario</title>
    </head>
    <body>
        <div class="modal-body">
            <form action="${pageContext.request.contextPath}/propietarios?accion=modificar"
                  method="POST" class="was-validated">
                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Nombres:</label>
                    <input type="text" name="nombres" value="${propietariodto.nombres}" class="form-control" id="recipient-name" required>
                </div>
                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Apellidos:</label>
                    <input type="text" name="apellidos" value="${propietariodto.apellidos}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Genero:</label>
                    <input type="text" name="genero" value="${propietariodto.genero}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Tipo Documento:</label>
                    <input type="text" name="tipodocumento" value="${propietariodto.tipoDocumento}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Numero Documento:</label>
                    <input type="text" name="numerodocumento" value="${propietariodto.numeroDocumento}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Direccion:</label>
                    <input type="text" name="direccion" value="${propietariodto.direccion}" class="form-control" id="recipient-name" required>
                </div> 

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label"> Correo:</label>
                    <input type="text" name="correo" value="${propietariodto.correo}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label"> Estrato:</label>
                    <input type="text" name="estrato" value="${propietariodto.estrato}" class="form-control" id="recipient-name" required>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    <input type="submit" class="btn btn-primary" value="Editar"/>
                </div>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>