package Clases;

import java.awt.Image;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Blob;

public class cls_repuestos {
	private String codigo;
	
	private String nombre;
	private double precio;
	private String foto;
	
////////////////////////////////////////////////////////////////////////////////////////
			public boolean insertar(){
					DB_Conexion conex = new DB_Conexion();

					try {
						String sql ="INSERT INTO repuestos (nombre, precio, imagen) VALUES (?,?,?)";
						PreparedStatement st = conex.Conectar().prepareStatement(sql);

						st.setString(1, getNombre());
						st.setDouble(2, getPrecio());
						st.setString(3, getFoto());


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
			public Image abrirImagen() throws SQLException, IOException
			 {
			 Image rpta=null;
			 String sql = "SELECT imagen FROM repuestos Where idRepuesto = 11 ";
			 //En este ejemplo solo recupero la primera Imagen
			 DB_Conexion conex = new DB_Conexion();
			 PreparedStatement st = conex.Conectar().prepareStatement(sql);

			 ResultSet results = st.executeQuery(sql);
			 
			 Blob imagen=null;
			 while(results.next())
			     imagen = results.getBlob("Imagen");
			 
			 rpta= javax.imageio.ImageIO.read(imagen.getBinaryStream());
			 //Esta parte es clave, donde se convierte a imagen
			  return rpta;
			 }
/////////////CONSULTAR nombre del repuesto////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar(String nombre){
		Object obj[][]=null;
		
		DB_Conexion conex = new DB_Conexion();
		
		try {
			String sql= "SELECT * FROM repuestos WHERE nombre like ?";
			PreparedStatement st= conex.Conectar().prepareStatement(sql);
			st.setString(1,"%"+nombre+"%");
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
			String sql = "UPDATE repuestos SET nombre=?, precio=?   WHERE idRepuesto =?";

			try {

				PreparedStatement st = conex.Conectar().prepareStatement(sql);

				st.setString(1, getNombre());
				st.setDouble(2, getPrecio());
				st.setString(3, String.valueOf(getCodigo()));


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
			String sql = "DELETE FROM  repuestos WHERE idRepuesto=?";
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

	public String[] datoRe(String codigo){
		String datos[] = new String [4];
		DB_Conexion conex=new DB_Conexion();
		try {
			String sql="SELECT *  FROM repuestos WHERE idRepuesto =?";
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String getNombre() {
		return nombre;
	}
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	

}
