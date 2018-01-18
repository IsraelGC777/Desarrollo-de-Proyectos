package Clases;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class cls_facturaVenta {
	
	private Date fecha;
	private String descrip;
	private double descuento;
	private double iva;
	private double total;
	private int idCl;
	private int idEmp;

////////////////insertar facturar venta ////////////////////////////////////////////////////////////////////////////////////////
	public boolean insertarFact(){
		DB_Conexion conex = new DB_Conexion();
		try {
			String sql ="INSERT INTO factura_venta ( fecha, descuento, iva, total, idClientes, idEmpleados) VALUES (?,?,?,?,?,?)";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);

			st.setDate(1, getFecha());
			st.setDouble(2, getDescuento());
			st.setDouble(3, getIva());
			st.setDouble(4, getTotal());
			st.setInt(5, getIdCl());
			st.setInt(6, getIdEmp());


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
/////////////CONSULTAR nombre////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultar1(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT idEmpleados, nombre, apellido,	direccion, cargo FROM empleados WHERE empleados.nombre like ?";
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
	public Object[][] consultarMant(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT mantenimiento.idMantenimiento, mantenimiento.nombre, placa, cedula, clientes.nombre, apellido, direccion FROM mantenimiento inner join det_auto on mantenimiento.idMantenimiento = det_auto.idMantenimiento inner join autos on det_auto.idAutos = autos.idAutos inner join clientes on autos.idclientes = clientes.idClientes where mantenimiento.idMantenimiento like ?   ORDER BY mantenimiento.idMantenimiento ASC";
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
	public Object[][] consultarServ(String idMantenimiento){
		Object obj[][]=null;
			DB_Conexion conex = new DB_Conexion();

				try {
					String sql= "SELECT revision.idRevision, servicios.idServicios as ID,  nombre_ser,  '1' , precio, precio as total FROM revision inner join servicios on revision.idServicios = servicios.idServicios Where idMantenimiento=?  ";
					PreparedStatement st= conex.Conectar().prepareStatement(sql);
					st.setString(1, idMantenimiento);
					ResultSet result = st.executeQuery();
					result.last();
					java.sql.ResultSetMetaData rsm =result.getMetaData();

					int id_rev[]=new int[100];
					int numCol = rsm.getColumnCount();
					//int numFil = result.getRow();
					int numFil = 15;
					obj = new Object[numFil][numCol];
					result.beforeFirst();
					int  j=0;
					while(result.next()){
						for(int a=0; a<=numCol-1; a++)
						{
							obj[j][a]= result.getObject(a+1);
							id_rev[j]=Integer.parseInt(result.getObject(1).toString());
						}
					
						j++;	
					}
					
					int  jj=j;
					for(int k=0;k<=j-1;k++)
					{
						DB_Conexion conex2 = new DB_Conexion();

						try {
							String sql2= "SELECT repuestos.idRepuesto,repuestos.idRepuesto as ID, nombre,  cantidad, precio, precio*det_repuesto.cantidad as total  FROM repuestos inner join det_repuesto on repuestos.idRepuesto = det_repuesto.idRepuesto Where idRevision=?";
							PreparedStatement st2= conex2.Conectar().prepareStatement(sql2);
							st2.setString(1,String.valueOf(id_rev[k]));
							
							ResultSet result2 = st2.executeQuery();
							result2.last();
							java.sql.ResultSetMetaData rsm2 =result2.getMetaData();
				
							result2.beforeFirst();
							
							while(result2.next())
							{
								for(int aa=0; aa<=numCol-1; aa++)
								{
									//System.out.println("fila: "+jj);
									obj[jj][aa]= result2.getObject(aa+1);
								}
							jj++;	
							}
						
						} catch (Exception e) {
							System.out.println(e);
						}				
						
					}
					
					
					
					

				} catch (Exception e) {
					System.out.println(e);
				}	
				return obj;
	} 
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*public Object[][] consultarRep(String idRevision){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT repuestos.idRepuesto, nombre, precio  FROM repuestos inner join det_repuesto on repuestos.idRepuesto = det_repuesto.idRepuesto Where idRevision like ?  ";
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
	} */
////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String [] datoMan(String codigo){
		String datos[] = new String[13];


		DB_Conexion conex = new DB_Conexion();
		try {
			String sql="SELECT mantenimiento.idMantenimiento, mantenimiento.nombre, cedula, clientes.nombre, apellido, direccion,  nombre_ser, precio, clientes.idClientes FROM mantenimiento inner join det_auto on mantenimiento.idMantenimiento = det_auto.idMantenimiento inner join autos on det_auto.idAutos = autos.idAutos inner join clientes on autos.idclientes = clientes.idClientes inner join revision on mantenimiento.idMantenimiento = revision.idMantenimiento inner join servicios on revision.idServicios = servicios.idServicios where mantenimiento.idMantenimiento  = ? ";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);
			st.setString(1, codigo);
			ResultSet rs = st.executeQuery();
			while(rs.next()){


				datos[0]= rs.getString(2);
				datos[1]= rs.getString(3);
				datos[2]= rs.getString(4);
				datos[3]= rs.getString(5);
				datos[4]= rs.getString(6);
				datos[8]= rs.getString(9);

}
} catch (Exception e) {
System.out.println(e);
}
return datos;
}	
///////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String [] datoEmp(String codigo){
		String datos[] = new String[5];
		DB_Conexion conex = new DB_Conexion();
		try {
			String sql="SELECT idEmpleados,  nombre, apellido, cargo FROM empleados WHERE idEmpleados = ? ";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);
			st.setString(1, codigo);
			ResultSet rs = st.executeQuery();
			while(rs.next()){


				datos[0]= rs.getString(1);
				datos[1]= rs.getString(2);
				datos[2]= rs.getString(3);
				datos[3]= rs.getString(4);

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return datos;
	}	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	 
	
	public String SubTotal(String codigo){
		 String id=" ";

		 DB_Conexion conex = new DB_Conexion();
		 try {
			 String sql="select SUM(subt) from ( select s.precio as subt from mantenimiento m, revision r, servicios s where m.idMantenimiento = r.idMantenimiento and r.idServicios = s.idServicios and m.idMantenimiento = ? union select dr.cantidad * re.precio as subt from mantenimiento m, revision r, det_repuesto dr, repuestos re where m.idMantenimiento = r.idMantenimiento and r.idRevision = dr.idRevision and dr.idRepuesto = re.idRepuesto and m.idMantenimiento = ?)V";
			 PreparedStatement st = conex.Conectar().prepareStatement(sql);
			 st.setString(1, codigo);
			 st.setString(2, codigo);
			 ResultSet rs = st.executeQuery();
			 while(rs.next()){
				 id= rs.getString(1);
			 }
		 } catch (Exception e) {
			 System.out.println(e);
		 }
		 return id;
	 }	
	
	
	
	public String ultimoid(){
		 String id=" ";

		 DB_Conexion conex = new DB_Conexion();
		 try {
			 String sql="SELECT MAX(idFactura_venta) as id from factura_venta";
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
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getIdCl() {
		return idCl;
	}
	public void setIdCl(int idCl) {
		this.idCl = idCl;
	}
	public int getIdEmp() {
		return idEmp;
	}
	public void setIdEmp(int idEmp) {
		this.idEmp = idEmp;
	}
	
	
	
}
