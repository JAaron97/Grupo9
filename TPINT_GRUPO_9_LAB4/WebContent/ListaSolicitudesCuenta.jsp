<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidad.Usuario" %>
    <%@ page import="Entidad.SolicitudCuenta" %>
    <%@ page import="NegocioImpl.SolicitudCuentaNegImpl" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

SolicitudCuentaNegImpl scN = new SolicitudCuentaNegImpl();
ArrayList<SolicitudCuenta> listaSolicitudCuenta = new ArrayList<SolicitudCuenta>();
	listaSolicitudCuenta = (ArrayList<SolicitudCuenta>) request.getAttribute("listaSolicitudes");
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
	        <li><a class="dropdown-item" href="AsignarCuentas.jsp">Asignar Cuentas</a></li>
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
	for(SolicitudCuenta sc : listaSolicitudCuenta){
	%>
	<tr>
	<form name="form" action="servletBanco?Solicitud=<%=sc.getID()%>" method="post">
		<td><%=sc.getID() %></td>
		<td><%=sc.getDNI_Cliente() %></td>
		<td><%=sc.getFechaSolicitud() %></td>
		<td><%=sc.getEstadoSolicitud() %></td>
		<td><input type="submit" name="btnAceptarSolicitud" value="Aceptar solicitud"></td>
	</form>
	</tr>
	<%
	}
	%>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>