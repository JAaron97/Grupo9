package DaoImpl;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Dao.IDaoCuotas;
import Entidad.Cuota;

public class DaoCuotas implements IDaoCuotas{
	
	
	private final static String insert = "INSERT INTO cuotas (ID, ID_Prestamo, Importe, Estado_Pago, Fecha) VALUES (?, ?, ?, ?, ?)";
	
	private final static String update = "UPDATE cuotas SET Importe = ? , Estado_Pago = ? , Fecha = ? WHERE ID = ? AND ID_Prestamo = ?";
	
	private final static String read = "SELECT * FROM cuotas WHERE WHERE ID = ? AND ID_Prestamo = ?";
	
	private final static String readall = "SELECT * FROM cuotas WHERE ID_Prestamo = ?";
	
	
	public boolean Insert(Cuota cuota) 
	{
		boolean isInsert = false;
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try 
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setInt(1, cuota.getID());
			statement.setInt(2, cuota.getIDPrestamo());
			statement.setBigDecimal(3, cuota.getImporte());
			statement.setInt(4, cuota.getEstadoPago());
			statement.setDate(5, Date.valueOf(cuota.getFecha()));
		
			
			if(statement.executeUpdate() > 0 ) 
			{
				conexion.commit();
				isInsert = true;
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
		return isInsert;
	}
	
	public boolean Update(Cuota cuota) 
	{
		boolean isUpdate = false;
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		try 
		{
			statement = conexion.prepareStatement(update);
			
			statement.setBigDecimal(1, cuota.getImporte());
			statement.setInt(2, cuota.getEstadoPago());
			statement.setDate(3, Date.valueOf(cuota.getFecha()));
			
			statement.setInt(4, cuota.getID());
			statement.setInt(5, cuota.getIDPrestamo());
			
			if(statement.executeUpdate() > 0 ) 
			{
				conexion.commit();
				isUpdate = true;
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
		return isUpdate;
		
	}
	
	public Cuota Read(int ID, int ID_Prestamo) 
	{
		Cuota cuota = null;
		
		PreparedStatement statement;
		ResultSet resultset;
		Conexion conexion = Conexion.getConexion();
		
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setInt(1, ID);
			statement.setInt(2, ID_Prestamo);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				cuota = getCuota(resultset);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return cuota;
	}
	
	public ArrayList<Cuota> ReadAll(int ID_Prestamo)
	{
		ArrayList<Cuota> Cuotas = new ArrayList<Cuota>();
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			statement.setInt(1, ID_Prestamo);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				Cuotas.add(getCuota(resultset));
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return Cuotas;
	}
	
	
	private Cuota getCuota(ResultSet resultset) throws SQLException
	{
		int id = resultset.getInt("ID");
		int id_prestamo = resultset.getInt("ID_Prestamo");
		BigDecimal importe = resultset.getBigDecimal("Importe");
		int estado = resultset.getInt("Estado_Pago");
		LocalDate fecha = resultset.getDate("Fecha").toLocalDate();
		
		return new Cuota(id, id_prestamo, importe, estado, fecha);
		
	}

}
