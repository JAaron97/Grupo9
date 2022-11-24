package NegocioImpl;

import DaoImpl.DaoTelefono;
import Entidad.Telefono;
import Negocio.TelefonosNeg;

public class TelefonosNegImpl implements TelefonosNeg{

	DaoTelefono dTel = new DaoTelefono();
	
	@Override
	public boolean Insert(Telefono telefono_add) 
	{
		if(ValidationTelefono(telefono_add)== true) 
		{
			return dTel.Insert(telefono_add);	
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean Update(Telefono telefono_update)
	{
		if(ValidationTelefono(telefono_update)== true) 
		{
			return dTel.Update(telefono_update);
		}
		else
		{
			return false;
		}
	}

	@Override
	public Telefono Read(int ID) 
	{
		return dTel.Read(ID);
	}
	
	
	private boolean ValidationTelefono(Telefono telefono)
	{
		try 
		{
			Integer.parseInt(telefono.getTelefono_1());
		}
		catch (Exception e) 
		{
			return false;
		}
		
		if(telefono.getTelefono_1().length() != 8 || telefono.getTelefono_1().length() != 10) {
			
			return false;
		}
			
			return true;	
	}
	

}
