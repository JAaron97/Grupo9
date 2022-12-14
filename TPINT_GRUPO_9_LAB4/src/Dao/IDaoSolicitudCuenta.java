package Dao;

import java.util.ArrayList;

import Entidad.SolicitudCuenta;

public interface IDaoSolicitudCuenta {
	public boolean Insert (SolicitudCuenta SolicitudCuenta);
	public ArrayList<SolicitudCuenta> ReadAll();
	public SolicitudCuenta Read(int ID);
	public boolean UpdateEstado(int ID);
}
