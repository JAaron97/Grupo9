<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidad.Usuario" %>
    <%@ page import="NegocioImpl.UsuarioNegImpl" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lista Asignar Cuentas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<style>
#cliente {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#cliente td, #cliente th {
  border: 1px solid #ddd;
  padding: 8px;
}

#cliente tr:nth-child(even){background-color: #f2f2f2;}

#cliente tr:hover {background-color: #ddd;}

#cliente th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<%
Usuario user = new Usuario();
user = (Usuario) session.getAttribute("Usuario");
UsuarioNegImpl userN = new UsuarioNegImpl();
ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
	listaUsuarios = (ArrayList<Usuario>)userN.readAll();
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


<table id="cliente">
	<tr>
		<th>DNI</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>ID Nacionalidad</th>
		<th>ID Localidad</th>
		<th>CUIL</th>
		<th>Sexo</th>
		<th>Fecha de Nacimiento</th>
		<th>Direccion</th>
		<th>Mail</th>
		<th>ID Telefonos</th>
		<th>Contraseña</th>
		<th></th>
		<th></th>
	</tr>
	<%
	for(Usuario u : listaUsuarios){
	%>
	<tr>
	<form name="form" action="servletBanco?idUsuario=<%=u.getDNI()%>" method="post">
		<td><%=u.getDNI() %></td>
		<td><%=u.getNombre() %></td>
		<td><%=u.getApellido() %></td>
		<td><%=u.getNacionalidad().getID() %></td>
		<td><%=u.getLocalidad().getIDLocalidad() %></td>
		<td><%=u.getCUIL() %></td>
		<td><%=u.getSexo() %></td>
		<td><%=u.getNacimiento() %></td>
		<td><%=u.getDireccion() %></td>
		<td><%=u.getMail() %></td>
		<td><%=u.getTelefono().getID_Telefono() %></td>
		<td><%=u.getPassword() %></td>
		<td><input type="submit" name="btnVercuentas" value="Ver cuentas"></td>
		<td><input type="submit" name="btnVerSolicitudCuentas" value="Ver Solicitudes de cuenta"></td>
		</form>
	</tr>
	<%
	}
	%>
</table>

<br>
<div class ="container">
	<div class="row">
		<div class="col">
			<!-- poner acar si se creo cuenta correctamente -->
			<%
			if(request.getAttribute("Filas") != null){
				boolean filas = false;
				filas = (Boolean)request.getAttribute("Filas");
				if(filas){
				%>
				<p class="text-center">Cuenta asignada correctamente</p>
				<%
				}
				else{
				%>
				<p class="text-center">El cliente ya posee el maximo de cuentas</p>
				<%
				}
			}
			%>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>