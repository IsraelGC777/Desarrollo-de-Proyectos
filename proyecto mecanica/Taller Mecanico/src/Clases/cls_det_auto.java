package Clases;

import java.sql.Date;
import java.sql.PreparedStatement;

public class cls_det_auto {
	private Date fecha;
	private int IdAuto;
	private int idMant;

////////////////insertar detalle auto////////////////////////////////////////////////////////////////////////////////////////
public boolean insertarDetAuto(){
DB_Conexion conex = new DB_Conexion();
		
		try {
			String sql ="INSERT INTO det_auto (fecha,idAutos,idMantenimiento) VALUES (?,?,?)";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);
			
			st.setDate(1, getFecha());
			st.setInt(2, getIdAuto());
			st.setInt(3, getIdMant());
			
			
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

public Date getFecha() {
	return fecha;
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

}
