package NegocioImpl;
import java.util.ArrayList;



import DaoImpl.DaoNacionalidad;
import Entidad.Nacionalidad;
import Negocio.NacionalidadNeg;

public class NacionalidadNegImpl implements NacionalidadNeg {

	DaoNacionalidad Ndao = new DaoNacionalidad();

	@Override
	public Nacionalidad Read(int ID) {
		return Ndao.Read(ID);
	}

	@Override
	public ArrayList<Nacionalidad> ReadAll() {
		return Ndao.ReadAll();
	}

}
