package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Dao.IDaoProvincia;
import Entidad.Provincia;

public class DaoProvincia implements IDaoProvincia {
	
	private static final String readall = "SELECT * FROM provincias";
	private static final String read = "SELECT * FROM provincias WHERE ID = ?";
	
	
	public ArrayList<Provincia> ReadAll()
	{
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<Provincia> Provincias = new ArrayList<Provincia>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				Provincias.add(getProvincias(resultSet));
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Provincias;
	}
	
	
	
	@Override
	public Provincia Read(int ID) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Provincia provincia = new Provincia();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setInt(1, ID);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				
				provincia = getProvincias(resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return provincia;
	}
	
	
	private Provincia getProvincias(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("ID");
		String descripcion = resultSet.getString("Descripcion");
		
		return new Provincia(id,descripcion);
	}
	
	
	
	
	

}
