package Dao;

import java.util.ArrayList;

import Entidad.TipoMovimiento;

public interface IDaoTipoMovimiento {
	
	public ArrayList<TipoMovimiento> ReadAll();
	
	public TipoMovimiento Read(int id);
	
	

}
