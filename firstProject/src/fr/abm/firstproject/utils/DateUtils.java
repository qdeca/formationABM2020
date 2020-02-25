package fr.abm.firstproject.utils;

import java.time.LocalDate;

public class DateUtils {
	
	
	public static LocalDate getFirstDayOfMonth(LocalDate date) {
		return date.minusDays(date.getDayOfMonth()-1);
	}

}
