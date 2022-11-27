package Main;

import Entidad.Telefono;

public class Principal {

	public static void main(String[] args) {
		
		Telefono tel = new Telefono();
		
		tel.setTelefono_1("12345678");
		
		System.out.println(tel.toString());
		
		
	}

}
