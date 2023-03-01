package DaoImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Dao.IDaoPrestamo;
import Entidad.NumeroCuotas;
import Entidad.Prestamo;
import Entidad.SolicitudPrestamo;

public class DaoPrestamo implements IDaoPrestamo {
	
	private static final String insert = "INSERT INTO prestamos (DNI_Usuario, ID_Solicitud_Prestamo, Cuenta_Destinataria, Fecha, Importe_Interes, ID_Numero_Cuotas) " + 
										 " VALUES (?, ?, ?, ?, ?, ?)";
	
	private static final String update = "UPDATE prestamos SET DNI_Usuario = ? , ID_Solicitud_Prestamo = ?, Cuenta_Destinataria = ?, Fecha = ? , Importe_Interes = ? WHERE ID = ?";
	
	private static final String  read = "SELECT * FROM prestamos WHERE ID = ?";
	
	private static final String readDNI = "SELECT * FROM prestamos WHERE DNI_Usuario = ?";
	
	private static final String readall = "SELECT * FROM prestamos";
	
	private DaoSolicitudPrestamo DSP;
	
	private DaoNumeroCuotas DNC;
	
	
	
	public boolean Insert(Prestamo prestamo) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isInsertExito = false;
		
		try 
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setString(1, prestamo.getDNICliente());
			statement.setInt(2,prestamo.getSolicitudPrestamo().getID());
			statement.setString(3,prestamo.getCuentaDestinataria());
			statement.setDate(4,Date.valueOf(prestamo.getFecha()));
			statement.setBigDecimal(5,prestamo.getImporteInteres());
			statement.setInt(6, prestamo.getNumeroCuotas().getID());
			
			
			
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
	
	
	public boolean Update(Prestamo prestamo) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isUpdateExito = false;
		
		try 
		{
			statement = conexion.prepareStatement(update);
			
			statement.setString(1, prestamo.getDNICliente());
			statement.setInt(2,prestamo.getSolicitudPrestamo().getID());
			statement.setString(3,prestamo.getCuentaDestinataria());
			statement.setDate(4,Date.valueOf(prestamo.getFecha()));
			statement.setBigDecimal(5,prestamo.getImporteInteres());
			
			statement.setInt(6,prestamo.getID());
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isUpdateExito = true;
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
		return isUpdateExito;
		
	}
	
	public Prestamo Read(int id) 
	{
		Prestamo prestamo = null;
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setInt(1, id);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				prestamo = getPrestamo(resultset);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return prestamo;
		
	}
	
	
	public ArrayList<Prestamo> ReadAll()
	{
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				prestamos.add(getPrestamo(resultset));
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return prestamos;
		
	}
	
	public ArrayList<Prestamo> readDNI(String DNI)
	{
		ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
		
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
				prestamos.add(getPrestamo(resultset));
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return prestamos;
		
	}
	
	private Prestamo getPrestamo(ResultSet resultset) throws SQLException 
	{
		int id  = resultset.getInt("ID");
		String dni = resultset.getString("DNI_Usuario");
		SolicitudPrestamo soli = getSolicitudPrestamo(resultset.getInt("ID_Solicitud_Prestamo"));
		String cuenta = resultset.getString("Cuenta_Destinataria");
		LocalDate fecha = resultset.getDate("Fecha").toLocalDate();
		BigDecimal importe  = resultset.getBigDecimal("Importe_Interes");
		NumeroCuotas nc = getNumeroCuotas(resultset.getInt("ID_Numero_Cuotas"));
		
		return new Prestamo(id, dni, nc, soli, cuenta, fecha, importe);
	}
	
	private SolicitudPrestamo getSolicitudPrestamo(int id) 
	{
		this.DSP = new DaoSolicitudPrestamo();
		
		return DSP.Read(id);
		
		
	}
	
	private NumeroCuotas getNumeroCuotas(int id) {
		
		this.DNC = new DaoNumeroCuotas();
		
		return DNC.Read(id);
	}
}
