 	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidad.Usuario" %>
    <%@ page import="NegocioImpl.PrestamoNegImpl" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="Entidad.Prestamo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="utf-8">
<title>Prestamos</title>
</head>
<body>
<%
Usuario user = new Usuario();
user = (Usuario) session.getAttribute("Usuario");

PrestamoNegImpl pNeg = new PrestamoNegImpl();

ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
	listaPrestamos = pNeg.readDNI(user.getDNI());
%>
<!-- Encabezado, copiar y pegar en todos los jsp -->
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
			<a class="nav-link" href="CerrarSesion.jsp">Cerrar Sesi?n</a>
		</li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            M?s
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="Movimientos.jsp">Movimientos y Transferencias</a></li>
	            <li><a class="dropdown-item" href="Prestamos.jsp">Prestamos</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="InfoUsuario.jsp">Informacion de Usuario</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
<%
for(Prestamo prest : listaPrestamos){
%>
<div class="card">
  <h5 class="card-header"><%=prest.getFecha() %></h5>
  <div class="card-body">
    <h5 class="card-title"><%=prest.getImporteInteres()%></h5>
    <p class="card-text"><%=prest.getCuentaDestinataria()%></p>
    <a href="#" class="btn btn-primary">Pagar</a>
  </div>
</div>
<% 
}
%>
<div style="margin: 5rem ">
	<a href="SolicitarPrestamo.jsp">Solicitar un nuevo prestamo</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>