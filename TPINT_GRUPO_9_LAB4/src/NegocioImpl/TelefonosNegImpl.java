package NegocioImpl;

import DaoImpl.DaoTelefono;
import Entidad.Telefono;
import Negocio.TelefonosNeg;

public class TelefonosNegImpl implements TelefonosNeg{

	DaoTelefono dTel = new DaoTelefono();
	
	@Override
	public boolean Insert(Telefono telefono_add) {
		return dTel.Insert(telefono_add);
	}

	@Override
	public boolean Update(Telefono telefono_update) {
		return dTel.Update(telefono_update);
	}

	@Override
	public Telefono Read(int ID) {
		return dTel.Read(ID);
	}

}
