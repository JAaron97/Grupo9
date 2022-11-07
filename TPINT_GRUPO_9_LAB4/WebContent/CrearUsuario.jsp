<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            <li><a class="dropdown-item" href="Movimientos.jsp">Movimientos</a></li>
            <li><a class="dropdown-item" href="#">Solicitar Prestamo</a></li>
            <li><a class="dropdown-item" href="#">Prestamos</a></li>
            <li><a class="dropdown-item" href="#">Transferencia</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Pedir cuenta bancaria</a></li>
            <li><a class="dropdown-item" href="#">Informacion de Usuario</a></li>
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
			<form action="servletBanco" method="get">
			<p class="text-center">Nombre: <input type="text" name="txtNombre"> </p>
			<p class="text-center">Apellido: <input type="text" name="txtApellido"> </p>
			<p class="text-center">Dni: <input type="number" name="txtDni"></p>
			<p class="text-center">Nacionalidad:
				<select name="Nacionalidad">
					    <option value="">Seleccione</option>
					    <option value="argentina">Argentina</option>			
					    <option value="20">Afganistán</option>					
					    <option value="30">Albania</option>					
					    <option value="40">Alemania</option>					
					    <option value="50">Andorra</option>					
					    <option value="60">Angola</option>					
					    <option value="70">Anguilla</option>					
					    <option value="80">Antártida Argentina</option>					
					    <option value="90">Antigua y Barbuda</option>					
					    <option value="100">Antillas Holandesas</option>					
					    <option value="110">Arabia Saudita</option>					
					    <option value="120">Argelia</option>					
					    <option value="130">Armenia</option>					
					    <option value="140">Aruba</option>					
					    <option value="150">Australia</option>					
					    <option value="160">Austria</option>					
					    <option value="170">Azerbaiján</option>					
					    <option value="180">Bahamas</option>					
					    <option value="190">Bahrain</option>					
					    <option value="200">Bangladesh</option>					
					    <option value="210">Barbados</option>					
					    <option value="220">Bélgica</option>					
					    <option value="230">Belice</option>					
					    <option value="240">Benin</option>					
					    <option value="250">Bhutan</option>					
					    <option value="260">Bielorusia</option>					
					    <option value="bolivia">Bolivia</option>					
					    <option value="280">Bosnia Herzegovina</option>					
					    <option value="290">Botswana</option>					
					    <option value="300">Brasil</option>					
					    <option value="310">Brunei</option>					
					    <option value="320">Bulgaria</option>					
					    <option value="330">Burkina Faso</option>				
					    <option value="340">Burundi</option>				
					    <option value="350">Cabo Verde</option>			
					    <option value="360">Camboya</option>				
					    <option value="370">Camerún</option>				
					    <option value="380">Canadá</option>					
					    <option value="390">Chad</option>					
					    <option value="chile">Chile</option>					
					    <option value="410">China</option>				
					    <option value="420">Chipre</option>					
					    <option value="430">Colombia</option>					
					    <option value="440">Comoros</option>					
					    <option value="450">Congo</option>			
					    <option value="460">Corea del Norte</option>				
					    <option value="470">Corea del Sur</option>				
					    <option value="480">Costa de Marfil</option>				
					    <option value="490">Costa Rica</option>					
					    <option value="500">Croacia</option>					
					    <option value="510">Cuba</option>					
					    <option value="520">Darussalam</option>					
					    <option value="530">Dinamarca</option>					
					    <option value="540">Djibouti</option>					
					    <option value="550">Dominica</option>					
					    <option value="560">Ecuador</option>					
					    <option value="570">Egipto</option>					
					    <option value="580">El Salvador</option>					
					    <option value="590">Em. Arabes Un.</option>					
					    <option value="600">Eritrea</option>					
					    <option value="610">Eslovaquia</option>					
					    <option value="620">Eslovenia</option>					
					    <option value="espana">España</option>					
					    <option value="640">Estados Unidos</option>					
					    <option value="650">Estonia</option>					
					    <option value="660">Etiopía</option>					
					    <option value="670">Fiji</option>					
					    <option value="680">Filipinas</option>					
					    <option value="690">Finlandia</option>					
					    <option value="700">Francia</option>					
					    <option value="710">Gabón</option>					
					    <option value="720">Gambia</option>					
					    <option value="730">Georgia</option>					
					    <option value="740">Ghana</option>					
					    <option value="750">Gibraltar</option>				
					    <option value="760">Grecia</option>					
					    <option value="770">Grenada</option>					
					    <option value="780">Groenlandia</option>					
					    <option value="790">Guadalupe</option>					
					    <option value="800">Guam</option>				
					    <option value="810">Guatemala</option>					
					    <option value="820">Guayana Francesa</option>				
					    <option value="830">Guinea</option>					
					    <option value="840">Guinea Ecuatorial</option>					
					    <option value="850">Guinea-Bissau</option>
					    <option value="860">Guyana</option>					
					    <option value="870">Haití</option>					
					    <option value="880">Holanda</option>					
					    <option value="890">Honduras</option>					
					    <option value="900">Hong Kong</option>					
					    <option value="910">Hungría</option>					
					    <option value="920">India</option>					
					    <option value="930">Indonesia</option>					
					    <option value="940">Irak</option>					
					    <option value="950">Irán</option>					
					    <option value="960">Irlanda</option>					
					    <option value="970">Islandia</option>					
					    <option value="980">Islas Cayman</option>					
					    <option value="990">Islas Cook</option>					
					    <option value="1000">Islas Faroe</option>					
					    <option value="1010">Islas Marianas del Norte</option>					
					    <option value="1020">Islas Marshall</option>					
					    <option value="1030">Islas Solomon</option>					
					    <option value="1040">Islas Turcas y Caicos</option>					
					    <option value="1050">Islas Vírgenes</option>					
					    <option value="1060">Islas Wallis y Futuna</option>					
					    <option value="1070">Israel</option>					
					    <option value="1080">Italia</option>					
					    <option value="1090">Jamaica</option>					
					    <option value="1100">Japón</option>					
					    <option value="1110">Jordania</option>					
					    <option value="1120">Kazajstán</option>					
					    <option value="1130">Kenya</option>					
					    <option value="1140">Kirguistán</option>					
					    <option value="1150">Kiribati</option>					
					    <option value="1160">Kuwait</option>					
					    <option value="1170">Laos</option>					
					    <option value="1180">Lesotho</option>					
					    <option value="1190">Letonia</option>					
					    <option value="1200">Líbano</option>					
					    <option value="1210">Liberia</option>					
					    <option value="1220">Libia</option>					
					    <option value="1230">Liechtenstein</option>					
					    <option value="1240">Lituania</option>					
					    <option value="1250">Luxemburgo</option>					
					    <option value="1260">Macao</option>					
					    <option value="1270">Macedonia</option>					
					    <option value="1280">Madagascar</option>					
					    <option value="1290">Malasia</option>					
					    <option value="1300">Malawi</option>					
					    <option value="1310">Mali</option>					
					    <option value="1320">Malta</option>					
					    <option value="1330">Marruecos</option>					
					    <option value="1340">Martinica</option>					
					    <option value="1350">Mauricio</option>					
					    <option value="1360">Mauritania</option>					
					    <option value="1370">Mayotte</option>
					    <option value="1380">México</option>					
					    <option value="1390">Micronesia</option>					
					    <option value="1400">Moldova</option>					
					    <option value="1410">Mónaco</option>					
					    <option value="1420">Mongolia</option>					
					    <option value="1430">Montserrat</option>					
					    <option value="1440">Mozambique</option>					
					    <option value="1450">Myanmar</option>
						<option value="1460">Namibia</option>					
					    <option value="1470">Nauru</option>					
					    <option value="1480">Nepal</option>					
					    <option value="1490">Nicaragua</option>					
					    <option value="1500">Níger</option>					
					    <option value="1510">Nigeria</option>					
					    <option value="1520">Noruega</option>					
					    <option value="1530">Nueva Caledonia</option>					
					    <option value="1540">Nueva Zelandia</option>					
					    <option value="1550">Omán</option>					
					    <option value="1570">Pakistán</option>					
					    <option value="1580">Panamá</option>					
					    <option value="1590">Papua Nueva Guinea</option>					
					    <option value="paraguay">Paraguay</option>					
					    <option value="1610">Perú</option>					
					    <option value="1620">Pitcairn</option>					
					    <option value="1630">Polinesia Francesa</option>					
					    <option value="1640">Polonia</option>					
					    <option value="1650">Portugal</option>					
					    <option value="1660">Puerto Rico</option>					
					    <option value="1670">Qatar</option>					
					    <option value="1680">RD Congo</option>					
					    <option value="1690">Reino Unido</option>					
					    <option value="1700">República Centroafricana</option>					
					    <option value="1710">República Checa</option>					
					    <option value="1720">República Dominicana</option>					
					    <option value="1730">Reunión</option>					
					    <option value="1740">Rumania</option>					
					    <option value="1750">Rusia</option>					
					    <option value="1760">Rwanda</option>					
					    <option value="1770">Sahara Occidental</option>					
					    <option value="1780">Saint Pierre y Miquelon</option>					
					    <option value="1790">Samoa</option>					
					    <option value="1800">Samoa Americana</option>					
					    <option value="1810">San Cristóbal y Nevis</option>					
					    <option value="1820">San Marino</option>					
					    <option value="1830">Santa Elena</option>					
					    <option value="1840">Santa Lucía</option>					
					    <option value="1850">Sao Tomé y Príncipe</option>					
					    <option value="1860">Senegal</option>					
					    <option value="1870">Serbia y Montenegro</option>					
					    <option value="1880">Seychelles</option>					
					    <option value="1890">Sierra Leona</option>					
					    <option value="1900">Singapur</option>					
					    <option value="1910">Siria</option>					
					    <option value="1920">Somalia</option>					
					    <option value="1930">Sri Lanka</option>					
			    		<option value="1940">Sudáfrica</option>					
					    <option value="1950">Sudán</option>				
					    <option value="1960">Suecia</option>					
						<option value="1970">Suiza</option>			
					    <option value="1980">Suriname</option>			
					    <option value="1990">Swazilandia</option>			
					    <option value="2000">Taiwán</option>
		    			<option value="uruguay">Uruguay</option>
				</select></p>
			<p class="text-center">Localidad: <input type="text" name="txtLocalidad"></p>
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