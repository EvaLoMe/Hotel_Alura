package sistema;
// La clase usuario se creó para mantener encapsulada la contraseña del método autenticar
public class Usuario {
	private String usuario;
	private String contrasena;
//Método para crear el usuario	
	public Usuario(String usuario, String contrasena) {
		this.usuario= usuario;
		this.contrasena= contrasena;
	}
	//Método para obtener la id del usuario
	public String getUsuario() {
		return usuario;
	}
	// Método para cambiar la id del usuario
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	// Método para obtener la contraseña
	public String getContrasena() {
		return contrasena;
	}
	// Método para cambiar la contraseña
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
	
		return usuario+"<----";
	}
	@Override
	public boolean equals(Object obj) {
		boolean ret=false;
		Usuario u=(Usuario)obj;
		if(this.contrasena.equals(u.contrasena)&&this.usuario.equals(u.usuario))
			ret=true;
		return ret;
	}
	
	
}
