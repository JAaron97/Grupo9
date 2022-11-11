package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.DaoUsuario;
import Entidad.Usuario;

@WebServlet("/servletBanco")
public class servletBanco extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnIngresar")!=null) {
			DaoUsuario dU = new DaoUsuario();
			ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
			usuarios = (ArrayList<Usuario>) dU.readAll();
			
			for(Usuario user : usuarios) {
				if(user.getDNI().equals(request.getParameter("txtDNI")) && user.getPassword().equals(request.getParameter("txtPasswd"))) {
					request.getSession().setAttribute("Usuario", user);
					RequestDispatcher rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
				}
				else {
					request.getSession().setAttribute("Usuario", null);
					RequestDispatcher rd = request.getRequestDispatcher("/Inicio.jsp");
					rd.forward(request, response);
				}
			}	
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
