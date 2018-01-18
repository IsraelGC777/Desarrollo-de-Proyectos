package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Clases.cls_det_empleado;
import Clases.cls_det_repuest;
import Clases.cls_mantenimiento;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class frm_det_repuesto extends JFrame {

	private JPanel contentPane;
	private JTextField txtN;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable tabla2;
	private JPanel panel_rep;
	private JTable tablaRepuest;
	private JTable tabla1;
	private JButton btnAgregar;
	private JButton button;
	private JButton button_1;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	
	DefaultTableModel m  = new DefaultTableModel() ;
	DefaultTableModel m2  = new DefaultTableModel() ;
	private JButton btnEliminar;
	private JButton button_2;
	private JTextField txtN2;
	private JTextField txtServicio;
	private JTextField txtMantenimiento;
	private JLabel lblMantenimiento;
	private JTextField txtPlaca;
	private JTextField txtMarca;
	private JTextField txtColor;
	private JTextField txtAnio;
	private JTextField txtModelo;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtID;
	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel label_15;
	private JTextField txtCant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_det_repuesto frame = new frm_det_repuesto();
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
	public frm_det_repuesto() {
		//this.setUndecorated(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				panel_rep.setVisible(false);
				txtID.setVisible(false);
				txtServicio.setVisible(false);
				
				cls_det_repuest man = new cls_det_repuest();
				
				String[] cabecera5={"ID Revision","Mantenimiento","Servicio"};
				Object datos5[][]=man.consultarRev(txtN2.getText());
				tabla1.setModel(new DefaultTableModel(datos5,cabecera5) );
				
				 String[] cabecera2={"ID","Repuesto","Precio","Stock"};
					Object datos2[][]=man.consultaRep(txtN.getText());
					tablaRepuest.setModel(new DefaultTableModel(datos2,cabecera2) );	
					

					String[] cabecera={"ID","Repuesto","Cantidad","Precio"};
					Object datos[][]=null;
					tabla2.setModel(new DefaultTableModel(datos,cabecera) );	
					
					
					
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1193, 798);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlLtHighlight);
		contentPane.setBorder(new LineBorder(SystemColor.textHighlight, 4));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_rep = new JPanel();
		panel_rep.setLayout(null);
		panel_rep.setBackground(SystemColor.textHighlight);
		panel_rep.setBounds(467, 24, 496, 343);
		contentPane.add(panel_rep);
		
		JLabel label = new JLabel("Repuesto");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 31));
		label.setBackground(Color.BLUE);
		label.setBounds(164, 11, 142, 34);
		panel_rep.add(label);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\boton-redondo-de-agregar.png"));
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fsel = tablaRepuest.getSelectedRow();
				try {
					String id, repuesto,precio, cant;
			
					if(fsel==-1) {
						
						JOptionPane.showMessageDialog(null, "debe selecionar un servicio!");
					}else {
						
						m = (DefaultTableModel) tablaRepuest.getModel();
						id = tablaRepuest.getValueAt(fsel, 0).toString();
						repuesto = tablaRepuest.getValueAt(fsel, 1).toString();
					    precio = tablaRepuest.getValueAt(fsel, 2).toString();
						
						cant= txtCant.getText(); 
						
						m2 = (DefaultTableModel) tabla2.getModel();
						m2.addRow(new Object [] {id, repuesto, cant, precio});
						tabla2.setModel(m2);
					
					}
					
			
					
				} catch (Exception e2) {
					
				}
			}
		});
		btnAgregar.setForeground(new Color(0, 0, 205));
		btnAgregar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnAgregar.setBounds(142, 282, 137, 50);
		panel_rep.add(btnAgregar);
		
		button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\cerrar (1).png"));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_rep.setVisible(false);
			}
		});
		button.setForeground(new Color(0, 0, 205));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setBounds(289, 282, 114, 50);
		panel_rep.add(button);
		
		JLabel label_1 = new JLabel("Servicio:");
		label_1.setForeground(new Color(0, 0, 139));
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_1.setBackground(Color.BLUE);
		label_1.setBounds(-185, 48, 91, 34);
		panel_rep.add(label_1);
		
		JLabel label_2 = new JLabel("Buscar Repuesto:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(23, 74, 142, 34);
		panel_rep.add(label_2);
		
		txtN = new JTextField();
		txtN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				cls_det_repuest man = new cls_det_repuest();
				 String[] cabecera5={"ID","Repuesto","Precio","Stock"};
					Object datos5[][]=man.consultaRep(txtN.getText());
					tablaRepuest.setModel(new DefaultTableModel(datos5,cabecera5) );	
			}
		});
		txtN.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtN.setColumns(10);
		txtN.setBounds(167, 80, 196, 26);
		panel_rep.add(txtN);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 119, 452, 142);
		panel_rep.add(scrollPane);
		
		tablaRepuest = new JTable();
		tablaRepuest.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane.setViewportView(tablaRepuest);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(346, 11, 57, 26);
		panel_rep.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(408, 11, 57, 26);
		panel_rep.add(textField_3);
		
		txtCant = new JTextField();
		txtCant.setText("1");
		txtCant.setBounds(32, 293, 82, 26);
		panel_rep.add(txtCant);
		txtCant.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtCant.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblCantidad.setBackground(Color.BLUE);
		lblCantidad.setBounds(42, 309, 62, 34);
		panel_rep.add(lblCantidad);
		
		button_1 = new JButton("Buscar");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_rep.setVisible(true);
			}
		});
		button_1.setForeground(new Color(0, 0, 205));
		button_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button_1.setBounds(149, 678, 103, 23);
		contentPane.add(button_1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(139, 560, 240, 105);
		contentPane.add(scrollPane_1);
		
		tabla2 = new JTable();
		tabla2.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane_1.setViewportView(tabla2);
		
		JLabel label_4 = new JLabel("Repuestos");
		label_4.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_4.setBounds(204, 526, 82, 23);
		contentPane.add(label_4);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(63, 63, 580, 167);
		contentPane.add(scrollPane_2);
		
		tabla1 = new JTable();
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cls_det_repuest man = new cls_det_repuest();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla1.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));
				datos=man.datoRev(codigo);
			
				txtID.setText(datos[0]);
				txtMantenimiento.setText(datos[1]);
				txtServicio.setText(datos[2]);
				
				txtPlaca.setText(datos[3]);
				txtMarca.setText(datos[4]);
				txtModelo.setText(datos[5]);
				txtColor.setText(datos[6]);
				txtAnio.setText(datos[7]);
				
				txtCedula.setText(datos[8]);
				txtNombre.setText(datos[9]);
				txtApellido.setText(datos[10]);
				txtDireccion.setText(datos[11]);
				txtFecha.setText(datos[12]);
			
			}
		});
		scrollPane_2.setViewportView(tabla1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				JOptionPane.showMessageDialog(null,"Registro Guardado");
				for(int j=0;j<=tabla2.getRowCount()-1;j++){
					cls_det_repuest det = new cls_det_repuest();
					
					DefaultTableModel tm = (DefaultTableModel) tabla2.getModel();
					String idRep =String.valueOf(tm.getValueAt(j,0));
					String cantidad =String.valueOf(tm.getValueAt(j,2));						
											
						//System.out.println("det emple: "+id_mantenimiento+" - "+idEmple);
						det.setIdRepust(Integer.parseInt(idRep));
						det.setIdRevision(Integer.parseInt(txtID.getText().toString()));
						det.setCant(Double.parseDouble(cantidad));
						det.insertarDetRepuest();
						
						}
				
				
			}
		});
		btnGuardar.setForeground(Color.RED);
		btnGuardar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnGuardar.setBounds(567, 701, 103, 47);
		contentPane.add(btnGuardar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel dtm = (DefaultTableModel) tabla2.getModel();  
				dtm.removeRow(tabla2.getSelectedRow());
			}
		});
		btnEliminar.setForeground(Color.RED);
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnEliminar.setBounds(264, 680, 103, 23);
		contentPane.add(btnEliminar);
		
		button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\flecha-hacia-la-izquierda (1).png"));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
		});
		button_2.setForeground(new Color(0, 0, 205));
		button_2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button_2.setBounds(1091, 24, 64, 55);
		contentPane.add(button_2);
		
		txtN2 = new JTextField();
		txtN2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				cls_det_repuest man = new cls_det_repuest();
				String[] cabecera5={"ID Revision","Mantenimiento","Servicio"};
				Object datos5[][]=man.consultarRev(txtN2.getText());
				tabla1.setModel(new DefaultTableModel(datos5,cabecera5) );
			}
		});
		txtN2.setBounds(130, 32, 86, 20);
		contentPane.add(txtN2);
		txtN2.setColumns(10);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblBuscar.setBounds(65, 29, 82, 23);
		contentPane.add(lblBuscar);
		
		txtServicio = new JTextField();
		txtServicio.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtServicio.setColumns(10);
		txtServicio.setBounds(29, 433, 166, 26);
		contentPane.add(txtServicio);
		
		txtMantenimiento = new JTextField();
		txtMantenimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtMantenimiento.setColumns(10);
		txtMantenimiento.setBounds(398, 478, 271, 26);
		contentPane.add(txtMantenimiento);
		
		lblMantenimiento = new JLabel("Mantenimiento:");
		lblMantenimiento.setForeground(Color.BLACK);
		lblMantenimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblMantenimiento.setBackground(Color.WHITE);
		lblMantenimiento.setBounds(264, 472, 147, 34);
		contentPane.add(lblMantenimiento);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtID.setColumns(10);
		txtID.setBounds(29, 472, 82, 26);
		contentPane.add(txtID);
		
		JLabel label_3 = new JLabel("DATOS DEL VEHICULO:");
		label_3.setBounds(107, 251, 221, 34);
		contentPane.add(label_3);
		label_3.setForeground(new Color(0, 0, 153));
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label_3.setBackground(Color.WHITE);
		
		JLabel label_5 = new JLabel("Placa:");
		label_5.setBounds(158, 290, 62, 34);
		contentPane.add(label_5);
		label_5.setForeground(new Color(0, 0, 139));
		label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_5.setBackground(Color.BLUE);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(204, 296, 103, 23);
		contentPane.add(txtPlaca);
		txtPlaca.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtPlaca.setColumns(10);
		
		JLabel label_6 = new JLabel("Marca:");
		label_6.setBounds(317, 290, 62, 34);
		contentPane.add(label_6);
		label_6.setForeground(new Color(0, 0, 139));
		label_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_6.setBackground(Color.BLUE);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(366, 295, 110, 23);
		contentPane.add(txtMarca);
		txtMarca.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtMarca.setColumns(10);
		
		JLabel label_7 = new JLabel("Color:");
		label_7.setBounds(692, 290, 48, 34);
		contentPane.add(label_7);
		label_7.setForeground(new Color(0, 0, 139));
		label_7.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_7.setBackground(Color.BLUE);
		
		txtColor = new JTextField();
		txtColor.setBounds(738, 295, 115, 23);
		contentPane.add(txtColor);
		txtColor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtColor.setColumns(10);
		
		JLabel label_8 = new JLabel("A\u00F1o:");
		label_8.setBounds(863, 290, 80, 34);
		contentPane.add(label_8);
		label_8.setForeground(new Color(0, 0, 139));
		label_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_8.setBackground(Color.BLUE);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(900, 295, 76, 23);
		contentPane.add(txtAnio);
		txtAnio.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtAnio.setColumns(10);
		
		JLabel label_9 = new JLabel("Modelo:");
		label_9.setBounds(486, 290, 55, 34);
		contentPane.add(label_9);
		label_9.setForeground(new Color(0, 0, 139));
		label_9.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_9.setBackground(Color.BLUE);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(544, 295, 138, 23);
		contentPane.add(txtModelo);
		txtModelo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtModelo.setColumns(10);
		
		JLabel label_10 = new JLabel("DATOS DELCLIENTE:");
		label_10.setBounds(175, 352, 237, 34);
		contentPane.add(label_10);
		label_10.setForeground(new Color(0, 0, 153));
		label_10.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label_10.setBackground(Color.BLUE);
		
		JLabel label_11 = new JLabel("Cedula:");
		label_11.setBounds(251, 397, 62, 34);
		contentPane.add(label_11);
		label_11.setForeground(new Color(0, 0, 139));
		label_11.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_11.setBackground(Color.BLUE);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(304, 402, 103, 23);
		contentPane.add(txtCedula);
		txtCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtCedula.setColumns(10);
		
		JLabel label_12 = new JLabel("Nombre:");
		label_12.setBounds(417, 397, 62, 34);
		contentPane.add(label_12);
		label_12.setForeground(new Color(0, 0, 139));
		label_12.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_12.setBackground(Color.BLUE);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(481, 402, 103, 23);
		contentPane.add(txtNombre);
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtNombre.setColumns(10);
		
		JLabel label_13 = new JLabel("Apellido:");
		label_13.setBounds(594, 397, 76, 34);
		contentPane.add(label_13);
		label_13.setForeground(new Color(0, 0, 139));
		label_13.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_13.setBackground(Color.BLUE);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(658, 402, 103, 23);
		contentPane.add(txtApellido);
		txtApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtApellido.setColumns(10);
		
		JLabel label_14 = new JLabel("Direccion:");
		label_14.setBounds(771, 397, 80, 34);
		contentPane.add(label_14);
		label_14.setForeground(new Color(0, 0, 139));
		label_14.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_14.setBackground(Color.BLUE);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(842, 402, 281, 23);
		contentPane.add(txtDireccion);
		txtDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtDireccion.setColumns(10);
		
		lblFecha = new JLabel("Fecha:");
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblFecha.setBackground(Color.WHITE);
		lblFecha.setBounds(693, 472, 103, 34);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtFecha.setColumns(10);
		txtFecha.setBounds(755, 478, 166, 26);
		contentPane.add(txtFecha);
		
		label_15 = new JLabel("");
		label_15.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\l\u00E1pices-del-color-en-una-hoja-en-blanco-14561301.jpg"));
		label_15.setBounds(10, 251, 1153, 264);
		contentPane.add(label_15);
	}
}
