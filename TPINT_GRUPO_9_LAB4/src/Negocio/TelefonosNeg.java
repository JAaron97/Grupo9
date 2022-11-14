package Negocio;

import Entidad.Telefono;

public interface TelefonosNeg {
	public boolean Insert(Telefono telefono_add);
	
	public boolean Update(Telefono telefono_update);
	
	public Telefono Read(int ID);
}
