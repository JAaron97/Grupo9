<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ page import="Entidad.Usuario" %>
    <%@ page import="Entidad.Cuenta" %>
    <%@ page import="Entidad.Localidad" %>
    <%@ page import="NegocioImpl.NacionalidadNegImpl" %>
    <%@ page import="NegocioImpl.LocalidadesNegImpl" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
%>
<%
ArrayList<Cuenta> listaCuentas = new  ArrayList<Cuenta>();
if(request.getAttribute("listaUsu")!=null)
listaCuentas =  (ArrayList<Cuenta>) request.getAttribute("listaUsu");
ArrayList<Cuenta> list = new  ArrayList<Cuenta>();
if(request.getAttribute("Listacuentas")!=null)
list =  (ArrayList<Cuenta>) request.getAttribute("Listacuentas");
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
<form action="servletBanco" method="post">
			<p class="text-center">
			  
				</form>
				<br>
				
			<table id="cliente">
			<tr> 
				<th>Numero de Cuenta</th>  
				<th> Dni_Usuario</th>  
				<th>Fecha creacion</th>  
				<th>Tipo de cuenta </th>
				<th>Cbu</th>
				<th>Saldo </th>
				
				
			</tr>
			<% 
				for( Cuenta c : list) 
				{
			%>
			<tr>  
				<td><%=c.getNumeroCuenta()%> </td>
				<td><%=c.getDNICliente()%></td>   
				<td><%=c.getFechaCreacion()%></td> 
				<td><%=c.getTipoCuenta() %></td>
				<td><%=c.getCBU()%></td>
				<td><%=c.getSaldo()%></td> 
				
				   
			</tr>

			<% 
			} 
			%>
		</table> 
		<div class ="container fondo">
	<div class="row">
		<div class="col">
			<!-- poner acar si se creo cuenta correctamente -->
			
		</div>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>	
</body>
</html>