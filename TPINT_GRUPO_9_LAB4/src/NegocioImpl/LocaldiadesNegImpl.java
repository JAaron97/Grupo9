package NegocioImpl;


import java.util.ArrayList;

import DaoImpl.DaoLocalidad;
import Entidad.Localidad;
import Negocio.LocaldiadesNeg;
public class LocaldiadesNegImpl implements LocaldiadesNeg {

	DaoLocalidad Ldao = new DaoLocalidad();

	@Override
	public ArrayList<Localidad> ReadAll() {
		return Ldao.ReadAll();
	}

	@Override
	public Localidad Read(int id) {
		return Ldao.Read(id);
	}


}
