package DaoImpl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.IDaoNacionalidad;


import Entidad.Nacionalidad;



public class DaoNacionalidad implements IDaoNacionalidad {

	private static final String readall = "SELECT * FROM nacionalidades ";
	private static final String read ="SELECT * FROM nacionalidades WHERE ID = ?";
	
	


	@Override
	public ArrayList<Nacionalidad> ReadAll() 
	{
		ArrayList<Nacionalidad> Nacionalidades = new ArrayList<Nacionalidad>();
		
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				Nacionalidades.add(getNacionalidad(resultSet));
			}
			
			
			conexion.cerrarConexion();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Nacionalidades;
	}
	
	
	@Override
	public Nacionalidad Read(int id)
	{
	
		Nacionalidad nacionalidad = null;
		
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				nacionalidad = getNacionalidad(resultSet);
			}
			
			conexion.cerrarConexion();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return nacionalidad;
	}


	
	
	
	private Nacionalidad getNacionalidad(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("ID");
		String descripcion = resultSet.getString("Descripcion");
		
		return new Nacionalidad(id,descripcion);
	}	

	
	
}
		
	



