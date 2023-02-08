package it.beije.neumann.vellani.feb3;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {

	public static void main(String[] args) throws ParseException {

		String dataStringa = "13/07/2001";
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ITALIAN);
		Date date = null;
		date = df.parse(dataStringa);
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        
        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        int year = calendar.get(Calendar.YEAR);
        
        System.out.println(df.format(date) + ", giorno " + dayOfYear + " dell'anno " +
        year + ", settimana numero " + weekOfYear);
	}

}
