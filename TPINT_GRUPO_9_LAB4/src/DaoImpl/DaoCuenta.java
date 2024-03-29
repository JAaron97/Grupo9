package DaoImpl;

import java.math.BigDecimal;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;

import Dao.IDaoCuenta;
import Entidad.Cuenta;
import Entidad.TipoCuenta;


public class DaoCuenta implements IDaoCuenta {
	
	private static final String readAllxDNI= "SELECT * FROM cuentas WHERE DNI_Usuario = ? ";
	
	private static final String readall= "SELECT * FROM cuentas ";
	
	private static final String readxNC= "SELECT * FROM cuentas WHERE Numero_Cuenta = ? ";
	
	private static final String insert= "INSERT INTO cuentas (Numero_Cuenta, DNI_Usuario, Fecha_Creacion, ID_Tipo_Cuenta, CBU, Saldo, Estado) "
										+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	private static final String update= "UPDATE cuentas SET ID_Tipo_Cuenta = ?, Saldo = ? WHERE  Numero_Cuenta = ? ";
	
	private static final String delete= "UPDATE cuentas SET Estado = 1 WHERE DNI_Usuario = ?";
	
	private DaoTipoCuenta DTC;
	
	
	public boolean Update(Cuenta cuenta) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isUpdateExito = false;
		
		try 
		{
			statement = conexion.prepareStatement(update);
			
			statement.setInt(1, cuenta.getTipoCuenta().getID());
			statement.setBigDecimal(2, cuenta.getSaldo());
			
			statement.setString(3, cuenta.getNumeroCuenta());
			
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
	
	public Cuenta Read(String numeroCuenta) {
		
		Cuenta Cuenta = null;
		
			PreparedStatement statement;
			Conexion conexion = Conexion.getConexion();
			ResultSet resultset;
			
			try 
			{
				statement = conexion.getSQLConexion().prepareStatement(readxNC);
				statement.setString(1, numeroCuenta);
				resultset = statement.executeQuery();
				
				while(resultset.next()) 
				{
					Cuenta = getCuenta(resultset);
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			
			return Cuenta;
		
	}
	
	public boolean Insert(Cuenta cuenta) {
		
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isInsertExito = false;
		
		try 
		{
			statement = conexion.prepareStatement(insert);
			
			statement.setString(1, cuenta.getNumeroCuenta());
			statement.setString(2, cuenta.getDNICliente());
			statement.setDate(3,java.sql.Date.valueOf(cuenta.getFechaCreacion()));
			statement.setInt(4, cuenta.getTipoCuenta().getID());
			statement.setString(5,cuenta.getCBU());
			statement.setBigDecimal(6, cuenta.getSaldo());
			statement.setInt(7, cuenta.getEstado());
			
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
	
	public boolean Delete(String DNI) 
	{
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		
		boolean isDeleteExito = false;
		
		try 
		{
			statement = conexion.prepareStatement(delete);
			statement.setString(1, DNI);
			
			if(statement.executeUpdate() > 0)
			{
				conexion.commit();
				isDeleteExito= true;
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
		
		return isDeleteExito;
	}
	
	public ArrayList<Cuenta> ReadAll()
	{
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		
		Conexion conexion = Conexion.getConexion();
		PreparedStatement statement;
		ResultSet resultset;
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultset = statement.executeQuery();
			
			while(resultset.next())
			{
				cuentas.add(getCuenta(resultset));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return cuentas;
	}
	
	public ArrayList<Cuenta> readAllxDNI(String DNIUsuario) 
	{
		ArrayList<Cuenta> cuenta = new ArrayList<Cuenta>();
		
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		ResultSet resultset;
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readAllxDNI);
			statement.setString(1, DNIUsuario);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				cuenta.add(getCuenta(resultset));
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return cuenta;
	}
	
	
	
 	private Cuenta getCuenta(ResultSet resultset)throws SQLException
	{	
		
		String numerocuenta = resultset.getString("Numero_Cuenta");
		String dniusuario = resultset.getString("DNI_Usuario");
		LocalDate fecha = resultset.getDate("Fecha_Creacion").toLocalDate();
		TipoCuenta tipocuenta = getTipoCuenta(resultset.getInt("ID_Tipo_Cuenta"));
		String cbu = resultset.getString("CBU");
		BigDecimal saldo = resultset.getBigDecimal("Saldo");
		int estado = resultset.getInt("Estado");
		
		return new Cuenta(numerocuenta, dniusuario, fecha, tipocuenta, cbu, saldo, estado);
	}
	
	private TipoCuenta getTipoCuenta(int id) {
		
		this.DTC = new DaoTipoCuenta();
		
		return DTC.Read(id);
		
	}
	

}
