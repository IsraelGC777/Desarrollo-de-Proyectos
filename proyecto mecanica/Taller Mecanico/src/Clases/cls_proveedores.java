package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class cls_proveedores {
	private String codigo;
	private String ruc;
	private String nombre;
	private String direccion;
	private String telefono;
	private String celular;
	private String  correo;
	
///////////////insertar////////////////////////////////////////////////
	public boolean insertar(){
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql ="INSERT INTO proveedores (ruc, nombre, direccion,  telefono, celular, correo) VALUES (?,?,?,?,?,?)";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);
	
			st.setString(1, getRuc());
			st.setString(2, getNombre());
			st.setString(3, getDireccion());
			st.setString(4, getTelefono());
			st.setString(5, getCelular());
			st.setString(6, getCorreo());
	
	
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
///////////////consultar//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT ruc, nombre, direccion,  telefono, celular, correo FROM proveedores WHERE nombre like ?";
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
		String sql = "UPDATE proveedores SET ruc=?, nombre=?, direccion=?, telefono=?, celular=?, correo=?   WHERE idProveedores =?";

		try {
			
		PreparedStatement st = conex.Conectar().prepareStatement(sql);
      
		st.setString(1, getRuc());
		st.setString(2, getNombre());
		st.setString(3, getDireccion());
		st.setString(4, getTelefono());
		st.setString(5, getCelular());
		st.setString(6, getCorreo());
		st.setString(7, String.valueOf(getCodigo()));


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
			String sql = "DELETE FROM  proveedores WHERE idProveedores=?";
			PreparedStatement st= conex.Conectar().prepareStatement(sql);

			st.setString(1, getCodigo());


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

	public String[] datoPr(String codigo){
	String datos[] = new String [7];
	DB_Conexion conex=new DB_Conexion();
	try {
		String sql="SELECT *  FROM proveedores WHERE ruc =?";
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
	
		}	

	} catch (Exception e) {
		System.out.println(e);

	}
	return datos;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public String getRuc() {
		return ruc;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
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
