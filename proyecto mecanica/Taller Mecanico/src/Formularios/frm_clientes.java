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

import javax.swing.JButton;
import javax.swing.JTextField;

import Clases.cls_clientes;
import Clases.cls_empleados;
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
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class frm_clientes extends JFrame {

	private int bandera;
	private JPanel contentPane;
	private JTextField txtcedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtCelular;
	private JTextField txtTelefono;
	private JComboBox cmbGenero;
	private JTable tabla1;
	private JTextField txtN;
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JTextField txtID;
	private JButton btnRegresar;
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
					frm_clientes frame = new frm_clientes();
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
	public frm_clientes() {
		this.setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\coche.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cls_clientes emp = new cls_clientes();
                String[] cabecera={"ID","Cedula","Nombre","Apellido","Dirección","Genero","Teléfono","Celular","Correo"};
				Object datos[][]=emp.consultarcl(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );	
				
				txtID.setVisible(false);
				
				bcajas();
				bbotones();
				btnAgregar.setEnabled(true);
				bandera=0;
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 686, 649);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new LineBorder(SystemColor.textHighlight, 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientes = new JLabel("CLIENTES");
		lblClientes.setForeground(Color.RED);
		lblClientes.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblClientes.setBackground(Color.BLUE);
		lblClientes.setBounds(293, 9, 109, 34);
		contentPane.add(lblClientes);
		
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
		btnAgregar.setBounds(106, 54, 134, 39);
		contentPane.add(btnAgregar);
		
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
			}
		});
		btnActualizar.setForeground(SystemColor.textHighlight);
		btnActualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnActualizar.setBounds(250, 54, 152, 39);
		contentPane.add(btnActualizar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\disquete.png"));
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_clientes cl = new cls_clientes();
				
				
				cl.setCedula(txtcedula.getText());
				cl.setNombre(txtNombre.getText());
				cl.setApellido(txtApellido.getText());
				cl.setDireccion(txtDireccion.getText());
				cl.setGenero(cmbGenero.getSelectedItem().toString());
				cl.setTelefono(txtTelefono.getText());
				cl.setCelular(txtCelular.getText());
				cl.setCorreo(txtCorreo.getText());
				
				

				if(bandera==1){
					
					if(cl.insertar()==true){
					
					JOptionPane.showMessageDialog(null,"Registro Guardado");
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Error al Registrar");
				  }
				}
				
				if(bandera==2){
					cl.setCogido(Integer.parseInt(txtID.getText().toString()));
					if(cl.actualizar()==true){
						
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
		btnGuardar.setBounds(412, 54, 134, 39);
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
		btnCancelar.setBounds(192, 100, 134, 39);
		contentPane.add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\goma-de-borrar.png"));
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			cls_clientes cli= new cls_clientes();
			
			cli.setCogido(Integer.parseInt(txtID.getText().toString()));
			if(cli.Eliminar()) {
				JOptionPane.showMessageDialog(null, "Registro Eliminado");
			}else {
				JOptionPane.showMessageDialog(null, "Error al Eliminar");
			}
				
			}
		});
		btnEliminar.setForeground(SystemColor.textHighlight);
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnEliminar.setBounds(336, 100, 134, 39);
		contentPane.add(btnEliminar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(Color.BLUE));
		panel.setBackground(SystemColor.menu);
		panel.setBounds(33, 165, 615, 225);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_6 = new JLabel("Correo:");
		label_6.setBounds(167, 170, 71, 34);
		panel.add(label_6);
		label_6.setForeground(new Color(0, 0, 139));
		label_6.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_6.setBackground(Color.BLUE);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(233, 175, 182, 28);
		panel.add(txtCorreo);
		txtCorreo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtCorreo.setColumns(10);
		
		JLabel label_1 = new JLabel("Cedula:");
		label_1.setBounds(10, 37, 71, 34);
		panel.add(label_1);
		label_1.setForeground(new Color(0, 0, 139));
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_1.setBackground(Color.BLUE);
		
		txtcedula = new JTextField();
		txtcedula.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				 char c=ke.getKeyChar(); 
                 if(Character.isLetter(c)) { 
	              getToolkit().beep();              
	              ke.consume();		               
	              JOptionPane.showMessageDialog(null, "Solo puede ingresar Números!"); 
	              } 
                 
                 if (txtcedula.getText().length()== limiteCl){
	                	JOptionPane.showMessageDialog(null, "Solo se admite (10)digitos!");
	                	txtcedula.setText("");
	                	ke.consume();
	                				}
				
			}
		});
		txtcedula.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				validacion_cedula va = new validacion_cedula();
				if(va.validadorDeCedula(txtcedula.getText().toString()) ==true)
				{
					//JOptionPane.showMessageDialog(null, "Cedula ingresada correctamente!");
				}
				else
				{
					
					JOptionPane.showMessageDialog(null, "La Cédula ingresada es incorrecta!");
					txtcedula.setText("");
				}
			}
		});
		txtcedula.setBounds(76, 43, 118, 26);
		panel.add(txtcedula);
		txtcedula.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtcedula.setColumns(10);
		
		JLabel label_2 = new JLabel("Nombre:");
		label_2.setBounds(204, 37, 71, 34);
		panel.add(label_2);
		label_2.setForeground(new Color(0, 0, 139));
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_2.setBackground(Color.BLUE);
		
		txtNombre = new JTextField();
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
		txtNombre.setBounds(277, 43, 118, 26);
		panel.add(txtNombre);
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(405, 37, 94, 34);
		panel.add(lblApellido);
		lblApellido.setForeground(new Color(0, 0, 139));
		lblApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblApellido.setBackground(Color.BLUE);
		
		txtApellido = new JTextField();
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
		txtApellido.setBounds(482, 43, 118, 26);
		panel.add(txtApellido);
		txtApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtApellido.setColumns(10);
		
		JLabel label_5 = new JLabel("Direccion:");
		label_5.setBounds(10, 82, 103, 34);
		panel.add(label_5);
		label_5.setForeground(new Color(0, 0, 139));
		label_5.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_5.setBackground(Color.BLUE);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(96, 88, 191, 26);
		panel.add(txtDireccion);
		txtDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
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
		txtTelefono.setBounds(96, 133, 155, 26);
		panel.add(txtTelefono);
		txtTelefono.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtTelefono.setColumns(10);
		
		txtCelular = new JTextField();
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
		txtCelular.setBounds(387, 132, 158, 28);
		panel.add(txtCelular);
		txtCelular.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtCelular.setColumns(10);
		
		JLabel label_4 = new JLabel("Genero:");
		label_4.setBounds(317, 82, 76, 34);
		panel.add(label_4);
		label_4.setForeground(new Color(0, 0, 139));
		label_4.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_4.setBackground(Color.BLUE);
		
		JLabel label_7 = new JLabel("Celular:");
		label_7.setBounds(311, 127, 74, 34);
		panel.add(label_7);
		label_7.setForeground(new Color(0, 0, 139));
		label_7.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_7.setBackground(Color.BLUE);
		
		JLabel label_8 = new JLabel("Telefono:");
		label_8.setBounds(10, 127, 80, 34);
		panel.add(label_8);
		label_8.setForeground(new Color(0, 0, 139));
		label_8.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_8.setBackground(Color.BLUE);
		
		JLabel lblDatosDelCliente = new JLabel("DATOS DEL CLIENTE:");
		lblDatosDelCliente.setForeground(SystemColor.desktop);
		lblDatosDelCliente.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblDatosDelCliente.setBackground(Color.BLUE);
		lblDatosDelCliente.setBounds(32, 0, 176, 34);
		panel.add(lblDatosDelCliente);
		
		cmbGenero = new JComboBox();
		cmbGenero.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		cmbGenero.setModel(new DefaultComboBoxModel(new String[] {"MASCULINO", "FEMENINO"}));
		cmbGenero.setBounds(387, 84, 155, 28);
		panel.add(cmbGenero);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 446, 666, 152);
		contentPane.add(scrollPane);
		
		tabla1 = new JTable();
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cls_clientes cl = new cls_clientes();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla1.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));
				datos=cl.datocl(codigo);
			
				txtID.setText(datos[0]);
				txtcedula.setText(datos[1]);
				txtNombre.setText(datos[2]);
				txtApellido.setText(datos[3]);
				txtDireccion.setText(datos[4]);
				cmbGenero.setSelectedItem(datos[5]);
				txtTelefono.setText(datos[6]);
				txtCelular.setText(datos[7]);
				txtCorreo.setText(datos[8]);
				
				
				bbotones();
				btnActualizar.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnEliminar.setEnabled(true);
				
			}
		});
		scrollPane.setViewportView(tabla1);
		
		JLabel lblBuscarPorNombre = new JLabel("Buscar por Nombre:");
		lblBuscarPorNombre.setForeground(new Color(0, 0, 139));
		lblBuscarPorNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblBuscarPorNombre.setBackground(Color.BLUE);
		lblBuscarPorNombre.setBounds(20, 398, 169, 45);
		contentPane.add(lblBuscarPorNombre);
		
		txtN = new JTextField();
		txtN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				cls_clientes emp = new cls_clientes();
                String[] cabecera={"ID","Cedula","Nombre","Apellido","Dirección","Genero","Teléfono","Celular","Correo"};
				Object datos[][]=emp.consultarcl(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );	
				
				
			}
		});
		txtN.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtN.setColumns(10);
		txtN.setBounds(186, 409, 169, 26);
		contentPane.add(txtN);
		
		txtID = new JTextField();
		txtID.setEnabled(false);
		txtID.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtID.setColumns(10);
		txtID.setBounds(21, 111, 53, 26);
		contentPane.add(txtID);
		
		btnRegresar = new JButton("");
		btnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
		});
		btnRegresar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\flecha-hacia-la-izquierda (1).png"));
		btnRegresar.setBounds(599, 27, 65, 66);
		contentPane.add(btnRegresar);
		
		label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\usuario-especialista.png"));
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		label_3.setBackground(Color.BLUE);
		label_3.setBounds(257, 9, 43, 34);
		contentPane.add(label_3);
		
		botontransparente();
	}
	

		public void botontransparente(){
			btnRegresar.setOpaque(false);
			btnRegresar.setContentAreaFilled(false);
			btnRegresar.setBorderPainted(false);
		}
	
	public void bcajas(){
		cmbGenero.setEnabled(false);
		txtcedula.setEnabled(false);
		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtTelefono.setEnabled(false);
		txtCelular.setEnabled(false);
		txtCorreo.setEnabled(false);
		
	}
	public void acajas(){
		cmbGenero.setEnabled(true);
		txtcedula.setEnabled(true);
		txtNombre.setEnabled(true);
		txtApellido.setEnabled(true);
		txtDireccion.setEnabled(true);
		txtTelefono.setEnabled(true);
		txtCelular.setEnabled(true);
		txtCorreo.setEnabled(true);
		
	}
	public void lcajas(){
		txtcedula.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCelular.setText("");
		txtCorreo.setText("");
	}
	public void bbotones(){
		btnAgregar.setEnabled(false);
		btnGuardar.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnCancelar.setEnabled(false);
	}
	
	

	

}
