package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.IDaoUsuario;
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
			+ " Fecha_Nacimiento, Direccion, Mail, ID_Telefonos, Password, Tipo_user) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM usuarios WHERE DNI = ?";
	private static final String readall = "SELECT * FROM usuarios";

	@Override
	public boolean insert(Usuario usuario, Nacionalidad nacionalidad, Telefono telefono, Localidad localidad) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setString(1, usuario.getDNI());
			statement.setString(2, usuario.getNombre());
			statement.setString(3, usuario.getApellido());
			statement.setInt(4, nacionalidad.getID_Nacionalidad());
			statement.setInt(5, localidad.getID_Localidad());
			statement.setString(6, usuario.getCUIL());
			statement.setInt(7, usuario.getSexo());
			statement.setDate(8, usuario.getNacimiento());
			statement.setString(9, usuario.getDireccion());
			statement.setString(10, usuario.getMail());
			statement.setInt(11, telefono.getID_Telefono());
			statement.setString(12, usuario.getPassword());
			statement.setInt(13, usuario.getTipo_Usuario());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
			
		return isInsertExitoso;
	}

	@Override
	public boolean delete(Usuario usuario_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, usuario_a_eliminar.getDNI());
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return isdeleteExitoso;
	}

	@Override
	public List<Usuario> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; 
		ArrayList<Usuario> personas = new ArrayList<Usuario>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getUsuario(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	@Override
	public boolean update(Usuario usuario_a_modificar) {
		// TODO Auto-generated method stub
		return false;
	}

	private Usuario getUsuario(ResultSet resultSet) throws SQLException {
		
		DaoNacionalidad dN = new DaoNacionalidad();
		DaoLocalidad dL = new DaoLocalidad();
		DaoTelefono dT = new DaoTelefono();
		
		 String DNI = resultSet.getString("DNI");
		 String Nombre = resultSet.getString("Nombre");
		 String Apellido = resultSet.getString("Apellido");
		 Nacionalidad Nacionalidad = dN.readAll(resultSet.getInt("ID_Nacionalidad"));
		 Localidad Localidad = dL.readAll(resultSet.getInt("ID_Localidad"));
		 String CUIL = resultSet.getString("CUIL");
		 int Sexo = resultSet.getInt("Sexo"); 
		 Date Nacimiento = resultSet.getDate("Fecha_Nacimiento");
		 String Direccion = resultSet.getString("Direccion");
		 String Mail = resultSet.getString("Mail");
		 Telefono Telefono = dT.readAll(resultSet.getInt("ID_Telefonos"));
		 String Password = resultSet.getString("Password");
		 int Tipo_Usuario = resultSet.getInt("Tipo_user");
		 return new Usuario(DNI, Nombre, Apellido, Nacionalidad, Localidad, CUIL, Sexo, Nacimiento, Direccion, Mail, Telefono, Password, Tipo_Usuario);
	}

}