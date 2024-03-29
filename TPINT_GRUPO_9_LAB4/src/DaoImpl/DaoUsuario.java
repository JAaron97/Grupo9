package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Dao.IDaoUsuario;

import java.sql.Connection;
import java.sql.Date;

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
			+ " Fecha_Nacimiento, Direccion, Mail, ID_Telefonos, Password, Tipo_user, Estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private static final String delete = "UPDATE usuarios SET Estado = 1 WHERE DNI = ?";
	
	private static final String readall = "SELECT * FROM usuarios";
	
	private static final String read = "SELECT * FROM usuarios WHERE DNI = ? ";
	
	private static final String update = "UPDATE usuarios SET Nombre = ?, Apellido = ?, ID_Nacionalidades = ? , ID_Localidades = ?, CUIL = ? "
			+ ", Sexo = ? , Fecha_Nacimiento = ? , Direccion = ? , Mail = ? , ID_Telefonos = ? , Password = ? , Tipo_user = ?  WHERE DNI = ? ";
	
	private static final String readcuil = "SELECT FROM usuarios WHERE CUIL = ? ";
	
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
			statement.setString(1 ,DNI);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				user = getUsuario(resultset);
			}
			
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
		int id_tel = getNewTelefono(User);
		
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
			statement.setObject(8,User.getNacimiento());
			statement.setString(9,User.getDireccion());
			statement.setString(10,User.getMail());
			statement.setInt(11, id_tel);
			statement.setString(12,User.getPassword());
			statement.setInt(13,User.getTipoUsuario());
			statement.setInt(14, User.getEstado());
			
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
	
	public boolean Delete(Usuario usuario)
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExito = false;
		try 
		{
			
			statement = conexion.prepareStatement(delete);
			
			statement.setString(1,usuario.getDNI());
			
			
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
			statement.setObject(7, user.getNacimiento());
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
		Date fecha;
		fecha = (Date) resultSet.getObject("Fecha_Nacimiento");
		LocalDate fechaNac = fecha.toLocalDate();
		
		
		String DNI = resultSet.getString("DNI");
		
		String Nombre = resultSet.getString("Nombre");
		
		String Apellido = resultSet.getString("Apellido");
		
		Nacionalidad Nacionalidad = getNacionalidad(resultSet.getInt("ID_Nacionalidades"));
		
		Localidad Localidad = getLocalidad(resultSet.getInt("ID_Localidades"));
		
		String CUIL = resultSet.getString("CUIL");
		
		String Sexo = resultSet.getString("Sexo");
		
		LocalDate Nacimiento = fechaNac;
		
		String Direccion = resultSet.getString("Direccion");
		
		String Mail = resultSet.getString("Mail");
		
		Telefono Telefono = getTelefono(resultSet.getInt("ID_Telefonos"));
		
		String Password = resultSet.getString("Password");
		
		int Tipo_Usuario = resultSet.getInt("Tipo_user");
		
		int estado = resultSet.getInt("Estado");
		
		return new Usuario(DNI, Nombre, Apellido, Nacionalidad, Localidad, CUIL, Sexo, Nacimiento, Direccion, Mail, Telefono, Password, estado, Tipo_Usuario);
		 
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
		
		id = DT.NextID();
		DT.Insert(user.getTelefono());
		
		return id;
	}
	
	public boolean DniExist(String dni) {
		
		boolean exist = false;
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		try 
		{
			
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setString(1,dni);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				exist = true;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return exist;
	}
	
public boolean CuilExist(String cuil) {
		
		boolean exist = false;
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		try 
		{
			
			statement = conexion.getSQLConexion().prepareStatement(readcuil);
			statement.setString(1,cuil);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				exist = true;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return exist;
	}
	
}
