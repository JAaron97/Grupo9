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
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
</style>
</head>
<body class="fondo">

<%
Usuario user = new Usuario();
user = (Usuario) session.getAttribute("Usuario");
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
	        <li><a class="dropdown-item" href="AsignarCuentas.jsp">Ver cuentas y Solicitudes</a></li>
	        <li><a class="dropdown-item" href="PrestamosAdmin.jsp">Aceptar/Rechazar Prestamos</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<div class="containter">
	<div class="row">
		<div class="col">	
			<br>
			<form action="servletBanco" method="post">
			<p class="text-center">
			<select name="ddlId">
				<option value="0">--Seleccionar--</option>
						    <%
						    for( Usuario u : list){
						    %>
						    <option value="<%=u.getDNI()%>"><%=u.getDNI()%></option>
						    <%
						    }
						    %>
			</select>  <input type="submit" name ="btnFiltrar" value="Filtrar">
			</form>
			<br>
		</div>	
	</div>
	<div class="row">
		<div class="col-sm-8 mx-auto">	
			<table border="1">
			<tr> 
				<th>DNI</th>  
				<th> Nombre</th>  
				<th>Apellido</th>  
				<th>ID_Nacionalidades</th>
				<th>ID_Localidades</th>
				<th>CUIL </th>
				<th>Fecha_Nacimiento</th>
				<th>Mail</th>  
				<th>ID_Telefonos</th>
				<th>Password </th>
				<th>Tipo_user </th>
			</tr>
			<% 
				for( Usuario u : listaUsuarios) 
				{
			%>
			<tr>  
				<td><%=u.getDNI()%> </td>
				<td><%=u.getNombre()%></td>   
				<td><%=u.getApellido()%></td> 
				<td><%=u.getNacionalidad().getID() %></td>
				<td><%=u.getLocalidad().getIDLocalidad() %></td> 
				<td><%=u.getCUIL()%></td> 
				<td><%=u.getNacimiento() %></td>
				<td><%=u.getMail() %></td>
				<td><%=u.getTelefono().getID_Telefono()%></td>
				<td><%=u.getPassword() %></td>
				<td><%=u.getTipoUsuario()%></td>     
			</tr>
			<% 
			} 
			%>
		</table> 	
		</div>
	</div>
</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>