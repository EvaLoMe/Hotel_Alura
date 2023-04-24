package modelo;
// Se creó como modelo unitario para la creación del hotel, es el vínculo para obtener 
//la información de una sola habitación, hace el código más actualizable
public class Habitacion {
	private int id;
	private int capacidad;
	private double precio;
	private boolean disponible;
	

	public Habitacion(int id, int capacidad, double precio) {
		this.id= id;
		this.capacidad= capacidad;
		this.precio= precio;
		this.disponible=true;
	}
	
	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
}
