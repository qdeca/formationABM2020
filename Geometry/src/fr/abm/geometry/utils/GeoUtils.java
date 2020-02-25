package fr.abm.geometry.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeoUtils {
	
	public static Date parseDate(String stringDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.parse(stringDate);
	}
	
	public Date generateDate() {
		return new Date();
	}
	
	// surcharge de méthode
	public Date generateDate(String stringDate) {
		return new Date();
	}
	
	
	public Date generateDatev2() {
		return generateDate();
	}

}
