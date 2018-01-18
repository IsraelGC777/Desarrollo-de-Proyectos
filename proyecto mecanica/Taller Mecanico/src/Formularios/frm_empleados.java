package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import Clases.cls_autos;
import Clases.cls_empleados;
import Clases.cls_mantenimiento;
import Clases.validacion_cedula;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class frm_empleados extends JFrame {

	private int bandera;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCedula;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtCelular;
	private JTextField txtTelefono;
	private JTextField txtCorreo;
	private JLabel lblClave;
	private JLabel lblUsuario;
	private JTextField txtUsuario;
	private JLabel lblAccesoAlSistema;
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JPanel panel_1;
	private JLabel lblPuestoQueDesempea;
	private JLabel lblCargo;
	private JComboBox cmbCargo;
	private JComboBox cmbGenero;
	private JTable tabla1;
	private JTextField txtN;
	private JTextField txtID;
	private JButton button;
	private JPasswordField txtClave;
	private JLabel label_3;
	
	  private int limiteTl  = 7;
	  private int limiteCl  = 10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_empleados frame = new frm_empleados();
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
	public frm_empleados() {
		this.setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\coche.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				cls_empleados emp = new cls_empleados();
                String[] cabecera={"ID","Cedula","Nombre","Apellido","Dirección","Genero","Teléfono","Celular","Correo","Cargo","Usuario","Contraseña"};
				Object datos[][]=emp.consultar1(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );	
				
				
				txtID.setVisible(false);
				bcajas();
				bbotones();
				btnAgregar.setEnabled(true);
				bandera=0;
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 730);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new LineBorder(SystemColor.textHighlight, 4));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_2 = new JLabel("EMPLEADOS");
		label_2.setBackground(Color.BLUE);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		label_2.setBounds(281, 9, 152, 34);
		contentPane.add(label_2);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\archivo.png"));
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				acajas();
				bbotones();
				btnGuardar.setEnabled(true);
				btnCancelar.setEnabled(true);
				bandera=1;
			}
		});
		btnAgregar.setForeground(SystemColor.textHighlight);
		btnAgregar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnAgregar.setBounds(134, 54, 134, 39);
		contentPane.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setVerticalAlignment(SwingConstants.BOTTOM);
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\actualizar.png"));
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				acajas();
				bbotones();
				btnGuardar.setEnabled(true);
				btnCancelar.setEnabled(true);
				bandera=2;
			}
		});
		btnActualizar.setForeground(SystemColor.textHighlight);
		btnActualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnActualizar.setBounds(281, 54, 153, 39);
		contentPane.add(btnActualizar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\disquete.png"));
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cls_empleados emp = new cls_empleados();
				
				emp.setCedula(txtCedula.getText());
				emp.setNombre(txtNombre.getText());
				emp.setApellido(txtApellido.getText());
				emp.setDireccion(txtDireccion.getText());
				emp.setGenero(cmbGenero.getSelectedItem().toString());
				emp.setTelefono(txtTelefono.getText());
				emp.setCelular(txtCelular.getText());
				emp.setCorreo(txtCorreo.getText());
				emp.setCargo(cmbCargo.getSelectedItem().toString());
				emp.setUsuario(txtUsuario.getText());
				emp.setContraseña(txtClave.getText());
			
				if(bandera==1){
					
					if(emp.insertar()==true){
					
					JOptionPane.showMessageDialog(null,"Registro Guardado");
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Error al Registrar");
				  }
				}
				
				if(bandera==2){
					emp.setCodigo(Integer.parseInt(txtID.getText().toString()));
					if(emp.actualizar()==true){
						
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
				
			}
				
			
		});
		btnGuardar.setForeground(SystemColor.textHighlight);
		btnGuardar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnGuardar.setBounds(443, 54, 134, 39);
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
			}
		});
		btnCancelar.setForeground(SystemColor.textHighlight);
		btnCancelar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnCancelar.setBounds(194, 100, 134, 39);
		contentPane.add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\goma-de-borrar.png"));
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cls_empleados cl = new cls_empleados();
				
				cl.setCodigo(Integer.parseInt(txtID.getText().toString()));
				if(cl.Eliminar()) {
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "Error al Eliminar");
				}
			}
		});
		btnEliminar.setForeground(SystemColor.textHighlight);
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnEliminar.setBounds(345, 100, 134, 39);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 567, 717, 152);
		contentPane.add(scrollPane);
		
		tabla1 = new JTable();
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cls_empleados man = new cls_empleados();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla1.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));
				datos=man.datoEmpleado(codigo);
				
				txtID.setText(datos[0]);
				txtCedula.setText(datos[1]);
				txtNombre.setText(datos[2]);
				txtApellido.setText(datos[3]);
				txtDireccion.setText(datos[4]);
				cmbGenero.setSelectedItem(datos[5]);
				txtTelefono.setText(datos[6]);
				txtCelular.setText(datos[7]);
				txtCorreo.setText(datos[8]);
				cmbCargo.setSelectedItem(datos[9]);
				txtUsuario.setText(datos[10]);
				txtClave.setText(datos[11]);
				
				bbotones();
				btnActualizar.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnEliminar.setEnabled(true);
				
				
			}
		});
		scrollPane.setViewportView(tabla1);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setForeground(new Color(0, 0, 153));
		lblBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblBuscar.setBackground(Color.BLUE);
		lblBuscar.setBounds(26, 528, 103, 34);
		contentPane.add(lblBuscar);
		
		txtN = new JTextField();
		txtN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				cls_empleados emp = new cls_empleados();
                String[] cabecera={"ID","Cedula","Nombre","Apellido","Dirección","Genero","Teléfono","Celular","Correo","Cargo","Usuario","Contraseña"};
				Object datos[][]=emp.consultar1(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );	
			}
		});
		txtN.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtN.setColumns(10);
		txtN.setBounds(90, 534, 163, 26);
		contentPane.add(txtN);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtID.setColumns(10);
		txtID.setBounds(26, 67, 56, 26);
		contentPane.add(txtID);
		
		button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\flecha-hacia-la-izquierda (1).png"));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
		});
		button.setForeground(new Color(0, 0, 205));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setBounds(645, 21, 66, 57);
		contentPane.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 120, 215), 2));
		panel_2.setBounds(29, 147, 626, 370);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBounds(21, 215, 270, 101);
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(SystemColor.controlHighlight);
		
		lblPuestoQueDesempea = new JLabel("Puesto que desempe\u00F1a el empleado");
		lblPuestoQueDesempea.setForeground(Color.BLACK);
		lblPuestoQueDesempea.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblPuestoQueDesempea.setBackground(Color.BLUE);
		lblPuestoQueDesempea.setBounds(10, 11, 275, 24);
		panel_1.add(lblPuestoQueDesempea);
		
		lblCargo = new JLabel("Cargo:");
		lblCargo.setForeground(new Color(0, 0, 153));
		lblCargo.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblCargo.setBackground(Color.BLUE);
		lblCargo.setBounds(20, 46, 77, 34);
		panel_1.add(lblCargo);
		
		cmbCargo = new JComboBox();
		cmbCargo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		cmbCargo.setModel(new DefaultComboBoxModel(new String[] {"TECNICO AUTOMOTRIZ", "MECANICO GENERAL", "OFICIAL"}));
		cmbCargo.setBounds(81, 51, 167, 30);
		panel_1.add(cmbCargo);
		
		JPanel panel = new JPanel();
		panel.setBounds(329, 215, 260, 144);
		panel_2.add(panel);
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setLayout(null);
		
		lblAccesoAlSistema = new JLabel("Acceso al Sistema");
		lblAccesoAlSistema.setBounds(20, 11, 150, 24);
		lblAccesoAlSistema.setForeground(SystemColor.desktop);
		lblAccesoAlSistema.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblAccesoAlSistema.setBackground(Color.BLUE);
		panel.add(lblAccesoAlSistema);
		
		lblClave = new JLabel("Clave:");
		lblClave.setBounds(40, 97, 50, 34);
		panel.add(lblClave);
		lblClave.setForeground(new Color(0, 0, 153));
		lblClave.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblClave.setBackground(Color.BLUE);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(20, 54, 77, 34);
		panel.add(lblUsuario);
		lblUsuario.setForeground(new Color(0, 0, 153));
		lblUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblUsuario.setBackground(Color.BLUE);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(92, 59, 135, 28);
		panel.add(txtUsuario);
		txtUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtUsuario.setColumns(10);
		
		txtClave = new JPasswordField();
		txtClave.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtClave.setBounds(92, 105, 135, 24);
		panel.add(txtClave);
		
		JLabel label_1 = new JLabel("Cedula:");
		label_1.setBounds(33, 35, 66, 34);
		panel_2.add(label_1);
		label_1.setBackground(Color.BLUE);
		label_1.setForeground(new Color(0, 0, 153));
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		txtCedula = new JTextField();
		txtCedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c=ke.getKeyChar(); 
                if(Character.isLetter(c)) { 
	              getToolkit().beep();              
	              ke.consume();		               
	              JOptionPane.showMessageDialog(null, "Solo se admite Números!"); 
	             
	              } 
				
				 if (txtCedula.getText().length()== limiteCl){
	                	JOptionPane.showMessageDialog(null, "Solo se admite (10)digitos!");
	                	txtCedula.setText("");
	                	ke.consume();
	                				}
			}
		});
		txtCedula.setBounds(109, 41, 118, 26);
		panel_2.add(txtCedula);
		txtCedula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				validacion_cedula va = new validacion_cedula();
				if(va.validadorDeCedula(txtCedula.getText().toString()) ==true)
				{
					//JOptionPane.showMessageDialog(null, "Cedula ingresada correctamente!");
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "La Cédula ingresada es incorrecta!");
					txtCedula.setText("");
				}
			}
		});
		txtCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtCedula.setColumns(10);
		
		JLabel label = new JLabel("Nombre:");
		label.setBounds(285, 35, 103, 34);
		panel_2.add(label);
		label.setBackground(Color.BLUE);
		label.setForeground(new Color(0, 0, 153));
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(364, 41, 118, 26);
		panel_2.add(txtNombre);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				String sl=String.valueOf(evt.getKeyChar());
				if (!(sl.matches("[a-zA-Z]"))){
					evt.consume();
					getToolkit().beep();
                                JOptionPane.showMessageDialog(null, "Solo puede ingresar Letras!");
				}
			}
		});
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(30, 80, 79, 34);
		panel_2.add(lblApellido);
		lblApellido.setBackground(Color.BLUE);
		lblApellido.setForeground(new Color(0, 0, 153));
		lblApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		txtApellido = new JTextField();
		txtApellido.setBounds(109, 86, 118, 26);
		panel_2.add(txtApellido);
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				String sl=String.valueOf(evt.getKeyChar());
				if (!(sl.matches("[a-zA-Z]"))){
					evt.consume();
					getToolkit().beep();
                                JOptionPane.showMessageDialog(null, "Solo puede ingresar Letras!");
				}
			}
		});
		txtApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtApellido.setColumns(10);
		
		JLabel label_9 = new JLabel("Genero:");
		label_9.setBounds(30, 125, 66, 34);
		panel_2.add(label_9);
		label_9.setBackground(Color.BLUE);
		label_9.setForeground(new Color(0, 0, 153));
		label_9.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		cmbGenero = new JComboBox();
		cmbGenero.setBounds(109, 129, 118, 26);
		panel_2.add(cmbGenero);
		cmbGenero.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 12));
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMININO"}));
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(37, 170, 72, 34);
		panel_2.add(lblCelular);
		lblCelular.setBackground(Color.BLUE);
		lblCelular.setForeground(new Color(0, 0, 153));
		lblCelular.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		txtCelular = new JTextField();
		txtCelular.setBounds(109, 175, 118, 28);
		panel_2.add(txtCelular);
		txtCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c=ke.getKeyChar(); 
                if(Character.isLetter(c)) { 
	              getToolkit().beep();              
	              ke.consume();		               
	              JOptionPane.showMessageDialog(null, "Solo puede ingresar Números!"); 
	              } 
                
                if (txtCelular.getText().length()== limiteCl){
                	JOptionPane.showMessageDialog(null, "Solo se admite Números de Celular!");
                	txtCelular.setText("");
                	ke.consume();
                				}
			}
		});
		txtCelular.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtCelular.setColumns(10);
		
		JLabel label_8 = new JLabel("Correo:");
		label_8.setBounds(289, 170, 72, 34);
		panel_2.add(label_8);
		label_8.setBackground(Color.BLUE);
		label_8.setForeground(new Color(0, 0, 153));
		label_8.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(364, 175, 203, 28);
		panel_2.add(txtCorreo);
		txtCorreo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtCorreo.setColumns(10);
		
		JLabel label_7 = new JLabel("Telefono:");
		label_7.setBounds(274, 125, 103, 34);
		panel_2.add(label_7);
		label_7.setBackground(Color.BLUE);
		label_7.setForeground(new Color(0, 0, 153));
		label_7.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(364, 131, 118, 26);
		panel_2.add(txtTelefono);
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c=ke.getKeyChar(); 
                if(Character.isLetter(c)) { 
	              getToolkit().beep();              
	              ke.consume();		               
	              JOptionPane.showMessageDialog(null, "Solo puede ingresar Números!"); 
	              } 
                
                if (txtTelefono.getText().length()== limiteTl){
                	JOptionPane.showMessageDialog(null, "Solo se admite Números de Telèfono!");
                	txtTelefono.setText("");
                	ke.consume();
                				}
			}
		});
		txtTelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtTelefono.setColumns(10);
		
		JLabel label_5 = new JLabel("Direccion:");
		label_5.setBounds(274, 80, 103, 34);
		panel_2.add(label_5);
		label_5.setBackground(Color.BLUE);
		label_5.setForeground(new Color(0, 0, 153));
		label_5.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(363, 86, 203, 26);
		panel_2.add(txtDireccion);
		txtDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtDireccion.setColumns(10);
		
		JLabel lblDatosDelEmpleado = new JLabel("DATOS DEL EMPLEADO:");
		lblDatosDelEmpleado.setForeground(new Color(0, 0, 0));
		lblDatosDelEmpleado.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblDatosDelEmpleado.setBackground(Color.BLUE);
		lblDatosDelEmpleado.setBounds(21, 0, 206, 34);
		panel_2.add(lblDatosDelEmpleado);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\mecanico.png"));
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		label_3.setBackground(Color.BLUE);
		label_3.setBounds(246, 9, 40, 34);
		contentPane.add(label_3);
	}
	
	public void bcajas(){
		cmbGenero.setEnabled(false);
		cmbCargo.setEnabled(false);
		txtCedula.setEnabled(false);
		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtTelefono.setEnabled(false);
		txtCelular.setEnabled(false);
		txtCorreo.setEnabled(false);
		txtUsuario.setEnabled(false);
		txtClave.setEnabled(false);
	}
	public void acajas(){
		cmbGenero.setEnabled(true);
		cmbCargo.setEnabled(true);
		txtCedula.setEnabled(true);
		txtNombre.setEnabled(true);
		txtApellido.setEnabled(true);
		txtDireccion.setEnabled(true);
		txtTelefono.setEnabled(true);
		txtCelular.setEnabled(true);
		txtCorreo.setEnabled(true);
		txtUsuario.setEnabled(true);
		txtClave.setEnabled(true);
	}
	public void lcajas(){
		txtCedula.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCelular.setText("");
		txtCorreo.setText("");
        txtUsuario.setText("");
		txtClave.setText("");
		
	}
	public void bbotones(){
		btnAgregar.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnCancelar.setEnabled(false);
	}
}
