package Clases;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class clsHistorialAuto {
/////////////CONSULTAR nombre del repuesto////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultarHis(String nombre){
		Object obj[][]=null;

		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT idDet_auto, mantenimiento.nombre, fecha, autos.placa, marca, modelo, color, anio, clientes.cedula , clientes.nombre, clientes.apellido FROM det_auto inner join mantenimiento on det_auto.idMantenimiento = mantenimiento.idMantenimiento inner join autos on det_auto.idAutos = autos.idAutos inner join clientes on autos.idclientes = clientes.idClientes WHERE autos.placa like ?";
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
///////////////SELECIONAR TABLA/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String[] datocl(String codigo){
		String datos[] = new String [11];
		DB_Conexion conex=new DB_Conexion();
		try {
			String sql="SELECT idDet_auto, marca, modelo, autos.placa, color, anio, mantenimiento.nombre,  fecha,  clientes.cedula , clientes.nombre, clientes.apellido FROM det_auto inner join mantenimiento on det_auto.idMantenimiento = mantenimiento.idMantenimiento inner join autos on det_auto.idAutos = autos.idAutos inner join clientes on autos.idclientes = clientes.idClientes WHERE idDet_auto  =?";
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
				
				
		}	
		
	} catch (Exception e) {
		System.out.println(e);
		
	}
	return datos;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
