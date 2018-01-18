package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Clases.cls_proveedores;
import Clases.cls_reportes;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class frm_reporte5 extends JFrame {

	private JPanel contentPane;
	private JTable tabla1;
	private JTextField txtN;
	private JLabel label_1;
	private JLabel lblLaEmpresa;
	private JTextField txtNombre;
	private JLabel lblPortadorDelCi;
	private JLabel lblDireccin;
	private JTextField txtDireccion;
	private JLabel label_2;
	private JTextField txtRuc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_reporte5 frame = new frm_reporte5();
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
	public frm_reporte5() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				cls_reportes pr = new cls_reportes();
				String[] cabecera={"Ruc","Empresa","Direccion","Telèfono","Celular","Correo"};
				Object datos[][]=pr.consultar5(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );
				txtN.setVisible(false);
			}
		});
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1054, 777);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(Color.RED, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
		});
		
		txtRuc = new JTextField();
		txtRuc.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtRuc.setColumns(10);
		txtRuc.setBounds(561, 535, 254, 26);
		contentPane.add(txtRuc);
		
		label_2 = new JLabel("\"MECANICA MORALES\"");
		label_2.setForeground(SystemColor.textHighlight);
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		label_2.setBackground(Color.BLUE);
		label_2.setBounds(337, 432, 359, 34);
		contentPane.add(label_2);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtNombre.setColumns(10);
		txtNombre.setBounds(383, 502, 322, 26);
		contentPane.add(txtNombre);
		
		lblDireccin = new JLabel("Direcci\u00F2n:");
		lblDireccin.setForeground(Color.BLACK);
		lblDireccin.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblDireccin.setBackground(Color.BLUE);
		lblDireccin.setBounds(324, 591, 142, 34);
		contentPane.add(lblDireccin);
		
		lblPortadorDelCi = new JLabel("Portador del CI - Ruc:");
		lblPortadorDelCi.setForeground(Color.BLACK);
		lblPortadorDelCi.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblPortadorDelCi.setBackground(Color.BLUE);
		lblPortadorDelCi.setBounds(278, 527, 322, 34);
		contentPane.add(lblPortadorDelCi);
		
		lblLaEmpresa = new JLabel("La Empresa:");
		lblLaEmpresa.setForeground(Color.BLACK);
		lblLaEmpresa.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblLaEmpresa.setBackground(Color.BLUE);
		lblLaEmpresa.setBounds(233, 495, 273, 34);
		contentPane.add(lblLaEmpresa);
		
		txtDireccion = new JTextField();
		txtDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(448, 597, 367, 28);
		contentPane.add(txtDireccion);
		button.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\flecha-hacia-la-izquierda (1).png"));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(967, 22, 65, 66);
		contentPane.add(button);
		
		JLabel label = new JLabel("Reporte con el Listado de todos los proveedores");
		label.setForeground(SystemColor.inactiveCaptionBorder);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		label.setBackground(Color.BLUE);
		label.setBounds(64, 68, 753, 34);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(58, 113, 924, 168);
		contentPane.add(scrollPane);
		
		tabla1 = new JTable();
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cls_reportes pr = new cls_reportes();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla1.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));
				datos=pr.datoPr(codigo);
			
				//txtIDpr.setText(datos[0]);
				txtRuc.setText(datos[0]);
				txtNombre.setText(datos[1]);
				txtDireccion.setText(datos[2]);
			}
		});
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 17));
		scrollPane.setViewportView(tabla1);
		
		txtN = new JTextField();
		txtN.setBounds(668, 69, 86, 20);
		contentPane.add(txtN);
		txtN.setColumns(10);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\3c7b4448a6afd54529c93ec12fba5a12.png"));
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setBounds(58, 309, 924, 389);
		contentPane.add(label_1);
	}
}
