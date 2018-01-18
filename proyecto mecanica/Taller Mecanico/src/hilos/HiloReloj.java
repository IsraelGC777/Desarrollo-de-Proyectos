package hilos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Formularios.frm_menu;

//import formularios.frmBienvenida;

public class HiloReloj extends Thread{

	@Override
	public void run() {
		
		do {
			
		int hora,minuto,segundo;
		
		Calendar calendar = GregorianCalendar.getInstance();
		Date date = Calendar.getInstance().getTime();
		
		SimpleDateFormat sdf = new SimpleDateFormat("E dd/MM/yyyy");
		
		hora = calendar.get(Calendar.HOUR_OF_DAY);
		minuto = calendar.get(Calendar.MINUTE);
		segundo = calendar.get(Calendar.SECOND);
		
		frm_menu.lblHora.setText(hora + " : " + minuto + " : " + segundo);
		frm_menu.lblFecha.setText(sdf.format(date));
		
			
		} while (true);
	}

	
}
