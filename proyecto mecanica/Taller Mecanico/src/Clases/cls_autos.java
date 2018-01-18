package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import Formularios.frm_autos;

public class cls_autos {
	private String placa;
	private String marca;
	private String modelo;
	private String color;
	private String anio;
	private String cilindraje;
	private int idClientes;
	private int codigo;
	
	//////////insertar/////////////////////////////////////////////////////////////////////////////////////
	
	public boolean insertar(){
			DB_Conexion conex = new DB_Conexion();
					
					try {
						String sql ="INSERT INTO autos (placa ,marca, modelo,	color, anio, cilindraje,  idClientes) VALUES (?,?,?,?,?,?,?)";
						PreparedStatement st = conex.Conectar().prepareStatement(sql);
						
						st.setString(1, getPlaca());
						st.setString(2, getMarca());
						st.setString(3, getModelo());
						st.setString(4, getColor());
						st.setString(5, getAnio());
						st.setString(6, getCilindraje());
						st.setInt(7, getIdClientes());
						
						
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
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////consultar//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar(String placa){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT idAutos, placa, marca, modelo, color, anio, cilindraje,  autos.idclientes,  clientes.idclientes, clientes.cedula, nombre, apellido, direccion, genero, telefono, celular, correo  FROM autos  inner join clientes  on autos.idclientes = clientes.idclientes  WHERE autos.placa like ?";
			PreparedStatement st= conex.Conectar().prepareStatement(sql);
			st.setString(1, "%"+placa+"%");
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
			String sql = "UPDATE autos SET placa=?, marca=?, modelo=?, color=?, anio=?, cilindraje=?,  idclientes=?   WHERE idAutos =?";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);
		       
			st.setString(1, getPlaca());
			st.setString(2, getMarca());
			st.setString(3, getModelo());
			st.setString(4, getColor());
			st.setString(5, getAnio());
			st.setString(6, getCilindraje());
			st.setInt(7, getIdClientes());
			st.setInt(8, getCodigo());
			
		
		
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
			String sql = "DELETE FROM  autos WHERE idAutos=?";
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

	public String[] datoAuto(String codigo){
		String datos[] = new String [18];
		DB_Conexion conex=new DB_Conexion();
		try {
			String sql="SELECT idAutos, placa, marca, modelo, color, anio, cilindraje, a.idclientes,  cl.idclientes, cl.cedula, nombre, apellido, direccion, genero, telefono, celular, correo FROM  clientes cl inner join  autos a on cl.idClientes = a.idclientes  WHERE idAutos =?";
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
				datos[12]=rs.getString(13);
				datos[13]=rs.getString(14);
				datos[14]=rs.getString(15); 
				datos[15]=rs.getString(16);   
				datos[16]=rs.getString(17);
		
			
			
			}	
		
		} catch (Exception e) {
			System.out.println(e);
		
		}
		return datos;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////CONSULTAR nombre cliente////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar1(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();
		
		try {
			String sql= "SELECT * FROM clientes where clientes.nombre like ?";
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
	public Object[][] consultar2(String idClientes){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();
		
		try {
			String sql= "SELECT * FROM clientes  WHERE idClientes like ?";
			PreparedStatement st= conex.Conectar().prepareStatement(sql);
			st.setString(1, "%"+idClientes+"%");
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
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
	
	
	
	public int getCodigo() {
		return codigo;
	}

	public String getCilindraje() {
		return cilindraje;
	}



	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}



	public String getPlaca() {
		return placa;
	}



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getAnio() {
		return anio;
	}
	public void setAnio(String anio) {
		this.anio = anio;
	}
	public int getIdClientes() {
		return idClientes;
	}
	public void setIdClientes(int idClientes) {
		this.idClientes = idClientes;
	}
	
	
	
	
	

}
