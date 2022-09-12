<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insertar Película</title>

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
			<form method="post" action="InsertarPeliculaController" enctype="multipart/form-data">
				<fieldset>
					<legend>Insertar Películas</legend>
					<p>Nombre de película</p>
					<input type="text" name="nombre" required
						oninvalid="this.setCustomValidity('Por favor ubicar un nombre para la película')" />
					<p>Calificación</p>
					<input type="number" name="calificacion" min="0" max="5" required />
					<p>Fecha de estreno</p>
					<input type="number" name="anio" id="anio" min="1800" step="1"
						required />
					<!-- <input type="month" name="fechaEstreno" /> -->
					<p>Género</p>
					<select name="genero" id="genero" required
						oninvalid="this.setCustomValidity('Por favor seleccione un género de película')">
						<option value="Acción">Acción</option>
						<option value="Comedia">Comedia</option>
						<option value="Drama">Drama</option>
						<option value="Terror">Terror</option>
						<option value="Ciencia Ficción">Ciencia Ficción</option>
						<option value="Romance">Romance</option>
						<option value="Musical">Musical</option>
						<option value="Documental">Documental</option>
						<option value="Infantil">Infantil</option>

					</select> <input type="text" name="estado" value="Disponible" hidden />
					<p>Fotografía</p>
					<input name="fileInput" class="inputs" type="file" id="file"
						required accept="image/png, image/jpeg"
						 />
					<br> <br> <br> <input type="submit" value="Insertar" />
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