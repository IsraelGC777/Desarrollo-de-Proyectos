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
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Clases.cls_reportes;

import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;

public class frm_reporte6 extends JFrame {

	private JPanel contentPane;
	private JTable tabla2;
	private JTable tabla1;
	private JTextField txtN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_reporte6 frame = new frm_reporte6();
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
	public frm_reporte6() {
		this.setUndecorated(true);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				txtN.setVisible(false);
				cls_reportes re = new cls_reportes();
				String[] cabecera={"ID","Placa","Marca","Modelo","Color","Año","Cilindraje"};
				Object datos[][]=re.consultarC1(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );	
				
				String[] cabecera2={"Total de Vehìculos"};
				Object datos2[][]=re.consultarC2(txtN.getText());
				tabla2.setModel(new DefaultTableModel(datos2,cabecera2) );	
			}
		});
		setBounds(100, 100, 907, 515);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(Color.RED, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReporteDelTotal = new JLabel("Reporte del total de vehiculos ingresados a la Mecanica ");
		lblReporteDelTotal.setForeground(SystemColor.inactiveCaptionBorder);
		lblReporteDelTotal.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblReporteDelTotal.setBackground(Color.BLUE);
		lblReporteDelTotal.setBounds(65, 69, 753, 34);
		contentPane.add(lblReporteDelTotal);
		
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
		button.setBounds(801, 23, 65, 66);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 131, 759, 268);
		contentPane.add(scrollPane);
		
		tabla1 = new JTable();
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 17));
		scrollPane.setViewportView(tabla1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(323, 424, 207, 41);
		contentPane.add(scrollPane_1);
		
		tabla2 = new JTable();
		tabla2.setFont(new Font("Tahoma", Font.BOLD, 20));
		scrollPane_1.setViewportView(tabla2);
		
		txtN = new JTextField();
		txtN.setBounds(38, 11, 54, 13);
		contentPane.add(txtN);
		txtN.setColumns(10);
	}
}
