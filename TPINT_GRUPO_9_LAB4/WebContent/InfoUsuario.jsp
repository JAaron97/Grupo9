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
        	<h6 class="mt-2 mb-3">Cuentas</h6>
        	
        	<table class="table user-view-table m-0">
        		<tbody>
        		<%
        		for(Cuenta cu : listaCuenta){
        			if(cu.getDNICliente().equals(user.getDNI())){
        		%>
        			<tr>
        				<td>Numero de cuenta:</td>
        				<td><%=cu.getNumeroCuenta() %></td>
        			</tr>
        			<tr>
        				<td>Tipo de Cuenta:</td>
        				<td><%=cu.getTipoCuenta().getDescripcion()%></td>
        			</tr>
        			<tr>
        				<td>CBU:</td>
        				<td><%=cu.getCBU()%></td>
        			</tr>
        			<tr>
        				<td>Saldo:</td>
        				<td><%=cu.getSaldo()%></td>
        			</tr>
        			<tr>
        				<td><hr></td>
        			</tr>
        		<%
        			}
        		}
        		%>
        		</tbody>
        	</table>
			<%
				if(request.getAttribute("Filas") != null){
					boolean filas = false;
					filas = (Boolean)request.getAttribute("Filas");
					if(filas){
						%>
						<p class="text-center">Cuenta Solicitada correctamente</p>
						<%
					}
					else{
						%>
							<p class="text-center">Ya posee el maximo de cuentas</p>
						<%
					}
				}
			%>
        	<form action="servletBanco" method="get">
        	<input type="submit" name="btnSolicitarCuenta" value="Solicitar nueva cuenta">
        	</form>
        </div>
        <hr class="border-light m-0">
        </div>
        	<div class="card col-md-8 order-md-1">
            <hr class="border-light m-0">
            <div class="card-body">
                <h6 class="mt-2 mb-3">Personal info</h6>
                
            	<table class="table user-view-table m-0">
                	<tbody>
                  		<tr>
                  			<td>DNI:</td>
                  			<td><%= user.getDNI() %></td>
                  		</tr>
                    	<tr>
                     	 <td>Nombre:</td>
                    	  <td><%= user.getNombre()%></td>
                  		</tr>
                    	<tr>
                    		<td>Apellido:</td>
                    		<td><%= user.getApellido()%></td>
                    	</tr>
                    	<tr>
                      		<td>E-mail:</td>
                      		<td><%= user.getMail() %></td>
                    	</tr>
                    	<tr>
                      		<td>Nacimiento:</td>
                      		<td><%= user.getNacimiento() %></td>
                    	</tr>
                    	<tr>
                      		<td>Nacionalidad:</td>
                      		<td><%= user.getNacionalidad().getDescripcion() %></td> 
                    	</tr>
                    	<tr>
                    		<td>Localidad:</td>
                    		<td><%= user.getLocalidad().getDescripcion() %></td>
                    	</tr>
                    	<tr>
                    		<td>CUIL:</td>
                    		<td><%= user.getCUIL() %></td>
                    	</tr>
                    	<tr>
                    		<td>Sexo:</td>
                    		<td><%= user.getSexo() %></td>
                    	</tr>
                    	<tr>
                    		<td>Direccion:</td>
                    		<td><%= user.getDireccion() %></td>
                    	</tr>
                  	</tbody>
                </table>
           
                <h6 class="mt-4 mb-3">Telefonos</h6>
                    
                <table class="table user-view-table m-0">
                	<tbody>
	                    <tr>
	                      <td>Telefono 1:</td>
	                      <td><%= user.getTelefono().getTelefono_1() %></td>
	                    </tr>
	                    <tr>
	                    <td>Telefono 2:</td>
	                    	<td><%= user.getTelefono().getTelefono_2() %></td>
	                    </tr>
	                    <tr>
	                    <td>Telefono 3:</td>
	                    	<td><%= user.getTelefono().getTelefono_3() %></td>
	                    </tr>
	                    <tr>
	                    <td>Telefono 4:</td>
	                    	<td><%= user.getTelefono().getTelefono_4() %></td>
	                    </tr>
                  </tbody>
                </table>
        	</div>
    	</div>
	</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>	
</body>
</html>