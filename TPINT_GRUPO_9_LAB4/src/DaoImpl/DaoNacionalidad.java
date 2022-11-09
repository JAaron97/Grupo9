package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.IDaoNacionalidad;
import Entidad.Nacionalidad;

public class DaoNacionalidad implements IDaoNacionalidad {

	private static final String readNacionalidad = "SELECT * FROM nacionalidades WHERE ID = ?";
	
	@Override
	public Nacionalidad readAll(int ID) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Nacionalidad nacionalidad = new Nacionalidad();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readNacionalidad);
			statement.setInt(1, ID);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				nacionalidad.setID(resultSet.getInt("ID"));
				nacionalidad.setPais(resultSet.getString("Pais_Nac"));
				nacionalidad.setGentilicio(resultSet.getString("Gentilicio_Nac"));
				nacionalidad.setIso(resultSet.getString("Iso_Nac"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return nacionalidad;
	}

}
