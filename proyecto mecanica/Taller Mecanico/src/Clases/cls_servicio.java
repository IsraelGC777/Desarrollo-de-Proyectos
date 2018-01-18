package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class cls_servicio {
	
	private String codigo;
	
	private String detalle_serv;
	private String nombre;
	private double manoObra;
/////////////////insetar///////////////////////////////////////////////////////////////////////	
	public boolean insertar(){
		DB_Conexion conex = new DB_Conexion();
				
				try {
					String sql ="INSERT INTO servicios (nombre_ser, detalle_serv, precio) VALUES (?,?,?)";
					PreparedStatement st = conex.Conectar().prepareStatement(sql);
					
					st.setString(1, getNombre());
					st.setString(2, getDetalle_serv());
					st.setDouble(3, getManoObra());
					
					
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

	////////////////////////////////////////////////////////////////////////////////////////
/////////////CONSULTAR nombre ////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar(String nombre_ser){
		Object obj[][]=null;

		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT * FROM servicios WHERE nombre_ser like ?";
			PreparedStatement st= conex.Conectar().prepareStatement(sql);
			st.setString(1,"%"+nombre_ser+"%");
			ResultSet result = st.executeQuery();
			result.last();
			java.sql.ResultSetMetaData rsm =result.getMetaData();
	
	
			int numCol = rsm.getColumnCount();
			int numFil = result.getRow();
			obj = new Object[numFil][numCol];
			result.beforeFirst();
			int  j=0;
			while(result.next()){
				for(int a=0;a<=numCol-1; a++)
				{
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
	String sql = "UPDATE servicios SET nombre_ser=?, detalle_serv=?, precio=?  WHERE idServicios =?";

	try {

		PreparedStatement st = conex.Conectar().prepareStatement(sql);

		st.setString(1, getNombre());
		st.setString(2, getDetalle_serv());
		st.setDouble(3, getManoObra());
		st.setString(4, String.valueOf(getCodigo()));


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
			String sql = "DELETE FROM  servicios WHERE idServicios=?";
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
	public String[] datoSer(String codigo){
		String datos[] = new String [4];
		DB_Conexion conex=new DB_Conexion();
		try {
			String sql="SELECT *  FROM servicios WHERE idServicios =?";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);
			st.setString(1,codigo);
			ResultSet rs = st.executeQuery();
			while(rs.next()){

				datos[0]=rs.getString(1);
				datos[1]=rs.getString(2);
				datos[2]=rs.getString(3);
				datos[3]=rs.getString(4);


			}	

		} catch (Exception e) {
			System.out.println(e);

		}
		return datos;
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	

	public String getDetalle_serv() {
		return detalle_serv;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public double getManoObra() {
		return manoObra;
	}

	public void setManoObra(double manoObra) {
		this.manoObra = manoObra;
	}

	public void setDetalle_serv(String detalle_serv) {
		this.detalle_serv = detalle_serv;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
