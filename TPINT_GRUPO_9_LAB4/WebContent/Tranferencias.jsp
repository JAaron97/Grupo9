<%@page import="Entidad.Cuenta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidad.Movimiento"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="Entidad.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="controladorEstilos.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="utf-8">
<title>Transferencias</title>
</head>
<body class="fondo">

<%

Cuenta cuen = new Cuenta();
cuen = (Cuenta) session.getAttribute("Cuenta");

Usuario user = new Usuario();
user = (Usuario) session.getAttribute("Usuario");
%>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="Inicio.jsp">Inicio</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			<li class="nav-item">
			<a class="nav-link disabled"><%=cuen.getCBU()%></a>
			</li>
			<li class="nav-item">
			<a class="nav-link" href="CerrarSesion.jsp">Cerrar Sesi�n</a>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            M�s
	          </a>
	          <ul class="dropdown-menu">
				<li><a class="dropdown-item" href="Movimientos.jsp">Movimientos</a></li>
	            <li><a class="dropdown-item" href="Prestamos.jsp">Prestamos</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="infoUsuario.jsp">Informacion de Usuario</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<form method="get" action="servletBanco">
	<div class="container">
		<div class="row">
			<div class = "col">
				<br>
				<p><input type="text" placeholder="CBU" name="txtCbu" required></p>
				<p><input type="submit" value ="Buscar" name="btnBuscar"></p>
			</div>
		</div>
	</div>
	</form>
	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>	
</body>
</html>