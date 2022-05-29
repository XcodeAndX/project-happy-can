
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Propietarios</title>
    </head>
    <body>
        <h1>
            <p style="text-align: center;">Lista de Propietarios</p>
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
                    <th>Estrato</th>
                </tr>
            </thead>
            <tbody>    
                <c:forEach var="propietario" items="${propietarios}" >
                    <tr>
                        <td>${propietario.nombres}</td>
                        <td>${propietario.apellidos}</td>
                        <td>${propietario.genero}</td>
                         <td>${propietario.tipoDocumento}</td>
                        <td>${propietario.numeroDocumento}</td>
                        <td>${propietario.direccion}</td>
                         <td>${propietario.correo}</td>
                        <td>${propietario.estrato}</td>
                        <td><a href="${pageContext.request.contextPath}/propietarios?accion=eliminar&numerodocumento=${propietario.numeroDocumento}" class="btn btn-secondary" >
                            Eliminar
                            </a>
                        <a href="${pageContext.request.contextPath}/propietarios?accion=editar&numerodocumento=${propietario.numeroDocumento}" class="btn btn-secondary" >
                            Editar
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <jsp:include page="../WEB-INF/propietarios/agregarPropietario.jsp"/>   
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
