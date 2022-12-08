package DaoImpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Dao.IDaoSolicitudPrestamo;
import Entidad.NumeroCuotas;
import Entidad.SolicitudPrestamo;

public class DaoSolicitudPrestamo implements IDaoSolicitudPrestamo{
	
	private static final String insert = "INSERT INTO solicitud_prestamo ( DNI_Usuario, Importe_Solicitado, ID_Numero_Cuotas, Cuenta_Destinataria, Fecha) " + 
										 "VALUES (?, ?, ?, ?, ?)";
	
	private static final String update = "UPDATE solicitud_prestamo SET DNI_Usuario = ? , Importe_Solicitado = ? , ID_Numero_Cuotas = ?, Cuenta_Destinataria = ?, Fecha = ?, Estado = ? WHERE ID = ?";
	
	private static final String read= "SELECT * FROM solicitud_prestamo WHERE ID = ?";
	
	private static final String readall = "SELECT * FROM solicitud_prestamo";
	
	private DaoNumeroCuotas DNC;
	
	
public boolean Insert(SolicitudPrestamo solicitud) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isInsertExito = false;
		
		try 
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setString(1, solicitud.getDNICliente());
			statement.setBigDecimal(2, solicitud.getImportePedido());
			statement.setInt(3, solicitud.getNumeroCuotas().getID());
			statement.setString(4, solicitud.getCuentaDestinataria());
			statement.setDate(5, Date.valueOf(solicitud.getFecha()));
			statement.setInt(6, solicitud.getEstado());
			
			
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
	
	
	public boolean Update(SolicitudPrestamo solicitud ) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isUpdateExito = false;
		
		try 
		{
			statement = conexion.prepareStatement(update);
			
			statement.setString(1, solicitud.getDNICliente());
			statement.setBigDecimal(2, solicitud.getImportePedido());
			statement.setInt(3, solicitud.getNumeroCuotas().getID());
			statement.setString(4, solicitud.getCuentaDestinataria());
			statement.setDate(5, Date.valueOf(solicitud.getFecha()));
			statement.setInt(6, solicitud.getEstado());
			statement.setInt(7, solicitud.getID());
			
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
	

	public SolicitudPrestamo Read(int ID) 
	{
		SolicitudPrestamo solicitud = null;
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(read);
			statement.setInt(1, ID);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				solicitud = getSolicitudPrestamo(resultset);
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return solicitud;
	}
	
	public ArrayList<SolicitudPrestamo> ReadAll()
	{
	ArrayList<SolicitudPrestamo> solicitudes = new ArrayList<SolicitudPrestamo>();
		
		Conexion conexion = Conexion.getConexion();
		PreparedStatement statement;
		ResultSet resultset;
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultset = statement.executeQuery();
			
			while(resultset.next())
			{
				solicitudes.add(getSolicitudPrestamo(resultset));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return solicitudes;
	}
	
	private SolicitudPrestamo getSolicitudPrestamo(ResultSet resultset) throws SQLException
	{
		int id = resultset.getInt("ID");
		String Dni = resultset.getString("DNI_Usuario");
		BigDecimal importe = resultset.getBigDecimal("Importe_Solicitado");
		NumeroCuotas cuotas = getNumeroCuotas(resultset.getInt("ID_Numero_Cuotas"));
		String cuenta = resultset.getString("Cuenta_Destinataria");
		LocalDate fecha = resultset.getDate("Fecha").toLocalDate();
		int estado = resultset.getInt("Estado");
		
		return new SolicitudPrestamo(id, Dni, importe, cuotas, cuenta, fecha, estado);
	}
	
	private NumeroCuotas getNumeroCuotas(int id) 
	{
		this.DNC = new DaoNumeroCuotas();
		
		return DNC.Read(id);
	}
}
