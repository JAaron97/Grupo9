package Servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidad.Localidad;
import Entidad.Nacionalidad;
import Entidad.Telefono;
import Entidad.Usuario;
import NegocioImpl.LocalidadesNegImpl;
import NegocioImpl.NacionalidadNegImpl;
import NegocioImpl.UsuarioNegImpl;

@WebServlet("/servletBanco")
public class servletBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		}
		if(request.getParameter("btnAsignarCuenta")!=null) {
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
