package Formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Button;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;


import Clases.DB_Conexion;
import Clases.cls_empleados;
import Clases.cls_usuario;


import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class frm_usuario extends JFrame {
	

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	
	private int cont=0;
	private JButton boton1;
	private JButton boton2;
	private JLabel lbl1;
	private JLabel lbl2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_usuario frame = new frm_usuario();
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
	
	public frm_usuario() {
		
		this.setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\coche.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				boton1.setEnabled(true);
				boton2.setEnabled(true);
				
				lbl1.setVisible(false);
				lbl2.setVisible(false);
			
			}
		});

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 413);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new LineBorder(new Color(0, 120, 215), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Usuario:");
		label.setForeground(new Color(0, 51, 255));
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label.setBounds(84, 184, 77, 22);
		contentPane.add(label);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				lbl1.setVisible(false);
				
			}
		});
		txtUsuario.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(197, 182, 202, 28);
		contentPane.add(txtUsuario);
		
		boton1 = new JButton("Ingresar");
		boton1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\kj.png"));
		boton1.setOpaque(false);
		boton1.setHorizontalAlignment(SwingConstants.LEFT);
		boton1.setForeground(Color.BLUE);
		boton1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		boton1.setContentAreaFilled(false);
		boton1.setBorderPainted(false);
		boton1.setBounds(31, 176, 58, 37);
		contentPane.add(boton1);
		
		JLabel label_1 = new JLabel("Contrase\u00F1a:");
		label_1.setForeground(new Color(0, 51, 255));
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		label_1.setBounds(84, 229, 115, 21);
		contentPane.add(label_1);
		
		boton2 = new JButton("Ingresar");
		boton2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\9u8y7u.png"));
		boton2.setOpaque(false);
		boton2.setHorizontalAlignment(SwingConstants.LEFT);
		boton2.setForeground(Color.BLUE);
		boton2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		boton2.setContentAreaFilled(false);
		boton2.setBorderPainted(false);
		boton2.setBounds(31, 220, 58, 37);
		contentPane.add(boton2);
		
		JButton btnIngresar = new JButton("");
		btnIngresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				ingresar();
				
		/*		if(validar_ingreso()>0){
					
					cls_empleados a = new cls_empleados();
					char[] arrayC = txtContraseña.getPassword(); 
					String pass = new String(arrayC); 
				        a.setUsuario(txtUsuario.getText());
						a.setContraseña(pass);
					a.acceder();
				}
				else
				{
					txtUsuario.setText("");
					txtContraseña.setText("");
					cont ++;
					JOptionPane.showMessageDialog(null," El Usuario no Existe","Advertencia", JOptionPane.WARNING_MESSAGE);
					
					if(cont ==3)
					{
						JOptionPane.showMessageDialog(null,"Intentos Superados","Advertencia", JOptionPane.WARNING_MESSAGE);
						System.exit(0);
					}
				}*/
			} 
		});
		btnIngresar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\portatil.png"));
		btnIngresar.setBounds(156, 296, 115, 63);
		contentPane.add(btnIngresar);
		
		JButton btnSalir = new JButton("");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\salida-de-emergency.png"));
		btnSalir.setBounds(310, 296, 108, 63);
		contentPane.add(btnSalir);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\logomorales.png"));
		label_3.setBounds(41, 21, 480, 63);
		contentPane.add(label_3);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\carreras.png"));
		label_2.setBounds(221, 106, 135, 52);
		contentPane.add(label_2);
		
		JLabel lblIngresar = new JLabel("Ingresar");
		lblIngresar.setForeground(Color.BLACK);
		lblIngresar.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblIngresar.setBounds(178, 370, 77, 21);
		contentPane.add(lblIngresar);
		
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.setForeground(Color.BLACK);
		lblSalir.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblSalir.setBounds(348, 370, 58, 21);
		contentPane.add(lblSalir);
		
		txtContraseña = new JPasswordField();
		txtContraseña.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				lbl2.setVisible(false);
			}
		});
		txtContraseña.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		txtContraseña.setBounds(197, 221, 202, 28);
		contentPane.add(txtContraseña);
		
		lbl2 = new JLabel("");
		lbl2.setIcon(new ImageIcon(frm_usuario.class.getResource("/imagenes/exclamation-mark.png")));
		lbl2.setBounds(409, 220, 37, 30);
		contentPane.add(lbl2);
		
		lbl1 = new JLabel("");
		lbl1.setIcon(new ImageIcon(frm_usuario.class.getResource("/imagenes/exclamation-mark.png")));
		lbl1.setBounds(409, 177, 37, 29);
		contentPane.add(lbl1);
	}
	
	
		protected void ingresar() {
			
			cls_empleados emp= new cls_empleados();
			char[] contraseña = txtContraseña.getPassword(); 
			String pass = new String(contraseña); 
		        emp.setUsuario(txtUsuario.getText());
				emp.setContraseña(pass);
				
			if(emp.acceder()==true){
			}
			else{
				cont++;
				lcajas();
				lbl1.setVisible(true);
				lbl2.setVisible(true);
				
			}
			if(cont==3){
				JOptionPane.showMessageDialog(null," Limite de Intentos Superados!!");
				System.exit(0);
			}
			
			

		} 
		/*
		public int validar_ingreso(){

		    String usuario = txtUsuario.getText();
		    char[] arrayC = txtContraseña.getPassword(); 
			String pass = new String(arrayC); 

		    int resultado=0;
		    
		    String SSQL="SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND contraseña='"+pass+"'";
		 
		    
		    DB_Conexion conex = new DB_Conexion();
		    //conexion cc = new conexion();
	        Connection cn = conex.Conectar();

		    try {
		    	
		    	
		        Statement psd = (Statement) cn.createStatement();
	            ResultSet rs = psd.executeQuery(SSQL);

		        if(rs.next()){

		            resultado=1;

		        }
		        

		    } catch (SQLException ex) {

		        //JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);

		    }

		return resultado;

		} */
		
		public void lcajas() {
			txtUsuario.setText("");
			txtContraseña.setText("");
		}
}
