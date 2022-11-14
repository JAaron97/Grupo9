package Negocio;

import java.util.ArrayList;


import Entidad.Nacionalidad;

public interface NacionalidadNeg {
	public Nacionalidad Read(int ID);
	public ArrayList<Nacionalidad> ReadAll();
	
}