package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;

import Dao.IDaoTelefono;
import Entidad.Telefono;

public class DaoTelefono implements IDaoTelefono{
	
	private static final String insert = "INSERT INTO telefonos (ID, Telefono_1,Telefono_2,Telefono_3,Telefono_4) VALUES ('?','?','?','?','?')";
	private static final String delete = "DELETE FROM telfonos WHERE ID = ?";
	private static final String readTelefonos = "SELECT * FROM telefonos WHERE ID = ?";

	@Override
	public boolean insert(Telefono telefono) {
		// TODO Auto-generated method stub
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try
		{
			statement = conexion.prepareStatement(insert);
			statement.setInt(1, telefono.getID_Telefono());
			statement.setString(2, telefono.getTelefono_1());
			statement.setString(3, telefono.getTelefono_2());
			statement.setString(4, telefono.getTelefono_3());
			statement.setString(5, telefono.getTelefono_4());
		
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
	public boolean delete(Telefono telefono_a_eliminar) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isdeleteExitoso = false;
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setInt(1, telefono_a_eliminar.getID_Telefono());
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
