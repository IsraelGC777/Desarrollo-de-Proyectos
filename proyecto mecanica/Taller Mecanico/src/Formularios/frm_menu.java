package Formularios;

import hilos.HiloReloj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Color;

import Clases.DB_Conexion;
import Clases.cls_empleados;
import Clases.cls_facturaVenta;

import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JCalendar;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;

public class frm_menu extends JFrame {

	public static Object fecha;
	private JPanel contentPane;
	
	
	public static  JLabel lblHora;
	public static  JLabel lblFecha;
	private JLabel lblFecha_1;
	private JLabel lblHora_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JButton btnSalir;
	private JButton btnClientes;
	private JButton btnAutos;
	private JButton btnEmpleado;
	private JButton btnManteniminto;
	private JButton btnHistorialAuto;
	private JButton btnrRepuesto;
	private JButton btnServicio;
	private JButton btnProveedores;
	private JPanel panel;
	private JLabel lblCarro;
	private JButton btnReportes;
	private JButton btnFacturaCompra;
	private JButton btnFacturaVenta;
	public JLabel lblUsu;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_menu frame = new frm_menu();
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

	public frm_menu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\coche.png"));
		this.setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1604, 932);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(new LineBorder(new Color(255, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("");
		
		label_1 = new JLabel("");
		
		label_2 = new JLabel("");
		
		label_3 = new JLabel("");
		
		label_4 = new JLabel("");
		
		label_5 = new JLabel("");
		
		label_6 = new JLabel("");
		
		lblHora = new JLabel("Hora");
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		lblHora.setBounds(1442, 881, 136, 37);
		contentPane.add(lblHora);
		
		
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblFecha.setBounds(82, 888, 228, 22);
		contentPane.add(lblFecha);
		
		lblFecha_1 = new JLabel("Fecha:");
		lblFecha_1.setForeground(Color.RED);
		lblFecha_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblFecha_1.setBounds(10, 887, 68, 22);
		contentPane.add(lblFecha_1);
		
		lblHora_1 = new JLabel("Hora:");
		lblHora_1.setForeground(Color.RED);
		lblHora_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 24));
		lblHora_1.setBounds(1364, 887, 68, 22);
		contentPane.add(lblHora_1);
		
		btnSalir = new JButton("");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\puerta.png"));
		btnSalir.setBounds(1434, 11, 144, 133);
		contentPane.add(btnSalir);
		
		btnClientes = new JButton("");
		btnClientes.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\hombre.png"));
		btnClientes.setSelectedIcon(null);
		btnClientes.addMouseListener(new MouseAdapter() {
			@Override
			
			
        
			public void mouseClicked(MouseEvent e) {
				frm_clientes cl = new frm_clientes();
				cl.setVisible(true);
				
				
				
			}
		});
		btnClientes.setBounds(10, 11, 144, 133);
		contentPane.add(btnClientes);
		
		btnAutos = new JButton("");
		btnAutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_autos au = new frm_autos();
				au.setVisible(true);
			}
		});
		btnAutos.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\carreras.png"));
		btnAutos.setBounds(10, 170, 144, 133);
		contentPane.add(btnAutos);
		
		btnEmpleado = new JButton("");
		btnEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frm_empleados emp = new frm_empleados();
				emp.setVisible(true);
			}
		});
		btnEmpleado.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\mecanico.png"));
		btnEmpleado.setBounds(10, 329, 144, 133);
		contentPane.add(btnEmpleado);
		
		btnManteniminto = new JButton("");
		btnManteniminto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_mantenimiento m = new  frm_mantenimiento();
				m.setVisible(true);
			}
		});
		btnManteniminto.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\mantenimiento.png"));
		btnManteniminto.setBounds(189, 11, 144, 133);
		contentPane.add(btnManteniminto);
		
		btnHistorialAuto = new JButton("");
		btnHistorialAuto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_historial_vehicular a = new frm_historial_vehicular();
				
				a.setVisible(true);
				
			}
		});
		btnHistorialAuto.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\coche-y-volante.png"));
		btnHistorialAuto.setBounds(370, 11, 144, 133);
		contentPane.add(btnHistorialAuto);
		
		btnrRepuesto = new JButton("");
		btnrRepuesto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_repuestos re = new frm_repuestos();
				re.setVisible(true);
			}
		});
		btnrRepuesto.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\tornillo.png"));
		btnrRepuesto.setBounds(547, 11, 144, 133);
		contentPane.add(btnrRepuesto);
		
		btnServicio = new JButton("");
		btnServicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_servicios s = new frm_servicios();
				s.setVisible(true);
			}
		});
		btnServicio.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\preguntas.png"));
		btnServicio.setBounds(726, 11, 144, 133);
		contentPane.add(btnServicio);
		
		btnProveedores = new JButton("");
		btnProveedores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_proveedores pr = new frm_proveedores();
				pr.setVisible(true);
			}
		});
		btnProveedores.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\apreton-de-manos.png"));
		btnProveedores.setBounds(903, 11, 144, 133);
		contentPane.add(btnProveedores);
		
		panel = new JPanel();
		panel.setBackground(SystemColor.desktop);
		panel.setBounds(208, 170, 1370, 693);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblCarro = new JLabel("");
		lblCarro.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\Chevrolet Camaro 2013.jpg"));
		lblCarro.setBounds(10, 11, 1331, 707);
		panel.add(lblCarro);
		
		btnReportes = new JButton("");
		btnReportes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_reportes a = new frm_reportes();
				
				a.setVisible(true);
				}
			
		});
		btnReportes.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\impreso.png"));
		btnReportes.setBounds(10, 493, 144, 133);
		contentPane.add(btnReportes);
		
		btnFacturaCompra = new JButton("");
		btnFacturaCompra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frm_facturaCompra a = new frm_facturaCompra() {
					
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
				
				a.setVisible(true);
			}
		});
		btnFacturaCompra.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\presupuesto.png"));
		btnFacturaCompra.setBounds(1081, 11, 144, 133);
		contentPane.add(btnFacturaCompra);
		
		btnFacturaVenta = new JButton("");
		btnFacturaVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_facturaVenta x = new frm_facturaVenta() {
					
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
				};
				x.setVisible(true);
			}
		});
		btnFacturaVenta.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\caja-registradora.png"));
		btnFacturaVenta.setBounds(1256, 11, 144, 133);
		contentPane.add(btnFacturaVenta);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 673, 184, 153);
		contentPane.add(calendar);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setForeground(Color.WHITE);
		lblClientes.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblClientes.setBounds(48, 144, 68, 22);
		contentPane.add(lblClientes);
		
		JLabel lblAutos = new JLabel("Autos");
		lblAutos.setForeground(Color.WHITE);
		lblAutos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblAutos.setBounds(60, 299, 56, 22);
		contentPane.add(lblAutos);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setForeground(Color.WHITE);
		lblEmpleados.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblEmpleados.setBounds(44, 460, 106, 22);
		contentPane.add(lblEmpleados);
		
		JLabel lblReportes = new JLabel("Reportes");
		lblReportes.setForeground(Color.WHITE);
		lblReportes.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblReportes.setBounds(44, 624, 91, 22);
		contentPane.add(lblReportes);
		
		JLabel lblMantenimiento = new JLabel("Mantenimiento");
		lblMantenimiento.setForeground(Color.WHITE);
		lblMantenimiento.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblMantenimiento.setBounds(199, 144, 134, 22);
		contentPane.add(lblMantenimiento);
		
		JLabel lblHistorialAuto = new JLabel("Historial Auto");
		lblHistorialAuto.setForeground(Color.WHITE);
		lblHistorialAuto.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblHistorialAuto.setBounds(380, 144, 123, 22);
		contentPane.add(lblHistorialAuto);
		
		JLabel lblRepuestos = new JLabel("Repuestos");
		lblRepuestos.setForeground(Color.WHITE);
		lblRepuestos.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblRepuestos.setBounds(574, 144, 86, 22);
		contentPane.add(lblRepuestos);
		
		JLabel lblServicios = new JLabel("Servicios");
		lblServicios.setForeground(Color.WHITE);
		lblServicios.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblServicios.setBounds(756, 144, 86, 22);
		contentPane.add(lblServicios);
		
		JLabel lblProveedores = new JLabel("Proveedores");
		lblProveedores.setForeground(Color.WHITE);
		lblProveedores.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblProveedores.setBounds(924, 144, 106, 22);
		contentPane.add(lblProveedores);
		
		JLabel lblFacturaCompra = new JLabel("Factura Compra");
		lblFacturaCompra.setForeground(Color.WHITE);
		lblFacturaCompra.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblFacturaCompra.setBounds(1081, 144, 144, 22);
		contentPane.add(lblFacturaCompra);
		
		JLabel lblFacturaVenta = new JLabel("Factura Venta");
		lblFacturaVenta.setForeground(Color.WHITE);
		lblFacturaVenta.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblFacturaVenta.setBounds(1266, 144, 136, 22);
		contentPane.add(lblFacturaVenta);
		
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.setForeground(Color.WHITE);
		lblSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblSalir.setBounds(1494, 144, 68, 22);
		contentPane.add(lblSalir);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.RED);
		lblUsuario.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblUsuario.setBounds(631, 888, 97, 22);
		contentPane.add(lblUsuario);
		
		lblUsu = new JLabel(".........");
		lblUsu.setForeground(Color.WHITE);
		lblUsu.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblUsu.setBounds(732, 889, 228, 22);
		contentPane.add(lblUsu);
		
		
		
		
		HiloReloj hiloReloj = new  HiloReloj();
		hiloReloj.start();
		
	    botontransparente();
	}
	
	public void botontransparente(){
		
		btnSalir.setOpaque(false);
		btnSalir.setContentAreaFilled(false);
		btnSalir.setBorderPainted(false);
		
		btnClientes.setOpaque(false);
		btnClientes.setContentAreaFilled(false);
		btnClientes.setBorderPainted(false);
		
		btnReportes.setOpaque(false);
		btnReportes.setContentAreaFilled(false);
		btnReportes.setBorderPainted(false);
		
		btnEmpleado.setOpaque(false);
		btnEmpleado.setContentAreaFilled(false);
		btnEmpleado.setBorderPainted(false);
		
		btnAutos.setOpaque(false);
		btnAutos.setContentAreaFilled(false);
		btnAutos.setBorderPainted(false);
		
		btnManteniminto.setOpaque(false);
		btnManteniminto.setContentAreaFilled(false);
		btnManteniminto.setBorderPainted(false);
		
		btnHistorialAuto.setOpaque(false);
		btnHistorialAuto.setContentAreaFilled(false);
		btnHistorialAuto.setBorderPainted(false);
		
		btnrRepuesto.setOpaque(false);
		btnrRepuesto.setContentAreaFilled(false);
		btnrRepuesto.setBorderPainted(false);
		
		btnServicio.setOpaque(false);
		btnServicio.setContentAreaFilled(false);
		btnServicio.setBorderPainted(false);
		
		btnProveedores.setOpaque(false);
		btnProveedores.setContentAreaFilled(false);
		btnProveedores.setBorderPainted(false);
		
		btnFacturaVenta.setOpaque(false);
		btnFacturaVenta.setContentAreaFilled(false);
		btnFacturaVenta.setBorderPainted(false);
		
		btnFacturaCompra.setOpaque(false);
		btnFacturaCompra.setContentAreaFilled(false);
		btnFacturaCompra.setBorderPainted(false);
		
		
    

	
	}
}
