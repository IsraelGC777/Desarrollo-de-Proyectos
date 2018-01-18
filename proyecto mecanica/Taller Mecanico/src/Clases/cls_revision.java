package Clases;

import java.sql.PreparedStatement;

public class cls_revision {
	private int idMant;
	private int idServ;
	
	
////////////////insertar Revision////////////////////////////////////////////////////////////////////////////////////////
	public boolean insertarRevision(){
		DB_Conexion conex = new DB_Conexion();
		try {
			String sql ="INSERT INTO revision (idServicios, idMantenimiento) VALUES (?,?)";
			PreparedStatement st = conex.Conectar().prepareStatement(sql);

			st.setInt(1, getIdServ());
			st.setInt(2, getIdMant());


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


public int getIdMant() {
	return idMant;
}


public void setIdMant(int idMant) {
	this.idMant = idMant;
}


public int getIdServ() {
	return idServ;
}


public void setIdServ(int idServ) {
	this.idServ = idServ;
}

}
