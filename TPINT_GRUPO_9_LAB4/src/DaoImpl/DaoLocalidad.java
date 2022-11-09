package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.IDaoLocalidad;
import Entidad.Localidad;


public class DaoLocalidad implements IDaoLocalidad {

	private static final String readall = "SELECT * FROM localidades WHERE ID = ?";
	
	@Override
	public Localidad readAll(int ID) {
		PreparedStatement statement;
		DaoProvincia dP = new DaoProvincia();
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Localidad localidad = new Localidad();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setInt(1, ID);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				localidad.setIDLocalidad(resultSet.getInt("ID"));
				localidad.setProvincia(dP.readall(resultSet.getInt("ID_Provincia")));
				localidad.setDescripcion(resultSet.getString("Descripcion"));
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return localidad;
	}

}
