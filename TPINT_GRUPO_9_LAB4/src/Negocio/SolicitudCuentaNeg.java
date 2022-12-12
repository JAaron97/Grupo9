package Negocio;

import java.util.ArrayList;

import Entidad.SolicitudCuenta;

public interface SolicitudCuentaNeg {
	public boolean Insert (SolicitudCuenta SolicitudCuenta);
	public ArrayList<SolicitudCuenta> ReadAll();
	public SolicitudCuenta Read(int ID);
}
