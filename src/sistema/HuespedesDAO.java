package sistema;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.sql.Date;
import java.text.Format;

import com.alura.jdbc.factory.ConnectionFactory;
import com.toedter.calendar.JDateChooser;

import modelo.ModeloH;
import modelo.ModeloR;
//La clase HuespedesDAO se creó para manejar todas las conexiones hacia la base de datos relacionadas con los huéspedes
public class HuespedesDAO {
	private static Connection con;
	//Mantiene la interacción con la base de datos en un mismo objeto
	public HuespedesDAO() {
		con = new ConnectionFactory().recuperaConexion();
	}
//Elimina un huésped utilizando la primary key como elemento de búsqueda devuelve falso si no puede completar la operación	
	public boolean eliminar(int id) {
		boolean ret=true;
		try {
// El statement se prepara y se ejecuta desde SQL 
			final PreparedStatement statement = con.prepareStatement(
					"DELETE FROM HUESPEDES WHERE ID = ?",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				 
				System.out.println(statement+"------>");
			statement.setInt(1, id);
			System.out.println(statement+"------>");
			statement.executeUpdate();

			final ResultSet resultSet = statement.getGeneratedKeys();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ret;
	}
	// Permite actualizar la informaciòn de un registro en la tabla de huespedes y regresa falso si no puede completar la operación
	public boolean editar(String Nombre, String Apellido, String Telefono, 
			int Nreserva, java.util.Date fecha, String Nacionalidad, int idReserva) {
		
	
		boolean ret=true;
		try {
			// El statement se prepara y se ejecuta desde SQL 
			final PreparedStatement statement = con.prepareStatement(
					"UPDATE HUESPEDES SET NOMBRE = ?, "
							+ "APELLIDO= ?, FECHA_DE_NACIMIENTO= ?, NACIONALIDAD= ?, TELEFONO= ?, ID_RESERVA= ? WHERE id = ?;",
					Statement.RETURN_GENERATED_KEYS);
			
			System.out.println(statement + "------>");
			java.sql.Date fN = new java.sql.Date(fecha.getTime());
			
			statement.setString(1, Nombre);
			System.out.println(statement + "------>1");
			statement.setString(2, Apellido);
			System.out.println(statement + "------>2");
			statement.setDate(3, fN);
			System.out.println(statement + "------>3");
			statement.setString(4, Nacionalidad);
			System.out.println(statement + "------>4");
			statement.setString(5, Telefono);
			System.out.println(statement + "------>5");
			statement.setInt(6,Nreserva);
			System.out.println(statement + "------>6");
			statement.setInt(7,idReserva);
			System.out.println(statement + "------>7");
			
			try (statement) {
				System.out.println(statement + "------>");
				statement.executeUpdate();

				final ResultSet resultSet = statement.getGeneratedKeys();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
			return ret;	
			}
		
	public boolean consultar(String telefono) {
		boolean ret=true;
		return ret;
	}
	
	public int consultar(int id_reserva) {
		int ret=-1;
		return ret;
	}
	// Permite actualizar la informaciòn de agregar un registro en la tabla de huespedes y regresa falso si no puede completar la operación
	public boolean agregar(String Nombre, String Apellido, String Telefono, int Nreserva, java.util.Date fecha, String Nacionalidad) {
		boolean ret=true;
		try {
			// El statement se prepara y se ejecuta desde SQL 
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO HUESPEDES" + " (nombre, apellido, telefono, fecha_de_nacimiento, nacionalidad, id_reserva) " + "VALUES(?,?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			// Query para consultar autoLlenado
			try (statement) {
				 
				System.out.println(statement+"------>");
				java.sql.Date fechaN = new java.sql.Date(fecha.getTime());
				
			statement.setString(1, Nombre);
			statement.setString(2, Apellido);
			statement.setString(3, Telefono);
			statement.setDate(4, fechaN);
			statement.setString(5, Nacionalidad);
			statement.setInt(6, Nreserva);
			System.out.println(statement+"------>");
			statement.executeUpdate();

			final ResultSet resultSet = statement.getGeneratedKeys();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ret;
	}
	// Permite obtener toda la informaciòn de la tabla huespedes 
		public List<ModeloH> mostrar() {
			
			List<ModeloH> resultado = new ArrayList<>();
			// Query para consultar autoLlenado
	        try {
	            String sql = "SELECT * FROM HUESPEDES";
	            
	            System.out.println(sql);
	         // El statement se prepara y se ejecuta desde SQL 
	            final PreparedStatement statement = con
	                    .prepareStatement(sql);

	            try (statement) {
	                final ResultSet resultSet = statement.executeQuery();

	                try (resultSet) {
	                    while (resultSet.next()) {
	                        resultado.add(new ModeloH(
	                                resultSet.getInt("ID"),
	                                resultSet.getString("NOMBRE"),
	                                resultSet.getString("APELLIDO"),
	                                resultSet.getDate("FECHA_DE_NACIMIENTO"),
	                                resultSet.getString("NACIONALIDAD"),
	                                resultSet.getString("TELEFONO"), resultSet.getInt("ID_RESERVA")));
	              
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }

	        return resultado;
		}
		
		
}
