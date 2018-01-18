package Clases;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class cls_mantenimiento {
	
	private Date fecha;
	private int IdAuto;
	private int idMant;
	private String detalle_RM;
	private int emp;
	private int idServ;
	private int idRepust;
	private int idRevision;
	
	
//////////insertarMantenimineto/////////////////////////////////////////////////////////////////////////////////////
public boolean insertar(){
		DB_Conexion conex = new DB_Conexion();
				
				try {
					String sql ="INSERT INTO mantenimiento (nombre) VALUES (?)";
					PreparedStatement st = conex.Conectar().prepareStatement(sql);
					
					
					st.setString(1, getDetalle_RM());
					
					
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
/////////////CONSULTAR placa////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar1(String placa){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT placa, marca, modelo, color, anio, cl.cedula, nombre, apellido, direccion FROM autos inner join clientes cl on autos.idclientes = cl.idClientes   WHERE placa like ?";
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
	 public String [] datocarro(String codigo){
         String datos[] = new String[10];
           DB_Conexion conex = new DB_Conexion();
              try {
               String sql="SELECT idAutos, placa, marca, modelo, color, anio, cl.cedula, nombre, apellido, direccion FROM  clientes cl inner join  autos a on cl.idClientes = a.idclientes WHERE placa =? ";
               PreparedStatement st = conex.Conectar().prepareStatement(sql);
               st.setString(1, codigo);
               ResultSet rs = st.executeQuery();
                 while(rs.next()){
              	   
                   datos[0]= rs.getString(1);
                   datos[1]= rs.getString(2);
                   datos[2]= rs.getString(3);
                   datos[3]= rs.getString(4);
                   datos[4]= rs.getString(5);
                   datos[5]= rs.getString(6);
                   datos[6]= rs.getString(7);
                   datos[7]= rs.getString(8);
                   datos[8]= rs.getString(9);
                   datos[9]= rs.getString(10);
                  
              }
        } catch (Exception e) {
  System.out.println(e);
       }
          return datos;
       }	

////////////////////seleccionar mantenimineto//////////////////////////////////////////////////////////////////////////////////////////////////
	 public String [] datoMan(String codigo){
         String datos[] = new String[9];
           DB_Conexion conex = new DB_Conexion();
              try {
               String sql="SELECT * FROM  mantenimiento WHERE idMantenimiento =? ";
               PreparedStatement st = conex.Conectar().prepareStatement(sql);
               st.setString(1, codigo);
               ResultSet rs = st.executeQuery();
                 while(rs.next()){
              	   
                   datos[0]= rs.getString(1);
                   datos[1]= rs.getString(2);
                  
              }
        } catch (Exception e) {
  System.out.println(e);
       }
          return datos;
       }	
	 
////////////////////////////////////////////////////////////////////////////////////////////////////////
	 public Object[][] consultarMEcanico(String nombre){
			Object obj[][]=null;
			DB_Conexion conex = new DB_Conexion();

			try {
				String sql= "SELECT idEmpleados, cedula, nombre, apellido, cargo FROM empleados WHERE nombre like ?";
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
///////////////////seleccionar mecanico/////////////////////////////////////////////////////////////////////////////////////
	 public String [] datoMecanico(String codigo){
         String datos[] = new String[2];
           DB_Conexion conex = new DB_Conexion();
              try {
               String sql="SELECT idEmpleados,nombre  FROM  empleados WHERE idEmpleados=? ";
               PreparedStatement st = conex.Conectar().prepareStatement(sql);
               st.setString(1, codigo);
               ResultSet rs = st.executeQuery();
                 while(rs.next()){
              	   
                   datos[0]= rs.getString(1);
                   datos[1]= rs.getString(2);
                  
              }
        } catch (Exception e) {
  System.out.println(e);
       }
          return datos;
       }	


////////////CONSULTAR servicio////////////////////////////////////////////////////////////////////////////////////////
public Object[][] consultarServ(String idServicios){
	Object obj[][]=null;
	DB_Conexion conex = new DB_Conexion();

	try {
		String sql= "SELECT idServicios, nombre_ser, precio FROM servicios WHERE idServicios like ?";
		PreparedStatement st= conex.Conectar().prepareStatement(sql);
		st.setString(1, "%"+idServicios+"%");
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
////////////////seleccionar tabla servicio////////////////////////////////////////////////////////////////////////////////////////
public String [] datoservicio(String codigo){
  String datos[] = new String[3];
    DB_Conexion conex = new DB_Conexion();
       try {
        String sql="SELECT idServicios,  detalle_serv, nombre_ser FROM servicios WHERE idServicios = ? ";
        PreparedStatement st = conex.Conectar().prepareStatement(sql);
        st.setString(1, codigo);
        ResultSet rs = st.executeQuery();
          while(rs.next()){
       	   
            datos[0]= rs.getString(1);
            datos[1]= rs.getString(2);
            datos[2]= rs.getString(3);
            
          }
       } catch (Exception e) {
    	   System.out.println(e);
       }
   return datos;
}	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////CONSULTAR Revision////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultaRevi(String idRevision){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT idRevision, nombre_ser,  fecha FROM revision  inner join mantenimiento  on revision.mantenimiento_idRevision = mantenimiento.idMantenimiento inner join  det_auto on  mantenimiento.idMantenimiento = det_auto.idMantenimiento  inner join servicios  on revision.servicios_idServicios = servicios.idServicios  WHERE idRevision like ?";
			PreparedStatement st= conex.Conectar().prepareStatement(sql);
			st.setString(1, "%"+idRevision+"%");
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
	public String ultimoid(){
		String id="";


		DB_Conexion conex = new DB_Conexion();
		try {
			String sql="SELECT MAX(idMantenimiento) as id from mantenimiento";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while(rs.next()){
		id= rs.getString(1);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return id;
	}	
////////////////////////////////////////////////////////////////////////////////////////////////////////	

	
public Date getFecha() {
	return fecha;
}

public int getIdRevision() {
	return idRevision;
}

public void setIdRevision(int idRevision) {
	this.idRevision = idRevision;
}

public int getIdRepust() {
	return idRepust;
}

public void setIdRepust(int idRepust) {
	this.idRepust = idRepust;
}

public int getIdServ() {
	return idServ;
}

public void setIdServ(int idServ) {
	this.idServ = idServ;
}

public int getEmp() {
	return emp;
}

public void setEmp(int emp) {
	this.emp = emp;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public int getIdAuto() {
	return IdAuto;
}
public void setIdAuto(int idAuto) {
	IdAuto = idAuto;
}
public int getIdMant() {
	return idMant;
}
public void setIdMant(int idMant) {
	this.idMant = idMant;
}
public String getDetalle_RM() {
	return detalle_RM;
}

public void setDetalle_RM(String detalle_RM) {
	this.detalle_RM = detalle_RM;
}

}
