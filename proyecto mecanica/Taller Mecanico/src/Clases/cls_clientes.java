package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class cls_clientes {
	
	
	private int cogido;
	private String cedula;
	private String nombre;
	private String apellido;
	private String direccion;
	private String genero;
	private String telefono;
	private String celular;
	private String correo;
	


	////////insertar/////////////////////////////////////////////////////////////////////////////////////////
	public boolean insertar(){
DB_Conexion conex = new DB_Conexion();
		
		try {
			String sql ="INSERT INTO clientes (cedula ,nombre, apellido, direccion, genero,  telefono, celular, correo) VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);
			
			st.setString(1, getCedula());
			st.setString(2, getNombre());
			st.setString(3, getApellido());
			st.setString(4, getDireccion());
			st.setString(5, getGenero());
			st.setString(6, getTelefono());
			st.setString(7, getCelular());
			st.setString(8, getCorreo());
			
			
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
	
///////////////consultar//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultarcl(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT * FROM clientes WHERE clientes.nombre like ?";
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
		 DB_Conexion conex = new DB_Conexion();
			try {
				String sql = "UPDATE clientes SET cedula=? ,nombre=?, apellido=?, direccion=?, genero=?,  telefono=?, celular=?, correo=?  WHERE idClientes=?";
				PreparedStatement st= conex.Conectar().prepareStatement(sql);
				        
				
				st.setString(1, getCedula());
				st.setString(2, getNombre());
				st.setString(3, getApellido());
				st.setString(4, getDireccion());
				st.setString(5, getGenero());
				st.setString(6, getTelefono());
				st.setString(7, getCelular());
				st.setString(8, getCorreo());
				st.setInt(9, getCogido());
				
				
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
	 
/////////////////////////////////////////////////////////////////////////////////////////////////	  
	 public boolean Eliminar(){	
		 DB_Conexion conex = new DB_Conexion();
			try {
				String sql = "DELETE FROM  clientes WHERE idClientes=?";
				PreparedStatement st= conex.Conectar().prepareStatement(sql);
	
				st.setInt(1, getCogido());
				
				
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
	 public String[] datocl(String codigo){
			String datos[] = new String [9];
			 DB_Conexion conex=new DB_Conexion();
			try {
				String sql="SELECT * FROM clientes WHERE idClientes=?";
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
	public int getCogido() {
		return cogido;
	}
	public void setCogido(int cogido) {
		this.cogido = cogido;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	
	
	
	
	
	
	


	

}
