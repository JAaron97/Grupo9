package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.IDaoTipoMovimiento;
import Entidad.TipoMovimiento;

public class DaoTipoMovimiento implements IDaoTipoMovimiento{
	
	private static final String readall = "SELECT * FROM tipo_movimientos";
	private static final String read = "SELECT * FROM tipo_movimientos WHERE ID = ?";
	
	
	public ArrayList<TipoMovimiento> ReadAll()
	{
		ArrayList<TipoMovimiento> tiposmovimiento = new ArrayList<>();
		
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) 
			{
				tiposmovimiento.add(getTiposMovimientos(resultSet));
			}
			
			conexion.cerrarConexion();
			
		}
		catch (Exception e) {
		
			e.printStackTrace();
			
		}
		
		return tiposmovimiento;
	}
	
	
	
	public TipoMovimiento Read(int id) {
		
		TipoMovimiento tm = null;
		
		
		PreparedStatement statement;
		ResultSet resultset;
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setInt(1, id);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				tm = getTiposMovimientos(resultset);
			}
			
			conexion.cerrarConexion();
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return tm;
		
	}
	
	
	private TipoMovimiento getTiposMovimientos(ResultSet resultset) throws SQLException
	{
	
		int id = resultset.getInt("ID");
		String descripcion = resultset.getString("Descripcion");
		
		return new TipoMovimiento(id, descripcion);
	
	}
	
	
}
