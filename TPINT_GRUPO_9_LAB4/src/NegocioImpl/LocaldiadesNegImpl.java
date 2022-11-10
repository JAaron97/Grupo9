package NegocioImpl;


import DaoImpl.DaoLocalidad;
import Entidad.Localidad;
import Negocio.LocaldiadesNeg;
public class LocaldiadesNegImpl implements LocaldiadesNeg {

	DaoLocalidad Ldao = new DaoLocalidad();
	@Override
	public Localidad readAll(int ID) {
		// TODO Auto-generated method stub
		
		return Ldao.readAll(ID);
	}

}
