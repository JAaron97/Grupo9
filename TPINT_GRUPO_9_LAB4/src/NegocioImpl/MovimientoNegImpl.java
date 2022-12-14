package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.DaoMovimiento;
import Entidad.Movimiento;
import Negocio.MovimientoNeg;

public class MovimientoNegImpl implements MovimientoNeg{

	DaoMovimiento dM = new DaoMovimiento();
	@Override
	public boolean Insert(Movimiento movimiento) {
		return dM.Insert(movimiento);
	}

	@Override
	public Movimiento Read(String id) {
		return dM.Read(id);
	}

	@Override
	public ArrayList<Movimiento> ReadAll() {
		return dM.ReadAll();
	}

}
