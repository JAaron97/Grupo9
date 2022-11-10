package NegocioImpl;
import java.util.ArrayList;



import DaoImpl.DaoNacionalidad;
import Entidad.Nacionalidad;
import Negocio.NacionaldiadNeg;

public class NacionaldiadNegImpl implements NacionaldiadNeg {

	DaoNacionalidad Ndao = new DaoNacionalidad();

	@Override
	public ArrayList<Nacionalidad> readAll() {
		// TODO Auto-generated method stub
		return (ArrayList<Nacionalidad>) Ndao.readAll();

		
	}

	@Override
	public Nacionalidad ObtenerUnaNacinalidad(String nacionalidad) {
		return Ndao.ObtenerUnaNacinalidad(nacionalidad);
	}

	@Override
	public Nacionalidad obtenerPorID(int ID) {
		// TODO Auto-generated method stub
		return Ndao.obtenerPorID(ID);
	}



	

}
