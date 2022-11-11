package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Dao.IDaoLocalidad;
import Entidad.Localidad;
import Entidad.Provincia;


public class DaoLocalidad implements IDaoLocalidad {

	private static final String readall = "SELECT * FROM localidades";
	private static final String read = "SELECT * FROM localidades WHERE ID = ?";
	private DaoProvincia DP;
	
	@Override
	public ArrayList<Localidad> ReadAll() 
	{
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		
		
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
			  localidades.add(getLocalidades(resultSet)); 	
				
			}
			
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		
		return localidades;
	}

	
	public Localidad Read(int id) 
	{
		Localidad ld = null;
		
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
				
				ld = getLocalidades(resultSet);
			}
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return ld;
		
	}
	
	
	private Localidad getLocalidades(ResultSet resultSet) throws SQLException
	{
		this.DP = new DaoProvincia();
		
		int id = resultSet.getInt("ID");
		Provincia prov = DP.Read(resultSet.getInt("ID_Provincia"));
		String descripcion = resultSet.getString("Descripcion");
		
		this.DP = null; ///LIBERA LA VARIABLE DE LA INSTANCIA Y EL GARABE COLLECTOR ELIMINA LA INSTANCIA.
		
		return new Localidad(id,prov,descripcion);
	}
	
}
