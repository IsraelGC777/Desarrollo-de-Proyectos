package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.junit.experimental.theories.Theories;

import Clases.cls_clientes;
import Clases.cls_det_empleado;
import Clases.cls_det_factura_venta;
import Clases.cls_det_repuest;
import Clases.cls_empleados;
import Clases.cls_facturaVenta;
import Clases.cls_mantenimiento;
import Clases.cls_repuestos;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.Painter;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.EncryptedPrivateKeyInfo;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public abstract class frm_facturaVenta extends JFrame implements Printable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JTextField txtIDemp;
	private JTextField txtSubTotal;
	private JTextField txtIVA;
	private JTextField txtTotal;
	private JTable tablaFactura;
	private JTextField txtFecha;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDireccion;
	private JTextField txtDescipcin;
	private JTextField txtCedula;
	private JTable tablaMantenimiento;
	private JPanel panel_mant;
	
	
	DefaultTableModel m  = new DefaultTableModel() ;
	DefaultTableModel m2  = new DefaultTableModel() ;
	
	static double total;
	double sub_total;
	double iva;
	double desc;
	
	private JTextField txtDescuento;
	private JTextField txtNcl;
	private JPanel panel_emp;
	private JTable tabla1;
	private JTextField txtN;
	private JButton btnGuardar;
	private JTextField txtIDcl;
	private JTextField txtApellidoEmp;
	private JTextField txtNombreEmp;
	private JTextField txtCargo;
	private int limiteTl  = 4;
	protected static  javax.swing.JPanel  panel_Factura;
	private JLabel lblFacturaDeVenta_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_facturaVenta frame = new frm_facturaVenta() {
						
						@Override
						public int print(Graphics graf, PageFormat pageFormat, int pageIndex) throws PrinterException {
							
							if(pageIndex>0) {
								return NO_SUCH_PAGE;
							}
							
							
							Graphics2D hub = (Graphics2D) graf;
							hub.translate(pageFormat.getImageableX(),  pageFormat.getImageableY() );
							//hub.scale(29, 113);
							
							
							panel_Factura.printAll(graf);
							return PAGE_EXISTS;
							
						
							
							
						
						}
					};frm_facturaVenta();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected static void frm_facturaVenta() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Create the frame.
	 */
	public frm_facturaVenta() {
		//this.setUndecorated(true);
		total = 0;
		sub_total = 0.0;
		iva = 0.0;
		desc = 0.0;
		
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				cls_facturaVenta a = new cls_facturaVenta();
				lblFacturaDeVenta_1.setVisible(false);
				txtIDemp.setVisible(false);
				txtIDcl.setVisible(false);
				
			
				txtFecha.setText(fechaActual());
				
				panel_mant.setVisible(false);
				panel_emp.setVisible(false);
				
				
				 String[] cabecera2={"ID","Mantenimiento","Placa","Cedula","Nombre","Apellido","Direccion"};
					Object datos2[][]=a.consultarMant(txtN.getText());
					tablaMantenimiento.setModel(new DefaultTableModel(datos2,cabecera2) );
				
				
			
                String[] cabecera={"ID","Nombre","Apellido","Dirección","Cargo"};
				Object datos[][]=a.consultar1(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );	
				
				
				//factura
				String[] cabecerasf={"ID Rev","ID","Nombre","Cantidad","Precio","Importe"};
				Object datosf[][]=null;
				tablaFactura.setModel(new DefaultTableModel(datosf,cabecerasf));	
				
			

			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\coche.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1253, 825);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_emp = new JPanel();
		panel_emp.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_emp.setBounds(396, 11, 412, 277);
		contentPane.add(panel_emp);
		panel_emp.setBackground(SystemColor.textHighlight);
		panel_emp.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(25, 90, 364, 125);
		panel_emp.add(scrollPane_3);
		
		tabla1 = new JTable();
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_facturaVenta a = new cls_facturaVenta();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla1.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));
				datos=a.datoEmp(codigo);
			
				txtIDemp.setText(datos[0]);
				txtNombreEmp.setText(datos[1]);
				txtApellidoEmp.setText(datos[2]);
				txtCargo.setText(datos[3]);
		
			}
		});
		scrollPane_3.setViewportView(tabla1);
		
		JLabel lblClientes = new JLabel("Empleado");
		lblClientes.setBounds(139, 7, 167, 34);
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		panel_emp.add(lblClientes);
		
		JLabel lblBuscarPorId = new JLabel("Buscar por Nombre:");
		lblBuscarPorId.setForeground(Color.WHITE);
		lblBuscarPorId.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblBuscarPorId.setBackground(Color.BLACK);
		lblBuscarPorId.setBounds(25, 56, 187, 34);
		panel_emp.add(lblBuscarPorId);
		
		txtNcl = new JTextField();
		txtNcl.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtNcl.setColumns(10);
		txtNcl.setBounds(191, 62, 115, 22);
		panel_emp.add(txtNcl);
		
		JButton btnNuevaFactura = new JButton("");
		btnNuevaFactura.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\cerrar (1).png"));
		btnNuevaFactura.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		btnNuevaFactura.setBounds(158, 223, 109, 43);
		panel_emp.add(btnNuevaFactura);
		
		txtIDemp = new JTextField();
		txtIDemp.setBounds(44, 16, 56, 23);
		panel_emp.add(txtIDemp);
		txtIDemp.setEnabled(false);
		txtIDemp.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtIDemp.setColumns(10);
		btnNuevaFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_emp.setVisible(false);
			}
		});
		
		panel_mant = new JPanel();
		panel_mant.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_mant.setBounds(672, 6, 569, 323);
		contentPane.add(panel_mant);
		panel_mant.setBackground(SystemColor.textHighlight);
		panel_mant.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 83, 540, 165);
		panel_mant.add(scrollPane_2);
		
		tablaMantenimiento = new JTable();
		tablaMantenimiento.setFont(new Font("Tahoma", Font.BOLD, 12));
		tablaMantenimiento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cls_facturaVenta a = new cls_facturaVenta();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tablaMantenimiento.getModel();
				String codigo=String.valueOf(tm.getValueAt(tablaMantenimiento.getSelectedRow(),0));
				datos=a.datoMan(codigo);
			
				txtDescipcin.setText(datos[0]);
				txtCedula.setText(datos[1]);
				txtNombre.setText(datos[2]);
				txtApellido.setText(datos[3]);
				txtDireccion.setText(datos[4]);
				txtIDcl.setText(datos[8]);

				
			}
		});
		scrollPane_2.setViewportView(tablaMantenimiento);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\cerrar (1).png"));
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_mant.setVisible(false);
			}
		});
		button_4.setBounds(260, 259, 114, 53);
		button_4.setForeground(new Color(0, 0, 205));
		button_4.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		panel_mant.add(button_4);
		
		JButton button_5 = new JButton("Agregar");
		button_5.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\boton-redondo-de-agregar.png"));
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_facturaVenta a = new cls_facturaVenta();
				
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tablaMantenimiento.getModel();
				String codigo=String.valueOf(tm.getValueAt(tablaMantenimiento.getSelectedRow(),0));
				
				
				 String[] cabecera={"ID Rev","Codigo","Descripcion","Cantidad","Precio Unitario","Total"};
				 Object datos2[][]=	a.consultarServ(codigo);
					tablaFactura.setModel(new DefaultTableModel(datos2,cabecera) );	
				
					
					String S =a.SubTotal(codigo);
					txtSubTotal.setText(S);
					

					DecimalFormat df = new DecimalFormat("#,00");
					df.setRoundingMode(RoundingMode.DOWN);
					 //df.format(iva)
					
					Double iva = Double.valueOf(txtSubTotal.getText()) *0.12;
					txtIVA.setText(""+iva);
					txtTotal.setText(  ""+((Double.valueOf(txtSubTotal.getText()) + iva )));

			}
		});
		button_5.setBounds(116, 259, 126, 53);
		button_5.setForeground(new Color(0, 0, 205));
		button_5.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		panel_mant.add(button_5);
		
		txtN = new JTextField();
		txtN.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtN.setColumns(10);
		txtN.setBounds(195, 56, 160, 22);
		panel_mant.add(txtN);
		
		JLabel label_2 = new JLabel("Mantenimiento");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		label_2.setBounds(127, 11, 167, 34);
		panel_mant.add(label_2);
		
		JLabel label_3 = new JLabel("Buscar por Nombre:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(26, 50, 187, 34);
		panel_mant.add(label_3);
		
		txtIDcl = new JTextField();
		txtIDcl.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtIDcl.setColumns(10);
		txtIDcl.setBounds(10, 11, 38, 22);
		panel_mant.add(txtIDcl);
		
		JLabel lblFacturaDeVenta = new JLabel("FACTURA DE VENTA");
		lblFacturaDeVenta.setForeground(SystemColor.textHighlight);
		lblFacturaDeVenta.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 26));
		lblFacturaDeVenta.setBounds(433, 7, 340, 34);
		contentPane.add(lblFacturaDeVenta);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\disquete.png"));
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				cls_facturaVenta fa = new cls_facturaVenta();
	            
		
				fa.setFecha(java.sql.Date.valueOf(txtFecha.getText().toString()));
				fa.setDescuento(Double.parseDouble(txtDescuento.getText().toString()));
				fa.setIva(Double.parseDouble(txtIVA.getText().toString()));
				fa.setTotal(Double.parseDouble(txtTotal.getText().toString()));	
				fa.setIdCl(Integer.parseInt(txtIDcl.getText().toString()));
				fa.setIdEmp(Integer.parseInt(txtIDemp.getText().toString()));
				
				if(fa.insertarFact()==true) {
					JOptionPane.showMessageDialog(null, "Registro Guardado!");
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
	 //////////////////////////////det Venta/////////////////
		
				String idFactura_venta="";
				idFactura_venta=fa.ultimoid();
		
			//	System.out.println("numero: "+tablaFactura.getRowCount());
				 for(int j=0;j<=tablaFactura.getRowCount()-1;j++){
				 cls_det_factura_venta det = new cls_det_factura_venta();
													
				 det.setIdFactura(Integer.parseInt(idFactura_venta));
				 DefaultTableModel tm = (DefaultTableModel) tablaFactura.getModel();
				 
				 String idCod=String.valueOf(tm.getValueAt(j,1));
				 String cantidad=String.valueOf(tm.getValueAt(j,3));
				 String precio=String.valueOf(tm.getValueAt(j,4));
													
				//System.out.println("det Factura: "+idMant+" - "+cantidad+" - "+precio);
				
				 det.setDescr(txtDescipcin.getText());
				 
				 det.setIdCod(Integer.parseInt(idCod));
				 det.setCantidad(Double.parseDouble(cantidad));
				 det.setPrecio(Double.parseDouble(precio));	
				 det.setIdFactura(Integer.parseInt(idFactura_venta));
				 
				 det.insertarDetFac(); 
								
				}
						   
						
				
			
			}
		});
		btnGuardar.setBounds(396, 663, 132, 41);
		contentPane.add(btnGuardar);
		
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
		button.setBounds(1163, 11, 64, 46);
		contentPane.add(button);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setBounds(95, 732, 86, 34);
		contentPane.add(lblNombre_1);
		lblNombre_1.setForeground(Color.BLACK);
		lblNombre_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblNombre_1.setBackground(Color.BLACK);
		
		txtNombreEmp = new JTextField();
		txtNombreEmp.setBounds(168, 735, 132, 28);
		contentPane.add(txtNombreEmp);
		txtNombreEmp.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtNombreEmp.setColumns(10);
		
		JLabel label_5 = new JLabel("Apellido:");
		label_5.setBounds(323, 732, 86, 34);
		contentPane.add(label_5);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_5.setBackground(Color.BLACK);
		
		txtApellidoEmp = new JTextField();
		txtApellidoEmp.setBounds(396, 735, 132, 28);
		contentPane.add(txtApellidoEmp);
		txtApellidoEmp.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtApellidoEmp.setColumns(10);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(569, 732, 56, 34);
		contentPane.add(lblCargo);
		lblCargo.setForeground(Color.BLACK);
		lblCargo.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblCargo.setBackground(Color.BLACK);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(623, 735, 333, 28);
		contentPane.add(txtCargo);
		txtCargo.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtCargo.setColumns(10);
		
		JLabel label_4 = new JLabel("Empleado");
		label_4.setBounds(51, 709, 167, 34);
		contentPane.add(label_4);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 19));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(39, 715, 959, 60);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		panel_Factura = new JPanel();
		panel_Factura.setBackground(SystemColor.inactiveCaptionBorder);
		panel_Factura.setBounds(29, 113, 983, 545);
		contentPane.add(panel_Factura);
		panel_Factura.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 623, 214);
		panel_Factura.add(panel_2);
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setLayout(null);
		
		JLabel lblDetalle = new JLabel("Detalle:");
		lblDetalle.setBounds(10, 69, 65, 34);
		panel_2.add(lblDetalle);
		lblDetalle.setForeground(Color.BLACK);
		lblDetalle.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblDetalle.setBackground(Color.BLACK);
		
		txtDescipcin = new JTextField();
		txtDescipcin.setBounds(77, 71, 361, 29);
		panel_2.add(txtDescipcin);
		txtDescipcin.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtDescipcin.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(10, 118, 65, 34);
		panel_2.add(lblCedula);
		lblCedula.setForeground(Color.BLACK);
		lblCedula.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblCedula.setBackground(Color.BLACK);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(69, 118, 136, 28);
		panel_2.add(txtCedula);
		txtCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtCedula.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(219, 118, 84, 34);
		panel_2.add(lblNombre);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblNombre.setBackground(Color.BLACK);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F2n:");
		lblDireccin.setBounds(10, 169, 86, 34);
		panel_2.add(lblDireccin);
		lblDireccin.setForeground(Color.BLACK);
		lblDireccin.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblDireccin.setBackground(Color.BLACK);
		
		JLabel lblDatosGenerales = new JLabel("DATOS GENERALES");
		lblDatosGenerales.setBounds(10, 18, 206, 40);
		panel_2.add(lblDatosGenerales);
		lblDatosGenerales.setForeground(Color.BLACK);
		lblDatosGenerales.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblDatosGenerales.setBackground(Color.BLUE);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(394, 6, 65, 34);
		panel_2.add(lblFecha);
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblFecha.setBackground(Color.BLACK);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(92, 171, 418, 29);
		panel_2.add(txtDireccion);
		txtDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtDireccion.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(291, 120, 115, 29);
		panel_2.add(txtNombre);
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtNombre.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(453, 8, 115, 29);
		panel_2.add(txtFecha);
		txtFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtFecha.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(416, 118, 86, 34);
		panel_2.add(lblApellido);
		lblApellido.setForeground(Color.BLACK);
		lblApellido.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblApellido.setBackground(Color.BLACK);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(489, 121, 115, 28);
		panel_2.add(txtApellido);
		txtApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtApellido.setColumns(10);
		
		lblFacturaDeVenta_1 = new JLabel("Factura de Venta");
		lblFacturaDeVenta_1.setBounds(204, 0, 206, 28);
		panel_2.add(lblFacturaDeVenta_1);
		lblFacturaDeVenta_1.setForeground(Color.BLACK);
		lblFacturaDeVenta_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblFacturaDeVenta_1.setBackground(Color.BLUE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 236, 767, 223);
		panel_Factura.add(scrollPane);
		
		tablaFactura = new JTable();
		tablaFactura.setFont(new Font("Tahoma", Font.BOLD, 15));
		tablaFactura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				 
			} 
		});
		scrollPane.setViewportView(tablaFactura);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 470, 767, 75);
		panel_Factura.add(panel);
		panel.setBorder(new LineBorder(Color.RED, 2));
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setLayout(null);
		
		JLabel lblDescuento = new JLabel("Sub Total:");
		lblDescuento.setBounds(213, 11, 86, 34);
		panel.add(lblDescuento);
		lblDescuento.setForeground(Color.BLACK);
		lblDescuento.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblDescuento.setBackground(Color.BLUE);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setBounds(297, 16, 100, 23);
		panel.add(txtSubTotal);
		txtSubTotal.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtSubTotal.setColumns(10);
		
		JLabel lblIva = new JLabel("IVA:");
		lblIva.setBounds(422, 11, 48, 34);
		panel.add(lblIva);
		lblIva.setForeground(Color.BLACK);
		lblIva.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblIva.setBackground(Color.BLUE);
		
		txtIVA = new JTextField();
		txtIVA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c=ke.getKeyChar(); 
                if(Character.isLetter(c)) { 
	              getToolkit().beep();              
	              ke.consume();		               
	              JOptionPane.showMessageDialog(null, "Solo puede ingresar Números!"); 
	              } 
                
                if (txtIVA.getText().length()== limiteTl){
                	JOptionPane.showMessageDialog(null, "Solo se admite Números de Telèfono!");
                	
                	ke.consume();
                				}
			}
		});
		txtIVA.setBounds(469, 16, 100, 23);
		panel.add(txtIVA);
		txtIVA.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtIVA.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(648, 16, 100, 23);
		panel.add(txtTotal);
		txtTotal.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtTotal.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(595, 11, 86, 34);
		panel.add(lblTotal);
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblTotal.setBackground(Color.BLUE);
		
		JLabel label_1 = new JLabel("Descuento:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		label_1.setBackground(Color.BLUE);
		label_1.setBounds(10, 11, 86, 34);
		panel.add(label_1);
		
		txtDescuento = new JTextField();
		txtDescuento.setText("0");
		txtDescuento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
				
				Double desc = Double.valueOf(txtDescuento.getText());
				Double total= Double.valueOf(txtTotal.getText());
				
				txtTotal.setText(""+(total-(total*desc/100)));
				
			}
			
			
		});
		txtDescuento.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(92, 16, 55, 23);
		panel.add(txtDescuento);
		
		JLabel label_6 = new JLabel("%");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		label_6.setBackground(Color.BLUE);
		label_6.setBounds(149, 11, 22, 34);
		panel.add(label_6);
		
		JButton btnImprimir = new JButton("");
		btnImprimir.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\impresora.png"));
		btnImprimir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblFacturaDeVenta_1.setVisible(true);
				try {
					
					PrinterJob gap = PrinterJob.getPrinterJob();
					gap.setPrintable(frm_facturaVenta.this);
					boolean top = gap.printDialog();
					if(top) {
						
						gap.print();
					}
					
					
					
					
				} catch (PrinterException pex) {
					JOptionPane.showMessageDialog(null, "ERROR"+ pex+ JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnImprimir.setForeground(SystemColor.textHighlight);
		btnImprimir.setBounds(1113, 663, 100, 88);
		contentPane.add(btnImprimir);
		
		JLabel label = new JLabel("Imprimir");
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		label.setBackground(Color.BLACK);
		label.setBounds(1137, 745, 70, 34);
		contentPane.add(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		panel_3.setBackground(SystemColor.inactiveCaptionBorder);
		panel_3.setBounds(10, 11, 354, 101);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(185, 11, 159, 73);
		panel_3.add(btnBuscar);
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\volante.png"));
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_mant.setVisible(true);
			}
		});
		btnBuscar.setForeground(SystemColor.windowText);
		btnBuscar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		JButton btnEmpleado = new JButton("Empleado");
		btnEmpleado.setBounds(10, 11, 165, 73);
		panel_3.add(btnEmpleado);
		btnEmpleado.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnEmpleado.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\usuarios (1).png"));
		btnEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_emp.setVisible(true);
			}
		});
	}
	
	public static String fechaActual(){
		 Date fecha=new Date(); 
		SimpleDateFormat formatoFecha=new SimpleDateFormat("YYYY-MM-dd"); 
		return formatoFecha.format(fecha);
}
}
