<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>Listar Películas Alquiladas</title>
            <style>
                table,
                th,
                td {
                    border: 1px solid black;
                    border-collapse: collapse;
                }
                /* setting the text-align property to center*/
                
                td {
                    padding: 5px;
                    text-align: center;
                }
            </style>

            <!-- Bootstrap -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
            <!-- CSS only -->
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">

            <body>


                <%@include file="../templates/banner_usuario.html" %>


                    <div class="wrapper">
                        <table class="table table-striped">
                            <thead class="thead-dark">
                                <tr class="fw-bold">
                                    <td scope="col">#</td>
                                    <td scope="col">Nombre Película</td>
                                    <td scope="col">Año de estreno</td>
                                    <td scope="col">Calificación</td>
                                    <td scope="col">Género</td>
                                    <td scope="col">Poster</td>
                                    <td scope="col"></td>
                                </tr>
                            </thead>

                            <c:forEach items="${peliculasAlquiladas}" var="pelicula">
                                <tr>

                                    <td>${pelicula.id}</td>
                                    <td>${pelicula.nombre}</td>
                                    <td>${pelicula.anioPublicacion}</td>
                                    <td>${pelicula.calificacion}</td>
                                    <td>${pelicula.genero}</td>
                                    <td><img src="img/${pelicula.pathImage}" width="75px"></td>
                                    <td><a href="DevolverPeliculaController?idPelicula=${pelicula.id}" class="text-decoration-none btn btn-dark">Devolver</a>
                                    </td>

                                </tr>

                            </c:forEach>
                        </table>
                    </div>
            </body>

        </html>