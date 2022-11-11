package Negocio;

import java.util.ArrayList;


import Entidad.Nacionalidad;

public interface NacionaldiadNeg {
	public Nacionalidad Read(int ID);
	public ArrayList<Nacionalidad> ReadAll();
	
}