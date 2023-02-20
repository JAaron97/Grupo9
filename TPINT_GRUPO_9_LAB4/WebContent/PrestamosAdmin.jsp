<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidad.Usuario" %>
    <%@ page import="NegocioImpl.SolicitudPrestamoNegImpl" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="Entidad.SolicitudPrestamo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="controladorEstilos.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="utf-8">
<title>Lista solicitudes prestamo</title>
</head>
<body>
<%
Usuario user = new Usuario();
user = (Usuario) session.getAttribute("Usuario");

SolicitudPrestamoNegImpl scN = new SolicitudPrestamoNegImpl();
ArrayList<SolicitudPrestamo> listaSolicitudPrestamo = new ArrayList<SolicitudPrestamo>();
	listaSolicitudPrestamo = scN.ReadAll();
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
	        <li><a class="dropdown-item" href="AsignarCuentas.jsp">Ver cuentas y Solicitudes</a></li>
	        <li><a class="dropdown-item" href="PrestamosAdmin.jsp">Aceptar/Rechazar Prestamos</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
<div class="containter fondo">
	<div class="row">
		<div class="col">
			<table id="cliente">
				<tr>
					<th>ID</th>
					<th>DNI Cliente</th>
					<th>Fecha Solicitud</th>
					<th>Cuenta destinataria</th>
					<th>Numero Cuotas</th>
					<th>Importe</th>
					<th>Estado</th>
				</tr>
				<%
				for(SolicitudPrestamo sp : listaSolicitudPrestamo){
				%>
				<tr>
				<form name="form" action="servletBanco?IDSolicitud=<%=sp.getID()%>" method="post">
					<td><%=sp.getID() %></td>
					<td><%=sp.getDNICliente() %></td>
					<td><%=sp.getFecha() %></td>
					<td><%=sp.getCuentaDestinataria() %></td>
					<td><%=sp.getNumeroCuotas() %></td>
					<td><%=sp.getImportePedido() %></td>
					<%if(sp.getEstado()==0){ %>
						<td>Sin Aceptar</td>
						<td><input type="submit" name="btnAceptarPrestamo" value="Aceptar Prestamo"></td>
					<%} else{ %>
						<td>Aceptado</td>
					<%} %>
				</form>
				</tr>
				<%
				}
				%>
			</table>
			<%
			if(request.getAttribute("update")!=null){
				boolean update = (boolean)request.getAttribute("update");
				if(update){
					%>
					<h2 class="text-center">Solicitud Aceptada</h2>
					<% 
				}
				else{
					%>
					<h2 class="text-center">Hubo un error al intentar aceptar la solicitud</h2>
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