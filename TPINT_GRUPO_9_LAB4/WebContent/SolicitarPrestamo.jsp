<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="Entidad.Usuario" %>
    <%@ page import="Entidad.NumeroCuotas" %>
    <%@ page import="NegocioImpl.NumeroCuotasNegImpl" %>
    <%@ page import="NegocioImpl.CuentaNegImpl" %>
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
<body class="fondo">
	<%
Usuario user = new Usuario();
user = (Usuario) session.getAttribute("Usuario");

NumeroCuotasNegImpl dNC = new NumeroCuotasNegImpl(); 
ArrayList<NumeroCuotas> listaNumeroCuotas = new  ArrayList<NumeroCuotas>();
listaNumeroCuotas = dNC.ReadAll();

CuentaNegImpl dC = new CuentaNegImpl();
ArrayList<Cuenta> listaCuentas = new  ArrayList<Cuenta>();
listaCuentas = dC.readAllxDNI(user.getDNI());
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
			<a class="nav-link disabled"><%=user.getNombre() %></a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="CerrarSesion.jsp">Cerrar Sesión</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Más
          </a>
          <ul class="dropdown-menu">
			<li><a class="dropdown-item" href="Movimientos.jsp">Movimientos</a></li>
            <li><a class="dropdown-item" href="Prestamos.jsp">Prestamos</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="InfoUsuario.jsp">Informacion de Usuario</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>

<form action="servletBanco" method="post">
<div class="container">
	<div class="row">
		<div class="col text-center">
		<br>
			<p>Cuenta Destino: 
			<select name="selectCuenta">
				<%
				for(Cuenta cue : listaCuentas){
				%>
					<option><%=cue.getNumeroCuenta() %></option>
				<%
				}
				%>
			</select>
			</p>
			<p>Importe deseado: <input type="text" name="txtImporte"></p>
			
			<p>Numero de cuotas: 
			<select name="NumCuotas">
				<%
				for(NumeroCuotas nCuo : listaNumeroCuotas){
				%>
				<option><%=nCuo.getDescripcion()%></option>
				<%
				}
				%>
			</select>
			</p>
			<p><input type="submit" name="btnSolPrestamo" value="Solicitar"></p>
		</div>
	</div>
</div>
</form>
<%
if(request.getAttribute("insert")!=null){
	boolean insert = (boolean)request.getAttribute("insert");
	if(insert){
		%>
		<h2 class="text-center">Solicitud enviada correctamente</h2>
		<% 
	}
	else{
		%>
		<h2 class="text-center">no se pudo enviar la solicitud</h2>
		<%
	}
}
%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>