package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.DaoSolicitudPrestamo;
import Entidad.SolicitudPrestamo;
import Negocio.SolicitudPrestamoNeg;

public class SolicitudPrestamoNegImpl implements SolicitudPrestamoNeg {
	
	DaoSolicitudPrestamo dsP = new DaoSolicitudPrestamo();
	@Override
	public boolean Insert(SolicitudPrestamo SolicitudPrestamo) {
		return dsP.Insert(SolicitudPrestamo);
	}

	@Override
	public ArrayList<SolicitudPrestamo> ReadAll() {
		return dsP.ReadAll();
	}

	@Override
	public SolicitudPrestamo Read(int ID) {
		return dsP.Read(ID);
	}

	@Override
	public boolean UpdateEstado(int ID) {
		return dsP.UpdateEstado(ID);
	}

}
