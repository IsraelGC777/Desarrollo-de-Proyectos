package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class frm_reportes extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_reportes frame = new frm_reportes();
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
	public frm_reportes() {
		this.setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 896, 760);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(new Color(255, 0, 0), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Reportes = new JLabel("REPORTES");
		Reportes.setForeground(Color.RED);
		Reportes.setFont(new Font("Comic Sans MS", Font.BOLD, 39));
		Reportes.setBackground(Color.BLUE);
		Reportes.setBounds(309, 11, 204, 44);
		contentPane.add(Reportes);
		
		JButton btnReporteDeTodos = new JButton("Reporte de todos los clientes y veh\u00EDculos registrados");
		btnReporteDeTodos.setBackground(Color.BLACK);
		btnReporteDeTodos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_reporte1 a = new frm_reporte1();
				
				a.setVisible(true);
			}
		});
		btnReporteDeTodos.setForeground(Color.RED);
		btnReporteDeTodos.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnReporteDeTodos.setBounds(73, 103, 683, 54);
		contentPane.add(btnReporteDeTodos);
		
		JButton btnReporteConEl_1 = new JButton("Reporte con el Listado de todos los empleados");
		btnReporteConEl_1.setBackground(Color.BLACK);
		btnReporteConEl_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_reporte4 a = new frm_reporte4();
			
			a.setVisible(true);
			}
		});
		btnReporteConEl_1.setForeground(Color.RED);
		btnReporteConEl_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnReporteConEl_1.setBounds(73, 416, 683, 54);
		contentPane.add(btnReporteConEl_1);
		
		JButton btnReporteDelTotal = new JButton("Reporte del total de vehiculos ingresados a la Mecanica Morales");
		btnReporteDelTotal.setBackground(Color.BLACK);
		btnReporteDelTotal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_reporte6 a = new frm_reporte6();
				
				a.setVisible(true);
			}
		});
		btnReporteDelTotal.setForeground(Color.RED);
		btnReporteDelTotal.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnReporteDelTotal.setBounds(73, 625, 683, 54);
		contentPane.add(btnReporteDelTotal);
		
		JButton btnReporteConEl = new JButton("Reporte con el empleado que atendi\u00F3 m\u00E1s veh\u00EDculos");
		btnReporteConEl.setBackground(Color.BLACK);
		btnReporteConEl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_reporte2 a = new frm_reporte2();
				
				a.setVisible(true);
			}
		});
		btnReporteConEl.setForeground(Color.RED);
		btnReporteConEl.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnReporteConEl.setBounds(73, 205, 683, 54);
		contentPane.add(btnReporteConEl);
		
		JButton btnReportesDelListado = new JButton("Reportes del listado de los repuestos que m\u00E1s se venden ");
		btnReportesDelListado.setBackground(Color.BLACK);
		btnReportesDelListado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_reporte3 a = new frm_reporte3();
				
				a.setVisible(true);
			}
		});
		btnReportesDelListado.setForeground(Color.RED);
		btnReportesDelListado.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnReportesDelListado.setBounds(73, 311, 683, 54);
		contentPane.add(btnReportesDelListado);
		
		JButton button_5 = new JButton("");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
		});
		button_5.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\flecha-hacia-la-izquierda (1).png"));
		button_5.setOpaque(false);
		button_5.setContentAreaFilled(false);
		button_5.setBorderPainted(false);
		button_5.setBounds(801, 23, 59, 60);
		contentPane.add(button_5);
		
		JButton btnReporteConEl_2 = new JButton("Reporte con el Listado de todos los provedores");
		btnReporteConEl_2.setBackground(Color.BLACK);
		btnReporteConEl_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frm_reporte5 a = new frm_reporte5();
				
				a.setVisible(true);
			}
		});
		btnReporteConEl_2.setForeground(Color.RED);
		btnReporteConEl_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnReporteConEl_2.setBounds(73, 520, 683, 54);
		contentPane.add(btnReporteConEl_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\periodico.png"));
		label.setForeground(Color.RED);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		label.setBackground(Color.BLUE);
		label.setBounds(237, 0, 88, 81);
		contentPane.add(label);
	}
}
