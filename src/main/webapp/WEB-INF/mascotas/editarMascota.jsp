<%-- 
    Document   : editarMascota
    Created on : 18 dic. 2020, 21:13:09
    Author     : HappyCan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Editar Mascota</title>
    </head>
    <body>
        <div class="modal-body">
            <form action="${pageContext.request.contextPath}/mascotas?accion=modificar"
                  method="POST" class="was-validated">
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">ID:</label>
                        <input type="text" name="id" value="${mascotadto.id}" class="form-control" id="recipient-name" required>
                    </div>
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Nombre:</label>
                        <input type="text" name="nombre" value="${mascotadto.nombre}" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Fecha de Nacimiento:</label>
                        <input type="text" name="fechanacimiento" value="${mascotadto.fechaNacimiento}" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Raza:</label>
                        <input type="text" name="raza" value="${mascotadto.raza}" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Color:</label>
                        <input type="text" name="color" value="${mascotadto.color}" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Documento del Propietario:</label>
                        <input type="text" name="propietario_numerodocumento" value="${mascotadto.documentoPropietario}" class="form-control" id="recipient-name" required>
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
