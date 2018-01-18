package Clases;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Generated;

public class cls_facturaCompra {
	private double precio;
	private double cantidad;
	
	private double descuent;
	private double total;
	private double iva;
	private Date fecha;
	private int idRepust;
	private int idFactura;
	private int  idPr;
	private String descrip;
	
////////////////insertar Det facturar venta ////////////////////////////////////////////////////////////////////////////////////////
	public boolean insertarDetFactCompra(){
		DB_Conexion conex = new DB_Conexion();
		try {
			String sql ="INSERT INTO det_fac_compra (cantidad, precio,  idRepuesto, idFactura_compra) VALUES (?,?,?,?)";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);

			st.setDouble(1, getPrecio());
			st.setDouble(2, getCantidad());
			st.setInt(3, getIdRepust());
			st.setInt(4, getIdFactura());



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

////////////////insertar Det facturar venta ////////////////////////////////////////////////////////////////////////////////////////
	public boolean insertarFacComp(){
		DB_Conexion conex = new DB_Conexion();
		try {
			String sql ="INSERT INTO factura_compra (descripcion, fecha, descuento, iva, total, idProveedores) VALUES (?,?,?,?,?,?)";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);
			
			st.setString(1, getDescrip());
            st.setDate(2, getFecha());
			st.setDouble(3, getDescuent() );
			st.setDouble(4, getIva());
			st.setDouble(5, getTotal());
			st.setInt(6, getIdPr());
			


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
/////////////CONSULTAR nombre del repuesto////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultarRep(String nombre){
		Object obj[][]=null;

		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT IdRepuesto, nombre, stock, precio FROM repuestos WHERE nombre like ?";
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
///////////////consultar pr//////////////////////////////////////////////////////////////////////////////////
	public Object[][] consultarPr(String nombre){
		Object obj[][]=null;
		DB_Conexion conex = new DB_Conexion();

		try {
			String sql= "SELECT  idProveedores, ruc, nombre, direccion,  telefono, celular, correo FROM proveedores WHERE nombre like ?";
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
	public String [] datoPr(String codigo){
		String datos[] = new String[5];

		DB_Conexion conex = new DB_Conexion();
		try {
			String sql="SELECT idProveedores, ruc, nombre , direccion FROM proveedores WHERE idProveedores  = ? ";
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
///////////////////////////////////////////////////////////////////////////////////////////////
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String ultimoid(){
		String id=" ";

		DB_Conexion conex = new DB_Conexion();
		try {
	String sql="SELECT MAX(idFactura_compra) as id from factura_compra";
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

	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdRepust() {
		return idRepust;
	}

	public void setIdRepust(int idRepust) {
		this.idRepust = idRepust;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	

	public int getIdPr() {
		return idPr;
	}

	public void setIdPr(int idPr) {
		this.idPr = idPr;
	}

	public double getDescuent() {
		return descuent;
	}

	public void setDescuent(double descuent) {
		this.descuent = descuent;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	
	
	
	
}
