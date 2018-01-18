package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import Clases.cls_autos;
import Clases.cls_det_auto;
import Clases.cls_det_empleado;
import Clases.cls_mantenimiento;
import Clases.cls_revision;
import Clases.cls_servicio;
import hilos.HiloReloj;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class frm_mantenimiento extends JFrame {

	
	DefaultTableModel m  = new DefaultTableModel() ;
	DefaultTableModel m2  = new DefaultTableModel() ;

	public JPanel contentPane;
	private JTextField txtN1;
	private JTable tabla;
	private JTextField txtPlaca;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtAnio;
	private JTextField txtColor;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtFecha;
	private JTextField txtNombreServ;
    private String id ;
    private int cantidad=0;
    
	
	public static  JLabel lblFecha;
	private JLabel Fecha1;
	private JTextField txtIDauto;
	private JTextField txtN3;
	private JTable tablaMecanico;
	private JPanel panelMecanico;
	private JTextField txtNombreMecanico;
	private JTextField txtIDmecanico;
	private JTextField txtIDman2;
	private JTextField txtN4;
	private JTextField txtIDservicio;
	private JTable tablaServicio;
	private JPanel panel_Servicio;
	private JTextField txtIDman3;
	private JTable tablaX;
	private JScrollPane panel_servicios;
	private JScrollPane scrollPane_1;
	private JTable tablaX2;
	private JButton btnGuardarTodo;

    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_mantenimiento frame = new frm_mantenimiento();
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
	public frm_mantenimiento() {
		this.setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\coche.png"));
		
	this.setLocationRelativeTo(null);
		
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent arg0) {
			}
			public void windowLostFocus(WindowEvent arg0) {
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				
				panelMecanico.setVisible(false);
				panel_Servicio.setVisible(false);
				txtIDauto.setVisible(false);
				
				txtFecha.setText(fechaActual());
				
				cls_mantenimiento man = new cls_mantenimiento();
				
                String[] cabecera={"Placa","Marca","Modelo","Color","Año","Cedula","Nombre","Apellido","Dirección"};
				Object datos[][]=man.consultar1(txtN1.getText());
				tabla.setModel(new DefaultTableModel(datos,cabecera) );	

                
				
				  String[] cabecera3={"ID","Cedula","Nombre","Apellido","Cargo"};
					Object datos3[][]=man.consultarMEcanico(txtN3.getText());
					tablaMecanico.setModel(new DefaultTableModel(datos3,cabecera3) );	
					
					String[] cabecera4={"ID","Servicio","Precio"};
					Object datos4[][]=man.consultarServ(txtN4.getText());
					tablaServicio.setModel(new DefaultTableModel(datos4,cabecera4) );	
					
					/*
					 String[] cabecera5={"ID","Repuesto","Precio","Stock"};
						Object datos5[][]=man.consultaRep(txtN5.getText());
						tablaRepuesto.setModel(new DefaultTableModel(datos5,cabecera5) );	
						
						String[] cabecera6={"ID","Servicio ","Fecha"};
						Object datos6[][]=man.consultaRevi(txtNB.getText());
						tablaRevision.setModel(new DefaultTableModel(datos6,cabecera6) );	*/
						
				
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////						
						String[] cabeceras={"ID","Servicio"};
						Object datoss[][]=null;
						tablaX.setModel(new DefaultTableModel(datoss,cabeceras) );	
						
						String[] cabecerasx2={"ID","Cedula","Nombre","Apellido","Cargo"};
						Object datossx2[][]=null;
						tablaX2.setModel(new DefaultTableModel(datoss,cabecerasx2) );	
						
						/*
						String[] cabecerasx3={"ID","Repuesto","Precio","Stock"};
						Object datossx3[][]=null;
						tablaX3.setModel(new DefaultTableModel(datoss,cabecerasx3) );	
                         	*/
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1317, 842);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(SystemColor.textHighlight, 3));
		contentPane.setBackground(SystemColor.info);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelMecanico = new JPanel();
		panelMecanico.setBounds(169, 158, 475, 354);
		contentPane.add(panelMecanico);
		panelMecanico.setLayout(null);
		panelMecanico.setBackground(SystemColor.textHighlight);
		
		JLabel lblMecanico = new JLabel("Mecanico");
		lblMecanico.setForeground(Color.WHITE);
		lblMecanico.setFont(new Font("Comic Sans MS", Font.BOLD, 31));
		lblMecanico.setBackground(Color.BLUE);
		lblMecanico.setBounds(164, 11, 142, 34);
		panelMecanico.add(lblMecanico);
		
		JButton AgregarMecanico = new JButton("Agregar");
		AgregarMecanico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				int fsel = tablaMecanico.getSelectedRow();
				try {
					String id, cedula, nombre, apellido, cargo;
					
					if(fsel==-1) {
						
						JOptionPane.showMessageDialog(null, "debe selecionar un servicio!");
					}else {
						m = (DefaultTableModel) tablaMecanico.getModel();
						id = tablaMecanico.getValueAt(fsel, 0).toString();
						cedula = tablaMecanico.getValueAt(fsel, 1).toString();
						nombre = tablaMecanico.getValueAt(fsel, 2).toString();
						apellido = tablaMecanico.getValueAt(fsel, 3).toString();
						cargo = tablaMecanico.getValueAt(fsel, 4).toString();
						
						m2 = (DefaultTableModel) tablaX2.getModel();
						m2.addRow(new Object [] {id, cedula, nombre, apellido, cargo});
						tablaX2.setModel(m2);
					
					}
					
			
					
				} catch (Exception e2) {
					
				}
				
			}
		});
		AgregarMecanico.setForeground(new Color(0, 0, 205));
		AgregarMecanico.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		AgregarMecanico.setBounds(119, 320, 103, 23);
		panelMecanico.add(AgregarMecanico);
		
		JButton btnCerrar2 = new JButton("Cerrar");
		btnCerrar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMecanico.setVisible(false);
			}
		});
		btnCerrar2.setForeground(new Color(0, 0, 205));
		btnCerrar2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnCerrar2.setBounds(253, 320, 103, 23);
		panelMecanico.add(btnCerrar2);
		
		JLabel label_8 = new JLabel("Servicio:");
		label_8.setForeground(new Color(0, 0, 139));
		label_8.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_8.setBackground(Color.BLUE);
		label_8.setBounds(-185, 48, 91, 34);
		panelMecanico.add(label_8);
		
		JLabel lblBuscar = new JLabel("Buscar:");
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblBuscar.setBackground(Color.WHITE);
		lblBuscar.setBounds(25, 71, 103, 34);
		panelMecanico.add(lblBuscar);
		
		txtN3 = new JTextField();
		txtN3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				cls_mantenimiento man = new cls_mantenimiento();
				 String[] cabecera3={"ID","Cedula","Nombre","Apellido","Cargo"};
					Object datos3[][]=man.consultarMEcanico(txtN3.getText());
					tablaMecanico.setModel(new DefaultTableModel(datos3,cabecera3) );	
			}
		});
		txtN3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtN3.setColumns(10);
		txtN3.setBounds(90, 77, 166, 26);
		panelMecanico.add(txtN3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(35, 116, 407, 133);
		panelMecanico.add(scrollPane_4);
		
		tablaMecanico = new JTable();
		tablaMecanico.setFont(new Font("Tahoma", Font.BOLD, 15));
		tablaMecanico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_mantenimiento man = new cls_mantenimiento();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tablaMecanico.getModel();
				String codigo=String.valueOf(tm.getValueAt(tablaMecanico.getSelectedRow(),0));
				datos=man.datoMecanico(codigo);
			
				txtIDmecanico.setText(datos[0]);
				txtNombreMecanico.setText(datos[1]);
				
			}
		});
		scrollPane_4.setViewportView(tablaMecanico);
		
		txtNombreMecanico = new JTextField();
		txtNombreMecanico.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtNombreMecanico.setColumns(10);
		txtNombreMecanico.setBounds(72, 268, 166, 26);
		panelMecanico.add(txtNombreMecanico);
		
		txtIDmecanico = new JTextField();
		txtIDmecanico.setEnabled(false);
		txtIDmecanico.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtIDmecanico.setColumns(10);
		txtIDmecanico.setBounds(341, 11, 57, 26);
		panelMecanico.add(txtIDmecanico);
		
		JLabel label_6 = new JLabel("Nombre:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_6.setBackground(Color.BLUE);
		label_6.setBounds(10, 260, 62, 34);
		panelMecanico.add(label_6);
		
		txtIDman2 = new JTextField();
		txtIDman2.setEnabled(false);
		txtIDman2.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtIDman2.setColumns(10);
		txtIDman2.setBounds(408, 11, 57, 26);
		panelMecanico.add(txtIDman2);
		
		panel_Servicio = new JPanel();
		panel_Servicio.setBounds(654, 158, 475, 354);
		contentPane.add(panel_Servicio);
		panel_Servicio.setLayout(null);
		panel_Servicio.setBackground(SystemColor.textHighlight);
		
		JLabel Servicio = new JLabel("Servicio");
		Servicio.setForeground(Color.WHITE);
		Servicio.setFont(new Font("Comic Sans MS", Font.BOLD, 31));
		Servicio.setBackground(Color.BLUE);
		Servicio.setBounds(164, 11, 142, 34);
		panel_Servicio.add(Servicio);
		
		JButton btnGuardarServ = new JButton("Agregar");
		btnGuardarServ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnGuardarServ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fsel = tablaServicio.getSelectedRow();
				try {
					String idServ, nombre;
					
					if(fsel==-1) {
						
						JOptionPane.showMessageDialog(null, "debe selecionar un servicio!");
					}else {
						m = (DefaultTableModel) tablaServicio.getModel();
						idServ = tablaServicio.getValueAt(fsel, 0).toString();
						nombre = tablaServicio.getValueAt(fsel, 1).toString();
						
						m2 = (DefaultTableModel) tablaX.getModel();
						m2.addRow(new Object [] {idServ, nombre});
						tablaX.setModel(m2);
					
					}
					
			
					
				} catch (Exception e2) {
					
				}
				

			}
		});
		btnGuardarServ.setForeground(new Color(0, 0, 205));
		btnGuardarServ.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnGuardarServ.setBounds(125, 320, 103, 23);
		panel_Servicio.add(btnGuardarServ);
		
		JButton btnCerrar3 = new JButton("Cerrar");
		btnCerrar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_Servicio.setVisible(false);
			}
		});
		btnCerrar3.setForeground(new Color(0, 0, 205));
		btnCerrar3.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnCerrar3.setBounds(260, 320, 103, 23);
		panel_Servicio.add(btnCerrar3);
		
		JLabel label_9 = new JLabel("Servicio:");
		label_9.setForeground(new Color(0, 0, 139));
		label_9.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_9.setBackground(Color.BLUE);
		label_9.setBounds(-185, 48, 91, 34);
		panel_Servicio.add(label_9);
		
		JLabel label_10 = new JLabel("Buscar:");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		label_10.setBackground(Color.WHITE);
		label_10.setBounds(25, 71, 103, 34);
		panel_Servicio.add(label_10);
		
		txtN4 = new JTextField();
		txtN4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				cls_mantenimiento man = new cls_mantenimiento();
				String[] cabecera4={"ID","Servicio","Detalle"};
				Object datos4[][]=man.consultarServ(txtN4.getText());
				tablaServicio.setModel(new DefaultTableModel(datos4,cabecera4) );
			}
		});
		txtN4.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtN4.setColumns(10);
		txtN4.setBounds(90, 77, 166, 26);
		panel_Servicio.add(txtN4);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(35, 116, 407, 159);
		panel_Servicio.add(scrollPane_1);
		
		tablaServicio = new JTable();
		tablaServicio.setFont(new Font("Tahoma", Font.BOLD, 15));
		tablaServicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*cls_mantenimiento man = new cls_mantenimiento();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tablaServicio.getModel();
				String codigo=String.valueOf(tm.getValueAt(tablaServicio.getSelectedRow(),0));
				datos=man.datoservicio(codigo);
				//txtIDservicio.setText(datos[0]);
				//txtDetServ.setText(datos[1]);
				//txtNservivio.setText(datos[2]);
			
				*/
			}
		});
		scrollPane_1.setViewportView(tablaServicio);
		
		txtIDservicio = new JTextField();
		txtIDservicio.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtIDservicio.setEnabled(false);
		txtIDservicio.setColumns(10);
		txtIDservicio.setBounds(346, 11, 57, 26);
		panel_Servicio.add(txtIDservicio);
		
		txtIDman3 = new JTextField();
		txtIDman3.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtIDman3.setEnabled(false);
		txtIDman3.setColumns(10);
		txtIDman3.setBounds(408, 11, 57, 26);
		panel_Servicio.add(txtIDman3);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setLayout(null);
		panel.setBackground(new Color(255, 228, 181));
		panel.setBounds(35, 176, 1228, 550);
		contentPane.add(panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(160, 56, 917, 91);
		panel.add(panel_2);
		
		JLabel label_5 = new JLabel("DATOS DEL VEHICULO:");
		label_5.setBounds(10, 1, 221, 34);
		panel_2.add(label_5);
		label_5.setForeground(new Color(0, 0, 153));
		label_5.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label_5.setBackground(SystemColor.text);
		
		JLabel label = new JLabel("Placa:");
		label.setBounds(61, 40, 62, 34);
		panel_2.add(label);
		label.setForeground(new Color(0, 0, 139));
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label.setBackground(Color.BLUE);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(107, 46, 103, 23);
		panel_2.add(txtPlaca);
		txtPlaca.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtPlaca.setColumns(10);
		
		JLabel label_1 = new JLabel("Marca:");
		label_1.setBounds(220, 40, 62, 34);
		panel_2.add(label_1);
		label_1.setForeground(new Color(0, 0, 139));
		label_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_1.setBackground(Color.BLUE);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(269, 45, 110, 23);
		panel_2.add(txtMarca);
		txtMarca.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtMarca.setColumns(10);
		
		JLabel label_3 = new JLabel("Color:");
		label_3.setBounds(389, 40, 48, 34);
		panel_2.add(label_3);
		label_3.setForeground(new Color(0, 0, 139));
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_3.setBackground(Color.BLUE);
		
		txtColor = new JTextField();
		txtColor.setBounds(435, 45, 115, 23);
		panel_2.add(txtColor);
		txtColor.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtColor.setColumns(10);
		
		JLabel label_4 = new JLabel("A\u00F1o:");
		label_4.setBounds(560, 40, 80, 34);
		panel_2.add(label_4);
		label_4.setForeground(new Color(0, 0, 139));
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_4.setBackground(Color.BLUE);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(597, 45, 76, 23);
		panel_2.add(txtAnio);
		txtAnio.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtAnio.setColumns(10);
		
		JLabel label_2 = new JLabel("Modelo:");
		label_2.setBounds(689, 40, 55, 34);
		panel_2.add(label_2);
		label_2.setForeground(new Color(0, 0, 139));
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label_2.setBackground(Color.BLUE);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(747, 45, 138, 23);
		panel_2.add(txtModelo);
		txtModelo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtModelo.setColumns(10);
		
		JLabel lblFecha_1 = new JLabel("Fecha:");
		lblFecha_1.setBounds(742, 11, 62, 34);
		panel.add(lblFecha_1);
		lblFecha_1.setForeground(new Color(0, 0, 139));
		lblFecha_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblFecha_1.setBackground(Color.BLUE);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(796, 19, 153, 23);
		panel.add(txtFecha);
		txtFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtFecha.setColumns(10);
		
		JLabel lblServicio_1 = new JLabel("Mantenimiento:");
		lblServicio_1.setForeground(new Color(0, 0, 139));
		lblServicio_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		lblServicio_1.setBackground(Color.BLUE);
		lblServicio_1.setBounds(10, 17, 138, 23);
		panel.add(lblServicio_1);
		
		txtNombreServ = new JTextField();
		txtNombreServ.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtNombreServ.setColumns(10);
		txtNombreServ.setBounds(136, 11, 596, 34);
		panel.add(txtNombreServ);
		
		JLabel lblTipoDeServicio = new JLabel("Trabajos a Realizar");
		lblTipoDeServicio.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblTipoDeServicio.setBounds(668, 334, 176, 23);
		panel.add(lblTipoDeServicio);
		
		JLabel lblMecanicos = new JLabel("Mecanicos");
		lblMecanicos.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblMecanicos.setBounds(322, 334, 97, 23);
		panel.add(lblMecanicos);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(223, 360, 305, 78);
		panel.add(scrollPane_2);
		
		tablaX2 = new JTable();
		tablaX2.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane_2.setViewportView(tablaX2);
		
		txtIDauto = new JTextField();
		txtIDauto.setEnabled(false);
		txtIDauto.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		txtIDauto.setColumns(10);
		txtIDauto.setBounds(1009, 22, 40, 23);
		panel.add(txtIDauto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(160, 175, 917, 91);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDatosDelcliente = new JLabel("DATOS DELCLIENTE:");
		lblDatosDelcliente.setBounds(10, -4, 237, 34);
		panel_1.add(lblDatosDelcliente);
		lblDatosDelcliente.setForeground(new Color(0, 0, 153));
		lblDatosDelcliente.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblDatosDelcliente.setBackground(Color.BLUE);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(86, 41, 62, 34);
		panel_1.add(lblCedula);
		lblCedula.setForeground(new Color(0, 0, 139));
		lblCedula.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblCedula.setBackground(Color.BLUE);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(139, 46, 103, 23);
		panel_1.add(txtCedula);
		txtCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtCedula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(252, 41, 62, 34);
		panel_1.add(lblNombre);
		lblNombre.setForeground(new Color(0, 0, 139));
		lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNombre.setBackground(Color.BLUE);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(316, 46, 103, 23);
		panel_1.add(txtNombre);
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtNombre.setColumns(10);
		
		JLabel lblNombre_1 = new JLabel("Apellido:");
		lblNombre_1.setBounds(429, 41, 76, 34);
		panel_1.add(lblNombre_1);
		lblNombre_1.setForeground(new Color(0, 0, 139));
		lblNombre_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNombre_1.setBackground(Color.BLUE);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(493, 46, 103, 23);
		panel_1.add(txtApellido);
		txtApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtApellido.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(606, 41, 80, 34);
		panel_1.add(lblDireccion);
		lblDireccion.setForeground(new Color(0, 0, 139));
		lblDireccion.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblDireccion.setBackground(Color.BLUE);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(677, 46, 185, 23);
		panel_1.add(txtDireccion);
		txtDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtDireccion.setColumns(10);
		
		JButton btnAgregar2 = new JButton("Buscar");
		btnAgregar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				panel_Servicio.setVisible(true);
				
			}
		});
		btnAgregar2.setForeground(new Color(0, 0, 205));
		btnAgregar2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnAgregar2.setBounds(645, 450, 97, 23);
		panel.add(btnAgregar2);
		
		JButton btnAgregar1 = new JButton("Buscar");
		btnAgregar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelMecanico.setVisible(true);
			}
		});
		btnAgregar1.setForeground(new Color(0, 0, 205));
		btnAgregar1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnAgregar1.setBounds(269, 450, 97, 23);
		panel.add(btnAgregar1);
		
		panel_servicios = new JScrollPane();
		panel_servicios.setBounds(593, 360, 305, 77);
		panel.add(panel_servicios);
		
		tablaX = new JTable();
		tablaX.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_servicios.setViewportView(tablaX);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) tablaX.getModel();  
				dtm.removeRow(tablaX.getSelectedRow());
			}
		});
		btnEliminar.setForeground(Color.RED);
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnEliminar.setBounds(766, 450, 97, 23);
		panel.add(btnEliminar);
		
		JButton btnElimiar = new JButton("Elimiar");
		btnElimiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel dtm = (DefaultTableModel) tablaX2.getModel();  
				dtm.removeRow(tablaX2.getSelectedRow());
			
			}
		});
		btnElimiar.setForeground(Color.RED);
		btnElimiar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnElimiar.setBounds(388, 450, 97, 23);
		panel.add(btnElimiar);
		
		JLabel lblMantenimiento = new JLabel("MANTENIMIENTO");
		lblMantenimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblMantenimiento.setBounds(545, 0, 262, 55);
		contentPane.add(lblMantenimiento);
		
		JLabel lblPlaca = new JLabel("Buscar por Placa:");
		lblPlaca.setForeground(new Color(0, 0, 139));
		lblPlaca.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblPlaca.setBackground(Color.BLUE);
		lblPlaca.setBounds(35, 42, 142, 34);
		contentPane.add(lblPlaca);
		
		txtN1 = new JTextField();
		txtN1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				cls_mantenimiento man = new cls_mantenimiento();
                String[] cabecera={"Placa","Marca","Modelo","Color","Año","Cedula","Nombre","Apellido","Dirección"};
				Object datos[][]=man.consultar1(txtN1.getText());
				tabla.setModel(new DefaultTableModel(datos,cabecera) );	

			}
				
			
		});
		txtN1.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtN1.setColumns(10);
		txtN1.setBounds(177, 48, 114, 26);
		contentPane.add(txtN1);
		
		JScrollPane scrollPane_Auto = new JScrollPane();
		scrollPane_Auto.setBounds(35, 77, 1228, 88);
		contentPane.add(scrollPane_Auto);
		
		tabla = new JTable();
		tabla.setFont(new Font("Tahoma", Font.BOLD, 15));
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cls_mantenimiento man = new cls_mantenimiento();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla.getSelectedRow(),0));
				datos=man.datocarro(codigo);
			
				txtIDauto.setText(datos[0]);
				txtPlaca.setText(datos[1]);
				txtMarca.setText(datos[2]);
				txtModelo.setText(datos[3]);
				txtColor.setText(datos[4]);
				txtAnio.setText(datos[5]);
				
				txtCedula.setText(datos[6]);
				txtNombre.setText(datos[7]);
				txtApellido.setText(datos[8]);
				txtDireccion.setText(datos[9]);
			}
		});
		scrollPane_Auto.setViewportView(tabla);
		
		btnGuardarTodo = new JButton("Guardar");
		btnGuardarTodo.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\disquete.png"));
		btnGuardarTodo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id_mantenimiento="";
				frm_det_repuesto a = new frm_det_repuesto();
				a.setVisible(true);
///////////////////////////////////////Mantenimiento//////////////////////////////////////////////////////////////////////	
				   cls_mantenimiento man = new cls_mantenimiento ();
				    man.setDetalle_RM(txtNombreServ.getText());/*id mantenimiento*/
					man.insertar();
					JOptionPane.showMessageDialog(null,"Mantenimineto Guardado");
					id_mantenimiento=man.ultimoid();	
					//////////////////////////////////////det auto//////////////////////////////////////////////////////////////////////		
					cls_det_auto au = new cls_det_auto();
					au.setFecha(java.sql.Date.valueOf(txtFecha.getText().toString()));
					au.setIdAuto(Integer.parseInt(txtIDauto.getText().toString()));
					au.setIdMant(Integer.parseInt(id_mantenimiento));
					au.insertarDetAuto();
					//System.out.println("det auto: "+id_mantenimiento+" - "+txtIDauto);

					
					///////////det Empleado/////////////
					//System.out.println("numero: "+tablaX2.getRowCount());
					for(int j=0;j<=tablaX2.getRowCount()-1;j++){
					cls_det_empleado det= new cls_det_empleado();
											
					det.setIdMant(Integer.parseInt(id_mantenimiento));
					DefaultTableModel tm = (DefaultTableModel) tablaX2.getModel();
					String idEmple =String.valueOf(tm.getValueAt(j,0));
											
											
						//System.out.println("det emple: "+id_mantenimiento+" - "+idEmple);
						det.setIdEmp(Integer.parseInt(idEmple));
						det.setIdMant(Integer.parseInt(id_mantenimiento));
						det.insertarDetEmp();
						
						}
					
					////////////insertar servicios/////////////
					//System.out.println("numero filas tabla x: "+tablaX.getRowCount());
					for(int j=0;j<=tablaX.getRowCount()-1;j++)
					{
						cls_revision revision= new cls_revision();
						
						revision.setIdMant(Integer.parseInt(id_mantenimiento));
						
						DefaultTableModel tm = (DefaultTableModel) tablaX.getModel();
						String idservicio=String.valueOf(tm.getValueAt(j,0));
						
						revision.setIdServ(Integer.parseInt(idservicio));
						revision.setIdMant(Integer.parseInt(id_mantenimiento));
						revision.insertarRevision();
						
						//System.out.println("mantenimiento: "+id_mantenimiento+" - servicio: "+idservicio);
						}
					 

				
			}
		});
		btnGuardarTodo.setForeground(Color.RED);
		btnGuardarTodo.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnGuardarTodo.setBounds(568, 750, 156, 55);
		contentPane.add(btnGuardarTodo);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\flecha-hacia-la-izquierda (1).png"));
		button.setForeground(new Color(0, 0, 205));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setBounds(1231, 11, 65, 55);
		contentPane.add(button);}
	
		public static String fechaActual(){
			 Date fecha=new Date(); 
			SimpleDateFormat formatoFecha=new SimpleDateFormat("YYYY-MM-dd"); 
			return formatoFecha.format(fecha);
	}
}
