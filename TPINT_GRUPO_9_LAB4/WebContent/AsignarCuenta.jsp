<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidad.Usuario" %>
    <%@ page import="Entidad.TipoCuenta" %>
    <%@ page import="NegocioImpl.UsuarioNegImpl" %>
    <%@ page import="NegocioImpl.TipoCuentaNegImpl" %>
        <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="controladorEstilos.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Asignar Cuenta</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body class="fondo">
<%
Usuario user = new Usuario();
TipoCuenta tCuenta = new TipoCuenta();
user = (Usuario) session.getAttribute("Usuario");

UsuarioNegImpl userN = new UsuarioNegImpl();
TipoCuentaNegImpl dNTC = new TipoCuentaNegImpl();

ArrayList<TipoCuenta> listaTipoCuentas = new ArrayList<TipoCuenta>();
	listaTipoCuentas = (ArrayList<TipoCuenta>) dNTC.ReadAll();

Usuario user2 = new Usuario();
	user2 = (Usuario)request.getAttribute("User");
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
			<a class="nav-link" href="CerrarSesion.jsp">Cerrar Sesi�n</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            M�s
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
<%
if(request.getAttribute("update")!=null){
	boolean update = (boolean)request.getAttribute("update");
	if(update){
		%>
		<h2 class="text-center">Solicitud Aceptada</h2>
		<% 
	}
}
%>

<div class="container">
	<div class="row">
		<div class="col">
			<form action="servletBanco" method="post">
			<p class="text-center">Dni: <%=user2.getDNI() %></p>
			<input type="hidden" name="DNI" value=<%=user2.getDNI() %>>
			<p class="text-center">Tipo de Cuenta
			<select name="TipoCuenta">
			<%
			for(TipoCuenta tC : listaTipoCuentas){
			%>
				<option><%=tC.getDescripcion() %></option>
			<%
			}
			%>
			</select>
			</p>
			<p class="text-center"><input type="submit" name="btnAsignar" value="Asignar"></p>
			</form>
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>