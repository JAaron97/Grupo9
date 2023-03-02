package Negocio;

import java.util.ArrayList;

import Entidad.Cuota;

public interface CuotaNeg {
	public boolean Insert(Cuota cuota);
	
	public boolean Update(Cuota cuota);
	
	public Cuota Read(int ID , int ID_Prestamo);
	
	public ArrayList<Cuota> ReadAll(int ID_Prestamo);
}
