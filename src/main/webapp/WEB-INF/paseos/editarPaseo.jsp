<%-- 
    Document   : editarPaseo
    Created on : 17/12/2020, 11:07:51 a. m.
    Author     : HappyCan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="modal-body">
            <form action="${pageContext.request.contextPath}/paseos?accion=modificar"
                  method="POST" class="was-validated">
                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">ID Mascota:</label>
                    <input type="text" name="id_mascota" value="${paseodto.id_mascota}" class="form-control" id="recipient-name" required>
                </div>
                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Numero Documento Paseador:</label>
                    <input type="text" name="numerodocumento_paseador" value="${paseodto.numeroDocumento_paseador}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Hora Salida:</label>
                    <input type="text" name="horasalida" value="${paseodto.horaSalida}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label">Hora Entrega:</label>
                    <input type="text" name="horaentrega" value="${paseodto.horaEntrada}" class="form-control" id="recipient-name" required>
                </div>

                <div class="mb-3">
                    <label for="recipient-name" class="col-form-label"> Fecha Paseo:</label>
                    <input type="text" name="fechapaseo" value="${paseodto.fechaPaseo}" class="form-control" id="recipient-name" required>
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
