package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Clases.cls_det_factura_venta;
import Clases.cls_facturaCompra;
import Clases.cls_facturaVenta;

import javax.swing.JTable;
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
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public abstract class frm_facturaCompra extends JFrame implements Printable {

	private JPanel contentPane;
	private JTextField txtN;
	private JTextField txtIDpr;
	private JTextField txtDireccion;
	private JTextField txtDetalle;
	private JTextField txtFecha;
	private JTextField txtRuc;
	private JTextField txtNombre;
	private JTextField textField_10;
	private JTable tablaProveedores;
	private JTable tablaFactura;
	private JPanel panelpr;
	private JTextField txtN2;
	private JTextField txtIDrep;
	private JTable tablaRep;
	private JPanel panel_rep;
	private JTextField txtCantidad;
	private JTextField txtPrecio;
	
	DefaultTableModel m  = new DefaultTableModel() ;
	DefaultTableModel m2  = new DefaultTableModel() ;
	

	static double total;
	double sub_total;
	double iva;
	double desc;
	private JTextField txtDescuento;
	private JTextField txtSubTotal;
	private JTextField txtIVA;
	private JTextField txtTotal;
	protected static JPanel panel_Factura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_facturaCompra frame = new frm_facturaCompra() {
						
						@Override
						public int print(Graphics graf, PageFormat pageFormat, int index) throws PrinterException {
							
							if(index>0) {
								return NO_SUCH_PAGE;
							}
							
							
							Graphics2D hub = (Graphics2D) graf;
							hub.translate(pageFormat.getImageableX(),  pageFormat.getImageableY() );
							//hub.scale(29, 113);
							
							
							panel_Factura.printAll(graf);
							return PAGE_EXISTS;
						}
					};
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
	public frm_facturaCompra() {
		total = 0;
		sub_total = 0.0;
		iva = 0.0;
		/////desc = 0.0;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				txtIDpr.setVisible(false);
				txtIDrep.setVisible(false);
				panel_rep.setVisible(false);
				txtFecha.setText(fechaActual());
				
				panelpr.setVisible(false);
				cls_facturaCompra a = new cls_facturaCompra();
				
					String[] cabecera2={"ID","Ruc","Empresa","Direccion","Telèfono","Celular","Correo"};
					Object datos2[][]=a.consultarPr(txtN.getText());
					tablaProveedores.setModel(new DefaultTableModel(datos2,cabecera2) );
					
					String[] cabecera={"idRepuesto","Nombre","Stock","Precio Venta"};
					Object datos[][]=a.consultarRep(txtN2.getText());
					tablaRep.setModel(new DefaultTableModel(datos,cabecera) );
					
					///factuta////////////
					 String[] cabecera3={"ID","Nombre","Cantidad","Precio Unitario","Total"};
					 Object datos3[][]=	null;
						tablaFactura.setModel(new DefaultTableModel(datos3,cabecera3) );	
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\coche.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1226, 817);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\flecha-hacia-la-izquierda (1).png"));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
		});
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new LineBorder(new Color(0, 120, 215), 3));
		panel_3.setBackground(SystemColor.inactiveCaptionBorder);
		panel_3.setBounds(974, 335, 136, 253);
		contentPane.add(panel_3);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(16, 11, 100, 85);
		panel_3.add(button_1);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				double x=0.0 , ivaActual=0.0, subtotalActual=0.0, total=0.0, precioActual=0.0;
				int fsel, fil;
				
			try {
				fsel = tablaFactura.getSelectedRow();
	
				if(fsel==-1) {
					JOptionPane.showMessageDialog(null, "debe selecionar el Producto a Elimnar!","Advertencia",JOptionPane.WARNING_MESSAGE);
				}else {
					
						total = Double.parseDouble(tablaFactura.getValueAt(fsel, 4).toString());
						precioActual = Double.parseDouble(txtTotal.getText())-total;
						total = precioActual;
						txtTotal.setText(""+total);
						ivaActual = total * 0.12;
						txtIVA.setText(""+ivaActual);
						subtotalActual = precioActual - ivaActual;
						txtSubTotal.setText(""+subtotalActual);
						
						m = (DefaultTableModel) tablaFactura.getModel();
						
						m.removeRow(fsel);
	
				}
				
		
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se pudo Eliminar");
			}  
				
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\cruzar.png"));
		button_1.setForeground(SystemColor.textHighlight);
		
		JLabel lblEliminarProducto = new JLabel("Eliminar Producto");
		lblEliminarProducto.setBounds(10, 91, 132, 34);
		panel_3.add(lblEliminarProducto);
		lblEliminarProducto.setForeground(Color.RED);
		lblEliminarProducto.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 13));
		lblEliminarProducto.setBackground(Color.BLACK);
		
		JButton button_7 = new JButton("");
		button_7.setBounds(16, 136, 100, 85);
		panel_3.add(button_7);
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtIDpr.setText("");
				txtRuc.setText("");
				txtNombre.setText("");
				txtDireccion.setText("");
				txtDescuento.setText("");
				txtSubTotal.setText("");
				txtIVA.setText("");
				txtTotal.setText("");
				txtDetalle.setText("");
			}
		});
		button_7.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\deshabilitado.png"));
		button_7.setForeground(SystemColor.textHighlight);
		
		JLabel lblCancelar = new JLabel("Cancelar");
		lblCancelar.setBounds(44, 216, 132, 34);
		panel_3.add(lblCancelar);
		lblCancelar.setForeground(Color.RED);
		lblCancelar.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblCancelar.setBackground(Color.BLACK);
		
		panelpr = new JPanel();
		panelpr.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelpr.setBounds(621, 0, 481, 321);
		contentPane.add(panelpr);
		panelpr.setLayout(null);
		panelpr.setBackground(SystemColor.textHighlight);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 83, 439, 156);
		panelpr.add(scrollPane);
		
		tablaProveedores = new JTable();
		tablaProveedores.setFont(new Font("Tahoma", Font.BOLD, 12));
		tablaProveedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_facturaCompra a = new cls_facturaCompra();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tablaProveedores.getModel();
				String codigo=String.valueOf(tm.getValueAt(tablaProveedores.getSelectedRow(),0));
				datos=a.datoPr(codigo);
			
				txtIDpr.setText(datos[0]);
				txtRuc.setText(datos[1]);
				txtNombre.setText(datos[2]);
				txtDireccion.setText(datos[3]);
	
				
			}
		});
		scrollPane.setViewportView(tablaProveedores);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\cerrar (1).png"));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				panelpr.setVisible(false);
			}
		});
		button_2.setForeground(new Color(0, 0, 205));
		button_2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button_2.setBounds(186, 248, 103, 62);
		panelpr.add(button_2);
		
		txtN = new JTextField();
		txtN.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtN.setColumns(10);
		txtN.setBounds(195, 56, 160, 22);
		panelpr.add(txtN);
		
		JLabel label_1 = new JLabel("Proveedores");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		label_1.setBounds(151, 2, 167, 34);
		panelpr.add(label_1);
		
		JLabel label_2 = new JLabel("Buscar por Nombre:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(26, 50, 187, 34);
		panelpr.add(label_2);
		
		txtIDpr = new JTextField();
		txtIDpr.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtIDpr.setColumns(10);
		txtIDpr.setBounds(10, 11, 38, 22);
		panelpr.add(txtIDpr);
		
		panel_rep = new JPanel();
		panel_rep.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_rep.setBounds(638, 0, 481, 324);
		contentPane.add(panel_rep);
		panel_rep.setLayout(null);
		panel_rep.setBackground(SystemColor.textHighlight);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(23, 83, 439, 165);
		panel_rep.add(scrollPane_2);
		
		tablaRep = new JTable();
		tablaRep.setFont(new Font("Tahoma", Font.BOLD, 12));
		scrollPane_2.setViewportView(tablaRep);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\cerrar (1).png"));
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_rep.setVisible(false);
			}
		});
		button_5.setForeground(new Color(0, 0, 205));
		button_5.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button_5.setBounds(359, 259, 103, 54);
		panel_rep.add(button_5);
		
		JButton button_6 = new JButton("Agregar");
		button_6.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\boton-redondo-de-agregar.png"));
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
					int fsel = tablaRep.getSelectedRow();
				try {
					String id,  nombre, precio, cant, importe;
					double x=0.0 , iva=0.0, calcula=0.0;
					if(fsel==-1) {
						
						JOptionPane.showMessageDialog(null, "debe selecionar un servicio!");
					}else {
						m = (DefaultTableModel) tablaRep.getModel();
						id = tablaRep.getValueAt(fsel, 0).toString();
						nombre = tablaRep.getValueAt(fsel, 1).toString();
						cant= txtCantidad.getText(); 
						precio = txtPrecio.getText();
					
						
						x=(Double.parseDouble(precio) * Integer.parseInt(cant));
						importe = String.valueOf(x);
						
						
							
						m2 = (DefaultTableModel) tablaFactura.getModel();
						m2.addRow(new Object [] {id, nombre, cant, precio, importe });
						tablaFactura.setModel(m2);
						
						
						DecimalFormat df = new DecimalFormat("#,00");
						df.setRoundingMode(RoundingMode.DOWN);
						 //df.format(iva)
						
						calcula = (Double.parseDouble(precio) * Integer.parseInt(cant));
						total = total + calcula;
						iva = total * 0.12;
						sub_total = total - iva;
						
						
						
						
						txtSubTotal.setText(""+ sub_total);
						txtIVA.setText(""+df.format(iva));
						txtTotal.setText(""+ total);

						
					}
					
			
					
				} catch (Exception e2) {
					
				}  
				
			}
		});
		button_6.setForeground(new Color(0, 0, 205));
		button_6.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		button_6.setBounds(231, 259, 118, 54);
		panel_rep.add(button_6);
		
		txtN2 = new JTextField();
		txtN2.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtN2.setColumns(10);
		txtN2.setBounds(172, 56, 160, 22);
		panel_rep.add(txtN2);
		
		JLabel lblRepuestos = new JLabel("Repuestos");
		lblRepuestos.setForeground(Color.WHITE);
		lblRepuestos.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		lblRepuestos.setBounds(175, 2, 167, 34);
		panel_rep.add(lblRepuestos);
		
		JLabel lblBuscarRepuesto = new JLabel("Buscar Repuesto:");
		lblBuscarRepuesto.setForeground(Color.WHITE);
		lblBuscarRepuesto.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblBuscarRepuesto.setBackground(Color.BLACK);
		lblBuscarRepuesto.setBounds(26, 50, 187, 34);
		panel_rep.add(lblBuscarRepuesto);
		
		txtIDrep = new JTextField();
		txtIDrep.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtIDrep.setColumns(10);
		txtIDrep.setBounds(10, 11, 38, 22);
		panel_rep.add(txtIDrep);
		
		txtCantidad = new JTextField();
		txtCantidad.setText("1");
		txtCantidad.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 19));
		txtCantidad.setColumns(10);
		txtCantidad.setBounds(23, 259, 86, 36);
		panel_rep.add(txtCantidad);
		
		txtPrecio = new JTextField();
		txtPrecio.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 19));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(127, 259, 86, 36);
		panel_rep.add(txtPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblCantidad.setBackground(Color.BLACK);
		lblCantidad.setBounds(26, 290, 83, 34);
		panel_rep.add(lblCantidad);
		
		JLabel lblPrecio = new JLabel("Precio C.");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		lblPrecio.setBackground(Color.BLACK);
		lblPrecio.setBounds(137, 290, 102, 34);
		panel_rep.add(lblPrecio);
		button.setForeground(new Color(0, 0, 205));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setBounds(1129, 11, 63, 46);
		contentPane.add(button);
		
		JLabel lblFacturaCompra = new JLabel("FACTURA COMPRA");
		lblFacturaCompra.setForeground(SystemColor.textHighlight);
		lblFacturaCompra.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 26));
		lblFacturaCompra.setBounds(467, 0, 252, 34);
		contentPane.add(lblFacturaCompra);
		
		JButton button_4 = new JButton("Guardar");
		button_4.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\disco-flexible.png"));
		button_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				cls_facturaCompra fa = new cls_facturaCompra();
	            
				fa.setDescrip(txtDetalle.getText());
				fa.setFecha(java.sql.Date.valueOf(txtFecha.getText().toString()));
				fa.setDescuent(Double.parseDouble(txtDescuento.getText().toString()));
				fa.setIva(Double.parseDouble(txtIVA.getText().toString()));
				fa.setTotal(Double.parseDouble(txtTotal.getText().toString()));	
				fa.setIdPr(Integer.parseInt(txtIDpr.getText().toString()));
				
				if(fa.insertarFacComp()==true) {
					JOptionPane.showMessageDialog(null, "Registro Guardado!");
				} else {
					JOptionPane.showMessageDialog(null, "Error!");
				}
	 //////////////////////////////detalle factura/////////////////
		
				String idFactura_compra="";
				idFactura_compra=fa.ultimoid();
		
			//	System.out.println("numero: "+tablaFactura.getRowCount());
				 for(int j=0;j<=tablaFactura.getRowCount()-1;j++){
				
													
				 fa.setIdFactura(Integer.parseInt(idFactura_compra));
				 DefaultTableModel tm = (DefaultTableModel) tablaFactura.getModel();
				 
				 String idRepuesto=String.valueOf(tm.getValueAt(j,0));
				 String precio=String.valueOf(tm.getValueAt(j,2));
				 String cantidad=String.valueOf(tm.getValueAt(j,3));
								
				//System.out.println("det Factura: "+idMant+" - "+cantidad+" - "+precio);
							 
				 fa.setIdRepust(Integer.parseInt(idRepuesto));
				 fa.setIdFactura(Integer.parseInt(idFactura_compra));
				 fa.setCantidad(Double.parseDouble(cantidad));
				 fa.setPrecio(Double.parseDouble(precio));
				 fa.insertarDetFactCompra();
								
				}
				
				
				
				
			}
		});
		button_4.setBounds(409, 694, 178, 73);
		contentPane.add(button_4);
		
		panel_Factura = new JPanel();
		panel_Factura.setBounds(0, 127, 983, 545);
		contentPane.add(panel_Factura);
		panel_Factura.setLayout(null);
		panel_Factura.setBackground(SystemColor.inactiveCaptionBorder);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 623, 214);
		panel_Factura.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		
		JLabel label_3 = new JLabel("Detalle:");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(10, 73, 65, 34);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Cedula/Ruc:");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_4.setBackground(Color.BLACK);
		label_4.setBounds(10, 115, 96, 34);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("Nombre:");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(274, 115, 84, 34);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("Direcci\u00F2n:");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(10, 169, 86, 34);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("DATOS GENERALES PROVEEDORES");
		label_7.setForeground(SystemColor.textHighlight);
		label_7.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		label_7.setBackground(Color.BLUE);
		label_7.setBounds(15, 7, 374, 40);
		panel_1.add(label_7);
		
		JLabel label_8 = new JLabel("Fecha:");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
		label_8.setBackground(Color.BLACK);
		label_8.setBounds(399, 11, 65, 34);
		panel_1.add(label_8);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(92, 171, 418, 29);
		panel_1.add(txtDireccion);
		
		txtDetalle = new JTextField();
		txtDetalle.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtDetalle.setColumns(10);
		txtDetalle.setBounds(79, 76, 354, 28);
		panel_1.add(txtDetalle);
		
		txtFecha = new JTextField();
		txtFecha.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtFecha.setColumns(10);
		txtFecha.setBounds(456, 14, 136, 28);
		panel_1.add(txtFecha);
		
		txtRuc = new JTextField();
		txtRuc.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtRuc.setColumns(10);
		txtRuc.setBounds(107, 118, 136, 28);
		panel_1.add(txtRuc);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtNombre.setColumns(10);
		txtNombre.setBounds(350, 118, 242, 28);
		panel_1.add(txtNombre);
		
		textField_10 = new JTextField();
		textField_10.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		textField_10.setColumns(10);
		textField_10.setBounds(94, 172, 370, 28);
		panel_1.add(textField_10);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 229, 831, 223);
		panel_Factura.add(scrollPane_1);
		
		tablaFactura = new JTable();
		tablaFactura.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane_1.setViewportView(tablaFactura);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 459, 831, 75);
		panel_Factura.add(panel_2);
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(Color.RED, 2));
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		
		JLabel label_9 = new JLabel("Sub Total:");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		label_9.setBackground(Color.BLUE);
		label_9.setBounds(228, 17, 86, 34);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("IVA:");
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		label_10.setBackground(Color.BLUE);
		label_10.setBounds(446, 17, 48, 34);
		panel_2.add(label_10);
		
		JLabel label_11 = new JLabel("Total:");
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		label_11.setBackground(Color.BLUE);
		label_11.setBounds(627, 17, 86, 34);
		panel_2.add(label_11);
		
		JLabel label_12 = new JLabel("Descuento:");
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		label_12.setBackground(Color.BLUE);
		label_12.setBounds(24, 17, 86, 34);
		panel_2.add(label_12);
		
		txtDescuento = new JTextField();
		txtDescuento.setText("0");
		txtDescuento.addKeyListener(new KeyAdapter() {
	
			@Override
			public void keyReleased(KeyEvent e) {
				Double desc = Double.valueOf(txtDescuento.getText());
				Double total= Double.valueOf(txtTotal.getText());
				
				txtTotal.setText(""+(total-(total*desc/100)));
				
			}
		});
		txtDescuento.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtDescuento.setColumns(10);
		txtDescuento.setBounds(106, 22, 58, 23);
		panel_2.add(txtDescuento);
		
		txtSubTotal = new JTextField();
		txtSubTotal.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtSubTotal.setColumns(10);
		txtSubTotal.setBounds(312, 22, 100, 23);
		panel_2.add(txtSubTotal);
		
		txtIVA = new JTextField();
		txtIVA.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtIVA.setColumns(10);
		txtIVA.setBounds(485, 22, 100, 23);
		panel_2.add(txtIVA);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtTotal.setColumns(10);
		txtTotal.setBounds(677, 22, 100, 23);
		panel_2.add(txtTotal);
		
		JLabel label = new JLabel("%");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		label.setBackground(Color.BLUE);
		label.setBounds(168, 17, 28, 34);
		panel_2.add(label);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\impresora.png"));
		button_3.setBounds(1085, 665, 100, 85);
		contentPane.add(button_3);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
						try {
					
					PrinterJob gap = PrinterJob.getPrinterJob();
					gap.setPrintable(frm_facturaCompra.this);
					boolean top = gap.printDialog();
					if(top) {
						
						gap.print();
					}
					
					
					
					
				} catch (PrinterException pex) {
					JOptionPane.showMessageDialog(null, "ERROR"+ pex+ JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		button_3.setForeground(SystemColor.textHighlight);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBorder(new LineBorder(new Color(0, 120, 215), 3));
		panel.setBounds(10, 31, 439, 85);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnBuscarProveedor = new JButton("Buscar Proveedor");
		btnBuscarProveedor.setBounds(10, 11, 193, 58);
		panel.add(btnBuscarProveedor);
		btnBuscarProveedor.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\lupa-de-busqueda (2).png"));
		btnBuscarProveedor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelpr.setVisible(true);
			}
		});
		btnBuscarProveedor.setForeground(SystemColor.textHighlight);
		btnBuscarProveedor.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		
		JButton btnRepuesto = new JButton("+ Repuesto");
		btnRepuesto.setBounds(213, 12, 216, 57);
		panel.add(btnRepuesto);
		btnRepuesto.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\pedales.png"));
		btnRepuesto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel_rep.setVisible(true);
			}
		});
		btnRepuesto.setForeground(SystemColor.textHighlight);
		btnRepuesto.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		
		JLabel lblImprimir = new JLabel("Imprimir");
		lblImprimir.setForeground(SystemColor.textHighlight);
		lblImprimir.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblImprimir.setBackground(Color.BLACK);
		lblImprimir.setBounds(1112, 744, 70, 34);
		contentPane.add(lblImprimir);
	}
	public static String fechaActual(){
		 Date fecha=new Date(); 
		SimpleDateFormat formatoFecha=new SimpleDateFormat("YYYY-MM-dd"); 
		return formatoFecha.format(fecha);
}
}
