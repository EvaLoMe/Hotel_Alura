package sistema;

import modelo.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
import java.util.Date;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import com.alura.jdbc.factory.ConnectionFactory;

//reserva es el método controller, donde se contienen: reservaDAO, huespedesDAO y el funcionamiento del hotel físico

public class Reserva {
	private Hotel hotel;
	private ReservaDAO reservaciones;
	private HuespedesDAO huespedes;
	public Reserva (Hotel hotel, ReservaDAO reservaciones, HuespedesDAO huespedes){
		this.hotel=hotel;
		this.reservaciones=reservaciones;
		this.huespedes=huespedes;
	}

	// Es el método para agregar los datos y regresa un cuarto asignado.
	public int agregar(Date fecha_entrada, Date fecha_salida, double valor, int tipo_pago) {

		int ret=asignarCuarto(fecha_entrada, fecha_salida,valor, tipo_pago);
        
		return ret;
	}
	
	public boolean disponible(LocalDateTime fecha_entrada, LocalDateTime fecha_salida) {
		//consulta y regresa true cuando esta disponible
		boolean ret=true;
		return ret;
	}
	public int asignarCuarto(Date fecha_entrada, Date fecha_salida,double valor, int tipo_pago) {
	// Recupera la siguiente habitación disponible y la asigna	
		int habDisponible=hotel.habitacionDisponible();
		int idReservacion=-1;
		System.out.println("Asignar cuarto: "+habDisponible);
	
		idReservacion=reservaciones.agregar( fecha_entrada, fecha_salida, valor, tipo_pago);
		hotel.agregarReservacion(habDisponible);
		return idReservacion;
	}
// Completa el JComboBox de txtValor al llenar todas las habitaciones existentes
	public ComboBoxModel<String> resolveComboBox(JComboBox<String> txtValor) {
		String []habitaciones=null;
		habitaciones =hotel.getHabitaciones();
		return new DefaultComboBoxModel(habitaciones);
	}
	// Este método agrega el huesped solo si todas las validaciones son verdaderas
	public boolean agregarHuesped(String Nombre, String Apellido, String Telefono, int Nreserva, java.util.Date FechaN, String Nacionalidad) {
		boolean ret=true;
		huespedes.agregar( Nombre, Apellido, Telefono,  Nreserva, FechaN,  Nacionalidad);
		return ret;
	}
	// Método que completa la información en la tabla  reservaciones devolviendo una lista de Modelo R.
	public List<ModeloR> mostrarReservaciones() {
	
		return reservaciones.mostrar();
		
	}
	public List<ModeloH>  mostrarHuespedes() {
		// Método que completa la información en la tabla  huespedes devolviendo una lista de Modelo H.	
		return huespedes.mostrar();
	}
	
	public boolean eliminarReservacion(int id) {
	//Este método borra un registro que se encuentra en la 	base de datos, no lo hace directamente sino a través de ReservacionesDAO
		return reservaciones.eliminar(id);
	}



	public boolean eliminarHuesped(int id) {
		//Este método borra un registro que se encuentra en la 	base de datos, no lo hace directamente sino a través de HuespedesDAO
		return huespedes.eliminar(id);
	}

// Este método actualiza la base de datos huespedes, luego de haber llenado la pantalla de edición
	public void actualizaHuesped(String Nombre, String Apellido, String Telefono, 
			int Nreserva, java.util.Date fecha, String Nacionalidad, int idReserva) {
	
		huespedes.editar(Nombre, Apellido, Telefono, Nreserva, fecha, Nacionalidad, idReserva);
	}

	// Este método actualiza la base de datos huespedes, luego de haber llenado la pantalla de edición
	public void actualizaReservacion(int id, java.util.Date fecha_entrada, java.util.Date fecha_salida, double valor,
			int formaPago) {
	
		reservaciones.editar(id, fecha_entrada, fecha_salida, valor, formaPago);
	}
	//Este método devuelve el costo diario por noche
	public double recuperaValor(String Datos) {
		return hotel.recuperaValor(Datos);
	}
	
}
	
