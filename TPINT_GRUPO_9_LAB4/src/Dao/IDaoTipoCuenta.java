package Dao;

import java.util.ArrayList;

import Entidad.TipoCuenta;

public interface IDaoTipoCuenta {

	public ArrayList<TipoCuenta> ReadAll();
	
	public TipoCuenta Read(int id);
	
	
	
}
