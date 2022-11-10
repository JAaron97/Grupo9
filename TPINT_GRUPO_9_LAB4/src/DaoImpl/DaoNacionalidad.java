package DaoImpl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.IDaoNacionalidad;


import Entidad.Nacionalidad;



public class DaoNacionalidad implements IDaoNacionalidad {

	private static final String readNacionalidad = "SELECT * FROM nacionalidades ";
	private static final String leerUnaNacionalidadID ="SELECT * FROM nacionalidades WHERE ID = ?";
	private static final String leerUnaNacionalidadDescripcicon ="select * from nacionalidad  where Pais_Nac = ?";
	


	@Override
	public List<Nacionalidad> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Nacionalidad> personas = new ArrayList<Nacionalidad>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readNacionalidad);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				personas.add(getNacionalidad(resultSet));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	
	
	private Nacionalidad getNacionalidad(ResultSet resultSet) throws SQLException
	{
		int id = resultSet.getInt("iD_Nacionalidad");
		String pais = resultSet.getString("pais");
		String gentilicio = resultSet.getString("gentilicio");
		String iso = resultSet.getString("iso");
		return new Nacionalidad(id, pais, gentilicio,iso);
	}



	@Override
	public Nacionalidad ObtenerUnaNacinalidad(String nacionalidad) {
	
		PreparedStatement statement;
		
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Nacionalidad na = new Nacionalidad();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(leerUnaNacionalidadDescripcicon);
			statement.setString(2, nacionalidad);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				
				na.setID(resultSet.getInt("iD_Nacionalidad"));
				na.setPais(resultSet.getString("pais"));
				na.setGentilicio(resultSet.getString("gentilicio"));
				na.setIso(resultSet.getString("iso"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return na;
	}



	@Override
	public Nacionalidad obtenerPorID(int ID) {
		
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Nacionalidad nacionalidad = new Nacionalidad();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(leerUnaNacionalidadID);
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
		
	



