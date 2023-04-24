package views;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

import javax.swing.*;

import java.awt.Color;

import com.toedter.calendar.JDateChooser;

import sistema.*;

import java.awt.Font;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.border.LineBorder;
//La clase EditarReserva se creó para actualizar o corregir el registro de una reservación

@SuppressWarnings("serial")
public class EditarReservas extends JFrame {

	private JPanel contentPane;
	public static JComboBox<String> txtValor;
	public static JDateChooser txtFechaEntrada;
	public static JDateChooser txtFechaSalida;
	public static JComboBox<String> txtFormaPago;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelAtras;
	private Reserva reservaciones;
	/**
	 * Launch the application.
	 */
	// El método se creó para realizar pruebas
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//ReservasView frame = new ReservasView();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	// El método se creó para actualizar los datos una vez hayan sido modificados en la ventana
	public EditarReservas(Reserva reservaciones, String numeroReserva,
			String valor, String FechaEntrada, String FechaSalida, String FormaPago) {
		super("Editar Reserva");
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditarReservas.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		
		this.reservaciones=reservaciones;
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Código que crea los elementos de la interfáz gráfica
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(SystemColor.textHighlight);
		separator_1_2.setBounds(68, 195, 289, 2);
		separator_1_2.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_2);
		
		JSeparator separator_1_3 = new JSeparator();
		separator_1_3.setForeground(SystemColor.textHighlight);
		separator_1_3.setBackground(SystemColor.textHighlight);
		separator_1_3.setBounds(68, 453, 289, 2);
		panel.add(separator_1_3);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setForeground(SystemColor.textHighlight);
		separator_1_1.setBounds(68, 281, 289, 11);
		separator_1_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1_1);
		
		JLabel lblCheckIn = new JLabel("FECHA DE CHECK IN");
		lblCheckIn.setForeground(SystemColor.textInactiveText);
		lblCheckIn.setBounds(68, 136, 169, 14);
		lblCheckIn.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckIn);
		
		JLabel lblCheckOut = new JLabel("FECHA DE CHECK OUT");
		lblCheckOut.setForeground(SystemColor.textInactiveText);
		lblCheckOut.setBounds(68, 221, 187, 14);
		lblCheckOut.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblCheckOut);
		
		JLabel lblFormaPago = new JLabel("FORMA DE PAGO");
		lblFormaPago.setForeground(SystemColor.textInactiveText);
		lblFormaPago.setBounds(68, 382, 187, 24);
		lblFormaPago.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblFormaPago);
		
		JLabel lblTitulo = new JLabel("SISTEMA DE RESERVAS");
		lblTitulo.setBounds(109, 60, 219, 42);
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 20));
		panel.add(lblTitulo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(EditarReservas.class.getResource("/imagenes/Ha-100px.png")));
		
		JLabel imagenFondo = new JLabel("");
		imagenFondo.setBounds(0, 140, 500, 409);
		panel_1.add(imagenFondo);
		imagenFondo.setBackground(Color.WHITE);
		imagenFondo.setIcon(new ImageIcon(EditarReservas.class.getResource("/imagenes/reservas-img-3.png")));

		JLabel lblValor = new JLabel("VALOR POR NOCHE");
		lblValor.setForeground(SystemColor.textInactiveText);
		lblValor.setBounds(72, 303, 196, 14);
		lblValor.setFont(new Font("Roboto Black", Font.PLAIN, 18));
		panel.add(lblValor);
	
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(SystemColor.textHighlight);
		separator_1.setBounds(68, 368, 289, 2);
		separator_1.setBackground(SystemColor.textHighlight);
		panel.add(separator_1);
												
		// Componentes para dejar la interfaz con estilo Material Design
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(new Color(12, 138, 199));
		btnexit.setBounds(429, 0, 53, 36);
		panel_1.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
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
		panel.add(header);
		
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
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		
		JLabel lblSiguiente = new JLabel("SIGUIENTE");
		lblSiguiente.setHorizontalAlignment(SwingConstants.CENTER);
		lblSiguiente.setForeground(Color.WHITE);
		lblSiguiente.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblSiguiente.setBounds(0, 0, 122, 35);
		
		
		//Campos que guardaremos en la base de datos
		txtFechaEntrada = new JDateChooser();
		txtFechaEntrada.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaEntrada.getCalendarButton().setIcon(new ImageIcon(EditarReservas.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		txtFechaEntrada.setBounds(68, 161, 289, 35);
		txtFechaEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		txtFechaEntrada.setBackground(Color.WHITE);
		txtFechaEntrada.setBorder(new LineBorder(SystemColor.window));
		txtFechaEntrada.setDateFormatString("yyyy-MM-dd");
		txtFechaEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(txtFechaEntrada);

		txtFechaSalida = new JDateChooser();
		txtFechaSalida.getCalendarButton().setIcon(new ImageIcon(EditarReservas.class.getResource("/imagenes/icon-reservas.png")));
		txtFechaSalida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		txtFechaSalida.setBounds(68, 246, 289, 35);
		txtFechaSalida.getCalendarButton().setBounds(267, 1, 21, 31);
		txtFechaSalida.setBackground(Color.WHITE);
		txtFechaSalida.setFont(new Font("Roboto", Font.PLAIN, 18));
		txtFechaSalida.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(txtFechaEntrada.getDate()!=null&&txtFechaSalida.getDate()!=null) {
					java.util.Date d1= (java.util.Date) txtFechaEntrada.getDate();
					java.util.Date d2= (java.util.Date) txtFechaSalida.getDate();
					System.out.println("Entro a la comparacion de fechas");
					System.out.println(d2.compareTo(d1)+" <++++++");
					if(d2.compareTo(d1)>0) {
						long diferenciaTime=d2.getTime() - d1.getTime();
						long diferencia=TimeUnit.DAYS.convert(diferenciaTime, TimeUnit.MILLISECONDS);
						double valorP= Double.parseDouble(valor);
						valorP=diferencia*reservaciones.recuperaValor(txtValor.getSelectedItem().toString());
						//labelValor.setText("Total a pagar: $ "+valorP+" m.n");
						System.out.println("Total a pagar: $ "+valorP+" m.n"+" Valor Diario:"+reservaciones.recuperaValor(txtValor.getSelectedItem().toString()));
					}else
						if(d2.compareTo(d1)<=0) {
							new Error(reservaciones, "La fecha de entrada debe ocurrir antes que la salida");
						}	
				}
			}
		});
		txtFechaSalida.setDateFormatString("yyyy-MM-dd");
		txtFechaSalida.getCalendarButton().setBackground(SystemColor.textHighlight);
		txtFechaSalida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(txtFechaSalida);

		txtValor = new JComboBox();
		txtValor.setBounds(68, 333, 289, 38);
		txtValor.setBackground(SystemColor.text);
		txtValor.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtValor.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtValor.setModel(reservaciones.resolveComboBox(txtValor));
		panel.add(txtValor);


		txtFormaPago = new JComboBox();
		txtFormaPago.setBounds(68, 417, 289, 38);
		txtFormaPago.setBackground(SystemColor.text);
		txtFormaPago.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		txtFormaPago.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtFormaPago.setModel(new DefaultComboBoxModel(new String[] {"Tarjeta de Crédito", "Tarjeta de Débito", "Dinero en efectivo"}));
		panel.add(txtFormaPago);

		JButton btnsiguiente = new JButton("RESERVAR");
		btnsiguiente.setForeground(Color.WHITE);
		btnsiguiente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (EditarReservas.txtFechaEntrada.getDate() != null && EditarReservas.txtFechaSalida.getDate() != null) {		
					actualizaReservacion(Integer.parseInt(numeroReserva),
							txtFechaEntrada.getDate(), txtFechaSalida.getDate(), Double.parseDouble(valor),
							txtFormaPago.getSelectedIndex() );
					Exito dialog =new Exito(reservaciones, "Datos modificados satisfactoriamente");
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					cerrar();
				} else {
					JOptionPane.showMessageDialog(null, "Debes llenar todos los campos.");
				}
			}						
		});
		btnsiguiente.setLayout(null);
		btnsiguiente.setBackground(SystemColor.textHighlight);
		btnsiguiente.setBounds(238, 493, 122, 35);
		panel.add(btnsiguiente);
		btnsiguiente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		txtValor.setSelectedItem(txtValor);
		java.util.Date fechaParseada=null;
		try {
			fechaParseada = new SimpleDateFormat("yyyy-MM-dd").parse(FechaEntrada);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		this.txtFechaEntrada.setDate(fechaParseada);
		
		try {
			fechaParseada = new SimpleDateFormat("yyyy-MM-dd").parse(FechaSalida);
		} catch (ParseException e1) {
			
			e1.printStackTrace();
		}
		
		this.txtFechaSalida.setDate(fechaParseada);
		txtFormaPago.setSelectedItem(FormaPago);
		this.setVisible(true);
	}
	//Este método finaliza el proceso del botón guardar
	private void actualizaReservacion(int id, java.util.Date fecha_entrada, java.util.Date fecha_salida, double valor,
			int formaPago) {
		java.util.Date d1= (java.util.Date) txtFechaEntrada.getDate();
		java.util.Date d2= (java.util.Date) txtFechaSalida.getDate();
		if(d2.compareTo(d1)>0) {
			long diferenciaTime=d2.getTime() - d1.getTime();
			long diferencia=TimeUnit.DAYS.convert(diferenciaTime, TimeUnit.MILLISECONDS);
			double valorP= -1;
			valorP=diferencia*reservaciones.recuperaValor(txtValor.getSelectedItem().toString());
			//labelValor.setText("Total a pagar: $ "+valorP+" m.n");
			System.out.println("Total a pagar: $ "+valorP+" m.n"+" Valor Diario:"+reservaciones.recuperaValor(txtValor.getSelectedItem().toString()));
			reservaciones.actualizaReservacion(id, fecha_entrada, fecha_salida, valor, formaPago);
			Exito dialog =new Exito(reservaciones, "Datos guardados satisfactoriamente");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			cerrar();
		}else
			if(d2.compareTo(d1)<=0) {
				new Error(reservaciones, "La fecha de entrada debe ocurrir antes que la salida");
			}	
		
		//reservaciones.agregarHuesped(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText(), 
		//		Integer.parseInt(txtNreserva.getText()), txtFechaN.getDate(), (String)txtNacionalidad.getSelectedItem());
	}
	//Este método cierra la ventana al final de la actualización de datos
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
