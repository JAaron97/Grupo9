package Dao;

import java.util.ArrayList;


import Entidad.Movimiento;

public interface IDaoMovimiento {
	
	public boolean Insert(Movimiento movimiento);
	
	public Movimiento Read(String id);
	
	public ArrayList<Movimiento> ReadAll();
}
