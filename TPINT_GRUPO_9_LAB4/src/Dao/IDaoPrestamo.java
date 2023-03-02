package Dao;

import java.util.ArrayList;

import Entidad.Prestamo;

public interface IDaoPrestamo {
	
	public boolean Insert(Prestamo prestamo);
	
	public boolean Update(Prestamo prestamo);
	
	public Prestamo Read(int id);
	
	public ArrayList<Prestamo> ReadAll();
	
	public ArrayList<Prestamo> readDNI(String DNI);
	
	public boolean UpdateCuotasPagadas(int cuotasPagadas, int ID);
	
	public boolean UpdateEstado(int id);

}
