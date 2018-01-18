package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;

import Clases.cls_repuestos;
import Clases.cls_servicio;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class frm_servicios extends JFrame {

	
	private int bandera;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextPane txtDetalle;
	private JTextField txtIDser;
	private JTextField txtPrecio;
	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnGuardarX;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private JTextField txtN;
	private JTable tabla1;
	private JButton button;
	private JLabel label_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frm_servicios frame = new frm_servicios();
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
	public frm_servicios() {
		this.setUndecorated(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\coche.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				cls_servicio ser = new cls_servicio();
				 String[] cabecera={"ID","Detalle","Nombre del Servico","Precio"};
					Object datos[][]=ser.consultar(txtN.getText());
					tabla1.setModel(new DefaultTableModel(datos,cabecera) );
				
				txtIDser.setVisible(false);
				bcajas();
				bbotones();
				btnAgregar.setEnabled(true);
				bandera=0;
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 660);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.info);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(SystemColor.textHighlight, 3));
		panel.setBackground(SystemColor.info);
		panel.setBounds(0, 0, 566, 660);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(22, 160, 523, 285);
		panel.add(panel_1);
		
		txtNombre = new JTextField();
		txtNombre.setForeground(new Color(0, 0, 153));
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNombre.setColumns(10);
		txtNombre.setBounds(47, 31, 400, 26);
		panel_1.add(txtNombre);
		
		JLabel lblNuevoServicio = new JLabel("Nombre del Servicio:");
		lblNuevoServicio.setForeground(SystemColor.desktop);
		lblNuevoServicio.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblNuevoServicio.setBackground(Color.BLUE);
		lblNuevoServicio.setBounds(10, 11, 146, 19);
		panel_1.add(lblNuevoServicio);
		
		JLabel label = new JLabel("Detalle:");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		label.setBackground(Color.BLUE);
		label.setBounds(23, 68, 75, 26);
		panel_1.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 102, 399, 111);
		panel_1.add(scrollPane);
		
		txtDetalle = new JTextPane();
		txtDetalle.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setViewportView(txtDetalle);
		txtDetalle.setForeground(new Color(0, 0, 153));
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblPrecio.setBackground(Color.BLUE);
		lblPrecio.setBounds(33, 238, 53, 19);
		panel_1.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setForeground(new Color(0, 0, 153));
		txtPrecio.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(78, 235, 96, 26);
		panel_1.add(txtPrecio);
		
		JLabel lblServicios = new JLabel("SERVICIOS");
		lblServicios.setBounds(222, 11, 138, 34);
		panel.add(lblServicios);
		lblServicios.setForeground(Color.RED);
		lblServicios.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		lblServicios.setBackground(Color.BLUE);
		
		txtIDser = new JTextField();
		txtIDser.setForeground(new Color(0, 0, 153));
		txtIDser.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtIDser.setColumns(10);
		txtIDser.setBounds(23, 115, 42, 26);
		panel.add(txtIDser);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\archivo.png"));
		btnAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				acajas();
				bbotones();
				btnGuardarX.setEnabled(true);
				btnCancelar.setEnabled(true);
				bandera=1;
				
				
			}
		});
		btnAgregar.setForeground(SystemColor.textHighlight);
		btnAgregar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnAgregar.setBounds(36, 56, 134, 39);
		panel.add(btnAgregar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\actualizar.png"));
		btnActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				acajas();
				bbotones();
				btnGuardarX.setEnabled(true);
				btnCancelar.setEnabled(true);
				bandera=2;
			}
		});
		btnActualizar.setForeground(SystemColor.textHighlight);
		btnActualizar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnActualizar.setBounds(177, 56, 152, 39);
		panel.add(btnActualizar);
		
		btnGuardarX = new JButton("Guardar");
		btnGuardarX.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\disquete.png"));
		btnGuardarX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_servicio ser = new cls_servicio();
				
				ser.setNombre(txtNombre.getText());
				ser.setDetalle_serv(txtDetalle.getText());
				ser.setManoObra(Double.parseDouble(txtPrecio.getText().toString()));
				ser.setCodigo(txtIDser.getText());
			
				if(bandera==1){
					
					if(ser.insertar()==true){
					
					JOptionPane.showMessageDialog(null,"Registro Guardado");
				}
				
				else{
					JOptionPane.showMessageDialog(null, "Error al Registrar");
				  }
				}
				
				if(bandera==2){
					if(ser.actualizar()==true){
						
						JOptionPane.showMessageDialog(null,"Registro Actualizado");
					}
					
					else{
						JOptionPane.showMessageDialog(null, "Error al Actualizar");
					  }
					
				}
				    bandera=0;
				    lcajas();
					bcajas();
					bbotones();
				    btnAgregar.setEnabled(true);
				

			
			}
		});
		btnGuardarX.setForeground(SystemColor.textHighlight);
		btnGuardarX.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnGuardarX.setBounds(335, 56, 134, 39);
		panel.add(btnGuardarX);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\cancelar.png"));
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				bcajas();
				lcajas();
				bbotones();
				btnAgregar.setEnabled(true);
			}
		});
		btnCancelar.setForeground(SystemColor.textHighlight);
		btnCancelar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnCancelar.setBounds(112, 102, 134, 39);
		panel.add(btnCancelar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\goma-de-borrar.png"));
		btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cls_servicio ser = new cls_servicio();
				ser.setCodigo(txtIDser.getText());
				if(ser.Eliminar()) {
					JOptionPane.showMessageDialog(null, "Registro Eliminado");
				}else {
					JOptionPane.showMessageDialog(null, "Error al Eliminar");
				}
			}
		});
		btnEliminar.setForeground(SystemColor.textHighlight);
		btnEliminar.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnEliminar.setBounds(251, 102, 134, 39);
		panel.add(btnEliminar);
		scrollPane_1.setBounds(22, 506, 523, 126);
		panel.add(scrollPane_1);
		
		tabla1 = new JTable();
		tabla1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				cls_servicio ser = new cls_servicio();
				String datos[] = null;
				DefaultTableModel tm = (DefaultTableModel) tabla1.getModel();
				String codigo=String.valueOf(tm.getValueAt(tabla1.getSelectedRow(),0));
				datos=ser.datoSer(codigo);
			
				txtIDser.setText(datos[0]);
				txtDetalle.setText(datos[1]);
				txtNombre.setText(datos[2]);
				txtPrecio.setText(datos[3]);
				
				
				bbotones();
				btnActualizar.setEnabled(true);
				btnCancelar.setEnabled(true);
				btnEliminar.setEnabled(true);
				
				
				
				
			}
		});
		tabla1.setFont(new Font("Tahoma", Font.BOLD, 18));
		scrollPane_1.setViewportView(tabla1);
		
		JLabel lblSevicio = new JLabel("Buscar Sevicio:");
		lblSevicio.setForeground(Color.BLACK);
		lblSevicio.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblSevicio.setBackground(Color.BLUE);
		lblSevicio.setBounds(22, 476, 97, 19);
		panel.add(lblSevicio);
		
		txtN = new JTextField();
		txtN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				cls_servicio ser = new cls_servicio();
				 String[] cabecera={"ID","Detalle","Nombre del Servico","Precio"};
					Object datos[][]=ser.consultar(txtN.getText());
					tabla1.setModel(new DefaultTableModel(datos,cabecera) );
				
			}
		});
		txtN.setForeground(new Color(0, 0, 153));
		txtN.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		txtN.setColumns(10);
		txtN.setBounds(125, 473, 138, 26);
		panel.add(txtN);
		
		button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\flecha-hacia-la-izquierda (1).png"));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hide();
			}
		});
		button.setForeground(new Color(0, 0, 205));
		button.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		button.setBounds(492, 11, 64, 57);
		panel.add(button);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\iconos aplicaciones\\mecanica\\menu\\herramientas-del-empleado-de-mantenimiento.png"));
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
		label_1.setBackground(Color.BLUE);
		label_1.setBounds(188, 11, 64, 34);
		panel.add(label_1);
	}
	
	public void acajas(){
		txtNombre.setEnabled(true);
		txtPrecio.setEnabled(true);
		txtDetalle.setEnabled(true);
	}
	
	public void bcajas(){
		txtNombre.setEnabled(false);
		txtPrecio.setEnabled(false);
		txtDetalle.setEnabled(false);
	}
	public void lcajas(){
		txtNombre.setText("");
		txtPrecio.setText("");
		txtDetalle.setText("");
	}
	public void bbotones(){
		btnAgregar.setEnabled(false);
		btnGuardarX.setEnabled(false);
		btnActualizar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnCancelar.setEnabled(false);
	}
	
	
}


