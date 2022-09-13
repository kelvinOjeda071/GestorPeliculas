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

</head>

<body>

	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid d-flex justify-content-center">
			<span class="navbar-brand mb-0 h1 d-flex justify-content-center">Gestor
				de Películas</span>
		</div>

	</nav>


	<div class="wrapper">
		<div class="formContent">
			<form method="post" action="../CrearCuentaController">
				<fieldset>
					<legend>Crear cuenta</legend>
					<input type="text" name="tipo" hidden value="Usuario" />
					<p>Correo</p>
					<input type="email" name="correo" required />
					<p>Nombre de usuario</p>
					<input type="text" name="nombre" required />
					<p>Password</p>
					<input type="password" name="password" required /> <br> <br>
					<br> <input type="submit" value="Crear cuenta" />
					<div>
						<a href="LoginController">Log in</a>
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