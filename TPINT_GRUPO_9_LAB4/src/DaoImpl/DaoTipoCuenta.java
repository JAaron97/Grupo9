package DaoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Dao.IDaoTipoCuenta;
import Entidad.TipoCuenta;

public class DaoTipoCuenta implements IDaoTipoCuenta{
	
	private static final String readall = "SELECT * FROM tipo_cuentas";
	private static final String read = "SELECT * FROM tipo_cuentas WHERE ID = ?";
	
	
	
	public ArrayList<TipoCuenta> ReadAll()
	{
		ArrayList<TipoCuenta> tiposcuentas = new ArrayList<TipoCuenta>();
		
		PreparedStatement statement;
		ResultSet resultSet;
		Conexion conexion = Conexion.getConexion();
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			while(resultSet.next())
			{
			  tiposcuentas.add(getTiposCuentas(resultSet)); 	
				
			}
			
			conexion.cerrarConexion();
			
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return  tiposcuentas;
		
	}
	
	
	public TipoCuenta Read(int id) 
	{
		TipoCuenta tc = null;
		
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
				tc = getTiposCuentas(resultSet);
			}
			
			conexion.cerrarConexion();
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		return tc;
		
	}
	
	
	
	private TipoCuenta getTiposCuentas(ResultSet resultset) throws SQLException 
	{
		
		int id = resultset.getInt("ID");
		String descripcion = resultset.getString("Descripcion");
		
		
		return new TipoCuenta(id,descripcion);
		
		
		
	}

}
