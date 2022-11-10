package Negocio;

import java.util.ArrayList;


import Entidad.Nacionalidad;

public interface NacionaldiadNeg {
	public ArrayList<Nacionalidad> readAll();
	public Nacionalidad ObtenerUnaNacinalidad(String  nacionalidad);
	public Nacionalidad obtenerPorID(int ID);
	
}