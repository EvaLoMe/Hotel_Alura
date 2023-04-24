package sistema;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.sql.Date;

import com.alura.jdbc.factory.ConnectionFactory;

import modelo.*;
//La clase ReservaDAO se creó para manejar todas las conexiones hacia la base de datos relacionadas con los reservaciones
public class ReservaDAO {
	private static Connection con;
//Mantiene la interacción con la base de datos en un mismo objeto
	public ReservaDAO() {
		con = new ConnectionFactory().recuperaConexion();
	}
//Método que realiza la actualización del registro en la base de datos, recibe java.util.Date que convierta a SQL.Date
	public boolean editar(int id, java.util.Date fecha_entrada, java.util.Date fecha_salida, double valor,
			int formaPago) {
		boolean ret = true;

		try {
			// El statement se prepara y se ejecuta desde SQL 
			final PreparedStatement statement = con.prepareStatement(
					"UPDATE RESERVAS SET FECHAENTRADA = ?, " + "FECHASALIDA= ?, VALOR= ?, FORMAPAGO= ? WHERE id = ?;",
					Statement.RETURN_GENERATED_KEYS);
			System.out.println(statement + "------>");
			java.sql.Date fE = new java.sql.Date(fecha_entrada.getTime());
			java.sql.Date fS = new java.sql.Date(fecha_salida.getTime());
			statement.setDate(1, fE);
			statement.setDate(2, fS);
			System.out.println(statement + "------>2");
			statement.setDouble(3, valor);
			statement.setInt(4, formaPago);
			System.out.println(statement + "------>3");
			statement.setInt(5, id);
			System.out.println(statement + "------>4");
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

	//Método que agrega un elemento del registro en la base de datos, recibe java.util.Date que convierta a SQL.Date
	public int agregar(java.util.Date fecha_entrada, java.util.Date fecha_salida, double valor, int formaPago) {
		int ret = -1;
		try {
			// El statement se prepara y se ejecuta desde SQL 
			final PreparedStatement statement = con.prepareStatement(
					"INSERT INTO RESERVAS" + " (fechaEntrada, fechaSalida, valor, formaPago) " + "VALUES(?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			// query de Insertar
			try (statement) {

				System.out.println(statement + "------>");
				java.sql.Date fE = new java.sql.Date(fecha_entrada.getTime());
				java.sql.Date fS = new java.sql.Date(fecha_salida.getTime());
				statement.setDate(1, fE);
				statement.setDate(2, fS);
				statement.setDouble(3, valor);
				statement.setInt(4, formaPago);
				System.out.println(statement + "------>");
				statement.executeUpdate();

				final ResultSet resultSet = statement.getGeneratedKeys();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

			// Query para consultar autoLlenado
			try {
				String sql = "SELECT * FROM RESERVAS";

				System.out.println(sql);
				// El statement se prepara y se ejecuta desde SQL 
				final PreparedStatement statement2 = con.prepareStatement(sql);

				try (statement2) {
					final ResultSet resultSet = statement2.executeQuery();

					try (resultSet) {
						while (resultSet.next()) {
							ret = resultSet.getInt("ID");
						}
					}
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return ret;
	}
 // Permite obtener toda la informaciòn de la tabla Reserva
	public List<ModeloR> mostrar() {

		List<ModeloR> resultado = new ArrayList<>();

		try {
			String sql = "SELECT * FROM RESERVAS";

			System.out.println(sql);
			// El statement se prepara y se ejecuta desde SQL 
			final PreparedStatement statement = con.prepareStatement(sql);

			try (statement) {
				final ResultSet resultSet = statement.executeQuery();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new ModeloR(resultSet.getInt("ID"), resultSet.getDate("FECHAENTRADA"),
								resultSet.getDate("FECHASALIDA"), resultSet.getDouble("VALOR"),
								resultSet.getInt("FORMAPAGO")));

					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}
	//Elimina una reserva utilizando la primary key como elemento de búsqueda devuelve falso si no puede completar la operación	
	public boolean eliminar(int id) {

		boolean ret = true;
		try {
			// El statement se prepara y se ejecuta desde SQL 
			final PreparedStatement statement = con.prepareStatement("DELETE FROM RESERVAS WHERE ID = ?",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {

				System.out.println(statement + "------>");
				statement.setInt(1, id);
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

}
