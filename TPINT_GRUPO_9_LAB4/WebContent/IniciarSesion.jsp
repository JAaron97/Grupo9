<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="controladorEstilos.css">
<title>Iniciar Sesión</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/sign-in/">
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>

<link href="signin.css" rel="stylesheet">
</head>
<body class="text-center">
	<main class="form-signin w-100 m-auto">
			<form action="servletBanco" method="post">
			<h1 class="h3 mb-3 fw-normal ">Inicie Sesión</h1>
			<div class="form-floating">
				<input type="text" name="txtDNI" class="form-control" id="floatingInput" placeholder="12345" required>
				<label for="floatingInput">DNI</label>
			</div>
			<div class="form-floating">
				<input type="password" name="txtPasswd" class="form-control" id="floatingPassword" placeholder="Contraseña" required>
				<label for="floatingPassword">Contraseña</label>
			</div>
				<input class="w-100 btn btn-lg btn-primary" type="submit" name="btnIngresar" value="Ingresar">
			</form>
			<!-- arreglar este if no anda bien masomenos -->
			<%
			if(request.getAttribute("Usuario")==null){
			%>
			<p>DNI o contraseña incorrectos</p>
			<%
			}
			%>
	</main>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
</body>
</html>