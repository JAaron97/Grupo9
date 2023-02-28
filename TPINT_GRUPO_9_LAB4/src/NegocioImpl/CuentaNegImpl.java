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
	public boolean Delete(String DNI) {
		return dC.Delete(DNI);
	}

	@Override
	public ArrayList<Cuenta> ReadAll() {
		return dC.ReadAll();
	}

	@Override
	public ArrayList<Cuenta> readAllxDNI(String DNIUsuario) {
		return dC.readAllxDNI(DNIUsuario);
	}

	@Override
	public Cuenta Read(String numeroCuenta) {
		return dC.Read(numeroCuenta);
	}

}
