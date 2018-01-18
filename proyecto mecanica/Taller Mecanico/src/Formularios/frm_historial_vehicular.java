package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Clases.clsHistorialAuto;
import Clases.cls_autos;

import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;

public class frm_historial_vehicular extends JFrame {

	private JPanel contentPane;
	private JTable tabla1;
	private JTextField txtN;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtAnio;
	private JTextField txtPlaca;
	private JTextField txtColor;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtMAntenimiento;
	private JTextField txtFecha;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_historial_vehicular frame = new frm_historial_vehicular();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_historial_vehicular() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				clsHistorialAuto a = new clsHistorialAuto();
				String[] cabecera={"ID","Mantenimiento","Fecha","Placa", "Marca","Modelo","Color","Año","Cedula","Nombre","Apellido"};
				Object datos[][]=a.consultarHis(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );
				
				txtID.setVisible(false);
			}
		});
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 761);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(Color.RED, 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(33, 560, 47, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtFecha.setColumns(10);
		txtFecha.setBounds(437, 649, 135, 26);
		contentPane.add(txtFecha);
		
		JLabel lblFechaDelIngreso = new JLabel("Fecha del Ingreso:");
		lblFechaDelIngreso.setForeground(Color.BLACK);
		lblFechaDelIngreso.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblFechaDelIngreso.setBackground(Color.BLUE);
		lblFechaDelIngreso.setBounds(204, 642, 261, 34);
		contentPane.add(lblFechaDelIngreso);
		
		JLabel label_3 = new JLabel("Portador del CI:");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		label_3.setBackground(Color.BLUE);
		label_3.setBounds(292, 716, 241, 34);
		contentPane.add(label_3);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtApellido.setColumns(10);
		txtApellido.setBounds(736, 687, 135, 26);
		contentPane.add(txtApellido);
		
		txtMAntenimiento = new JTextField();
		txtMAntenimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtMAntenimiento.setColumns(10);
		txtMAntenimiento.setBounds(531, 618, 326, 26);
		contentPane.add(txtMAntenimiento);
		
		JLabel lblIngresoALa = new JLabel("Ingreso a la Mecanica para un:");
		lblIngresoALa.setForeground(Color.BLACK);
		lblIngresoALa.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblIngresoALa.setBackground(Color.BLUE);
		lblIngresoALa.setBounds(150, 611, 463, 34);
		contentPane.add(lblIngresoALa);
		
		JLabel lblPropietarioSrsra = new JLabel("Propietario :   Sr/Sra. Cliente:");
		lblPropietarioSrsra.setForeground(Color.BLACK);
		lblPropietarioSrsra.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblPropietarioSrsra.setBackground(Color.BLUE);
		lblPropietarioSrsra.setBounds(204, 680, 416, 34);
		contentPane.add(lblPropietarioSrsra);
		
		txtCedula = new JTextField();
		txtCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtCedula.setColumns(10);
		txtCedula.setBounds(498, 723, 141, 26);
		contentPane.add(txtCedula);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtNombre.setColumns(10);
		txtNombre.setBounds(591, 687, 135, 26);
		contentPane.add(txtNombre);
		
		JLabel label_7 = new JLabel("Del A\u00F1o:");
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		label_7.setBackground(Color.BLUE);
		label_7.setBounds(376, 581, 118, 34);
		contentPane.add(label_7);
		
		txtMarca = new JTextField();
		txtMarca.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtMarca.setColumns(10);
		txtMarca.setBounds(278, 554, 135, 26);
		contentPane.add(txtMarca);
		
		JLabel label_9 = new JLabel("Color:");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		label_9.setBackground(Color.BLUE);
		label_9.setBounds(150, 581, 82, 34);
		contentPane.add(label_9);
		
		txtPlaca = new JTextField();
		txtPlaca.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(752, 554, 135, 26);
		contentPane.add(txtPlaca);
		
		txtAnio = new JTextField();
		txtAnio.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtAnio.setColumns(10);
		txtAnio.setBounds(484, 588, 135, 26);
		contentPane.add(txtAnio);
		
		txtColor = new JTextField();
		txtColor.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtColor.setColumns(10);
		txtColor.setBounds(231, 588, 135, 26);
		contentPane.add(txtColor);
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtModelo.setColumns(10);
		txtModelo.setBounds(423, 554, 135, 26);
		contentPane.add(txtModelo);
		
		JLabel lblElVehiculo = new JLabel("El Vehiculo:");
		lblElVehiculo.setForeground(Color.BLACK);
		lblElVehiculo.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblElVehiculo.setBackground(Color.BLUE);
		lblElVehiculo.setBounds(134, 547, 161, 34);
		contentPane.add(lblElVehiculo);
		
		JLabel lblDeLasPlacas = new JLabel("de las Placas:");
		lblDeLasPlacas.setForeground(Color.BLACK);
		lblDeLasPlacas.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblDeLasPlacas.setBackground(Color.BLUE);
		lblDeLasPlacas.setBounds(577, 547, 186, 34);
		contentPane.add(lblDeLasPlacas);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\3c7b4448a6afd54529c93ec12fba5a12.png"));
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setBounds(10, 428, 951, 322);
		contentPane.add(label_1);
		
		JLabel lblHi = new JLabel("HISTORIAL DEL VEHICULO");
		lblHi.setForeground(Color.RED);
		lblHi.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		lblHi.setBackground(Color.BLUE);
		lblHi.setBounds(221, 23, 468, 34);
		contentPane.add(lblHi);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				hide();
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\flecha-hacia-la-izquierda (1).png"));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(845, 15, 65, 66);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 128, 761, 289);
		contentPane.add(scrollPane);
		
		tabla1 = new JTable();
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 17));
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				clsHistorialAuto a = new clsHistorialAuto();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla1.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));
				datos=a.datocl(codigo);
				
				
			    txtID.setText(datos[0]);
				txtMarca.setText(datos[1]);
				txtModelo.setText(datos[2]);
				txtPlaca.setText(datos[3]);
				txtColor.setText(datos[4]);
				txtAnio.setText(datos[5]);
				txtMAntenimiento.setText(datos[6]);
				txtFecha.setText(datos[7]);
				txtCedula.setText(datos[8]);
				txtNombre.setText(datos[9]);
				txtApellido.setText(datos[10]);
				
			}
		});
		scrollPane.setViewportView(tabla1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\libro-de-historia-para-la-educacion.png"));
		label.setForeground(Color.RED);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		label.setBackground(Color.BLUE);
		label.setBounds(150, 0, 88, 81);
		contentPane.add(label);
		
		txtN = new JTextField();
		txtN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				clsHistorialAuto a = new clsHistorialAuto();
				String[] cabecera={"ID","Fecha","Mantenimiento","Placa", "Marca","Modelo","Color","Año","Cedula","Nombre","Apellido"};
				Object datos[][]=a.consultarHis(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );
			}
		});
		txtN.setForeground(Color.RED);
		txtN.setBackground(Color.BLACK);
		txtN.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtN.setColumns(10);
		txtN.setBounds(155, 101, 160, 22);
		contentPane.add(txtN);
		
		JLabel lblBuscarXPlaca = new JLabel("Buscar x Placa:");
		lblBuscarXPlaca.setForeground(Color.RED);
		lblBuscarXPlaca.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblBuscarXPlaca.setBackground(Color.BLACK);
		lblBuscarXPlaca.setBounds(29, 95, 187, 34);
		contentPane.add(lblBuscarXPlaca);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
