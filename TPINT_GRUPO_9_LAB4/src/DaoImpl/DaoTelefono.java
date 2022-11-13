package DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Dao.IDaoTelefono;
import Entidad.Telefono;

public class DaoTelefono implements IDaoTelefono{
	
	private static final String insert = "INSERT INTO telefonos (ID, Telefono_1,Telefono_2,Telefono_3,Telefono_4) VALUES ('?','?','?','?','?')";
	
	private static final String delete = "DELETE FROM telfonos WHERE ID = ?";
	
	private static final String read = "SELECT * FROM telefonos WHERE ID = ?";
	
	private static final String update = "UPDATE telefonos SET Telefono_1 = '?' , Telefono_2 = '?', Telefono_3 = '?', Telefono_4 = '?' WHERE ID = ?";
	
	
	

	public boolean Insert(Telefono telefono_add) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		
		try
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setInt(1,telefono_add.getID_Telefono());
			statement.setString(2,telefono_add.getTelefono_1());
			statement.setString(3,telefono_add.getTelefono_2());
			statement.setString(4,telefono_add.getTelefono_3());
			statement.setString(5,telefono_add.getTelefono_4());
		
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
			
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			try 
			{
				conexion.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
			
		return isInsertExitoso;
		
	}

	
	public boolean Delete(int id) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isdeleteExitoso = false;
		
		try 
		{
			statement = conexion.prepareStatement(delete);
			
			statement.setInt(1, id);
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isdeleteExitoso = true;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			
			try 
			{
				conexion.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		return isdeleteExitoso;
	}

	public boolean Update(Telefono telefono_update) {

		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		
		try
		{
			statement = conexion.prepareStatement(update);
			
			statement.setString(1, telefono_update.getTelefono_1());
			statement.setString(2, telefono_update.getTelefono_2());
			statement.setString(3, telefono_update.getTelefono_3());
			statement.setString(4, telefono_update.getTelefono_4());
			statement.setInt(5, telefono_update.getID_Telefono());
		
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
			}
			
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
			try 
			{
				conexion.rollback();
			} 
			catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
		}
		
		
		
		return isInsertExitoso;
	}

	
	public Telefono Read(int ID) 
	{
		Telefono Tele = null;
		
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setInt(1, ID);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				Tele = getTelefono(resultSet);
			}
			
			conexion.cerrarConexion();
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return Tele;
	}

	
	private Telefono getTelefono(ResultSet rs) throws SQLException 
	{
		
	int id = rs.getInt("ID");	
	String tel1 = rs.getString("Telefono_1");
	String tel2 = (rs.getString("Telefono_2") == null) ? null : rs.getString("Telefono_2");
	String tel3 = (rs.getString("Telefono_3") == null) ? null : rs.getString("Telefono_3");
	String tel4 = (rs.getString("Telefono_4") == null) ? null : rs.getString("Telefono_4");
		
		return new Telefono(id,tel1,tel2,tel3,tel4);
	}
}
