package Dao;

import java.util.ArrayList;

import Entidad.NumeroCuotas;

public interface IDaoNumeroCuotas {
	
	public ArrayList<NumeroCuotas> ReadAll();
	
	public NumeroCuotas Read(int id);
	

}
