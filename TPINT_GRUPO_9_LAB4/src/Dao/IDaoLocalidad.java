package Dao;

import java.util.ArrayList;

import Entidad.Localidad;

public interface IDaoLocalidad {
	
	public ArrayList<Localidad> ReadAll();
	
	public Localidad Read(int id);
	
}
