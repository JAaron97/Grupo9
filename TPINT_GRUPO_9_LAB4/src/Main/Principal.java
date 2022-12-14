package Main;

import java.time.LocalDate;
import java.time.Period;
import Entidad.Usuario;




public class Principal {

	public static void main(String[] args) {
		
		Usuario user = new Usuario();
		
		user.setMail("roma.com");
		
		
		 String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
         java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
         java.util.regex.Matcher m = p.matcher(user.getMail());
         if(m.matches()) {
        	 System.out.println("yyyyeaaaah");
         }
		
		
		
	}

}
