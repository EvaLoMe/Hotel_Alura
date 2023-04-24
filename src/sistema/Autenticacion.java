package sistema;

import java.util.*;
//Esta clase realiza el proceso de login para que sea transparente en la aplicación
public class Autenticacion {
	ArrayList <Usuario> empleados;
	public Autenticacion(){
		empleados =new <Usuario>ArrayList();
		this.addUsuario("admin", "admin");
		this.addUsuario("a", "a");
	}
// Regresa true si puede agregar un usuario y regresa false cuando el usuario ya está registrado	
	public boolean addUsuario(Usuario u) {
		boolean ret=true;
		if(empleados.isEmpty())
		empleados.add(u);
		else {
			if(empleados.indexOf(u)>=0)
				ret=false;
			else
				empleados.add(u);
		}
		return ret;
	}
	
	private boolean addUsuario( String usuario, String contrasena) {
		boolean ret=true;
		if(empleados.isEmpty())
			empleados.add (new Usuario(usuario, contrasena));
			else {
				Usuario u= new Usuario(usuario, contrasena);
				if(empleados.indexOf(u)>=0)
					ret=false;
				else
					empleados.add(u);
			}
		return ret;
	}
//Proceso directo de autenticacion, regresa true si el usuario y password son correctos, false en cualquier otro caso	
	public boolean autentificar(String usuario, String contrasena) {
		boolean ret=false;
		Usuario u= new Usuario(usuario, contrasena);
		
		if(empleados.indexOf(u)>=0)
			ret=true;
		return ret;
	}
}
