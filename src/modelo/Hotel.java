package modelo;
//Se creó el hotel para agregar las habitaciones por número de habitación, huéspedes y precio por noche
// Hotel es la forma lógica de las habitaciones en físico, fue pensado el número de habitaciones máximas es 10 pero puede cambiar a un List si el hotel fuera incrementable

public class Hotel {
	Habitacion[] habitaciones = new Habitacion[10];
	int registradas;

	public Hotel() {
		registradas = 0;
		this.agregarHabitacion(101, 2, 1200);
		this.agregarHabitacion(102, 2, 1200);
		this.agregarHabitacion(103, 2, 1200);
		this.agregarHabitacion(104, 4, 1200);
		this.agregarHabitacion(105, 4, 3200);
		this.agregarHabitacion(106, 4, 3200);
		this.agregarHabitacion(107, 6, 3200);
		this.agregarHabitacion(108, 6, 3200);
		this.agregarHabitacion(109, 6, 3200);
		this.agregarHabitacion(110, 6, 3200);
	}
// La operación agregarHabitacion registra habitaciones nuevas, devuelve false si son mas de 10
	public boolean agregarHabitacion(Habitacion h) {
		boolean ret = true;
		if (registradas < 10)
			habitaciones[registradas] = h;
		else
			ret = false;
		registradas++;
		return ret;
	}
// La operación agregarHabitacion cuando no recibes el objeto habitacion
	public boolean agregarHabitacion(int id, int capacidad, double precio) {
		boolean ret = true;
		if (registradas < 10)
			habitaciones[registradas] = new Habitacion(id, capacidad, precio);
		else
			ret = false;
		System.out.println("Creacion de habitaciones: " + habitaciones[registradas].getId());
		registradas++;
		return ret;
	}
// La operación agregarReservacion cambia la disponibilidad de una habitacion
	public void agregarReservacion(int id) {
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i].getId() == id)
				habitaciones[i].setDisponible(false);
		}

	}
	// La operación eliminarReservacion elimina la disponibilidad de una habitacion
	public void eliminarReservacion(int id) {
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i].getId() == id)
				habitaciones[i].setDisponible(true);
		}

	}
	// La operación consultarReservacion verifica disponibilidad de una habitacion
	public boolean consultarReservacion(int id) {
		boolean disponible = false;
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i].getId() == id)
				disponible = habitaciones[i].isDisponible();
		}
		return disponible;

	}
	// La operación habitacionDisponible devuelve la próxima habitacion disponible
	public int habitacionDisponible() {
		int disponible = -1;
		System.out.println("De isDisponible: " + habitaciones.length + " " + registradas + "<+++++++++");
		for (int i = 0; i < habitaciones.length; i++) {
			System.out.println("For habitacionDisponible: " + i + "i ;" + habitaciones[i].isDisponible());
			if (habitaciones[i].isDisponible()) {
				disponible = habitaciones[i].getId();
				break;
			}
		}
		return disponible;

	}
	// La operación getPrecioHabitacion devuelve el precio de la  habitacion disponible
	public double getPrecioHabitacion(int noHabitacion) {
		int aux = 0;
		for (int i = 0; i < habitaciones.length; i++) {
			if (habitaciones[i].getId() == noHabitacion) {
				aux = i;
				break;
			}

		}
		return habitaciones[aux].getPrecio();
	}
// La operación getHabitaciones  devuelve un arreglo de String con la información ordenada de cada habitación para llenar el objeto jcombobox_txtValor
	public String[] getHabitaciones() {
		String []ret=new String[10];
		for (int i = 0; i < habitaciones.length; i++) {
			ret[i]="Huespedes: "+habitaciones[i].getCapacidad()+" Precio: $"+habitaciones[i].getPrecio()+" m.n";

		}
		return ret;
	}
	// La operación recuperaValor devuelve el precio de la  habitación a partir de los datos ordenados
	public double recuperaValor(String Datos){
		double ret=-1;
		int cuarto=0;
		for (int i = 0; i < habitaciones.length; i++) {
			if(Datos.equals("Huespedes: "+habitaciones[i].getCapacidad()+" Precio: $"+habitaciones[i].getPrecio()+" m.n")) {
				cuarto=i;
				break;
			}
				
		}
		ret=habitaciones[cuarto].getPrecio();
		return ret;
	}
}
