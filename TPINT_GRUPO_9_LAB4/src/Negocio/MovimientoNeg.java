package Negocio;

import java.util.ArrayList;

import Entidad.Movimiento;

public interface MovimientoNeg {
	
	public boolean Insert(Movimiento movimiento);
	
	public Movimiento Read(String id);
	
	public ArrayList<Movimiento> ReadAll();
	
	public ArrayList<Movimiento> readDNI(String DNI);
}
