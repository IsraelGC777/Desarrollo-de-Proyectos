package Clases;

import java.sql.PreparedStatement;


public class cls_det_empleado {
	private int idEmp;
	private int idMant;
////////////////insertar detalle empleado////////////////////////////////////////////////////////////////////////////////////////
public boolean insertarDetEmp(){
DB_Conexion conex = new DB_Conexion();
try {
	String sql ="INSERT INTO det_empleado ( idEmpleados, idMantenimiento) VALUES (?,?)";
	PreparedStatement st = conex.Conectar().prepareStatement(sql);
	
	
	st.setInt(1, getIdEmp());
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





public int getIdEmp() {
	return idEmp;
}
public void setIdEmp(int idEmp) {
	this.idEmp = idEmp;
}
public int getIdMant() {
	return idMant;
}
public void setIdMant(int idMant) {
	this.idMant = idMant;
}

}
