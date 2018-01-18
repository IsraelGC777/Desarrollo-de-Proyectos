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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Clases.cls_autos;
import Clases.cls_reportes;

import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.SwingConstants;

public class frm_reporte1 extends JFrame {

	private JPanel contentPane;
	private JTable tabla1;
	private JTextField txtN;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtCedula;
	private JTextField txtDireccion;
	private JTextField txtMarca;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtAnio;
	private JTextField txtColor;
	private JTextField txtID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_reporte1 frame = new frm_reporte1();
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
	public frm_reporte1() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				cls_reportes em = new cls_reportes();
				 String[] cabecera={"ID","Placa","Marca","Modelo","Color","Año","Cedula","Nombre","Apellido","Dirección"};
					Object datos[][]=em.consultar1(txtN.getText());
					tabla1.setModel(new DefaultTableModel(datos,cabecera) );		
				
				txtN.setVisible(false);
				txtID.setVisible(false);
				
			}
		});
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 719);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(new Color(255, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(631, 488, 135, 26);
		contentPane.add(txtApellido);
		txtApellido.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtApellido.setColumns(10);
		
		JLabel lblReporteDeTodos = new JLabel("Reporte de todos los clientes y veh\u00EDculos registrados");
		lblReporteDeTodos.setForeground(SystemColor.inactiveCaptionBorder);
		lblReporteDeTodos.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblReporteDeTodos.setBackground(Color.BLUE);
		lblReporteDeTodos.setBounds(20, 32, 753, 34);
		contentPane.add(lblReporteDeTodos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 88, 951, 200);
		contentPane.add(scrollPane);
		
		tabla1 = new JTable();
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_reportes man = new cls_reportes();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla1.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));
				datos=man.datocarro(codigo);
			
				txtID.setText(datos[0]);
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
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(tabla1);
		
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
		button.setBounds(948, 11, 65, 66);
		contentPane.add(button);
		
		txtN = new JTextField();
		txtN.setBounds(705, 42, 79, 27);
		contentPane.add(txtN);
		txtN.setColumns(10);
		
		JLabel label = new JLabel("\"MECANICA MORALES\"");
		label.setBounds(364, 421, 359, 34);
		contentPane.add(label);
		label.setForeground(SystemColor.textHighlight);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		label.setBackground(Color.BLUE);
		
		JLabel lblElSerCliente = new JLabel("El  Sr/Sra. Cliente:");
		lblElSerCliente.setBounds(228, 481, 273, 34);
		contentPane.add(lblElSerCliente);
		lblElSerCliente.setForeground(Color.BLACK);
		lblElSerCliente.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblElSerCliente.setBackground(Color.BLUE);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(486, 488, 135, 26);
		contentPane.add(txtNombre);
		txtNombre.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtNombre.setColumns(10);
		
		JLabel label_2 = new JLabel("Portador del CI:");
		label_2.setBounds(316, 517, 241, 34);
		contentPane.add(label_2);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		label_2.setBackground(Color.BLUE);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(523, 525, 141, 26);
		contentPane.add(txtCedula);
		txtCedula.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtCedula.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F2n:");
		lblDireccion.setBounds(364, 553, 127, 34);
		contentPane.add(lblDireccion);
		lblDireccion.setForeground(Color.BLACK);
		lblDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblDireccion.setBackground(Color.BLUE);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(497, 560, 326, 26);
		contentPane.add(txtDireccion);
		txtDireccion.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtDireccion.setColumns(10);
		
		JLabel lblSuVehiculo = new JLabel("Su Vehiculo:");
		lblSuVehiculo.setBounds(261, 586, 161, 34);
		contentPane.add(lblSuVehiculo);
		lblSuVehiculo.setForeground(Color.BLACK);
		lblSuVehiculo.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblSuVehiculo.setBackground(Color.BLUE);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(422, 593, 135, 26);
		contentPane.add(txtMarca);
		txtMarca.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(567, 593, 135, 26);
		contentPane.add(txtModelo);
		txtModelo.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtModelo.setColumns(10);
		
		JLabel lblDeLasPlacas = new JLabel("Del A\u00F1o:");
		lblDeLasPlacas.setBounds(281, 616, 186, 34);
		contentPane.add(lblDeLasPlacas);
		lblDeLasPlacas.setForeground(Color.BLACK);
		lblDeLasPlacas.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblDeLasPlacas.setBackground(Color.BLUE);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(389, 623, 135, 26);
		contentPane.add(txtAnio);
		txtAnio.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtAnio.setColumns(10);
		
		JLabel label_1 = new JLabel("De las Placas:");
		label_1.setBounds(554, 616, 186, 34);
		contentPane.add(label_1);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		label_1.setBackground(Color.BLUE);
		
		txtPlaca = new JTextField();
		txtPlaca.setBounds(729, 623, 135, 26);
		contentPane.add(txtPlaca);
		txtPlaca.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtPlaca.setColumns(10);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(399, 651, 82, 34);
		contentPane.add(lblColor);
		lblColor.setForeground(Color.BLACK);
		lblColor.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblColor.setBackground(Color.BLUE);
		
		txtColor = new JTextField();
		txtColor.setBounds(475, 658, 135, 26);
		contentPane.add(txtColor);
		txtColor.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		txtColor.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(72, 299, 951, 400);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\3c7b4448a6afd54529c93ec12fba5a12.png"));
		
		txtID = new JTextField();
		txtID.setBounds(814, 477, 68, 26);
		contentPane.add(txtID);
		txtID.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		txtID.setColumns(10);
	}
}
