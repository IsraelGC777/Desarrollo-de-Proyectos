package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.UIManager;

import Clases.cls_autos;
//import Clases.cls_usuario;
import Clases.cls_clientes;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class frm_autos extends JFrame {
	
	private int bandera;

	private JPanel contentPane;
	private JTextField txtCorreo;
	private JTextField txtN1;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCelular;
	private JTextField txtGenero;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtAnio;
	private JTextField txtN2;
	private JTextField txtCedula;
	private JComboBox cmbMarca;
	private JComboBox cmbColor;
	private JTable tabla1;
	private JTextField txtN;
	private JButton btnGuardar;
	private JButton btnActualizar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JLabel lblnuevovehiculo;
	private JLabel lblActualizar;
	private JTextField txtID_auto;
	private JTextField txtID_cl;
	private JTable tabla2;
	private JLabel lblSeleccioneAlCliente;
	private JLabel label_1;
	private JTextField txtCilindraje;
	private JTextField txtID;
	private JLabel lblId;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_autos frame = new frm_autos();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frm_autos() {
		this.setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\coche.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				cls_autos emp = new cls_autos();
                String[] cabecera={"ID","Placa","Marca","Modelo","Color","Año","Cilindraje","idCliente"};
				Object datos[][]=emp.consultar(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );	
				
				cls_autos au = new cls_autos();
                String[] cabecera1={"ID","Cedula","Nombre","Apellido","Dirección","Genero","Teléfono","Celular","Correo"};
				Object datos1[][]=au.consultar1(txtN1.getText());
				tabla2.setModel(new DefaultTableModel(datos1,cabecera1) );	
				
				txtID.setVisible(false);
				//txtID_auto.setVisible(false);
				//txtID_cl.setVisible(false);
				lblnuevovehiculo.setVisible(false);
				lblActualizar.setVisible(false);
				lblSeleccioneAlCliente.setVisible(false);
				
				bcajas();
				bbotones();
				btnAgregar.setEnabled(true);
				bandera=0;
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 858);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new LineBorder(new Color(0, 120, 215), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(35, 623, 814, 169);
		contentPane.add(panel);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo Electr\u00F3nico:");
		lblCorreoElectrnico.setForeground(new Color(0, 0, 139));
		lblCorreoElectrnico.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblCorreoElectrnico.setBackground(Color.BLUE);
		lblCorreoElectrnico.setBounds(327, 124, 176, 34);
		panel.add(lblCorreoElectrnico);
		
		txtCorreo = new JTextField();
		txtCorreo.setForeground(Color.BLACK);
		txtCorreo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(497, 129, 182, 28);
		panel.add(txtCorreo);
		
		JLabel label_2 = new JLabel("Nombre:");
		label_2.setForeground(new Color(0, 0, 139));
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_2.setBackground(Color.BLUE);
		label_2.setBounds(19, 37, 71, 34);
		panel.add(label_2);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtNombre.setColumns(10);
		txtNombre.setBounds(90, 42, 148, 26);
		panel.add(txtNombre);
		
		JLabel label_3 = new JLabel("Apellido:");
		label_3.setForeground(new Color(0, 0, 139));
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_3.setBackground(Color.BLUE);
		label_3.setBounds(259, 37, 103, 34);
		panel.add(label_3);
		
		txtApellido = new JTextField();
		txtApellido.setForeground(Color.BLACK);
		txtApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtApellido.setColumns(10);
		txtApellido.setBounds(340, 43, 146, 26);
		panel.add(txtApellido);
		
		JLabel label_4 = new JLabel("Direccion:");
		label_4.setForeground(new Color(0, 0, 139));
		label_4.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_4.setBackground(Color.BLUE);
		label_4.setBounds(518, 37, 103, 34);
		panel.add(label_4);
		
		txtDireccion = new JTextField();
		txtDireccion.setForeground(Color.BLACK);
		txtDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(604, 43, 191, 26);
		panel.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setForeground(Color.BLACK);
		txtTelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(105, 130, 155, 26);
		panel.add(txtTelefono);
		
		txtCelular = new JTextField();
		txtCelular.setForeground(Color.BLACK);
		txtCelular.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtCelular.setColumns(10);
		txtCelular.setBounds(604, 87, 158, 28);
		panel.add(txtCelular);
		
		JLabel label_5 = new JLabel("Genero:");
		label_5.setForeground(new Color(0, 0, 139));
		label_5.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_5.setBackground(Color.BLUE);
		label_5.setBounds(281, 80, 76, 34);
		panel.add(label_5);
		
		txtGenero = new JTextField();
		txtGenero.setForeground(Color.BLACK);
		txtGenero.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtGenero.setColumns(10);
		txtGenero.setBounds(351, 86, 155, 26);
		panel.add(txtGenero);
		
		JLabel label_6 = new JLabel("Celular:");
		label_6.setForeground(new Color(0, 0, 139));
		label_6.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_6.setBackground(Color.BLUE);
		label_6.setBounds(528, 82, 74, 34);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Telefono:");
		label_7.setForeground(new Color(0, 0, 139));
		label_7.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_7.setBackground(Color.BLUE);
		label_7.setBounds(19, 124, 80, 34);
		panel.add(label_7);
		
		JLabel lblCeculaDelCliente = new JLabel("DATOS DEL CLIENTE:");
		lblCeculaDelCliente.setForeground(Color.BLACK);
		lblCeculaDelCliente.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblCeculaDelCliente.setBackground(Color.BLUE);
		lblCeculaDelCliente.setBounds(32, 0, 176, 34);
		panel.add(lblCeculaDelCliente);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setForeground(new Color(0, 0, 139));
		lblCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblCedula.setBackground(Color.BLUE);
		lblCedula.setBounds(19, 82, 80, 34);
		panel.add(lblCedula);
		
		txtCedula = new JTextField();
		txtCedula.setForeground(Color.BLACK);
		txtCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtCedula.setColumns(10);
		txtCedula.setBounds(90, 85, 161, 26);
		panel.add(txtCedula);
		
		txtID_cl = new JTextField();
		txtID_cl.setEnabled(false);
		txtID_cl.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtID_cl.setColumns(10);
		txtID_cl.setBounds(741, 5, 54, 26);
		panel.add(txtID_cl);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtID.setEnabled(false);
		txtID.setColumns(10);
		txtID.setBounds(199, 5, 54, 26);
		panel.add(txtID);
		
		label = new JLabel("ID:");
		label.setForeground(new Color(0, 0, 139));
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label.setBackground(Color.BLUE);
		label.setBounds(710, -1, 35, 34);
		panel.add(label);
		
		JLabel lblVehiculos = new JLabel("AUTOS");
		lblVehiculos.setForeground(Color.RED);
		lblVehiculos.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblVehiculos.setBackground(Color.BLUE);
		lblVehiculos.setBounds(372, 0, 82, 34);
		contentPane.add(lblVehiculos);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(255, 228, 181));
		panel_1.setBounds(35, 153, 814, 130);
		contentPane.add(panel_1);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setForeground(new Color(0, 0, 139));
		lblPlaca.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblPlaca.setBackground(Color.BLUE);
		lblPlaca.setBounds(19, 37, 71, 34);
		panel_1.add(lblPlaca);
		
		txtPlaca = new JTextField();
		txtPlaca.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtPlaca.setColumns(10);
		txtPlaca.setBounds(72, 43, 148, 26);
		panel_1.add(txtPlaca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(new Color(0, 0, 139));
		lblMarca.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblMarca.setBackground(Color.BLUE);
		lblMarca.setBounds(259, 37, 62, 34);
		panel_1.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(new Color(0, 0, 139));
		lblModelo.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblModelo.setBackground(Color.BLUE);
		lblModelo.setBounds(10, 82, 103, 34);
		panel_1.add(lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtModelo.setColumns(10);
		txtModelo.setBounds(82, 88, 138, 26);
		panel_1.add(txtModelo);
		
		txtAnio = new JTextField();
		txtAnio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				 char c=ke.getKeyChar(); 
                 if(Character.isLetter(c)) { 
	              getToolkit().beep();              
	              ke.consume();		               
	              JOptionPane.showMessageDialog(null, " Solo puede ingresar Números!"); 
	              } 
			}
		});
		txtAnio.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtAnio.setColumns(10);
		txtAnio.setBounds(298, 88, 138, 26);
		panel_1.add(txtAnio);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setForeground(new Color(0, 0, 139));
		lblColor.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblColor.setBackground(Color.BLUE);
		lblColor.setBounds(485, 37, 54, 34);
		panel_1.add(lblColor);
		
		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setForeground(new Color(0, 0, 139));
		lblAo.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblAo.setBackground(Color.BLUE);
		lblAo.setBounds(259, 82, 80, 34);
		panel_1.add(lblAo);
		
		JLabel lblDatosDelVehiculo = new JLabel("VEHICULO");
		lblDatosDelVehiculo.setForeground(Color.BLACK);
		lblDatosDelVehiculo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblDatosDelVehiculo.setBackground(Color.BLUE);
		lblDatosDelVehiculo.setBounds(99, -2, 81, 34);
		panel_1.add(lblDatosDelVehiculo);
		
		cmbMarca = new JComboBox();
		cmbMarca.setModel(new DefaultComboBoxModel(new String[] {"AUDI", "BMW", "CHERY", "CHEVROLET", "CITROEN", "DAEWOO", "DODGE", "FIAT", "FORD", "GREAT WALL", "HONDA", "HYUNDAI", "ISUZU", "JEEP", "MAZDA", "MERCEDES BENZ", "MITSUBISHI", "NISSAN", "PEUGEOT", "RENAULT", "SUZUKI", "TOYOTA", "VOLKSWAGEN", "VOLVO"}));
		cmbMarca.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		cmbMarca.setBounds(318, 41, 118, 26);
		panel_1.add(cmbMarca);
		
		cmbColor = new JComboBox();
		cmbColor.setModel(new DefaultComboBoxModel(new String[] {"AMARILLO", "AZUL", "BLANCO", "CAFE", "CONCHE-VINO", "DORADO", "GRIS", "MORADO", "NEGRO", "ROJO", "TOMATE", "VERDE"}));
		cmbColor.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		cmbColor.setBounds(539, 44, 118, 26);
		panel_1.add(cmbColor);
		
		lblnuevovehiculo = new JLabel("NUEVO:");
		lblnuevovehiculo.setForeground(Color.BLACK);
		lblnuevovehiculo.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblnuevovehiculo.setBackground(Color.BLUE);
		lblnuevovehiculo.setBounds(30, -2, 62, 34);
		panel_1.add(lblnuevovehiculo);
		
		lblActualizar = new JLabel("ACTUALIZAR");
		lblActualizar.setForeground(Color.BLACK);
		lblActualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblActualizar.setBackground(Color.BLUE);
		lblActualizar.setBounds(0, -2, 103, 34);
		panel_1.add(lblActualizar);
		
		txtID_auto = new JTextField();
		txtID_auto.setEnabled(false);
		txtID_auto.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtID_auto.setColumns(10);
		txtID_auto.setBounds(750, 16, 54, 26);
		panel_1.add(txtID_auto);
		
		JLabel lblCilindraje = new JLabel("Cilindraje:");
		lblCilindraje.setForeground(new Color(0, 0, 139));
		lblCilindraje.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblCilindraje.setBackground(Color.BLUE);
		lblCilindraje.setBounds(480, 82, 123, 34);
		panel_1.add(lblCilindraje);
		
		txtCilindraje = new JTextField();
		txtCilindraje.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtCilindraje.setColumns(10);
		txtCilindraje.setBounds(568, 88, 96, 26);
		panel_1.add(txtCilindraje);
		
		lblId = new JLabel("ID:");
		lblId.setForeground(new Color(0, 0, 139));
		lblId.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblId.setBackground(Color.BLUE);
		lblId.setBounds(722, 11, 35, 34);
		panel_1.add(lblId);
		
		txtN1 = new JTextField();
		txtN1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				cls_autos au = new cls_autos();
                String[] cabecera1={"ID","Cedula","Nombre","Apellido","Dirección","Genero","Teléfono","Celular","Correo"};
				Object datos1[][]=au.consultar1(txtN1.getText());
				tabla2.setModel(new DefaultTableModel(datos1,cabecera1) );	

			}
			@Override
			public void keyTyped(KeyEvent evt) {
				
			}
		});
		txtN1.setBounds(232, 493, 114, 26);
		contentPane.add(txtN1);
		txtN1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtN1.setColumns(10);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\actualizar.png"));
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acajas();
				bbotones();
				btnGuardar.setEnabled(true);
				btnCancelar.setEnabled(true);
				bandera=2;
				lblActualizar.setVisible(true);
			}
		});
		btnActualizar.setForeground(SystemColor.textHighlight);
		btnActualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnActualizar.setBounds(346, 56, 152, 39);
		contentPane.add(btnActualizar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\disquete.png"));
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_autos au = new cls_autos();
				
				au.setPlaca(txtPlaca.getText());
				au.setMarca(cmbMarca.getSelectedItem().toString());
				au.setModelo(txtModelo.getText());
				au.setColor(cmbColor.getSelectedItem().toString());
				au.setAnio(txtAnio.getText());
				au.setCilindraje(txtCilindraje.getText());
				au.setIdClientes(Integer.parseInt(txtID_cl.getText().toString()));
				
				
				
					if(bandera==1){
					
					if(au.insertar()==true){
					
					JOptionPane.showMessageDialog(null,"Registro Guardado");
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Error al Registrar");
				  }
				}
				
				if(bandera==2){
					au.setCodigo(Integer.parseInt(txtID_auto.getText().toString()));
					if(au.actualizar()==true){
						
						JOptionPane.showMessageDialog(null,"Registro Actualizado");
					}
					
					else{
						JOptionPane.showMessageDialog(null, "Error al Actualizar");
					  }
					
				}
				    bandera=0;
				    lcajas();
					bcajas();
					bbotones();
				    btnAgregar.setEnabled(true);
				    lblnuevovehiculo.setVisible(false);
				
			}
			
		});
		btnGuardar.setForeground(SystemColor.textHighlight);
		btnGuardar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnGuardar.setBounds(508, 56, 134, 39);
		contentPane.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\cancelar.png"));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bcajas();
				lcajas();
				bbotones();
				btnAgregar.setEnabled(true);
				lblnuevovehiculo.setVisible(false);
				lblSeleccioneAlCliente.setVisible(false);
			}
		});
		btnCancelar.setForeground(SystemColor.textHighlight);
		btnCancelar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnCancelar.setBounds(280, 102, 134, 39);
		contentPane.add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\goma-de-borrar.png"));
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cls_autos u = new cls_autos();
				
				u.setCodigo(Integer.parseInt(txtID_auto.getText().toString()));
				if(u.Eliminar()) {
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "Error al Eliminar");
				}
			}
		});
		btnEliminar.setForeground(SystemColor.textHighlight);
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnEliminar.setBounds(424, 102, 134, 39);
		contentPane.add(btnEliminar);
		
		JLabel lblDeCedula = new JLabel("Buscar por Nombre:");
		lblDeCedula.setForeground(new Color(0, 0, 139));
		lblDeCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblDeCedula.setBackground(Color.BLUE);
		lblDeCedula.setBounds(63, 487, 229, 34);
		contentPane.add(lblDeCedula);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 523, 815, 89);
		contentPane.add(scrollPane);
		
		tabla2 = new JTable();
		tabla2.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabla2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla2.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla2.getSelectedRow(),0));
				cls_autos au = new cls_autos();
				datos=au.datocl(codigo);
				
				txtID_cl.setText(datos[0]);
				txtCedula.setText(datos[1]);
				txtNombre.setText(datos[2]);
				txtApellido.setText(datos[3]);
				txtDireccion.setText(datos[4]);
				txtGenero.setText(datos[5]);
				txtTelefono.setText(datos[6]);
				txtCelular.setText(datos[7]);
				txtCorreo.setText(datos[8]);
				
			}
		});
		scrollPane.setViewportView(tabla2);
		
		txtN2 = new JTextField();
		txtN2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				cls_autos au = new cls_autos();
                String[] cabecera1={"ID","Cedula","Nombre","Apellido","Dirección","Genero","Teléfono","Celular","Correo"};
				Object datos1[][]=au.consultar2(txtN2.getText());
				tabla2.setModel(new DefaultTableModel(datos1,cabecera1) );	
			}
			@Override
			public void keyTyped(KeyEvent evt) {
				
			}
		});
		txtN2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtN2.setColumns(10);
		txtN2.setBounds(604, 493, 114, 26);
		contentPane.add(txtN2);
		
		JLabel lblApellido = new JLabel("Buscar por ID:");
		lblApellido.setForeground(new Color(0, 0, 139));
		lblApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblApellido.setBackground(Color.BLUE);
		lblApellido.setBounds(478, 487, 134, 34);
		contentPane.add(lblApellido);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(34, 331, 815, 102);
		contentPane.add(scrollPane_1);
		
		tabla1 = new JTable();
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_autos aut = new cls_autos();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla1.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));
				datos=aut.datoAuto(codigo);
				
				
			    txtID_auto.setText(datos[0]);
				txtPlaca.setText(datos[1]);
				cmbMarca.setSelectedItem(datos[2]);
				txtModelo.setText(datos[3]);
				cmbColor.setSelectedItem(datos[4]);
				txtAnio.setText(datos[5]);
				txtCilindraje.setText(datos[6]);
				
				
				
				txtID_cl.setText(datos[7]);
				txtID.setText(datos[8]);
				
				txtCedula.setText(datos[9]);
				txtNombre.setText(datos[10]);
				txtApellido.setText(datos[11]);
				txtDireccion.setText(datos[12]);
				txtGenero.setText(datos[13]);
				txtTelefono.setText(datos[14]);
				txtCelular.setText(datos[15]);
				txtCorreo.setText(datos[16]);  
				
				
				bbotones();
				btnActualizar.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnEliminar.setEnabled(true);
				
				txtCedula.setText("");
				txtNombre.setText("");
				txtApellido.setText("");
				txtDireccion.setText("");
				txtGenero.setText("");
				txtCelular.setText("");
				txtTelefono.setText("");
				txtCorreo.setText("");
				
				
			}
		});
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 13));
		scrollPane_1.setViewportView(tabla1);
		
		JLabel lblBuscarPorPlaca = new JLabel("Buscar por Placa:");
		lblBuscarPorPlaca.setForeground(new Color(0, 0, 139));
		lblBuscarPorPlaca.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblBuscarPorPlaca.setBackground(Color.BLUE);
		lblBuscarPorPlaca.setBounds(35, 288, 172, 34);
		contentPane.add(lblBuscarPorPlaca);
		
		txtN = new JTextField();
		txtN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				cls_autos emp = new cls_autos();
                String[] cabecera={"ID","Placa","Marca","Modelo","Color","Año","Cilindraje","idCliente"};
				Object datos[][]=emp.consultar(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );
				
			}
		});
		txtN.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtN.setColumns(10);
		txtN.setBounds(179, 294, 148, 26);
		contentPane.add(txtN);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\archivo.png"));
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblnuevovehiculo.setVisible(true);
				lblSeleccioneAlCliente.setVisible(true);
				acajas();
				bbotones();
				btnGuardar.setEnabled(true);
				btnCancelar.setEnabled(true);
				bandera=1;  
				lblActualizar.setVisible(false);
			}

			
		});
		btnAgregar.setForeground(SystemColor.textHighlight);
		btnAgregar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnAgregar.setBounds(202, 56, 134, 39);
		contentPane.add(btnAgregar);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\flecha-hacia-la-izquierda (1).png"));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
		});
		button.setForeground(new Color(0, 0, 205));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setBounds(812, 11, 65, 67);
		contentPane.add(button);
		
		lblSeleccioneAlCliente = new JLabel("Seleccione al Cliente que va  asignar el vehiculo");
		lblSeleccioneAlCliente.setForeground(new Color(0, 0, 139));
		lblSeleccioneAlCliente.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblSeleccioneAlCliente.setBackground(Color.BLUE);
		lblSeleccioneAlCliente.setBounds(35, 444, 595, 34);
		contentPane.add(lblSeleccioneAlCliente);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\carro-compacto.png"));
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		label_1.setBackground(Color.BLUE);
		label_1.setBounds(396, 22, 82, 34);
		contentPane.add(label_1);
	}
	
	private void acajas() {
		txtCilindraje.setEnabled(true);
		cmbColor.setEnabled(true);
		cmbMarca.setEnabled(true);
		txtCedula.setEnabled(true);
		txtNombre.setEnabled(true);
		txtApellido.setEnabled(true);
		txtDireccion.setEnabled(true);
		txtTelefono.setEnabled(true);
		txtCorreo.setEnabled(true);
		txtGenero.setEnabled(true);
		txtCelular.setEnabled(true);
		
		txtPlaca.setEnabled(true);
		txtModelo.setEnabled(true);
		txtAnio.setEnabled(true);		
	}
	
	public void bcajas(){
		txtCilindraje.setEnabled(false);
		cmbColor.setEnabled(false);
		cmbMarca.setEnabled(false);
		txtCedula.setEnabled(false);
		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtTelefono.setEnabled(false);
		txtCorreo.setEnabled(false);
		txtGenero.setEnabled(false);
		txtCelular.setEnabled(false);
		
		txtPlaca.setEnabled(false);
		txtModelo.setEnabled(false);
		txtAnio.setEnabled(false);
	}
	public void lcajas(){
		txtCilindraje.setText("");
		txtCedula.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		txtGenero.setText("");
		txtCelular.setText("");
		
		txtPlaca.setText("");
		txtModelo.setText("");
		txtAnio.setText("");
	}
	public void bbotones(){
		btnAgregar.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnCancelar.setEnabled(false);
	}
}
