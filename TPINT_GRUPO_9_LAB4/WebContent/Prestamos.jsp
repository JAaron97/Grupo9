 	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<meta charset="utf-8">
<title>Prestamos</title>
</head>
<body>
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
		<% 
			session.setAttribute("Usuario", session.getAttribute("usuario"));
			if(session.getAttribute("Usuario") == null){
		%>
          <a class="nav-link active" aria-current="page" href="IniciarSesion.jsp">Iniciar Sesión</a>
		<%
			}
			else{
		%>
		<a class="nav-link disabled"><%= session.getAttribute("Usuario").toString() %></a>
		<a class="nav-link" href="IniciarSesion.jsp">Cerrar Sesión</a>
		<%
			}
		%>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Más
          </a>
          <ul class="dropdown-menu">
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
<!-- Encabezado, copiar y pegar en todos los jsp -->

<div>
<h1 style="text-align: left; margin: 2rem; font-family: Cambria,Georgia,serif">Prestamos</h1>
</div>

<div style="margin: 5rem ">

 <div class="card text-white bg-dark text-center my-3">
                <div class="card-body"><p class="text-white m-0" style="text-align: left;"> <a href="#">#3123</a> $700.000 </p> </div>
                
</div>
 <div class="card text-white bg-dark text-center my-3">
                <div class="card-body"><p class="text-white m-0" style="text-align: left;"> <a href="#">#3124</a> $1.900.000 </p> </div>
               
</div>
 <div class="card text-white bg-dark text-center my-3">
                <div class="card-body"><p class="text-white m-0" style="text-align: left;"> <a href="#">#3125</a> $900.000 </p> </div>
   
</div>

</div>

<div style="margin: 5rem ">

	<input type="submit" value="Solicitar un nuevo prestamo" class="form-control mt-4" name="btnAgregar">

</div>





<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</body>
</html>