package Negocio;

import java.util.List;


import Entidad.Usuario;

public interface UsuarioNeg {
	public boolean insert(Usuario usuario);
	
	public boolean Delete(Usuario usuario);
	
	public boolean update(Usuario usuario_a_modificar);
	
	public List<Usuario> readAll();
	
	public Usuario Read(String DNI);
}
