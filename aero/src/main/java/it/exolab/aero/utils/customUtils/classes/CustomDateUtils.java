package it.exolab.aero.utils.customUtils.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class CustomDateUtils {

	public static boolean isAdult(final LocalDate date, final int adultAge) {
		return date.isBefore(LocalDate.now().minus(Period.ofYears(adultAge)));
	}

	public static boolean isTooOldAge(final LocalDate date, final int maxAge) {
		return date.isBefore(LocalDate.now().minus(Period.ofYears(maxAge)));
	}

	public static boolean isFutureDate(final LocalDate date) {
		return date.isAfter(LocalDate.now());
	}

	public static List<LocalDateTime> getDaysAtMidnight(int year, int month) {
		YearMonth yearMonth = YearMonth.of(year, month);
		int daysInMonth = yearMonth.lengthOfMonth();

		List<LocalDateTime> localDateTimes = new ArrayList<>();

		for (int day = 1; day <= daysInMonth; day++) {
			LocalDateTime dateTime = LocalDateTime.of(year, month, day, 0, 0);
			localDateTimes.add(dateTime);
		}

		return localDateTimes;
	}
}
