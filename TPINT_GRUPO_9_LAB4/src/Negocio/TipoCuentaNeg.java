package Negocio;

import java.util.ArrayList;

import Entidad.TipoCuenta;

public interface TipoCuentaNeg {
	
	public ArrayList<TipoCuenta> ReadAll();
	
	public TipoCuenta Read(int id);
}
