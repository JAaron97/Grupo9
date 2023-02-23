<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="Entidad.Usuario" %>
    <%@ page import="Entidad.Nacionalidad" %>
    <%@ page import="Entidad.Localidad" %>
    <%@ page import="NegocioImpl.NacionalidadNegImpl" %>
    <%@ page import="NegocioImpl.LocalidadesNegImpl" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html >

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="controladorEstilos.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Listar Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<style>
body{
overflow: hidden;
}
</style>
</head>
<body>

<%
	boolean sesionIniciada = false;
Usuario user = new Usuario();
user = (Usuario) session.getAttribute("Usuario");
NacionalidadNegImpl nacioNeg = new NacionalidadNegImpl();
LocalidadesNegImpl locNeg = new LocalidadesNegImpl();
ArrayList<Nacionalidad> listaNacionalidades = null; 
	listaNacionalidades = nacioNeg.ReadAll();
ArrayList<Localidad> listaLocalidades = null;
	listaLocalidades = locNeg.ReadAll();
%>
<%

ArrayList<Usuario> listaUsuarios = new  ArrayList<Usuario>();
if(request.getAttribute("listaUsu")!=null)
listaUsuarios =  (ArrayList<Usuario>) request.getAttribute("listaUsu");
ArrayList<Usuario> list = new  ArrayList<Usuario>();
if(request.getAttribute("ListaIdUsuarios")!=null)
list =  (ArrayList<Usuario>) request.getAttribute("ListaIdUsuarios");





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
			<a class="nav-link disabled"><%= user.getNombre() %></a>
		</li>
		<li>
			<a class="nav-link" href="CerrarSesion.jsp">Cerrar Sesión</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Más
          </a>
          <ul class="dropdown-menu">
             <li><a class="dropdown-item" href="AmblUsuarios.jsp">Ambl Usuarios</a></li>
	        <li><a class="dropdown-item" href="ListaAsignarCuentas.jsp">Ver cuentas y Solicitudes</a></li>
	        <li><a class="dropdown-item" href="PrestamosAdmin.jsp">Aceptar/Rechazar Prestamos</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="containter fondo text-center">
	<div class="row">
		<div class="col-sm-2 mx-auto">	
			<br>
			<div class="card border-primary mb-3 text-bg-dark mb-3" style="width: 18rem;">
				<p></p>
				<p><a class="btn btn-primary" href="servletBanco?param=add"> Agregar Usuario</a></p>
				<p><a class="btn btn-primary" href="servletBanco?param=list"> listar Usuarios</a></p>
				<p><a class="btn btn-primary" href="servletBanco?param=eliminar">Eliminar Usuarios </a></p>
				<p><a class="btn btn-primary" href="servletBanco?param=modificar">Modificar Usuarios </a></p>
			</div>
		</div>
	</div>
</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>