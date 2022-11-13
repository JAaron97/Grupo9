package DaoImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.IDaoUsuario;

import java.sql.Connection;

import DaoImpl.Conexion;
import DaoImpl.DaoNacionalidad;
import DaoImpl.DaoLocalidad;
import DaoImpl.DaoTelefono;
import Entidad.Localidad;
import Entidad.Nacionalidad;
import Entidad.Telefono;
import Entidad.Usuario;

public class DaoUsuario implements IDaoUsuario{
	
	private static final String insert = "INSERT INTO usuarios(DNI, Nombre, Apellido, ID_Nacionalidades, ID_Localidades, CUIL, Sexo,"
			+ " Fecha_Nacimiento, Direccion, Mail, ID_Telefonos, Password, Tipo_user) VALUES('?', '?', '?', ?, ?, '?', '?', ?, '?', '?', ?, '?', ?)";
	
	private static final String delete = "DELETE FROM usuarios WHERE DNI = '?' ";
	
	private static final String readall = "SELECT * FROM usuarios";
	
	private static final String read = "SELECT FROM usuarios WHERE DNI = '?' ";
	
	private static final String update = "UPDATE usuarios SET Nombre = '?', Apellido = '?', ID_Nacionalidades = ? , ID_Localidades = ?, CUIL = '?' "
			+ ", Sexo = '?' , Fecha_Nacimiento = ? , Direccion = '?' , Mail = '?' , ID_Telefonos = ? , Password = '?' , Tipo_user = ?  WHERE DNI = '?' ";
	
	private DaoLocalidad DL;
	private DaoNacionalidad DN;
	private DaoTelefono DT;
	
	public ArrayList<Usuario> ReadAll()
	{
		ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
		
		Conexion conexion = Conexion.getConexion();
		PreparedStatement statement;
		ResultSet resultset;
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				Usuarios.add(getUsuario(resultset));
			}
			
			conexion.cerrarConexion();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return Usuarios;
	}
	
	
	public Usuario Read(String DNI) 
	{
		Usuario user = null;
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		try 
		{
			
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setString(1,DNI);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				user = getUsuario(resultset);
			}
			
			conexion.cerrarConexion();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return user;
		
	}


	public boolean Insert(Usuario User) 
	{
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isInsertExistoso = false;
		
		try 
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setString(1, User.getDNI());
			statement.setString(2, User.getNombre());
			statement.setString(3,User.getApellido());
			statement.setInt(4,User.getNacionalidad().getID());
			statement.setInt(5,User.getLocalidad().getIDLocalidad());
			statement.setString(6,User.getCUIL());
			statement.setString(7,User.getSexo());
			statement.setDate(8,User.getNacimiento());
			statement.setString(9,User.getDireccion());
			statement.setString(10,User.getMail());
			
			
			statement.setInt(11,getNewTelefono(User));
			
			statement.setString(12,User.getPassword());
			statement.setInt(13,User.getTipoUsuario());
			
			if(statement.executeUpdate() > 0 )
			{
				conexion.commit();
				isInsertExistoso = true;
				
			}
			
			
		}
		catch (Exception e) 
		{
		
			e.printStackTrace();
			try 
			{
				conexion.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		return isInsertExistoso;
		
	}
	
	public boolean Delete(String DNI) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isDeleteExito = false;
		
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, DNI);
			
			if(statement.executeUpdate() > 0 )
			{
				conexion.commit();
				isDeleteExito = true;
			}	
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
			try 
			{
				conexion.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
		}
		
		return isDeleteExito;
	}
	
	public boolean Update(Usuario user) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExito = false;
		
		try 
		{
			
			statement = conexion.prepareStatement(update);
			
			statement.setString(1,user.getNombre());
			statement.setString(2,user.getApellido());
			statement.setInt(3, user.getNacionalidad().getID());
			statement.setInt(4,user.getLocalidad().getIDLocalidad());
			statement.setString(5, user.getCUIL());
			statement.setString(6, user.getSexo());
			statement.setDate(7, user.getNacimiento());
			statement.setString(8,user.getDireccion());
			statement.setString(9,user.getMail());
			statement.setInt(10,user.getTelefono().getID_Telefono());
			statement.setString(11,user.getPassword());
			statement.setInt(12,user.getTipoUsuario());
			
			statement.setString(13, user.getDNI());
			
			if(statement.executeUpdate() > 0 )
			{
				conexion.commit();
				isUpdateExito = true;
			}
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			
			try 
			{
				conexion.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		return isUpdateExito;
	}
	
	
	private Usuario getUsuario(ResultSet resultSet) throws SQLException 
	{
		String DNI = resultSet.getString("DNI");
		
		String Nombre = resultSet.getString("Nombre");
		
		String Apellido = resultSet.getString("Apellido");
		
		Nacionalidad Nacionalidad = getNacionalidad(resultSet.getInt("ID_Nacionalidades"));
		
		Localidad Localidad = getLocalidad(resultSet.getInt("ID_Localidades"));
		
		String CUIL = resultSet.getString("CUIL");
		
		String Sexo = resultSet.getString("Sexo");
		
		Date Nacimiento = resultSet.getDate("Fecha_Nacimiento");
		
		String Direccion = resultSet.getString("Direccion");
		
		String Mail = resultSet.getString("Mail");
		
		Telefono Telefono = getTelefono(resultSet.getInt("ID_Telefonos"));
		
		String Password = resultSet.getString("Password");
		
		int Tipo_Usuario = resultSet.getInt("Tipo_user");
		
		return new Usuario(DNI, Nombre, Apellido, Nacionalidad, Localidad, CUIL, Sexo, Nacimiento, Direccion, Mail, Telefono, Password, Tipo_Usuario);
		 
	}
	
	private Nacionalidad getNacionalidad(int id) {
		
		this.DN = new DaoNacionalidad();
		
		Nacionalidad nc = DN.Read(id); 
		
		return  nc;
	}
	
	private Localidad getLocalidad(int id) {
		
		this.DL = new DaoLocalidad();
		
		Localidad nc = DL.Read(id); 
		
		return  nc;
	}
	
	private Telefono getTelefono(int id) {
		
		this.DT = new DaoTelefono();
		
		Telefono nc = DT.Read(id);
		
		return nc;
		
	}
	
	private int getNewTelefono(Usuario user) {
		
		int id=0;
		this.DT = new DaoTelefono();
		
		DT.Insert(user.getTelefono());
		id = DT.NextID();
		
		return id;
	}

}
