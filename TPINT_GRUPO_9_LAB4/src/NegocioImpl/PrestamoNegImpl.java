package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.DaoPrestamo;
import Entidad.Prestamo;
import Negocio.PrestamoNeg;

public class PrestamoNegImpl implements PrestamoNeg{

	DaoPrestamo dP = new DaoPrestamo();
	
	@Override
	public boolean Insert(Prestamo prestamo) {
		return dP.Insert(prestamo);
	}

	@Override
	public boolean Update(Prestamo prestamo) {
		return dP.Update(prestamo);
	}

	@Override
	public Prestamo Read(int id) {
		return dP.Read(id);
	}

	@Override
	public ArrayList<Prestamo> ReadAll() {
		return dP.ReadAll();
	}

	@Override
	public ArrayList<Prestamo> readDNI(String DNI) {
		return dP.readDNI(DNI);
	}
	
	public boolean UpdateCuotasPagadas(int cuotasPagadas, int ID) {
		return dP.UpdateCuotasPagadas(cuotasPagadas, ID);
	}
	
	public boolean UpdateEstado(int id) {
		return dP.UpdateEstado(id);
	}
}
