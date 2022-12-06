package NegocioImpl;

import java.util.ArrayList;

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
		if(!TelefonoIsNumber(telefono)) 
		{
			return false;
		}
		
		if(!TelefonoisCorrect(telefono)) 
		{
			return false;
		}
		if(!TelefonoDontRepeat(telefono)) 
		{
			
			return false;
		}
			
			return true;	
	}
	
	
	
	
	private boolean TelefonoIsNumber(Telefono telefono) 
	{
		try 
		{
			Integer.parseInt(telefono.getTelefono_1());
		}
		catch (Exception e) 
		{
			return false;
		}
		try 
		{	
			if(telefono.getTelefono_2() != null) 
			{
			Integer.parseInt(telefono.getTelefono_2());
			}
		}
		catch (Exception e) 
		{
			return false;
		}
		try 
		{	
			if(telefono.getTelefono_3() != null) 
			{
			Integer.parseInt(telefono.getTelefono_3());
			}
		}
		catch (Exception e) 
		{
			return false;
		}
		try 
		{	
			if(telefono.getTelefono_4() != null) 
			{
			Integer.parseInt(telefono.getTelefono_4());
			}
		}
		catch (Exception e) 
		{
			return false;
		}
		
		return true;
	}
	
	private boolean TelefonoisCorrect(Telefono telefono) 
	{
		if(telefono.getTelefono_1().trim().length() != 8 ||telefono.getTelefono_1().trim().length() != 10) 
		{
			
			return false;
		}
		
		if(telefono.getTelefono_2() != null) 
		{
		if(telefono.getTelefono_2().trim().length() != 8 || telefono.getTelefono_2().trim().length() != 10) 
		{
			
			return false;
		}
		}

		if(telefono.getTelefono_3() != null) 
		{
		if(telefono.getTelefono_3().trim().length() != 8 || telefono.getTelefono_3().trim().length() != 10) 
		{
			
			return false;
		}
		}
		
		if(telefono.getTelefono_4() != null) 
		{
		if(telefono.getTelefono_4().trim().length() != 8 || telefono.getTelefono_4().trim().length() != 10) 
		{
			
			return false;
		}
		}

		return true;
	}
	
	private boolean TelefonoDontRepeat(Telefono telefono)
	{
		ArrayList<Integer> Telefonos = new ArrayList<Integer>(); 
		boolean iscorret = true;
		
		try 
		{
			Telefonos.add(Integer.parseInt(telefono.getTelefono_1()));
			Telefonos.add(Integer.parseInt(telefono.getTelefono_2()));
			Telefonos.add(Integer.parseInt(telefono.getTelefono_3()));
			Telefonos.add(Integer.parseInt(telefono.getTelefono_4()));
			
			
			for(int i = 0; i< Telefonos.size() ; i++) 
			{
				int copi=0;
				
				for(int j =0; j<Telefonos.size(); j++) 
				{
					if(Telefonos.get(i).equals(Telefonos.get(j)))
					{
						copi++;
					}
							
				}
				
				if(copi > 1)
				{
					iscorret = false;
					break;	
				}
				
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return iscorret;
	}
	
	
}
