

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
        <title>Mascotas</title>
    </head>
    <body>
        <h1>
            <p style="text-align: center;">Lista de Mascotas</p>
        </h1>
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo">Agregar</button>
        <table class="table">
            <thead>
                <tr>    
                    <th>ID Mascota</th> 
                    <th>Nombre</th> 
                    <th>Fecha de NAcimiento</th> 
                    <th>Raza</th> 
                    <th>Color</th>
                    <th>Numero Documento Propietario</th>
                </tr>
            </thead>
            <tbody>    
                <c:forEach var="mascota" items="${mascotas}" >
                    <tr>
                        <td>${mascota.id}</td>
                        <td>${mascota.nombre}</td>
                        <td>${mascota.fechaNacimiento}</td>
                        <td>${mascota.raza}</td>
                        <td>${mascota.color}</td>
                        <td>${mascota.documentoPropietario}</td>
                        <td><a href="${pageContext.request.contextPath}/mascotas?accion=eliminar&id=${mascota.id}" class="btn btn-secondary" >
                            Eliminar
                            </a>
                        <a href="${pageContext.request.contextPath}/mascotas?accion=editar&id=${mascota.id}" class="btn btn-secondary" >
                            Editar
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <jsp:include page="../WEB-INF/mascotas/agregarMascota.jsp"/>   
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
    </body>
</html>
