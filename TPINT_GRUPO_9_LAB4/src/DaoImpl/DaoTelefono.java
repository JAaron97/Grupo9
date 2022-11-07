package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Dao.IDaoTelefono;
import Entidad.Telefono;

public class DaoTelefono implements IDaoTelefono{
	
	private static final String insert = "";
	private static final String delete = "";
	private static final String readTelefonos = "SELECT * FROM telefonos WHERE ID = ?";

	@Override
	public boolean insert(Telefono telefono) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Telefono telefono_a_eliminar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Telefono telefono_a_modificar) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Telefono readAll(int ID) {
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		Telefono telefono = new Telefono();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readTelefonos);
			statement.setInt(1, ID);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				telefono = getTelefono(telefono, resultSet);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return telefono;
	}

	
	private Telefono getTelefono(Telefono tel, ResultSet rs) throws SQLException {
		tel.setID_Telefono(rs.getInt("ID"));
		tel.setTelefono_1(rs.getString("Telefono_1"));
		tel.setTelefono_2(rs.getString("Telefono_2"));
		tel.setTelefono_3(rs.getString("Telefono_3"));
		tel.setTelefono_4(rs.getString("Telefono_4"));
		
		return tel;
	}
}
