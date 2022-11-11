package Negocio;

import java.util.ArrayList;

import Entidad.Localidad;

public interface LocaldiadesNeg {
	public ArrayList<Localidad> ReadAll();
	
	public Localidad Read(int id);
}
