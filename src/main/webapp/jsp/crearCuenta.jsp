<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Login Persona</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<!-- CSS only -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
<script src="https://kit.fontawesome.com/1dcb9ecca7.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>

<body>

	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid d-flex justify-content-center">
			<span class="material-symbols-outlined text-white"> movie </span> <span
				class="navbar-brand mb-0 h1 d-flex justify-content-center align-items-center mx-3">
				Gestor de Películas </span>
		</div>

	</nav>


	<div class="wrapper">
		<div class="formContent text-start">
			<form method="post" action="../CrearCuentaController">
				<fieldset>
					<legend class="text-center">
						<span class="material-symbols-outlined mx-2 mt-1"> person </span>Crear
						cuenta
					</legend>
					<input type="text" name="tipo" hidden value="Usuario" />
					<div class="mb-3">
						<p class="form-label">Correo</p>
						<input type="email" name="correo" class="form-control" required />
					</div>
					<div class="mb-3">
						<p class="form-label">Nombre de usuario</p>
						<input type="text" name="nombre" class="form-control" required />
					</div>
					<div class="mb-3">
						<p class="form-label">Password</p>
						<input type="password" name="password" class="form-control"
							required />
					</div>
					<br> <input type="submit" class="btn btn-dark"
						value="Crear cuenta" /> <br> <br>
					<div class="text-center">
						Ir al <a href="../LoginController" class="text-secondary">Log
							in</a>
					</div>
				</fieldset>
			</form>
		</div>

	</div>

	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
		crossorigin="anonymous"></script>
</body>

</html>