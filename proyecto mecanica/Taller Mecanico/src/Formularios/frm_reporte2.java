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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frm_reporte2 extends JFrame {

	private JPanel contentPane;
	private JTable tabla1;
	private JTextField txtN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_reporte2 frame = new frm_reporte2();
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
	public frm_reporte2() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
					
			}
		});
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 914, 587);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new LineBorder(Color.RED, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblReporteConEl = new JLabel("Reporte con el empleado que atendi\u00F3 m\u00E1s veh\u00EDculos");
		lblReporteConEl.setForeground(SystemColor.inactiveCaptionBorder);
		lblReporteConEl.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblReporteConEl.setBackground(Color.BLUE);
		lblReporteConEl.setBounds(38, 46, 753, 34);
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
		button.setBounds(810, 31, 59, 59);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 139, 821, 374);
		contentPane.add(scrollPane);
		
		tabla1 = new JTable();
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 17));
		scrollPane.setViewportView(tabla1);
		
		txtN = new JTextField();
		txtN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				cls_reportes re = new cls_reportes();
				 String[] cabecera={"ID","Nombre","Apellido","Cargo","Matenimiento","Placa","Marca","Modelo"};
				 Object datos2[][]=	re.consultarEmp(txtN.getText());
				 tabla1.setModel(new DefaultTableModel(datos2,cabecera) );	
			}
		});
		txtN.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtN.setBounds(154, 107, 119, 21);
		contentPane.add(txtN);
		txtN.setColumns(10);
		
		JLabel lblBuscarXNombre = new JLabel("Buscar x  Nombre:");
		lblBuscarXNombre.setForeground(Color.WHITE);
		lblBuscarXNombre.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 15));
		lblBuscarXNombre.setBounds(10, 111, 149, 17);
		contentPane.add(lblBuscarXNombre);
	}

}
