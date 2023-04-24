package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.ModeloH;
import modelo.ModeloR;
import sistema.Reserva;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
// Esta clase es la interfaz que muestra las condiciones de ambas tablas y permite la edición, búsqueda y eliminación de registros
@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JLabel labelAtras;
	private JLabel labelExit;
	private Reserva reservaciones;
	private int ventana;
	private JScrollPane scroll_table;
	int xMouse, yMouse;
	private JTabbedPane panel;

	/**
	 * Launch the application.
	 */
	
	// Este método se creó para hacer pruebas
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Busqueda frame = new Busqueda();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// Este método crea la ventana de búsqueda
	public Busqueda(Reserva reservaciones) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		this.reservaciones = reservaciones;

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);

		panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		actualizarTablaReservas(modelo);
		scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), scroll_table,
				null);
		scroll_table.setVisible(true);
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		actualizarTablaHuespedes(modeloHuesped);
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")),
				scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario(reservaciones);
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario(reservaciones);
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) { // Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) { // Al usuario quitar el mouse por el botón este volverá al estado
													// original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(panel.getSelectedIndex()+" <-------");
				if (panel.getSelectedIndex()== 0) {
					consultaReservas(modelo, txtBuscar.getText());
				} else {
					
					consultaHuespedes(modeloHuesped, txtBuscar.getText());
				}

			}

			

		});

		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);
		btnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(panel.getSelectedIndex()+" <-------");
				if (panel.getSelectedIndex()== 0) {
					int selectedRow = tbReservas.getSelectedRow();
					System.out.println(tbReservas.getValueAt(selectedRow, 0));
					int id = Integer.parseInt((tbReservas.getValueAt(selectedRow, 0)).toString());

					new EditarReservas(reservaciones, tbReservas.getValueAt(selectedRow, 0).toString(),
							tbReservas.getValueAt(selectedRow, 3).toString(),
							tbReservas.getValueAt(selectedRow, 1).toString(),
							tbReservas.getValueAt(selectedRow, 2).toString(),
							tbReservas.getValueAt(selectedRow, 4).toString());
				} else {
					int selectedRow = tbHuespedes.getSelectedRow();
					System.out.println(tbHuespedes.getValueAt(selectedRow, 0));
					int id = Integer.parseInt((tbHuespedes.getValueAt(selectedRow, 0)).toString());
					new EditarHuesped(reservaciones, tbHuespedes.getValueAt(selectedRow, 1).toString(),
							tbHuespedes.getValueAt(selectedRow, 2).toString(),
							tbHuespedes.getValueAt(selectedRow, 5).toString(),
							tbHuespedes.getValueAt(selectedRow, 3).toString(),
							tbHuespedes.getValueAt(selectedRow, 4).toString(),
							tbHuespedes.getValueAt(selectedRow, 6).toString(),
							tbHuespedes.getValueAt(selectedRow, 0).toString());

				}

			}

		});

		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		lblEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (panel.getSelectedIndex()== 0) {
					System.out.println(tbReservas.getValueAt(tbReservas.getSelectedRow(), 0));
					int id = Integer.parseInt((tbReservas.getValueAt(tbReservas.getSelectedRow(), 0)).toString());
					eliminarReservacion(id);
				} else {
					System.out.println(tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 0));
					int id = Integer.parseInt((tbHuespedes.getValueAt(tbHuespedes.getSelectedRow(), 0)).toString());
					eliminarHuespedes(id);
				}

			}

		});
		setResizable(false);
	}
//Emplea una lista de modelos para actualizar la tabla de Reservas
	private void actualizarTablaReservas(DefaultTableModel modelo) {
		List<ModeloR> resultado = reservaciones.mostrarReservaciones();
		for (int i = 0; i < resultado.size(); i++) {
			modelo.addRow(resultado.get(i).getParametros());
		}

	}
//Emplea una lista de modelos para actualizar la tabla de Huéspedes
	private void actualizarTablaHuespedes(DefaultTableModel modelo) {
		List<ModeloH> resultado = reservaciones.mostrarHuespedes();
		for (int i = 0; i < resultado.size(); i++) {
			modelo.addRow(resultado.get(i).getParametros());
		}

	}
// Muestra los resultados de la búsqueda, puede ser en cualquier elemento de cualquier campo	
	private void consultaReservas(DefaultTableModel modelo, String Dato) {
		List<ModeloR> resultado = reservaciones.mostrarReservaciones();
		boolean exito=false;
		this.modelo.setRowCount(0);
		for (int i = 0; i < resultado.size(); i++) {
			if(resultado.get(i).consultaDato(Dato)) {
				this.modelo.addRow(resultado.get(i).getParametros());
				exito=true;
			}
			
		}
		//Devuelve un mensaje cuando en la búsqueda ningún elemento ha coincidido
		if(!exito) {
			new Error(reservaciones, "Paràmetro no encontrado");
			this.actualizarTablaReservas(modelo);
		}
	}
 // Muestra los resultados de la búsqueda, puede ser en cualquier elemento de cualquier campo	
	private void consultaHuespedes(DefaultTableModel modelo, String Dato) {
		List<ModeloH> resultado = reservaciones.mostrarHuespedes();
		boolean exito=false;
		modeloHuesped.setRowCount(0);
		for (int i = 0; i < resultado.size(); i++) {
			ModeloH mod=resultado.get(i);
			if(mod.consultaDato(Dato)) {
				modeloHuesped.addRow(mod.getParametros());
				exito=true;
			}
			
		}
		//Devuelve un mensaje cuando en la búsqueda ningún elemento ha coincidido
		System.out.println(exito+" <+++ consulta huespedes");
		if(!exito) {
			new Error(reservaciones, "Paràmetro no encontrado");
			this.actualizarTablaHuespedes(modelo);
		}
	}
//Método para eliminar un registro, lanza un mensaje cuando el registro fue eliminado satisfactoriamente
	private void eliminarReservacion(int id) {
		reservaciones.eliminarReservacion(id);
		Exito dialog = new Exito(reservaciones, "Registro eliminado satisfactoriamente");
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		this.actualizarTablaReservas(modelo);
		cerrar();
	}
	//Método para eliminar un registro, lanza un mensaje cuando el registro fue eliminado satisfactoriamente
	private void eliminarHuespedes(int id) {
		reservaciones.eliminarHuesped(id);
		Exito dialog = new Exito(reservaciones, "Registro eliminado satisfactoriamente");
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
		this.actualizarTablaHuespedes(modelo);
		cerrar();
	}
//Método para cerrar la ventana una vez que finalizó la operación
	private void cerrar() {
		this.dispose();
	}

//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"

	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}
