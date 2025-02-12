package it.exolab.aero.utils.customUtils.classes;

import java.time.LocalDateTime;
import java.time.Period;

public class CustomDateTimeUtils {

	public static boolean isTooOldAge(final LocalDateTime dateTime, final int maxAge) {
		return dateTime.isBefore(LocalDateTime.now().minus(Period.ofYears(maxAge)));
	}


}
