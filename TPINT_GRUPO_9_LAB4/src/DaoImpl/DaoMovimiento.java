package DaoImpl;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Dao.IDaoMovimiento;
import Entidad.Movimiento;
import Entidad.TipoMovimiento;

public class DaoMovimiento implements IDaoMovimiento {
	
	private static final String insert = "INSERT INTO movimientos (ID, Fecha, DNI_Usuario, ID_Tipo_Movimiento, Importe, Cuenta_Origen, Cuenta_Destino) " + 
										" VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	private static final String read = "SELECT * FROM movimientos WHERE ID = ?";
	
	private static final String readDNI = "SELECT * FROM movimientos WHERE DNI_Usuario = ?";
	
	private static final String readall = "SELECT * FROM movimientos";
	
	private DaoTipoMovimiento DTM;
	
	

	public boolean Insert(Movimiento movimiento) 
	{
		boolean isInsertExito = false;
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		
		try 
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setString(1,movimiento.getID());
			statement.setDate(2,Date.valueOf(movimiento.getFecha()));
			statement.setString(3, movimiento.getDNIUsuario());
			statement.setInt(4,movimiento.getTipoMovimiento().getID());
			statement.setBigDecimal(5,movimiento.getImporte());
			statement.setString(6,movimiento.getNumeroCuentaOrigen());
			statement.setString(7,movimiento.getNumeroCuentaDestino());
			
			if(statement.executeUpdate() > 0) 
			{
				conexion.commit();
				isInsertExito = true;
				
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
		
		
		
		return isInsertExito;
	}
	
	public ArrayList<Movimiento> readDNI(String DNI)
	{
		ArrayList<Movimiento> Movimientos = new ArrayList<Movimiento>();
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readDNI);
			statement.setString(1, DNI);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				Movimientos.add(getMovimiento(resultset));
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return Movimientos;
		
	}
	
	public Movimiento Read(String id) {
		
		Movimiento movi = null;
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setString(1, id);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				movi = getMovimiento(resultset);
			}
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return movi;
		
	}
	
	
	
	public ArrayList<Movimiento> ReadAll()
	{
		ArrayList<Movimiento> Movimientos = new ArrayList<Movimiento>();
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		try
		{
			
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				Movimientos.add(getMovimiento(resultset));
				
			}
			
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();	
		}
		
		return Movimientos;
		
	}
	
	private Movimiento getMovimiento(ResultSet resultset) throws SQLException
	{
		String id = resultset.getString("ID");
		String dni = resultset.getString("DNI_Usuario");
		LocalDate Fecha =  resultset.getDate("Fecha").toLocalDate();
		TipoMovimiento TipoMovi = getTipoMovimiento(resultset.getInt("ID_Tipo_Movimiento"));
		BigDecimal Importe = resultset.getBigDecimal("Importe");
		String CuentaOrigen = resultset.getString("Cuenta_Origen");
		String CuentaDestino = resultset.getString("Cuenta_Destino");
		
		return new Movimiento(id, Fecha, dni, TipoMovi, Importe, CuentaOrigen, CuentaDestino);
		
		
	}
	
	private TipoMovimiento getTipoMovimiento(int id) 
	{
		this.DTM = new DaoTipoMovimiento();
		
		return DTM.Read(id);
		
	}
	
}
