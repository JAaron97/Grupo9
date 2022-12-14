package NegocioImpl;

import java.util.ArrayList;

import DaoImpl.DaoCuenta;
import Entidad.Cuenta;
import Negocio.CuentaNeg;

public class CuentaNegImpl implements CuentaNeg {
	
	DaoCuenta dC = new DaoCuenta();
	
	@Override
	public boolean Insert(Cuenta cuenta) {
		return dC.Insert(cuenta);
	}

	@Override
	public boolean Update(Cuenta cuenta) {
		return dC.Update(cuenta);
	}

	@Override
	public boolean Delete(String NumeroCuenta) {
		return dC.Delete(NumeroCuenta);
	}

	@Override
	public ArrayList<Cuenta> ReadAll() {
		return dC.ReadAll();
	}

	@Override
	public Cuenta Read(String NumeroCuenta) {
		return dC.Read(NumeroCuenta);
	}

}
