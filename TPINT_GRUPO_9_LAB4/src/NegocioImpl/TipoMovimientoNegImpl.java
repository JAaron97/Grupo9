package NegocioImpl;

import java.util.ArrayList;

import Dao.IDaoTipoMovimiento;
import DaoImpl.DaoTipoMovimiento;
import Entidad.TipoMovimiento;
import Negocio.TipoMovimientoNeg;


public class TipoMovimientoNegImpl implements TipoMovimientoNeg {
	
	 IDaoTipoMovimiento DTM = new DaoTipoMovimiento();
	 
	 public TipoMovimiento Read(int ID) 
	 {
		 return DTM.Read(ID);
	 }
	 
	 public ArrayList<TipoMovimiento> ReadAll()
	 {
		 return DTM.ReadAll();
	 }
	 
	

}
