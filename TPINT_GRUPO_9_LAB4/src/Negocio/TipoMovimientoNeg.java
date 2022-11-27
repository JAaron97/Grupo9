package Negocio;

import java.util.ArrayList;

import Entidad.TipoMovimiento;

public interface TipoMovimientoNeg {
	
	public TipoMovimiento Read(int ID);
	
	public ArrayList<TipoMovimiento> ReadAll();
	

}
