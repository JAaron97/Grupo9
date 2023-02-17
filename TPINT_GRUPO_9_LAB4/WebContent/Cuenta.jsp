<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidad.Usuario" %>
	<%@ page import="Entidad.Cuenta" %>
    <%@ page import="NegocioImpl.CuentaNegImpl" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="infouser.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Usuario user = new Usuario();
user = (Usuario) session.getAttribute("Usuario");

Cuenta cuen = new Cuenta();
cuen = (Cuenta) session.getAttribute("Cuenta");

CuentaNegImpl dC = new CuentaNegImpl();
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
				<a class="nav-link disabled"><%= user.getNombre()%></a>
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

<div class="container bootdey flex-grow-1 container-p-y">
	<div class="media align-items-center py-3 mb-3">
		<div class="media-body ml-4">
        	<h2 class="font-weight-bold mb-0"><%= user.getNombre()%></h2>
        </div>
	</div>
	<div class="row">
    <div class="card mb-4 col-md-4 order-md-2">
    	<div class="card-body">

<table class="table user-view-table m-0">
        		<tbody>
        	
        			<tr>
        		
        			
        				<td>Numero de cuenta:</td>
        				<td><%=cuen.getNumeroCuenta() %></td>
        				
        			</tr>
        			<tr>
        				<td>Tipo de Cuenta:</td>
        				<td><%=cuen.getTipoCuenta().getDescripcion()%></td>
        			</tr>
        			<tr>
        				<td>CBU:</td>
        				<td><%=cuen.getCBU()%></td>
        			</tr>
        			<tr>
        				<td>Saldo:</td>
        				<td><%=cuen.getSaldo()%></td>
        			</tr>
        			<tr>
        			<td>
        				<form action="servletBanco" method="post" name="form">
        			
        			</td>
        			<td>
        			<input type="hidden" value=<%=cuen.getCBU()%> name="txtcbuOrigen">
        			</form>
        			</td>
        			
        			
        			</tr>
        			
        		
        		</tbody>
        	</table>
        	<form action="servletBanco" method="post" name="form">
        			<input type="submit" value="Hacer una transferencia" name="BtnTransferencia">
        			<input type="hidden" value=<%=cuen.getCBU()%> name="txtcbuOrigen">
        			</form>
        	


</body>
</html>