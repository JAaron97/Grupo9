<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidad.Movimiento"%>
    <%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="controladorEstilos.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="utf-8">
<title>Movimientos</title>
</head>
<body>

<%
	ArrayList<Movimiento> listaMovimientos=null;
	if(request.getAttribute("listaUsuarios")!=null){
		listaMovimientos = (ArrayList<Movimiento>) request.getAttribute("listaUsuarios");
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
				session.setAttribute("Usuario", session.getAttribute("usuario"));
			%>
			<li class="nav-item">
			<a class="nav-link disabled">Jose</a>
			</li>
			<li class="nav-item">
			<a class="nav-link" href="IniciarSesion.jsp">Cerrar Sesi�n</a>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            M�s
	          </a>
	          <ul class="dropdown-menu">
				<li><a class="dropdown-item" href="Movimientos.jsp">Movimientos y Transferencias</a></li>
	            <li><a class="dropdown-item" href="Prestamos.jsp">Prestamos</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="#">Pedir cuenta bancaria</a></li>
	            <li><a class="dropdown-item" href="#">Informacion de Usuario</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<table>
		<tr>
			<th>ID</th>
			<th>Fecha</th>
			<th>Tipo</th>
			<th>Importe</th>
			<th>Cuenta origen</th>
			<th>Cuenta destino</th>
		</tr>
		<%
		if(listaMovimientos!=null)
			for(Movimiento mov : listaMovimientos){
		%>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td></td>
		</tr>
	</table>
	
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>	
</body>
</html>