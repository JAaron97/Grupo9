package Servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Cuenta;
import Entidad.Localidad;
import Entidad.Movimiento;
import Entidad.Nacionalidad;
import Entidad.NumeroCuotas;
import Entidad.SolicitudCuenta;
import Entidad.SolicitudPrestamo;
import Entidad.Telefono;
import Entidad.TipoCuenta;
import Entidad.Usuario;
import NegocioImpl.CuentaNegImpl;
import NegocioImpl.LocalidadesNegImpl;
import NegocioImpl.MovimientoNegImpl;
import NegocioImpl.NacionalidadNegImpl;
import NegocioImpl.NumeroCuotasNegImpl;
import NegocioImpl.SolicitudCuentaNegImpl;
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
		
		if(request.getParameter("btnSolicitarCuenta") != null) {
			Usuario user = new Usuario();
			user = (Usuario) request.getSession().getAttribute("Usuario");
			CuentaNegImpl dC = new CuentaNegImpl();
			SolicitudCuenta SolicitudCuenta = new SolicitudCuenta();
			SolicitudCuentaNegImpl nSC = new SolicitudCuentaNegImpl();
			ArrayList<Cuenta> listaCuenta = new  ArrayList<Cuenta>();
			listaCuenta = dC.ReadAll();
			
			SolicitudCuenta.setDNI_Cliente(user.getDNI());
			SolicitudCuenta.setFechaSolicitud(java.time.LocalDate.now());
			boolean filas = false;
			 if(!maximoCuentas(listaCuenta, request, user.getDNI())) {
				 filas = nSC.Insert(SolicitudCuenta);
			 }
			 
			 request.setAttribute("Filas", filas);
			 RequestDispatcher rd = request.getRequestDispatcher("/InfoUsuario.jsp");
			 rd.forward(request, response);
		}
		
		if(request.getParameter("btnVerMovimientos")!=null) {
			String numeroCuenta = request.getParameter("numeroCuenta");
			MovimientoNegImpl mNeg = new MovimientoNegImpl();
			ArrayList<Movimiento> listaMovimientos = new ArrayList<Movimiento>();
			ArrayList<Movimiento> listaMovimientosCuenta = new ArrayList<Movimiento>();
			listaMovimientos = mNeg.ReadAll();
			
			for(Movimiento m : listaMovimientos) {
				if(m.getNumeroCuentaDestino().equals(numeroCuenta)) {
					listaMovimientosCuenta.add(m);
				}
			}
			
			request.setAttribute("listaMovCuenta", listaMovimientosCuenta);
			RequestDispatcher rd = request.getRequestDispatcher("/Movimientos.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnIngresar")!=null) {
			UsuarioNegImpl nU = new UsuarioNegImpl();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = (ArrayList<Usuario>) nU.readAll();
			boolean aux = false;
			
			RequestDispatcher rd = loginUsuario(usuarios, request);
			if(rd!=null) {
				rd.forward(request, response);
			}
			else {
				request.setAttribute("sesion", aux);
				RequestDispatcher rd2 = request.getRequestDispatcher("/IniciarSesion.jsp");
				rd2.forward(request, response);
			}
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
		
			if(request.getParameter("btnVercuentas")!=null) {
				CuentaNegImpl nC = new  CuentaNegImpl();
				ArrayList<Cuenta> cue = new ArrayList<Cuenta>();
				cue = (ArrayList<Cuenta>) nC.ReadAll();
				//pasar un el nro dni y listar solo las cuentas de esa dni
				
				int tipo= Integer.parseInt(request.getParameter("idUsuario"));
				ArrayList<Cuenta> rep = new ArrayList<Cuenta>();
				
				for(Cuenta x : cue) {
					if(Integer.parseInt(x.getDNICliente())==tipo) {
						rep.add(x);
					}
				}
				
				request.setAttribute("Listacuentas",rep);
				RequestDispatcher  rd = request.getRequestDispatcher("/Listar cuentas.jsp");
				rd.forward(request, response);
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
			 cuenta.setDNICliente(request.getParameter("DNI"));
			 cuenta.setFechaCreacion(java.time.LocalDate.now());
			 cuenta.setTipoCuenta(negTC.Read(getIdTipoCuenta(listaTipoCuentas, request)));
			 cuenta.setCBU(String.valueOf(rand.nextInt(999999)));
			 cuenta.setSaldo(BigDecimal.valueOf(10000));
			 
			 boolean filas = false;
			 if(!maximoCuentas(listaCuentas, request, request.getParameter("DNI"))) {
				 filas = negC.Insert(cuenta);
			 }
			 
			 request.setAttribute("Filas", filas);
			 RequestDispatcher rd = request.getRequestDispatcher("/ListaAsignarCuentas.jsp");
			 rd.forward(request, response);
		}
		
		if(request.getParameter("btnSolicitar")!=null) {
			SolicitudPrestamo sP = new SolicitudPrestamo();
			Usuario u = new Usuario();
			NumeroCuotasNegImpl negNC = new NumeroCuotasNegImpl();
			ArrayList<NumeroCuotas> listaNumeroCuotas = null;
			listaNumeroCuotas = negNC.ReadAll();
			u = (Usuario)request.getSession().getAttribute("Usuario");
			int importe = Integer.valueOf(request.getParameter("txtImporte"));
			
			
			sP.setDNICliente(u.getDNI());
			sP.setImportePedido(BigDecimal.valueOf(importe));
			sP.setCuentaDestinataria(request.getParameter("cuenta"));
			sP.setNumeroCuotas(negNC.Read(getIdNumeroCuotas(listaNumeroCuotas, request)));
			sP.setFecha(java.time.LocalDate.now());
			
		}
		
		if(request.getParameter("btnVerSolicitudCuentas")!=null) {
			SolicitudCuentaNegImpl nC = new  SolicitudCuentaNegImpl();
			ArrayList<SolicitudCuenta> scue = new ArrayList<SolicitudCuenta>();
			scue = (ArrayList<SolicitudCuenta>) nC.ReadAll();
			
			int tipo= Integer.parseInt(request.getParameter("idUsuario"));
			ArrayList<SolicitudCuenta> rep = new ArrayList<SolicitudCuenta>();
			
			for(SolicitudCuenta x : scue) {
				if(Integer.parseInt(x.getDNI_Cliente())==tipo) {
					rep.add(x);
				}
			}
			
			request.setAttribute("ListaSolicitudes",rep);
			RequestDispatcher  rd = request.getRequestDispatcher("/ListaSolicitudesCuenta.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnAceptarSolicitud")!=null) {
			SolicitudCuentaNegImpl scN = new SolicitudCuentaNegImpl();
			UsuarioNegImpl usN = new UsuarioNegImpl(); 
			SolicitudCuenta sc = new SolicitudCuenta(); 
			Usuario user = new Usuario();
			sc = scN.Read(Integer.parseInt(request.getParameter("Solicitud")));
			user = usN.Read(sc.getDNI_Cliente());

			boolean updateEsxitoso = scN.UpdateEstado(Integer.parseInt(request.getParameter("Solicitud")));
			
			request.setAttribute("update", updateEsxitoso);
			request.setAttribute("User", user);
			RequestDispatcher rd = request.getRequestDispatcher("/AsignarCuenta.jsp");
			rd.forward(request, response);
		}
	}
		
	public RequestDispatcher loginUsuario( ArrayList<Usuario> usuarios , HttpServletRequest request) {
		RequestDispatcher rd = null;
		for(Usuario user : usuarios) {
			if(user.getDNI().equals(request.getParameter("txtDNI")) && user.getPassword().equals(request.getParameter("txtPasswd"))) {
				request.getSession().setAttribute("Usuario", user);
				rd = request.getRequestDispatcher("/Inicio.jsp");
			} 
		}
		
		return rd;
	}
	
	public boolean maximoCuentas(ArrayList<Cuenta> listaCuentas, HttpServletRequest request, String DNI) {
		int cont;
		boolean maxCuentas = false;
		
		cont=0;
		for(Cuenta c : listaCuentas) {
			if(c.getDNICliente().equals(DNI)) {
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
	
	public int getIdNumeroCuotas(ArrayList<NumeroCuotas> listaNumeroCuotas, HttpServletRequest request) {
		int idNC = 0;
		for(NumeroCuotas nc : listaNumeroCuotas) {
			if(nc.getDescripcion().equals(request.getParameter("Localidad"))) {
				idNC = nc.getID(); 
			}
		}
		
		return idNC;
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
