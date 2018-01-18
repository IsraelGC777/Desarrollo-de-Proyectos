package Clases;

import java.sql.PreparedStatement;


public class cls_det_factura_venta {
	
	private String descr;
	private double precio;
	private double cantidad;
	private int idCod;
	private int idFactura;
////////////////insertar Det facturar venta ////////////////////////////////////////////////////////////////////////////////////////
	public boolean insertarDetFac(){
		DB_Conexion conex = new DB_Conexion();
		try {
			String sql ="INSERT INTO det_fac_venta (descripcion, precio, cantidad, cod_producto, idFactura_venta) VALUES (?,?,?,?,?)";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);

			st.setString(1, getDescr());
			st.setDouble(2, getPrecio());
			st.setDouble(3, getCantidad());
			st.setInt(4, getIdCod());
			st.setInt(5, getIdFactura());
			


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
	
	public String getDescr() {
		return descr;
	}


	public void setDescr(String descr) {
		this.descr = descr;
	}


	public int getIdCod() {
		return idCod;
	}


	public void setIdCod(int idCod) {
		this.idCod = idCod;
	}


	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

}
