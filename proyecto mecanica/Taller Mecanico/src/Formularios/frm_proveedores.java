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

import Clases.cls_autos;
import Clases.cls_empleados;
import Clases.cls_proveedores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class frm_proveedores extends JFrame {

	private int bandera;
	
	private JPanel contentPane;
	private JTextField txtRuc;
	private JTextField txtNombrePr;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCelular;
	private JTextField txtCorreo;
	private JTextField txtN;
	private JTable tabla1;
	private JTextField txtIDpr;
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private JButton button;
	private JLabel label_1;
	
	  private int limiteTl  = 7;
	  private int limiteCl  = 10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_proveedores frame = new frm_proveedores();
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
	public frm_proveedores() {
		this.setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\coche.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cls_proveedores pr = new cls_proveedores();
                String[] cabecera={"Ruc","Empresa","Direccion","Telèfono","Celular","Correo"};
				Object datos[][]=pr.consultar(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );
				
				txtIDpr.setVisible(false);
				
				bcajas();
				bbotones();
				btnAgregar.setEnabled(true);
				bandera=0;
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 621);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new LineBorder(SystemColor.textHighlight, 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProveedores = new JLabel("PROVEEDORES");
		lblProveedores.setForeground(Color.RED);
		lblProveedores.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblProveedores.setBackground(Color.BLUE);
		lblProveedores.setBounds(341, 11, 169, 34);
		contentPane.add(lblProveedores);
		
		btnAgregar = new JButton("Agregar");
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
		btnAgregar.setBounds(182, 55, 133, 39);
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
		btnActualizar.setBounds(323, 55, 149, 39);
		contentPane.add(btnActualizar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\disquete.png"));
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_proveedores pr = new cls_proveedores();
				
				pr.setRuc(txtRuc.getText());
				pr.setNombre(txtNombrePr.getText());
				pr.setDireccion(txtDireccion.getText());
				pr.setTelefono(txtTelefono.getText());
				pr.setCelular(txtCelular.getText());
				pr.setCorreo(txtCorreo.getText());
				pr.setCodigo(txtIDpr.getText());
			
				if(bandera==1){
					
					if(pr.insertar()==true){
					
					JOptionPane.showMessageDialog(null,"Registro Guardado");
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Error al Registrar");
				  }
				}
				
				if(bandera==2){
					if(pr.actualizar()==true){
						
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
		btnGuardar.setBounds(480, 55, 134, 39);
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
		btnCancelar.setBounds(258, 105, 133, 39);
		contentPane.add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\goma-de-borrar.png"));
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_proveedores cls = new cls_proveedores();
				cls.setCodigo(txtIDpr.getText());
				if(cls.Eliminar()) {
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "Error al Eliminar");
				}
			}
		});
		btnEliminar.setForeground(SystemColor.textHighlight);
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnEliminar.setBounds(401, 105, 134, 39);
		contentPane.add(btnEliminar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		panel.setBackground(SystemColor.control);
		panel.setBounds(25, 176, 778, 152);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCedularuc = new JLabel("Cedula-Ruc:");
		lblCedularuc.setBounds(24, 33, 104, 34);
		panel.add(lblCedularuc);
		lblCedularuc.setForeground(new Color(0, 0, 153));
		lblCedularuc.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblCedularuc.setBackground(Color.BLUE);
		
		txtRuc = new JTextField();
		txtRuc.setBounds(128, 39, 160, 26);
		panel.add(txtRuc);
		txtRuc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c=ke.getKeyChar(); 
                if(Character.isLetter(c)) { 
	              getToolkit().beep();              
	              ke.consume();		               
	              JOptionPane.showMessageDialog(null, "Solo puede ingresar Números!"); 
	              } 
			}
		});
		txtRuc.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtRuc.setColumns(10);
		
		JLabel lblNombreProveedor = new JLabel("Nombre Proveedor:");
		lblNombreProveedor.setBounds(320, 33, 196, 34);
		panel.add(lblNombreProveedor);
		lblNombreProveedor.setForeground(new Color(0, 0, 153));
		lblNombreProveedor.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNombreProveedor.setBackground(Color.BLUE);
		
		txtNombrePr = new JTextField();
		txtNombrePr.setBounds(488, 39, 242, 26);
		panel.add(txtNombrePr);
		txtNombrePr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
			}
		});
		txtNombrePr.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtNombrePr.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setBounds(34, 72, 103, 34);
		panel.add(lblDireccin);
		lblDireccin.setForeground(new Color(0, 0, 153));
		lblDireccin.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblDireccin.setBackground(Color.BLUE);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(128, 78, 334, 26);
		panel.add(txtDireccion);
		txtDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtDireccion.setColumns(10);
		
		JLabel label_5 = new JLabel("Telefono:");
		label_5.setBounds(477, 72, 80, 34);
		panel.add(label_5);
		label_5.setForeground(new Color(0, 0, 153));
		label_5.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_5.setBackground(Color.BLUE);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(568, 78, 141, 26);
		panel.add(txtTelefono);
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
		
		JLabel label_6 = new JLabel("Celular:");
		label_6.setBounds(58, 107, 72, 34);
		panel.add(label_6);
		label_6.setForeground(new Color(0, 0, 153));
		label_6.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_6.setBackground(Color.BLUE);
		
		txtCelular = new JTextField();
		txtCelular.setBounds(128, 112, 131, 28);
		panel.add(txtCelular);
		txtCelular.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c=ke.getKeyChar(); 
                if(Character.isLetter(c)) { 
	              getToolkit().beep();              
	              ke.consume();		               
	              JOptionPane.showMessageDialog(null, "Solo se admite Números!"); 
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
		
		JLabel label_7 = new JLabel("Correo:");
		label_7.setBounds(281, 107, 72, 34);
		panel.add(label_7);
		label_7.setForeground(new Color(0, 0, 153));
		label_7.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_7.setBackground(Color.BLUE);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(352, 112, 236, 28);
		panel.add(txtCorreo);
		txtCorreo.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtCorreo.setColumns(10);
		
		JLabel lblDatosProveedor = new JLabel("DATOS PROVEEDOR:");
		lblDatosProveedor.setBounds(10, 0, 157, 34);
		panel.add(lblDatosProveedor);
		lblDatosProveedor.setForeground(SystemColor.desktop);
		lblDatosProveedor.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblDatosProveedor.setBackground(Color.BLUE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 413, 794, 158);
		contentPane.add(scrollPane);
		
		tabla1 = new JTable();
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_proveedores pr = new cls_proveedores();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla1.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));
				datos=pr.datoPr(codigo);
			
				txtIDpr.setText(datos[0]);
				txtRuc.setText(datos[1]);
				txtNombrePr.setText(datos[2]);
				txtDireccion.setText(datos[3]);
				txtTelefono.setText(datos[4]);
				txtCelular.setText(datos[5]);
				txtCorreo.setText(datos[6]);
				
				bbotones();
				btnActualizar.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnEliminar.setEnabled(true);
				
			}
		});
		scrollPane.setViewportView(tabla1);
		
		JLabel label = new JLabel("Nombre Proveedor:");
		label.setForeground(new Color(0, 0, 153));
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label.setBackground(new Color(0, 0, 153));
		label.setBounds(26, 363, 196, 34);
		contentPane.add(label);
		
		txtN = new JTextField();
		txtN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				cls_proveedores pr = new cls_proveedores();
                String[] cabecera={"Ruc","Empresa","Direccion","Telèfono","Celular","Correo"};
				
				Object datos[][]=pr.consultar(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );	
			}
		});
		txtN.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtN.setColumns(10);
		txtN.setBounds(194, 369, 242, 26);
		contentPane.add(txtN);
		
		txtIDpr = new JTextField();
		txtIDpr.setEnabled(false);
		txtIDpr.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtIDpr.setColumns(10);
		txtIDpr.setBounds(31, 113, 53, 26);
		contentPane.add(txtIDpr);
		
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
		button.setBounds(751, 22, 64, 64);
		contentPane.add(button);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\recursos-humanos.png"));
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		label_1.setBackground(Color.BLUE);
		label_1.setBounds(305, 11, 39, 34);
		contentPane.add(label_1);
	}
	public void bcajas(){
		txtRuc.setEnabled(false);
		txtNombrePr.setEnabled(false);
		txtDireccion.setEnabled(false);
		txtTelefono.setEnabled(false);
		txtCelular.setEnabled(false);
		txtCorreo.setEnabled(false);
		
	}
	public void acajas(){
		txtRuc.setEnabled(true);
		txtNombrePr.setEnabled(true);
		txtDireccion.setEnabled(true);
		txtTelefono.setEnabled(true);
		txtCelular.setEnabled(true);
		txtCorreo.setEnabled(true);
		
	}
	public void lcajas(){
		txtRuc.setText("");
		txtNombrePr.setText("");
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
