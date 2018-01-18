package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class cls_det_repuest {
	private int idRepust;
	private int idRevision;
	private double cant;
////////////////insertar Det Repuest////////////////////////////////////////////////////////////////////////////////////////
	public boolean insertarDetRepuest(){
		DB_Conexion conex = new DB_Conexion();
		try {
			String sql ="INSERT INTO det_repuesto (idRevision, idRepuesto, cantidad) VALUES (?,?,?)";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);

			st.setInt(1, getIdRevision());
			st.setInt(2, getIdRepust());
			st.setDouble(3, getCant());


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
////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////consultar//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultarRev(String idRevision){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT idRevision, nombre, nombre_ser FROM revision  inner join mantenimiento on revision.idMantenimiento = mantenimiento.idMantenimiento inner join servicios on revision.idServicios = servicios.idServicios WHERE nombre like ?";
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
	public String [] datoRev(String codigo){
		String datos[] = new String[13];


		DB_Conexion conex = new DB_Conexion();
		try {
			String sql="SELECT idRevision, mantenimiento.nombre, nombre_ser,    placa, marca, modelo, color, anio,     cedula, clientes.nombre, apellido, direccion, fecha FROM revision inner join servicios on revision.idServicios = servicios.idServicios inner join mantenimiento on revision.idMantenimiento = mantenimiento.idMantenimiento  inner join det_empleado on mantenimiento.idMantenimiento = det_empleado.idMantenimiento  inner join det_auto on mantenimiento.idMantenimiento = det_auto.idMantenimiento  inner join autos on det_auto.idAutos =  autos.idAutos inner join clientes on autos.idclientes = clientes.idClientes WHERE idRevision = ?  ORDER BY mantenimiento.nombre ASC ";
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
				datos[10]= rs.getString(11);
				datos[11]= rs.getString(12);
				datos[12]= rs.getString(13);



			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return datos;
	}	
//////////////consultar revision//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar1(String nombre){
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
////////////CONSULTAR repuesto////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultaRep(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT idRepuesto, nombre, precio, stock FROM repuestos WHERE nombre like ?";
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
////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String [] datoRepuesto(String codigo){
		String datos[] = new String[2];


		DB_Conexion conex = new DB_Conexion();
		try {
			String sql="SELECT idRepuesto, nombre FROM repuestos WHERE idRepuesto = ? ";
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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
public int getIdRepust() {
	return idRepust;
}
public void setIdRepust(int idRepust) {
	this.idRepust = idRepust;
}
public int getIdRevision() {
	return idRevision;
}
public void setIdRevision(int idRevision) {
	this.idRevision = idRevision;
}
public double getCant() {
	return cant;
}
public void setCant(double cant) {
	this.cant = cant;
}


}
