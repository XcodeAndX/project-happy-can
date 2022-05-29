<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Nuevo Paseo</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/paseos?accion=crear"
                      method="POST" class="was-validated">
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">ID Mascota:</label>
                        <input type="text" name="id_mascota" class="form-control" id="recipient-name" required>
                    </div>
                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Numero Documento Paseador:</label>
                        <input type="text" name="numerodocumento_paseador" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Hora Salida:</label>
                        <input type="text" name="horasalida" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label">Hora Entrega:</label>
                        <input type="text" name="horaentrega" class="form-control" id="recipient-name" required>
                    </div>

                    <div class="mb-3">
                        <label for="recipient-name" class="col-form-label"> Fecha Paseo:</label>
                        <input type="text" name="fechapaseo" class="form-control" id="recipient-name" required>
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
