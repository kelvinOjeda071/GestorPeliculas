<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insertar Película</title>

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <!-- CSS only -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">

    </head>

    <body>


       <%@include file="../templates/banner_administrador.html" %>

            <div class="wrapper">
                <div class="formContent">
                    <form method="post" action="InsertarPeliculaController" enctype="multipart/form-data">
                        <fieldset>
                            <legend class="text-center"><span class="material-symbols-outlined text-dark"> movie
                                    </span> Insertar Películas
                            </legend>
                            <div class="mb-3">
                                <p class=" form-label">Nombre de película</p>
                                <input type="text" name="nombre" class="form-control" required />
                            </div>
                            <div class="mb-3">
                                <p class=" form-label">Calificación</p>
                                <input type="number" name="calificacion" class="form-control" min="0" max="5" required />
                            </div>
                            <div class="mb-3">
                                <p class=" form-label">Año de estreno</p>
                                <input type="number" name="anio" id="anio" class="form-control" min="1800" step="1" required />
                            </div>
                            <div class="mb-3">
                                <p class=" form-label">Género</p>
                                <select name="genero" class="form-select" id="genero" required oninvalid="this.setCustomValidity('Por favor seleccione un género de película')">
                                        <option value="Accion">Accion</option>
                                        <option value="Comedia">Comedia</option>
                                        <option value="Drama">Drama</option>
                                        <option value="Terror">Terror</option>
                                        <option value="Ciencia Ficcion">Ciencia Ficcion</option>
                                        <option value="Romance">Romance</option>
                                        <option value="Musical">Musical</option>
                                        <option value="Documental">Documental</option>
                                        <option value="Infantil">Infantil</option>

                                    </select>
                            </div>
                            <input type="text" name="estado" class="form-select" value="Disponible" hidden />
                            <div class="mb-3">
                                <p class=" form-label">Fotografía</p>
                                <input name="fileInput" class=" btn btn-dark text-center" type="file" id="file" required accept="image/png, image/jpeg" />
                            </div>
                            <br>
                            <div class="text-center">
                                <input type="submit" class=" btn btn-dark text-center" value="Insertar" />
                            </div>
                        </fieldset>
                    </form>
                </div>

            </div>
            <!-- JavaScript Bundle with Popper -->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
            <script>
                // Get the year of today
                var today = new Date();
                var yyyy = today.getFullYear();
                // Set the year of the input to the year of today
                document.getElementById("anio").setAttribute('max', '' + yyyy)
            </script>
    </body>

    </html>