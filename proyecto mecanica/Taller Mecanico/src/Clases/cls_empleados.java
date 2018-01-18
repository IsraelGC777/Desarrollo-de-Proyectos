package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Formularios.frm_empleados;
import Formularios.frm_menu;


public class cls_empleados {
	private int codigo;
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String genero;
	private String telefono;
	private String celular;
	private String correo;
	private String cargo;
	private String usuario;
	private String contraseña;
	
	 private int cont=0;

	
////////////////7LOGIN///////////////////////////////////////////////////////////////////////////////
public   boolean acceder()
{ 
	 DB_Conexion conex = new DB_Conexion();
	 	String emp=" ";
	try {
		String sql="SELECT * FROM empleados WHERE usuario = ? && contraseña = ?";
		PreparedStatement st = conex.Conectar().prepareStatement(sql);
		st.setString(1, getUsuario());
		st.setString(2, getContraseña());
		ResultSet rs=st.executeQuery();
		
		while (rs.next()) {
			
			emp =rs.getString("cargo");
			
		}
		
		if(emp.equals("MECANICO GENERAL")){
	        JOptionPane.showMessageDialog(null,"Bienvenido "+emp);	
	        frm_menu a=new frm_menu(); 
	        a.setVisible(true);
	       this.setVisible(false);
	       a.lblUsu.setText(getUsuario());
		}
		if(emp.equals("TECNICO AUTOMOTRIZ")){
	        JOptionPane.showMessageDialog(null,"Bienvenido "+emp);	
	        frm_menu a=new frm_menu(); 
	        a.setVisible(true);
	       this.setVisible(false);
	       a.lblUsu.setText(getUsuario());
		}
		if(emp.equals("OFICIAL")){
	        JOptionPane.showMessageDialog(null,"Bienvenido "+emp);	
	        frm_menu a=new frm_menu(); 
	        a.setVisible(true);
	       this.setVisible(false);
	       a.lblUsu.setText(getUsuario());
		}
		
		
		if((!emp.equals("MECANICO GENERAL")) &&(!emp.equals("TECNICO AUTOMOTRIZ"))&&(!emp.equals("OFICIAL"))){
			frm_empleados em = new frm_empleados();
			JOptionPane.showMessageDialog(em, "Datos invalidos", "Error", JOptionPane.ERROR_MESSAGE);
			cont++;
		}
		/*if(cont>3){
			JOptionPane.showMessageDialog(null,"Limite de Intentos Superados!");
			System.exit(0);
		}*/
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	return false;
}


private void setVisible(boolean b) {
// TODO Auto-generated method stub

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////insertar/////////////////////////////////////////////////////////////////////////////////
	public boolean insertar(){
		DB_Conexion conex = new DB_Conexion();
		
		try {
			String sql ="INSERT INTO empleados (cedula ,nombre, apellido, direccion, genero, telefono, celular, correo,  cargo, usuario, contraseña) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);
			
			st.setString(1, getCedula());
			st.setString(2, getNombre());
			st.setString(3, getApellido());
			st.setString(4, getDireccion());
			st.setString(5, getGenero());
			st.setString(6, getTelefono());
			st.setString(7, getCelular());
			st.setString(8, getCorreo());
			st.setString(9, getCargo());
			st.setString(10, getUsuario());
			st.setString(11, getContraseña());
			
			int row = st.executeUpdate();
			 if(row >0){
				 return true;
			 }

         } catch (Exception e) {
	            System.out.println(e);
	         return false;
             }
           return false;
     }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////CONSULTAR nombre////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar1(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT idEmpleados, cedula, nombre, apellido,	direccion, genero,  telefono, celular, correo,  cargo, usuario, contraseña FROM empleados WHERE empleados.nombre like ?";
			PreparedStatement st= conex.Conectar().prepareStatement(sql);
		st.setString(1, "%"+nombre+"%");
		ResultSet result = st.executeQuery();
		result.last();
		java.sql.ResultSetMetaData rsm =result.getMetaData();
	
	
		int numCol = rsm.getColumnCount();
		int numFil = result.getRow();
		obj = new Object[numFil][numCol];
		result.beforeFirst();
		int  j=0;
		while(result.next()){
			for(int a=0; a<=numCol-1; a++){
				obj[j][a]= result.getObject(a+1);
			}
			j++;
		}
	
		} catch (Exception e) {
			System.out.println(e);
		}
		return obj;
	}  
////////////////////////////////////////////////////////////////////////////////////////////////////////
	 ///////////////////ACTUALIZAR///////////////////
	 public boolean actualizar(){	
		 DB_Conexion conex=new DB_Conexion();
			
			try {
				String sql = "UPDATE empleados SET cedula=? ,nombre=?, apellido=?,	direccion=?, genero=?,  telefono=?, celular=?, correo=?,  cargo=?, usuario=?, contraseña=? WHERE idEmpleados=?";
				PreparedStatement st = conex.Conectar().prepareStatement(sql);
				        
				st.setString(1, getCedula());
				st.setString(2, getNombre());
				st.setString(3, getApellido());
				st.setString(4, getDireccion());
				st.setString(5, getGenero());
				st.setString(6, getTelefono());
				st.setString(7, getCelular());
				st.setString(8, getCorreo());
				st.setString(9, getCargo());
				st.setString(10, getUsuario());
				st.setString(11, getContraseña());
				st.setInt(12, getCodigo());
				
				
						int row = st.executeUpdate();
						
						if(row>0){
							return true;				
						}	
						else{
							return false;
						}
							
			} catch (Exception e) {
				System.out.println(e);
				
			}
			return false;
		}
	 
/////////////////eliminar///////////////////////////////////////////////////////////////////////////////	  
	 public boolean Eliminar(){	
		 DB_Conexion conex = new DB_Conexion();
		 try {
			 String sql = "DELETE FROM  empleados WHERE idEmpleados=?";
			 PreparedStatement st= conex.Conectar().prepareStatement(sql);

			 st.setInt(1, getCodigo());


			 int row = st.executeUpdate();

			 if(row>0){
				 return true;				
			 }	
			 else{
				 return false;
			 }

		 } catch (Exception e) {
			 System.out.println(e.getMessage());

		 }
		 return false;
	 }
////////////////SELECIONAR TABLA/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	 public String[] datoEmpleado(String codigo){
			String datos[] = new String [12];
			 DB_Conexion conex=new DB_Conexion();
			try {
				String sql="SELECT * FROM empleados WHERE idEmpleados=?";
				PreparedStatement st = conex.Conectar().prepareStatement(sql);
				st.setString(1,codigo);
				ResultSet rs = st.executeQuery();
				while(rs.next()){
					datos[0]=rs.getString(1);
					datos[1]=rs.getString(2);
					datos[2]=rs.getString(3);
					datos[3]=rs.getString(4);
					datos[4]=rs.getString(5);
					datos[5]=rs.getString(6);
					datos[6]=rs.getString(7);
					datos[7]=rs.getString(8);
					datos[8]=rs.getString(9);
					datos[9]=rs.getString(10);
					datos[10]=rs.getString(11);
					datos[11]=rs.getString(12);
				}
				
			} catch (Exception e) {
				System.out.println(e);
				
			}
			return datos;
		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	 
	 
	public String getNombre() {
		return nombre;
	}
	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getCont() {
		return cont;
	}


	public void setCont(int cont) {
		this.cont = cont;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	

}
