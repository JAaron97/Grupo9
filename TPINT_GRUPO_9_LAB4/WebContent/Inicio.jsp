<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="Entidad.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="controladorEstilos.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="utf-8">
<title>Inicio</title>
</head>
<body>
<%
boolean sesionIniciada = false;
boolean admin = false;
Usuario user = new Usuario();

if(session.getAttribute("Usuario") != null){
	sesionIniciada = true;
	user = (Usuario) session.getAttribute("Usuario");
	if(user.getTipoUsuario() == 1){
		admin = true;
	}
}
%>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="Inicio.jsp">Inicio</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
			<% 
				if(!sesionIniciada){
			%>
			<li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="IniciarSesion.jsp">Iniciar Sesión</a>
	        </li>
			<%
				}
				else{
			%>
			
			<li class="nav-item">
				<a class="nav-link disabled"><%= user.getNombre() %></a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="CerrarSesion.jsp">Cerrar Sesión</a> 
			</li>
			<%
				}
			%>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Más
	          </a>
	          <ul class="dropdown-menu">
	            <%
					if(!sesionIniciada){
				%>
	            <li><a class="dropdown-item" href="IniciarSesion.jsp">Movimientos y Transferencias</a></li>
	            <li><a class="dropdown-item" href="IniciarSesion.jsp">Prestamos</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="IniciarSesion.jsp">Informacion de Usuario</a></li>
				<%
					}
					else if(admin){
				%>
				 <li><a class="dropdown-item" href="AmblUsuarios.jsp">Ambl Usuarios</a></li>
	            <li><a class="dropdown-item" href="ListaAsignarCuentas.jsp">Ver cuentas y Solicitudes</a></li>
	            <li><a class="dropdown-item" href="PrestamosAdmin.jsp">Aceptar/Rechazar Prestamos</a></li>
				<%
					}
					else{
				%>
				<li><a class="dropdown-item" href="Movimientos.jsp">Movimientos y Transferencias</a></li>
	            <li><a class="dropdown-item" href="Prestamos.jsp">Prestamos</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="InfoUsuario.jsp">Informacion de Usuario</a></li>
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
				<h1 style=font-size:150px class="text-center text-dark">Comencemos</h1><br>
			</div>
		</div>
		<%
		if(!admin){
		%>
		<div class="row">
			<div class="col">
				<div class="card border-primary mb-3 text-bg-dark mb-3" style="width: 18rem;">
	  			<img src="transferencias.jpg" class="card-img-top" alt="...">
	  				<div class="card-body">
						<h5 class="card-title">Movimientos y Tranferencias</h5>
						<p class="card-text">Revise los ultimos movimientos de su/s cuentas, y reciba o envie transferencias de dinero.</p>
						<%
						if(!sesionIniciada){
						%>
						<a href="IniciarSesion.jsp" class="btn btn-primary">Es necesario iniciar sesión</a>
						<%
							}
							else{
						%>
						<a href="Movimientos.jsp" class="btn btn-primary">Mov. y transferencias</a>
						<%
							}
						%>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card border-primary mb-3 text-bg-dark mb-3" style="width: 18rem;">
	  			<img src="prestamo.jpg" class="card-img-top" alt="...">
	  				<div class="card-body">
						<h5 class="card-title">Prestamos</h5>
						<p class="card-text">Solicite nuevos prestamos, o mire sus prestamos actuales .</p>
						<%
						if(!sesionIniciada){
						%>
						<a href="IniciarSesion.jsp" class="btn btn-primary">Es necesario iniciar sesión</a>
						<%
							}
							else{
						%>
						<a href="Prestamos.jsp" class="btn btn-primary">Prestamos</a>
						<%
							}
						%>
					</div>
				</div>
			</div>
			<div class="col">
				<div class="card border-primary mb-3 text-bg-dark mb-3" style="width: 18rem;">
	  			<img src="cuenta.jpg" class="card-img-top" alt="...">
	  				<div class="card-body">
						<h5 class="card-title">Información y Cuentas</h5>
						<p class="card-text">Consulte la su informacion y la de sus cuentas.</p>
						<%
						if(!sesionIniciada){
						%>
						<a href="IniciarSesion.jsp" class="btn btn-primary">Es necesario iniciar sesión</a>
						<%
							}
							else{
						%>
						<a href="InfoUsuario.jsp" class="btn btn-primary">Info. Usuario</a>
						<%
							}
						%>
					</div>
				</div>
			</div>
		</div>
		<%
		}
		else{
		
		%>
		<div class="row">
			<div class="col">
				<h5 class="text-center">Vista de Administrador</h5>
			</div>
		</div>
		<%
		}
		%>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>