

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Lista de Paseos</title>
    </head>
    <body>
        <h1>
            <p style="text-align: center;">Lista de Paseos</p>
        </h1>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">Agregar</button>
        <table class="table">
            <thead>
                <tr>    
                    <th>ID Mascota</th> 
                    <th>Numero Documento Paseador</th> 
                    <th>Hora de Salida</th> 
                    <th>Hora de Entrega</th> 
                    <th>Fecha del Paseo</th>
                </tr>
            </thead>
            <tbody>    
                <c:forEach var="paseo" items="${paseos}" >
                    <tr>
                        <td>${paseo.id_mascota}</td>
                        <td>${paseo.numeroDocumento_paseador}</td>
                        <td>${paseo.horaSalida}</td>
                         <td>${paseo.horaEntrada}</td>
                        <td>${paseo.fechaPaseo}</td>
                        <td><a href="${pageContext.request.contextPath}/paseos?accion=eliminar&fechapaseo=${paseo.fechaPaseo}" class="btn btn-secondary" >
                            Eliminar
                            </a>
                        <a href="${pageContext.request.contextPath}/paseos?accion=editar&fechapaseo=${paseo.fechaPaseo}" class="btn btn-secondary" >
                            Editar
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <jsp:include page="../WEB-INF/paseos/agregarPaseo.jsp"/>   
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
