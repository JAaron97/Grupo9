package Negocio;

import java.util.ArrayList;

import Entidad.SolicitudPrestamo;

public interface SolicitudPrestamoNeg {
public boolean Insert(SolicitudPrestamo Solicitud);
	
	public boolean UpdateEstado(int id);
	
	public SolicitudPrestamo Read(int id);
	
	public ArrayList<SolicitudPrestamo> ReadAll();
}
