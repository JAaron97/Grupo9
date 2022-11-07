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
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="Inicio.jsp">Inicio</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
        	<% 
			session.setAttribute("Usuario", session.getAttribute("usuario"));
			if(session.getAttribute("Usuario") == null){
			%>
	          <a class="nav-link active" aria-current="page" href="IniciarSesion.jsp">Iniciar Sesión</a>
			<%
				}
				else{
			%>
			<a class="nav-link disabled"><%= session.getAttribute("Usuario").toString() %></a>
			<a class="nav-link" href="IniciarSesion.jsp">Cerrar Sesión</a>
			<%
				}
			%>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Más
          </a>
          <ul class="dropdown-menu">
          	<%
			session.setAttribute("Usuario", session.getAttribute("usuario"));
			if(session.getAttribute("Usuario") == null){
			%>
            <li><a class="dropdown-item" href="IniciarSesion.jsp">Movimientos y Transferencias</a></li>
            <li><a class="dropdown-item" href="IniciarSesion.jsp">Prestamos</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="IniciarSesion.jsp">Pedir cuenta bancaria</a></li>
            <li><a class="dropdown-item" href="IniciarSesion.jsp">Informacion de Usuario</a></li>
            <%
				}
				else{
			%>
			<li><a class="dropdown-item" href="Movimientos.jsp">Movimientos y Transferencias</a></li>
            <li><a class="dropdown-item" href="Prestamos.jsp">Prestamos</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Pedir cuenta bancaria</a></li>
            <li><a class="dropdown-item" href="#">Informacion de Usuario</a></li>
			<%
				}
			%>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="containter fondo">
	<div class="row">
		<div class="col">	
			<br>
			<form action="servletBanco" method="get">
			<p class="text-center">DNI: <input type="text" name="txtNombre" required> </p>
			<p class="text-center">Contraseña: <input type="text" name="txtPasswd" required></p>
			<p class="text-center"> <input type="submit" name="btnIngresar" value="Ingresar"> </p> 
			</form>
		</div>
	</div>
</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
	
</body>
</html>