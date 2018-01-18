package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class cls_reportes {
	
	
///////////////consultar//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar1(String placa){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT  idAutos, placa, marca, modelo, color, anio, cl.cedula, nombre, apellido, direccion FROM  clientes cl inner join  autos a on cl.idClientes = a.idclientes WHERE idAutos like ?";
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
////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String [] datocarro(String codigo){
		String datos[] = new String[10];
		DB_Conexion conex = new DB_Conexion();
		try {
			String sql="SELECT idAutos, placa, marca, modelo, color, anio, cl.cedula, nombre, apellido, direccion FROM  clientes cl inner join  autos a on cl.idClientes = a.idclientes WHERE idAutos =? ";
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
/////////////////CONSULTAR nombre////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar4(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT *FROM empleados WHERE empleados.nombre like ?";
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
	 public String[] datoEmpleado(String codigo){
			String datos[] = new String [4];
			 DB_Conexion conex=new DB_Conexion();
			try {
				String sql="SELECT cedula, nombre, apellido, cargo FROM empleados WHERE idEmpleados=?";
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
///////////////consultar//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar5(String nombre){
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
	
////////////////SELECIONAR TABLA/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String[] datoPr(String codigo){
		String datos[] = new String [7];
		DB_Conexion conex=new DB_Conexion();
		try {
			String sql="SELECT ruc, nombre, direccion  FROM proveedores WHERE ruc =?";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);
			st.setString(1,codigo);
			ResultSet rs = st.executeQuery();
			while(rs.next()){

				datos[0]=rs.getString(1);
				datos[1]=rs.getString(2);
				datos[2]=rs.getString(3);
				

			}	

		} catch (Exception e) {
			System.out.println(e);

		}
		return datos;
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////consultar//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultarEmp(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT empleados.idEmpleados, empleados.nombre, empleados.apellido, empleados.cargo, mantenimiento.nombre , autos.placa, autos.marca, autos.modelo FROM empleados inner join det_empleado on empleados.idEmpleados = det_empleado.idEmpleados inner join mantenimiento on det_empleado.idMantenimiento = mantenimiento.idMantenimiento inner join det_auto on mantenimiento.idMantenimiento = det_auto.idMantenimiento inner join autos on det_auto.idAutos = autos.idAutos WHERE  empleados.nombre like ?";
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
///////////////consultar//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultarX1(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "Select re.idRepuesto, re.nombre, re.precio from repuestos re inner join det_repuesto dre on re.idRepuesto = dre.idRepuesto inner join revision on dre.idRevision = revision.idRevision inner join mantenimiento ma on revision.idMantenimiento = ma.idMantenimiento inner join det_empleado demp on ma.idMantenimiento = demp.idMantenimiento inner join empleados em on demp.idEmpleados = em.idEmpleados inner join factura_venta fav on em.idEmpleados = fav.idEmpleados  WHERE  re.nombre like ? ORDER BY re.idRepuesto ASC";
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
///////////////consultar//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultarX2(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "Select re.idRepuesto, re.nombre, re.precio from repuestos re inner join det_repuesto dre on re.idRepuesto = dre.idRepuesto inner join revision on dre.idRevision = revision.idRevision inner join mantenimiento ma on revision.idMantenimiento = ma.idMantenimiento inner join det_empleado demp on ma.idMantenimiento = demp.idMantenimiento inner join empleados em on demp.idEmpleados = em.idEmpleados inner join factura_venta fav on em.idEmpleados = fav.idEmpleados  WHERE  re.nombre like ? ORDER BY re.idRepuesto DESC";
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
///////////////consultar//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultarC1(String placa){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT idAutos, placa, marca, modelo, color, anio, cilindraje FROM autos   WHERE autos.placa like ?  ORDER BY autos.idAutos ASC";
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
//////////////consultar//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultarC2(String placa){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT count(*) as total FROM autos WHERE autos.placa like ?";
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
	
	

}
