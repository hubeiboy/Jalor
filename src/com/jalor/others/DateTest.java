package com.jalor.others;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// SimpleDateFormat myFmt=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		// Date now=new Date();
		// System.out.println(myFmt.format(now));
		// System.out.println(java.sql.Date.valueOf(myFmt.format(now)));

		String str = dateByFormat(new Date(), "yyyy-mm-dd hh:mm:ss");
		System.out.println(str);

		SimpleDateFormat conversionTime = new SimpleDateFormat("yyyy-MM-dd");
		String st = "2018-08-28 00:00:00";
		String c56Time = st.substring(0, 10);
		String dayTime = dateByFormat(new Date(), "yyyy-MM-dd");
		Date c56Date = null;
		Date dayDate = null;
		try {
			c56Date = conversionTime.parse(c56Time);
			dayDate = conversionTime.parse(dayTime);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		System.out.println(c56Date.getTime() + "\t" + dayDate.getTime());
		if (dayDate.getTime() >= c56Date.getTime()) {
			System.out.println("此人已转正！");
		}

	}

	public static String dateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			result = sdf.format(date);
		}
		return result;
	}

}
