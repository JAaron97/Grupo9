package Negocio;

import java.util.ArrayList;

import Entidad.Prestamo;

public interface PrestamoNeg {
	
	public boolean Insert(Prestamo prestamo);
	
	public boolean Update(Prestamo prestamo);
	
	public Prestamo Read(int id);
	
	public ArrayList<Prestamo> ReadAll();
	
	public ArrayList<Prestamo> readDNI(String DNI);
	
	public boolean UpdateCuotasPagadas(int cuotasPagadas, int ID);
	
	public boolean UpdateEstado(int id);

}
