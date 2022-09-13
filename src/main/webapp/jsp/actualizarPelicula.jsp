<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Actualizar Película</title>

        <!-- CSS only -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <!-- CSS only -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    </head>

    <body>

        <%@include file="../templates/banner_administrador.html" %>


            <div class="wrapper">
                <div class="formContent">
                    <form method="post" action="ActualizarPeliculaController">
                        <fieldset>
                            <legend><span class="material-symbols-outlined text-dark"> movie </span> Actualizar Películas
                            </legend>
                            <input type="text" hidden name="id" value="${pelicula.id }" />
                            <div class="mb-3">
                                <p class=" form-label">Nombre de película</p>
                                <input class="form-control" type="text" name="nombre" value="${pelicula.nombre }" required />
                            </div>

                            <div class="mb-3">
                                <p class=" form-label">Calificación</p>
                                <input class="form-control" type="number" name="calificacion" min="0" max="5" value="${pelicula.calificacion }" required />
                            </div>
                            <div class="mb-3">
                                <p class=" form-label">Año de estreno</p>
                                <input class=" form-control" type="number" name="anio" id="anio" min=" 1900" step=" 1" value="${pelicula.anioPublicacion}" required />
                            </div>
                            <div class=" mb-3">
                                <p class=" form-label">Género</p>
                                <select class="form-select" name="genero" id="genero" required>
                                        <option value="Accion" ${pelicula.genero=="Accion" ?"selected" : '' }>Acción
                                        </option>
                                        <option value="Comedia" ${pelicula.genero=="Comedia" ?"selected" : '' }>Comedia
                                        </option>
                                        <option value="Drama" ${pelicula.genero=="Drama" ?"selected" : '' }>Drama
                                        </option>
                                        <option value="Terror" ${pelicula.genero=="Terror" ?"selected" : '' }>Terror
                                        </option>
                                        <option value="Ciencia Ficcion" ${pelicula.genero=="Ciencia Ficcion" ?"selected"
                                            : '' }>Ciencia
                                            Ficción</option>
                                        <option value="Romance" ${pelicula.genero=="Romance" ?"selected" : '' }>Romance
                                        </option>
                                        <option value="Musical" ${pelicula.genero=="Musical" ?"selected" : '' }>Musical
                                        </option>
                                        <option value="Documental" ${pelicula.genero=="Documental" ?"selected" : '' }>
                                            Documental
                                        </option>
                                        <option value="Infantil" ${pelicula.genero=="Infantil" ?"selected" : '' }>
                                            Infantil</option>
                                    </select>
                            </div>
                            <div class="mb-3">
                                <p class="form-label">Estado</p>
                                <select class="form-select" name="estado" required>
                                        <option value="Disponible" ${pelicula.estado=="Disponible" ?" selected" : '' }>
                                            Disponible
                                        </option>
                                        <option value="No Disponible" ${pelicula.estado=="No Disponible" ?" selected"
                                            : '' }>No
                                            Disponible</option>
                                    </select>
                            </div> <br> <input type="submit" class=" btn btn-dark" value=" Actualizar" />
                        </fieldset>
                    </form>
                </div>

            </div>
            <!-- JavaScript Bundle with Popper -->
            <script src=" https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity=" sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin=" anonymous"></script>
            <script>
                // Get the year of today
                var today = new Date();
                var yyyy = today.getFullYear();
                // Set the year of the input to the year of today
                document.getElementById("anio").setAttribute('max', '' + yyyy)
            </script>
    </body>

    </html>