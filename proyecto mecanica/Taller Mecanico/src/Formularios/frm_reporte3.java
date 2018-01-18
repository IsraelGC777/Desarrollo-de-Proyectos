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

import Clases.cls_reportes;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;

public class frm_reporte3 extends JFrame {

	private JPanel contentPane;
	private JTable tabla1;
	private JTable tabla2;
	private JTextField txtN;
	private JTextField txtN2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_reporte3 frame = new frm_reporte3();
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
	public frm_reporte3() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				cls_reportes re = new cls_reportes();
				String[] cabecera={"ID","Repuesto","Precio"};
				Object datos[][]=re.consultarX1(txtN.getText());
				tabla1.setModel(new DefaultTableModel(datos,cabecera) );	
				
				String[] cabecera2={"ID","Repuesto","Precio"};
				Object datos2[][]=re.consultarX2(txtN2.getText());
				tabla2.setModel(new DefaultTableModel(datos2,cabecera2) );	
				
			}
		});
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 628);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(Color.RED, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReportesDelListado = new JLabel("Reportes del listado de los repuestos que m\u00E1s se venden \r\n");
		lblReportesDelListado.setForeground(SystemColor.inactiveCaptionBorder);
		lblReportesDelListado.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblReportesDelListado.setBackground(Color.BLUE);
		lblReportesDelListado.setBounds(30, 51, 810, 86);
		contentPane.add(lblReportesDelListado);
		
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
		button.setBounds(775, 28, 59, 55);
		contentPane.add(button);
		
		JLabel lblRepuestosQueMenos = new JLabel("Repuestos que menos ser venden");
		lblRepuestosQueMenos.setForeground(SystemColor.inactiveCaptionBorder);
		lblRepuestosQueMenos.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblRepuestosQueMenos.setBackground(Color.BLUE);
		lblRepuestosQueMenos.setBounds(30, 307, 810, 86);
		contentPane.add(lblRepuestosQueMenos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 174, 800, 148);
		contentPane.add(scrollPane);
		
		tabla1 = new JTable();
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 17));
		scrollPane.setViewportView(tabla1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(30, 415, 800, 148);
		contentPane.add(scrollPane_1);
		
		tabla2 = new JTable();
		tabla2.setFont(new Font("Tahoma", Font.BOLD, 17));
		scrollPane_1.setViewportView(tabla2);
		
		JLabel lblBuscarXRepuesto_1 = new JLabel("Buscar x Repuesto:");
		lblBuscarXRepuesto_1.setForeground(Color.WHITE);
		lblBuscarXRepuesto_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblBuscarXRepuesto_1.setBounds(10, 146, 149, 17);
		contentPane.add(lblBuscarXRepuesto_1);
		
		txtN = new JTextField();
		txtN.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtN.setColumns(10);
		txtN.setBounds(154, 142, 119, 21);
		contentPane.add(txtN);
		
		JLabel lblBuscarXRepuesto = new JLabel("Buscar x  Repuesto:");
		lblBuscarXRepuesto.setForeground(Color.WHITE);
		lblBuscarXRepuesto.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblBuscarXRepuesto.setBounds(10, 387, 149, 17);
		contentPane.add(lblBuscarXRepuesto);
		
		txtN2 = new JTextField();
		txtN2.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtN2.setColumns(10);
		txtN2.setBounds(154, 383, 119, 21);
		contentPane.add(txtN2);
	}

}
