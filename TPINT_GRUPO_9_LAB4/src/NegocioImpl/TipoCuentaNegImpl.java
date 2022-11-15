package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.DaoTipoCuenta;
import Entidad.TipoCuenta;
import Negocio.TipoCuentaNeg;

public class TipoCuentaNegImpl implements TipoCuentaNeg{
	
	DaoTipoCuenta dTC = new DaoTipoCuenta();

	@Override
	public ArrayList<TipoCuenta> ReadAll() {
		return dTC.ReadAll();
	}

	@Override
	public TipoCuenta Read(int id) {
		return dTC.Read(id);
	}

}
