package Negocio;

import java.util.ArrayList;

import Entidad.NumeroCuotas;

public interface NumeroCuotasNeg {
	
	public NumeroCuotas Read(int ID);
	
	public ArrayList<NumeroCuotas> ReadAll();
	

}
