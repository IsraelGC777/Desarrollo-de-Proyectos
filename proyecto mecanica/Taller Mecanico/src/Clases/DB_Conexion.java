package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;




public class DB_Conexion {
	public static Connection Conectar(){
		
		
		String servidor="jdbc:mysql://localhost/mecanicaX";
		String usu="root";
		String pwd="123";
		Connection conexion=null;
		
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion= DriverManager.getConnection(servidor, usu, pwd);
		}
		catch(ClassNotFoundException ex){
			JOptionPane.showMessageDialog(null, " No se Ecuentra el Driver ");
			conexion=null;
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(null, " Error en la Conexion con la Base de Datos ");
			conexion=null;
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, " Error en la Conexion ");
			conexion=null;
		}
		
		
		finally{
			return conexion;
			
		}
	
		
	}

	
	
}


