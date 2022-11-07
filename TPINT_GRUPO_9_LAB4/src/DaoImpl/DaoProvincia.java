package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.IDaoProvincia;
import Entidad.Provincia;

public class DaoProvincia implements IDaoProvincia {

	private static final String readall = "SELECT * FROM provincias WHERE ID = ?";
	
	@Override
	public Provincia readall(int ID) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Provincia provincia = new Provincia();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setInt(1, ID);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				
				provincia.setID_Provincia(resultSet.getInt("ID"));
				provincia.setDescripcion(resultSet.getString("Descripcion"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return provincia;
	}

}
