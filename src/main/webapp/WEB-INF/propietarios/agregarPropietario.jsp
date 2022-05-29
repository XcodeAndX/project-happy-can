<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Nuevo Propietario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/propietarios?accion=crear"
                      method="POST" class="was-validated">
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Nombres:</label>
                        <input type="text" name="nombres" class="form-control" id="recipient-name" required>
                    </div>
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Apellidos:</label>
                        <input type="text" name="apellidos" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Genero:</label>
                        <input type="text" name="genero" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Tipo Documento:</label>
                        <input type="text" name="tipodocumento" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Numero Documento:</label>
                        <input type="text" name="numerodocumento" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Direccion:</label>
                        <input type="text" name="direccion" class="form-control" id="recipient-name" required>
                    </div> 

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label"> Correo:</label>
                        <input type="text" name="correo" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label"> Estrato:</label>
                        <input type="text" name="estrato" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                        <input type="submit" class="btn btn-primary" value="Guardar"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
