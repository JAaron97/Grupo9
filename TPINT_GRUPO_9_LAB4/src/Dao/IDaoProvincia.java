package Dao;

import java.util.ArrayList;

import Entidad.Provincia;

public interface IDaoProvincia {
	
	
	
	public ArrayList<Provincia> ReadAll();
	
	public Provincia Read(int ID);
	
}
