package Dao;

import java.util.ArrayList;

import Entidad.Nacionalidad;



public interface IDaoNacionalidad {
	
	public Nacionalidad Read(int ID);
	
	public ArrayList<Nacionalidad> ReadAll();
	
	
	
}
