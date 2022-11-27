package NegocioImpl;

import java.util.ArrayList;

import Dao.IDaoNumeroCuotas;
import DaoImpl.DaoNumeroCuotas;
import Entidad.NumeroCuotas;
import Negocio.NumeroCuotasNeg;

public class NumeroCuotasNegImpl implements NumeroCuotasNeg {

	IDaoNumeroCuotas DNC = new DaoNumeroCuotas();
	
	public NumeroCuotas Read(int ID) 
	{
		return DNC.Read(ID);
	}
	
	public ArrayList<NumeroCuotas> ReadAll()
	{
		return DNC.ReadAll();
	}
	
	
	
}
