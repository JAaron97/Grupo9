package DaoImpl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Dao.IDaoNumeroCuotas;
import java.sql.PreparedStatement;
import Entidad.NumeroCuotas;

public class DaoNumeroCuotas  implements IDaoNumeroCuotas{
	
	private static final String readall = "SELECT * FROM numero_cuotas";
	private static final String read = "SELECT * FROM numero_cuotas WHERE ID = ?";
	
	
	public ArrayList<NumeroCuotas> ReadAll()
	{
		ArrayList<NumeroCuotas> numerocuotas = new ArrayList<NumeroCuotas>();
		
		PreparedStatement statement;
		ResultSet resultset;
		Conexion conexion = Conexion.getConexion();
		
		
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultset = statement.executeQuery();
			
			while(resultset.next()) 
			{
				numerocuotas.add(getNumeroCuotas(resultset));
			}
		
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return numerocuotas;
	}
	
	
	
	public NumeroCuotas Read(int id) 
	{
		NumeroCuotas nc = null;
		
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
				nc = getNumeroCuotas(resultset);
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return nc;
		
	}
	
	
	
	private NumeroCuotas getNumeroCuotas(ResultSet resultset)throws SQLException 
	{
		int id = resultset.getInt("ID");
		String descripcion = resultset.getString("Descripcion");	
		
		return new NumeroCuotas(id, descripcion);
		
	}
	

}
