<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidad.Usuario" %>
    <%@ page import="Entidad.NumeroCuotas" %>
    <%@ page import="DaoImpl.DaoNumeroCuotas" %>
    <%@ page import="DaoImpl.DaoCuenta" %>
    <%@ page import="Entidad.Cuenta" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="controladorEstilos.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="utf-8">
<title>Solicitar Prestamo</title>
</head>
<body>
	<%
Usuario user = new Usuario();
user = (Usuario) session.getAttribute("Usuario");

DaoNumeroCuotas dNC = new DaoNumeroCuotas(); 
ArrayList<NumeroCuotas> listaNumeroCuotas = new  ArrayList<NumeroCuotas>();
listaNumeroCuotas = dNC.ReadAll();

DaoCuenta dC = new DaoCuenta();
ArrayList<Cuenta> listaCuenta = new  ArrayList<Cuenta>();
listaCuenta = dC.ReadAll();
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
				<a class="nav-link disabled">sexo</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="CerrarSesion.jsp">Cerrar Sesión</a>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Más
	          </a>
	          <ul class="dropdown-menu">
	          <!-- Aca no hay if en el dropdown ya que es un panel que solo le va a ver si estas logeado -->
				<li><a class="dropdown-item" href="Movimientos.jsp">Movimientos y Transferencias</a></li>
	            <li><a class="dropdown-item" href="Prestamos.jsp">Prestamos</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="#">Pedir cuenta bancaria</a></li>
	            <li><a class="dropdown-item" href="InfoUsuario.jsp">Informacion de Usuario</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
<div class="container">
	<div class="row">
		<div class="col text-center">
			<form action="servletBanco" method="post">
			<p>Ingrese el importe que desea solicitar: <input type="number" name="txtImporte"></p>
			<p>
				Cantidad de cuotas: 
				<select name="cuotas">
					<%
					for(NumeroCuotas nc : listaNumeroCuotas){
						
					%>
					<option value="<%=nc.getDescripcion() %>"><%=nc.getDescripcion() %></option>
					<%
					}
					%>
				</select>
			</p>
			<p>
				Seleccione la cuenta para el prestamo:
				<select name="cuenta">
					<%
					for(Cuenta c : listaCuenta){
						if(user.getDNI()==c.getDNICliente()){
					%>
					<option value="<%c.getNumeroCuenta(); %>"><%=c.getNumeroCuenta() %></option>
					<%
						}
					}
					%>
				</select>
			</p>
			<p><input type="submit" name="btnSolicitar" value="Solicitar"></p>
			</form>
		</div>
	</div>
</div>	

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>