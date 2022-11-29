package Servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cuenta;
import Entidad.Localidad;
import Entidad.Nacionalidad;
import Entidad.Telefono;
import Entidad.TipoCuenta;
import Entidad.Usuario;
import NegocioImpl.CuentaNegImpl;
import NegocioImpl.LocalidadesNegImpl;
import NegocioImpl.NacionalidadNegImpl;
import NegocioImpl.TipoCuentaNegImpl;
import NegocioImpl.UsuarioNegImpl;

@WebServlet("/servletBanco")
public class servletBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("param")!=null)
		{
			
			String param= request.getParameter("param").toString();
			if(param.equals("add")) 
			{
				NacionalidadNegImpl Na =  new NacionalidadNegImpl();
				ArrayList<Nacionalidad> nacionalidades = new ArrayList<Nacionalidad>();
				nacionalidades =(ArrayList<Nacionalidad>)Na.ReadAll();
				LocalidadesNegImpl Lo =  new LocalidadesNegImpl();
				ArrayList<Localidad> localidadades = new ArrayList<Localidad>();
				localidadades =(ArrayList<Localidad>)Lo.ReadAll();
				
				request.setAttribute("Localidades",localidadades);
				request.setAttribute("Nacionalidades",nacionalidades);
				RequestDispatcher rd = request.getRequestDispatcher("/CrearUsuario.jsp");
				rd.forward(request, response);
			}		
			else if(param.equals("list"))
			{
				UsuarioNegImpl nU = new UsuarioNegImpl();
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				usuarios = (ArrayList<Usuario>) nU.readAll();
				request.setAttribute("listaUsu",usuarios);
				request.setAttribute("ListaIdUsuarios",usuarios);
				RequestDispatcher  rd = request.getRequestDispatcher("/ListarUsuarios.jsp");
				rd.forward(request, response);
				
			}
			
			else if(param.equals("eliminar"))
			{
				UsuarioNegImpl nU = new UsuarioNegImpl();
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				usuarios = (ArrayList<Usuario>) nU.readAll();
				request.setAttribute("listaUsu",usuarios);
				RequestDispatcher  rd = request.getRequestDispatcher("/EliminarUsuarios.jsp");
				rd.forward(request, response);
			
			}
			else if (param.equals("modificar")) {
				
				UsuarioNegImpl nU = new UsuarioNegImpl();
				ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
				usuarios = (ArrayList<Usuario>) nU.readAll();
				request.setAttribute("listaUsu",usuarios);
				RequestDispatcher  rd = request.getRequestDispatcher("/ModificarUsuario.jsp");
				rd.forward(request, response);
			}
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(request.getParameter("btnIngresar")!=null) {
			UsuarioNegImpl nU = new UsuarioNegImpl();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = (ArrayList<Usuario>) nU.readAll();
			for(Usuario user : usuarios) {
				if(user.getDNI().equals(request.getParameter("txtDNI")) && user.getPassword().equals(request.getParameter("txtPasswd"))) {
					request.getSession().setAttribute("Usuario", user);
					RequestDispatcher rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
				}
			}
			/*esto no sirve por que te cierra la secion cuando salis de inicio*/
			/*request.getSession().setAttribute("Usuario", null);
			RequestDispatcher rd = request.getRequestDispatcher("/IniciarSesion.jsp");
			rd.forward(request, response);*/
		}
		
if(request.getParameter("btnModificar")!=null) {
			
			UsuarioNegImpl nU = new UsuarioNegImpl();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = (ArrayList<Usuario>) nU.readAll();
			for(Usuario user : usuarios) {
				if(user.getDNI().equals(request.getParameter("idUsuario")) ) {
				
					user.setPassword(request.getParameter("txtPasword").toString());
					nU.update(user);
					
			}
				}
		
			
            ArrayList<Usuario> lista= usuarios;
			request.setAttribute("listaUsu", lista);
			
			RequestDispatcher  rd = request.getRequestDispatcher("/ModificarUsuario.jsp");
	        rd.forward(request, response);
			
			
		}
		
		if(request.getParameter("btnFiltrar")!=null) {
			UsuarioNegImpl nU = new UsuarioNegImpl();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = (ArrayList<Usuario>) nU.readAll();
			try 
			{
				if(Integer.parseInt(request.getParameter("ddlId").toString()) == 0) {
					request.setAttribute("listaUsu",usuarios);
				}
				else
				{
					int  tipo= Integer.parseInt(request.getParameter("ddlId").toString());
					ArrayList<Usuario> rep = new ArrayList<Usuario>();
					
					for(int i=0; i<usuarios.size();i++) {
						Usuario x = new Usuario();
						x=usuarios.get(i);
						
						if(Integer.parseInt(x.getDNI())==tipo) {
							
							rep.add(usuarios.get(i));
						}
					}
					request.setAttribute("listaUsu",rep);	
				}
				request.setAttribute("ListaIdUsuarios",usuarios);
				RequestDispatcher rd = request.getRequestDispatcher("/ListarUsuarios.jsp");
				rd.forward(request, response);
			}
			catch (Exception e) 
			{
			e.printStackTrace();
			request.setAttribute("ListaIdUsuarios",usuarios);
			
			RequestDispatcher rd = request.getRequestDispatcher("/CrearUsuario.jsp");
			rd.forward(request, response);
			}	
		}
		
		if(request.getParameter("btnEliminar2")!=null)
		{
			UsuarioNegImpl nU = new UsuarioNegImpl();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = (ArrayList<Usuario>) nU.readAll();
			String aux = request.getParameter("idUsuario").toString();
			System.out.println(aux);
			for(Usuario user : usuarios) {
				if(user.getDNI().equals(request.getParameter("idUsuario")) ) {
					nU.Delete(user);
				}
			}
			
		     ArrayList<Usuario> lista= usuarios;
				request.setAttribute("listaUsu", lista);
				
				RequestDispatcher  rd = request.getRequestDispatcher("/EliminarUsuarios.jsp");
		        rd.forward(request, response);
			
		}
		
		if(request.getParameter("btnCrear")!=null) {
			UsuarioNegImpl negU = new UsuarioNegImpl();
			NacionalidadNegImpl negN = new NacionalidadNegImpl();
			LocalidadesNegImpl negL = new LocalidadesNegImpl();
			Usuario user = new Usuario();
			
			user = cargarUsuario(user, negU, negN, negL, request);
			boolean filas = negU.insert(user);
			
			request.setAttribute("cantFilas", filas);
			RequestDispatcher rd = request.getRequestDispatcher("/CrearUsuario.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnAsignar")!=null) {
			 Cuenta cuenta = new Cuenta();
			 Random rand = new Random();
			 TipoCuentaNegImpl negTC = new TipoCuentaNegImpl();
			 CuentaNegImpl negC = new CuentaNegImpl();
			 ArrayList<TipoCuenta> listaTipoCuentas = new ArrayList<TipoCuenta>();
			 ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
			 listaCuentas = negC.ReadAll();
			 listaTipoCuentas = negTC.ReadAll();
			 
			 cuenta.setNumeroCuenta(String.valueOf(rand.nextInt(50000)));
			 cuenta.setDNICliente(request.getParameter("txtDNI"));
			 cuenta.setFechaCreacion(java.time.LocalDate.now());
			 cuenta.setTipoCuenta(negTC.Read(getIdTipoCuenta(listaTipoCuentas, request)));
			 cuenta.setCBU(String.valueOf(rand.nextInt(999999)));
			 cuenta.setSaldo(BigDecimal.valueOf(10000));
			 
			 boolean filas = false;
			 if(!maximoCuentas(listaCuentas, request)) {
				 filas = negC.Insert(cuenta);
			 }
			 
			 request.setAttribute("Filas", filas);
			 RequestDispatcher rd = request.getRequestDispatcher("/ListaAsignarCuentas.jsp");
			 rd.forward(request, response);
		
	}
		}
		
	
	
	public boolean maximoCuentas(ArrayList<Cuenta> listaCuentas, HttpServletRequest request) {
		int cont;
		boolean maxCuentas = false;
		
		cont=0;
		for(Cuenta c : listaCuentas) {
			if(c.getDNICliente().equals(request.getParameter("txtDNI"))) {
				cont++;
			}
		}
		if(cont == 3) {
			maxCuentas=true;
		}
		
		return maxCuentas;
	}
	
	public int getIdTipoCuenta(ArrayList<TipoCuenta> listaTipoCuentas, HttpServletRequest request ) {
		int idTC = 0;
		for(TipoCuenta tc : listaTipoCuentas) {
			if(tc.getDescripcion().equals(request.getParameter("TipoCuenta"))) {
				idTC = tc.getID();
			}
		}
		
		return idTC;
	}

	
	public Usuario cargarUsuario(Usuario user, UsuarioNegImpl negU, NacionalidadNegImpl negN, LocalidadesNegImpl negL, HttpServletRequest request) {
		
		ArrayList<Nacionalidad> listaNacionalidades = null;
		ArrayList<Localidad> listaLocalidades = null;
		listaNacionalidades = negN.ReadAll();
		listaLocalidades = negL.ReadAll();
		Telefono tel = new Telefono();
	    
		user.setDNI(request.getParameter("txtDni"));
		user.setNombre(request.getParameter("txtNombre"));
		user.setApellido(request.getParameter("txtApellido"));
		user.setNacionalidad(negN.Read(getIdNacionalidad(listaNacionalidades, request)));
		user.setLocalidad(negL.Read(getIdLocalidad(listaLocalidades, request)));
		user.setCUIL(request.getParameter("txtCuil"));
		user.setSexo(getSexo(request));
		user.setNacimiento(getFechaNac(request));
		user.setDireccion(request.getParameter("txtCalle") + " " + request.getParameter("txtAltura"));
		user.setMail(request.getParameter("mail"));
		user.setTelefono(cargarTelefonos(tel, request));
		user.setPassword(request.getParameter("txtPassword"));
		user.setTipoUsuario(0);
		
		return user;
	}
	
	public String getSexo(HttpServletRequest request) {
		String sexo = null;
		if(request.getParameter("Sexo")=="masculino") {
			sexo="M";
		}
		else if(request.getParameter("Sexo")=="femenino") {
			sexo="F";
		}
		else {
			sexo="X";
		}
		return sexo;
	}
	
	public int getIdNacionalidad(ArrayList<Nacionalidad> listaNacionalidades, HttpServletRequest request ) {
		int idNac = 0;
		for(Nacionalidad nac : listaNacionalidades) {
			if(nac.getDescripcion().equals(request.getParameter("Nacionalidad"))) {
				idNac = nac.getID();
			}
		}
		
		return idNac;
	}
	
	public int getIdLocalidad(ArrayList<Localidad> listaLocalidades, HttpServletRequest request) {
		int idLoc = 0;
		for(Localidad loc : listaLocalidades) {
			if(loc.getDescripcion().equals(request.getParameter("Localidad"))) {
				idLoc = loc.getIDLocalidad(); 
			}
		}
		
		return idLoc;
	}
	
	public LocalDate getFechaNac(HttpServletRequest request) {
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy, MM, dd", Locale.ENGLISH);
		LocalDate fechaNac = LocalDate.parse(request.getParameter("fechaNac"));
		return fechaNac;
	}
	
	public Telefono cargarTelefonos(Telefono tel, HttpServletRequest request) {
		tel.setTelefono_1(request.getParameter("telefono1"));
		tel.setTelefono_2(request.getParameter("telefono2"));
		tel.setTelefono_3(request.getParameter("telefono3"));
		tel.setTelefono_4(request.getParameter("telefono4"));
		
		return tel;
	}
}
