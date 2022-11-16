package Negocio;

import java.util.ArrayList;

import Entidad.Cuenta;

public interface CuentaNeg {
public boolean Insert(Cuenta cuenta);
	
	public boolean Update(Cuenta cuenta);
	
	public boolean Delete(String NumeroCuenta);
	
	public ArrayList<Cuenta> ReadAll();
	
	public Cuenta Read(String NumeroCuenta);
}
