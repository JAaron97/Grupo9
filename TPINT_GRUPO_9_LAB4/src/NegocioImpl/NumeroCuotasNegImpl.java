package NegocioImpl;

import java.util.ArrayList;
import DaoImpl.DaoNumeroCuotas;
import Entidad.NumeroCuotas;
import Negocio.NumeroCuotasNeg;

public class NumeroCuotasNegImpl implements NumeroCuotasNeg {

	DaoNumeroCuotas DNC = new DaoNumeroCuotas();
	
	public NumeroCuotas Read(int ID) 
	{
		return DNC.Read(ID);
	}
	
	public ArrayList<NumeroCuotas> ReadAll()
	{
		return DNC.ReadAll();
	}
	
	
	
}
