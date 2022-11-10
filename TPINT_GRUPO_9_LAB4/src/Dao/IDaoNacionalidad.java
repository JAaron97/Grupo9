package Dao;

import java.util.List;

import Entidad.Nacionalidad;



public interface IDaoNacionalidad {
	public Nacionalidad obtenerPorID(int ID);
	public List<Nacionalidad> readAll();
	public Nacionalidad ObtenerUnaNacinalidad(String  nacionalidad);
}
