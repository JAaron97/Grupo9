package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.DaoCuotas;
import Entidad.Cuota;
import Negocio.CuotaNeg;

public class CuotaNegImpl implements CuotaNeg {
	
	DaoCuotas dC = new DaoCuotas();
	
	@Override
	public boolean Insert(Cuota cuota) {
		return dC.Insert(cuota);
	}

	@Override
	public boolean Update(Cuota cuota) {
		return dC.Update(cuota);
	}

	@Override
	public Cuota Read(int ID, int ID_Prestamo) {
		return dC.Read(ID, ID_Prestamo);
	}

	@Override
	public ArrayList<Cuota> ReadAll(int ID_Prestamo) {
		return dC.ReadAll(ID_Prestamo);
	}

}
