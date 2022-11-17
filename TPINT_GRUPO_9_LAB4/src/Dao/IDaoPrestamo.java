package Dao;

import java.util.ArrayList;

import Entidad.Prestamo;

public interface IDaoPrestamo {
	
	public boolean Insert(Prestamo prestamo);
	
	public boolean Update(Prestamo prestamo);
	
	public Prestamo Read(int id);
	
	public ArrayList<Prestamo> ReadAll();

}
