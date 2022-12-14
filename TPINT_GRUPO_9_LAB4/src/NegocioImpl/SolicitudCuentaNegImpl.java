package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.DaoSolicitudCuenta;
import Entidad.SolicitudCuenta;
import Negocio.SolicitudCuentaNeg;

public class SolicitudCuentaNegImpl implements SolicitudCuentaNeg{
	DaoSolicitudCuenta dSC = new DaoSolicitudCuenta();

	@Override
	public boolean Insert(SolicitudCuenta SolicitudCuenta) {
		return dSC.Insert(SolicitudCuenta);
	}

	@Override
	public ArrayList<SolicitudCuenta> ReadAll() {
		return dSC.ReadAll();
	}

	@Override
	public SolicitudCuenta Read(int ID) {
		return dSC.Read(ID);
	}

	@Override
	public boolean UpdateEstado(int ID) {
		return dSC.UpdateEstado(ID);
	}

}
