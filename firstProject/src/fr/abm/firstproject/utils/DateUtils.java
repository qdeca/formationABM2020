package fr.abm.firstproject.utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	
	public static LocalDate getFirstDayOfMonth(LocalDate date) {
		return date.minusDays(date.getDayOfMonth()-1);
	}

}
