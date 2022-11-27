package Negocio;

import java.util.ArrayList;

import Entidad.Localidad;

public interface LocalidadesNeg {
	
	public ArrayList<Localidad> ReadAll();
	
	public Localidad Read(int id);
}
