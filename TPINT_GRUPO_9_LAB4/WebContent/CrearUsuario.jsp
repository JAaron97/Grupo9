<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidad.Usuario" %>
    <%@ page import="Entidad.Nacionalidad" %>
    <%@ page import="Entidad.Localidad" %>
    <%@ page import="NegocioImpl.NacionaldiadNegImpl" %>
    <%@ page import="NegocioImpl.LocaldiadesNegImpl" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Crear Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

</head>
<body>
<%
boolean sesionIniciada = false;
Usuario user = new Usuario();
user = (Usuario) session.getAttribute("Usuario");
NacionaldiadNegImpl nacioNeg = new NacionaldiadNegImpl();
LocaldiadesNegImpl locNeg = new LocaldiadesNegImpl();
ArrayList<Nacionalidad> listaNacionalidades = null; 
	listaNacionalidades = nacioNeg.ReadAll();
ArrayList<Localidad> listaLocalidades = null;
	listaLocalidades = locNeg.ReadAll();
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
			<a class="nav-link" href="IniciarSesion.jsp">Cerrar Sesión</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Más
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="CrearUsuario.jsp">Nuevo Cliente</a></li>
	        <li><a class="dropdown-item" href="AsignarCuentas.jsp">Asignar Cuentas</a></li>
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
			<p class="text-center">Nombre: <input type="text" name="txtNombre"> </p>
			<p class="text-center">Apellido: <input type="text" name="txtApellido"> </p>
			<p class="text-center">Dni: <input type="number" name="txtDni"></p>
			<p class="text-center">Nacionalidad:
				<select name="Nacionalidad">
					    <%
					    for(Nacionalidad nac : listaNacionalidades){
					    %>
					    <option><%=nac.getDescripcion() %></option>
					    <%
					    }
					    %>
				</select></p>
			<p class="text-center">Localidad:
				<select name="Nacionalidad">
					    <%
					    for(Localidad loc : listaLocalidades){
					    %>
					    <option><%=loc.getDescripcion() %></option>
					    <%
					    }
					    %>
				</select></p>
			<p class="text-center">CUIL: <input type="text" name="txtCuil"></p>
			<p class="text-center">Sexo: 
				<select name="Sexo">
					<option value="">Sexo</option>
					<option value="masculino">Masculino</option>
					<option value="femenino">Femenino</option>
					<option value="otro">Otro</option>
				</select>
			</p>
			<p class="text-center">Fecha de nacimiento: <input type="date" name="fechaNac"></p>
			<p class="text-center">Calle: <input type="text" name="txtCalle"> Altura: <input type="text" name="txtAltura"></p>
			<p class="text-center">Mail: <input type="email" placeholder="pedrogonzalez@gmail.com" name="mail"></p>
			<p class="text-center">Telefonos: <br> 
				<input type="number" name="telefono1" placeholder="Telefono 1"><br>
				<input type="number" name="telefono2" placeholder="Telefono 2"><br>
				<input type="number" name="telefono3" placeholder="Telefono 3"><br>
				<input type="number" name="telefono4" placeholder="Telefono 4">
			</p>
			<p class="text-center"> <input type="submit" name="btnRegistrarse" value="Registrarse"> </p> 
			</form>
		</div>
	</div>
</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

</body>
</html>