package Dao;

import java.util.ArrayList;

import Entidad.SolicitudPrestamo;

public interface IDaoSolicitudPrestamo {
	
	public boolean Insert(SolicitudPrestamo Solicitud);
	
	public boolean UpdateEstado(int id);
	
	public SolicitudPrestamo Read(int id);
	
	public ArrayList<SolicitudPrestamo> ReadAll();
	

}
