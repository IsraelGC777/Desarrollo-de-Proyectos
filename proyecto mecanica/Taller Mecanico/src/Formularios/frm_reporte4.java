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

import Clases.cls_empleados;
import Clases.cls_reportes;

import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;

public class frm_reporte4 extends JFrame {

	private JPanel contentPane;
	private JTable tabla1;
	private JTextField txtN;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCargo;
	private JLabel lblXxxx;
	private JLabel lblPortadorDelCi;
	private JLabel lblCargoQueDesempea;
	private JLabel lblmecanicaMorales;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_reporte4 frame = new frm_reporte4();
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
	public frm_reporte4() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				cls_reportes emp = new cls_reportes();
	
                String[] cabecera={"ID","Cedula","Nombre","Apellido","Dirección","Genero","Teléfono","Celular","Correo","Cargo","Usuario","Contraseña"};
				Object datos[][]=emp.consultar4(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );		
				txtN.setVisible(false);
			}
		});
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 757);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(Color.RED, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(605, 587, 254, 28);
		contentPane.add(txtCargo);
		txtCargo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtCargo.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(616, 492, 135, 26);
		contentPane.add(txtApellido);
		txtApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtApellido.setColumns(10);
		
		lblPortadorDelCi = new JLabel("Portador del CI:");
		lblPortadorDelCi.setBounds(365, 519, 202, 34);
		contentPane.add(lblPortadorDelCi);
		lblPortadorDelCi.setForeground(Color.BLACK);
		lblPortadorDelCi.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblPortadorDelCi.setBackground(Color.BLUE);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(573, 526, 141, 26);
		contentPane.add(txtCedula);
		txtCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtCedula.setColumns(10);
		
		lblCargoQueDesempea = new JLabel("Cargo que desempe\u00F1a en la empresa:");
		lblCargoQueDesempea.setBounds(157, 587, 486, 34);
		contentPane.add(lblCargoQueDesempea);
		lblCargoQueDesempea.setForeground(Color.BLACK);
		lblCargoQueDesempea.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblCargoQueDesempea.setBackground(Color.BLUE);
		
		lblmecanicaMorales = new JLabel("\"MECANICA MORALES\"");
		lblmecanicaMorales.setBounds(319, 420, 359, 34);
		contentPane.add(lblmecanicaMorales);
		lblmecanicaMorales.setForeground(SystemColor.textHighlight);
		lblmecanicaMorales.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblmecanicaMorales.setBackground(Color.BLUE);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(471, 492, 135, 26);
		contentPane.add(txtNombre);
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtNombre.setColumns(10);
		
		lblXxxx = new JLabel("El  Sr/Sra. Mecanico:");
		lblXxxx.setBounds(196, 485, 273, 34);
		contentPane.add(lblXxxx);
		lblXxxx.setForeground(Color.BLACK);
		lblXxxx.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblXxxx.setBackground(Color.BLUE);
		
		JLabel label = new JLabel("");
		label.setBounds(34, 299, 924, 388);
		contentPane.add(label);
		label.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\3c7b4448a6afd54529c93ec12fba5a12.png"));
		label.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lblReporteConEl = new JLabel("Reporte con el Listado de todos los empleados");
		lblReporteConEl.setForeground(SystemColor.inactiveCaptionBorder);
		lblReporteConEl.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblReporteConEl.setBackground(Color.BLUE);
		lblReporteConEl.setBounds(55, 66, 753, 34);
		contentPane.add(lblReporteConEl);
		
		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
			
		});
		button.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\flecha-hacia-la-izquierda (1).png"));
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setBounds(866, 23, 65, 66);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 125, 872, 146);
		contentPane.add(scrollPane);
		
		tabla1 = new JTable();
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cls_reportes man = new cls_reportes();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla1.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));
				datos=man.datoEmpleado(codigo);
				
				
				txtCedula.setText(datos[0]);
				txtNombre.setText(datos[1]);
				txtApellido.setText(datos[2]);
				
				txtCargo.setText(datos[3]);
			}
		});
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 17));
		scrollPane.setViewportView(tabla1);
		
		txtN = new JTextField();
		txtN.setBounds(649, 83, 65, 12);
		contentPane.add(txtN);
		txtN.setColumns(10);
	}
}
