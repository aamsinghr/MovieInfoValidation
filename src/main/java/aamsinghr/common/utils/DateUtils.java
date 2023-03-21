package aamsinghr.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static final String FORMAT_MMMMM_dd_yyyy = "MMMMM dd, yyyyy";
	public static final String FORMAT_dd_MMMMM_yyyy = "dd MMMMM yyyyy";
	public static final String FORMAT_dd_MM_yyyy = "dd-MM-yyyyy";

	public static Date convertStringToDate(String sDate, String format) {
		Date date = null;

		try {
			date = new SimpleDateFormat(format).parse(sDate);
		} catch (ParseException e) {
			throw new UnsupportedOperationException("ParseException - Cannot convert the String to Date");
		}
		return date;
	}

}
