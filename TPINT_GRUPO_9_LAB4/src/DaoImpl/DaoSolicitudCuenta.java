package DaoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Dao.IDaoSolicitudCuenta;
import Entidad.SolicitudCuenta;

public class DaoSolicitudCuenta implements IDaoSolicitudCuenta {
	private static final String insert = "INSERT INTO solicitudcuenta (ID, DNICliente, Fecha_Solicitud, Estado_Solicitud) VALUES (?, ?, ?, ?)";

	private static final String  read = "SELECT * FROM solicitudcuenta WHERE ID = ?";

	private static final String readall = "SELECT * FROM solicitudcuenta";
	
	@Override
	public boolean Insert(SolicitudCuenta SolicitudCuenta) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isInsertExitoso = false;
		
		try 
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setInt(1, SolicitudCuenta.getID());
			statement.setString(2, SolicitudCuenta.getDNI_Cliente());
			statement.setDate(3, Date.valueOf(SolicitudCuenta.getFechaSolicitud()));
			statement.setInt(4, SolicitudCuenta.getEstadoSolicitud());
			
			
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isInsertExitoso = true;
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
		return isInsertExitoso;
	}

	@Override
	public ArrayList<SolicitudCuenta> ReadAll() {
		ArrayList<SolicitudCuenta> SolicitudCuentas = new ArrayList<SolicitudCuenta>();
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				SolicitudCuentas.add(getSolicitudCuenta(resultset));
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return SolicitudCuentas;
	}

	@Override
	public SolicitudCuenta Read(int ID) {
		SolicitudCuenta SolicitudCuenta = null;
		
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
				SolicitudCuenta = getSolicitudCuenta(resultset);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return SolicitudCuenta;
		
	}
	
	private SolicitudCuenta getSolicitudCuenta(ResultSet resultset) throws SQLException 
	{
		int id = resultset.getInt("ID");
		String DNICliente = resultset.getString("DNICliente");
		LocalDate FechaSolicitud = resultset.getDate("Fecha_Solicitud").toLocalDate();
		int estadoSolicitud = resultset.getInt("Estado_Solicitud");
		
		return new SolicitudCuenta(id, DNICliente, FechaSolicitud, estadoSolicitud);
	}

}
