<%-- 
    Document   : editarPaseador
    Created on : 18 dic. 2020, 20:48:30
    Author     : HappyCan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Editar Paseador</title>
    </head>
    <body>
        <div class="modal-body">
            <form action="${pageContext.request.contextPath}/paseadores?accion=modificar"
                  method="POST" class="was-validated">
                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Nombres:</label>
                    <input type="text" name="nombres" value="${paseadordto.nombres}" class="form-control" id="recipient-name" required>
                </div>
                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Apellidos:</label>
                    <input type="text" name="apellidos" value="${paseadordto.apellidos}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Genero:</label>
                    <input type="text" name="genero" value="${paseadordto.genero}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Tipo Documento:</label>
                    <input type="text" name="tipodocumento" value="${paseadordto.tipoDocumento}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Numero Documento:</label>
                    <input type="text" name="numerodocumento" value="${paseadordto.numeroDocumento}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Direccion:</label>
                    <input type="text" name="direccion" value="${paseadordto.direccion}" class="form-control" id="recipient-name" required>
                </div> 

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label"> Correo:</label>
                    <input type="text" name="correo" value="${paseadordto.correo}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label"> Experiencia:</label>
                    <input type="text" name="experiencia" value="${paseadordto.experiencia}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label"> Descripcion:</label>
                    <input type="text" name="descripcion" value="${paseadordto.descripcion}" class="form-control" id="recipient-name" required>
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
