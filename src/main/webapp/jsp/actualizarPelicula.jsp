<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Actualizar Película</title>

<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<!-- CSS only -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">

</head>

<body>

	<%@include file="../templates/banner_interno.html"%>


	<div class="wrapper">
		<div class="formContent">
			<form method="post" action="ActualizarPeliculaController">
				<fieldset>
					<legend>Actualizar Películas</legend>
					<input type="text" hidden name="id" value="${pelicula.id }" />
					<p>Nombre de película</p>
					<input type="text" name="nombre" value="${pelicula.nombre }"
						required
						oninvalid="this.setCustomValidity('Por favor ubicar un nombre para la película')" />

					<p>Calificación</p>
					<input type="number" name="calificacion" min="0" max="5"
						value="${pelicula.calificacion }" required
						oninvalid="this.setCustomValidity('Por favor seleccione un valor entere 0 a 5')">
					<p>Fecha de estreno</p>
					<input type="number" name="anio" id="anio" min="1900" step="1"
						value="${pelicula.anioPublicacion }" required
						oninvalid="this.setCustomValidity('Por favor seleccione un año')" />
					<!-- <input type="month" name="fechaEstreno" /> -->
					<p>Género</p>
					<select name="genero" id="genero" required
						oninvalid="this.setCustomValidity('Por favor seleccione un género de película')">
						<option value="Acción"
							${pelicula.genero=="Acción" ? "selected" : '' }>Acción</option>
						<option value="Comedia"
							${pelicula.genero=="Comedia" ? "selected" : '' }>Comedia</option>
						<option value="Drama"
							${pelicula.genero=="Drama" ? "selected" : '' }>Drama</option>
						<option value="Terror"
							${pelicula.genero=="Terror" ? "selected" : '' }>Terror</option>
						<option value="Ciencia Ficción"
							${pelicula.genero=="Ciencia Ficción" ? "selected" : '' }>Ciencia
							Ficción</option>
						<option value="Romance"
							${pelicula.genero=="Romance" ? "selected" : '' }>Romance</option>
						<option value="Musical"
							${pelicula.genero=="Musical" ? "selected" : '' }>Musical</option>
						<option value="Documental"
							${pelicula.genero=="Documental" ? "selected" : '' }>Documental</option>
						<option value="Infantil"
							${pelicula.genero=="Infantil" ? "selected" : '' }>Infantil</option>
					</select>
					<p>Estado</p>
					<select name="estado" requered>
						<option value="Disponible"
							${pelicula.estado=="Disponible" ? "selected" : '' }>Disponible</option>
						<option value="No Disponible"
							${pelicula.estado=="No Disponible" ? "selected" : '' }>No
							Disponible</option>
					</select> <br> <br> <br> <input type="submit"
						value="Actualizar" />
				</fieldset>
			</form>
		</div>

	</div>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
		crossorigin="anonymous"></script>
	<script>
		// Get the year of today
		var today = new Date();
		var yyyy = today.getFullYear();
		// Set the year of the input to the year of today
		document.getElementById("anio").setAttribute('max', '' + yyyy)
	</script>
</body>

</html>