

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Paseadores</title>
    </head>
    <body>
        <h1>
            <p style="text-align: center;">Lista de Paseadores</p>
        </h1>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">Agregar</button>
        <table class="table">
            <thead>
                <tr>    
                    <th>Nombres</th> 
                    <th>Apellidos</th> 
                    <th>Genero</th> 
                    <th>Tipo Documento</th> 
                    <th>Numero Documento</th>
                    <th>Direccion</th> 
                    <th>Correo</th> 
                    <th>Experiencia</th>
                    <th>Descripcion</th>
                </tr>
            </thead>
            <tbody>    
                <c:forEach var="paseador" items="${paseadores}" >
                    <tr>
                        <td>${paseador.nombres}</td>
                        <td>${paseador.apellidos}</td>
                        <td>${paseador.genero}</td>
                        <td>${paseador.tipoDocumento}</td>
                        <td>${paseador.numeroDocumento}</td>
                        <td>${paseador.direccion}</td>
                        <td>${paseador.correo}</td>
                        <td>${paseador.experiencia}</td>
                        <td>${paseador.descripcion}</td>
                        <td><a href="${pageContext.request.contextPath}/paseadores?accion=eliminar&numerodocumento=${paseador.numeroDocumento}" class="btn btn-secondary" >
                            Eliminar
                            </a>
                        <a href="${pageContext.request.contextPath}/paseadores?accion=editar&numerodocumento=${paseador.numeroDocumento}" class="btn btn-secondary" >
                            Editar
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <jsp:include page="../WEB-INF/paseadores/agregarPaseador.jsp"/>   
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
