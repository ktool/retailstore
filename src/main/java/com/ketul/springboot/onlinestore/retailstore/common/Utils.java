package com.ketul.springboot.onlinestore.retailstore.common;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Utils {
	
	/**
	 * Method to Get Number of years for a given date compare to Today
	 * @param registeredDate
	 * @return
	 */
	public static int getUserRegisteredDurationInYear(Date registeredDate) {

		Date currentDate = new Date();
		Instant instant = Instant.ofEpochMilli(currentDate.getTime());
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		LocalDate today = localDateTime.toLocalDate();

		Instant instantReg = Instant.ofEpochMilli(registeredDate.getTime());
		LocalDateTime localDateTimeReg = LocalDateTime.ofInstant(instantReg, ZoneId.systemDefault());
		LocalDate registerDay = localDateTimeReg.toLocalDate();

		Period age = Period.between(registerDay, today);
		return age.getYears();

	}
}
