package com.jalor.sinponet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sinponet_20180919 {
	public static void main(String[] args) {
		String str1 = "2018-09-17 21:13:43";
		String str2 = "2018-09-17 21:15:43";
		String time = concatTime(str1, str2);
		System.out.println(time);
	}

	public static String concatTime(String str1, String str2) {
		// 日期格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String result = "";
		try {
			Date startDate = sdf.parse(str1);
			Date endDate = sdf.parse(str2);
			String date1 = dateByFormat(startDate, "yyyy-MM-dd HH:mm");
			String date2 = dateByFormat(endDate, "HH:mm");
			result = date1 + "~" + date2;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 日期格式化封装
	public static String dateByFormat(Date date, String format) {
		String result = "";
		if (date != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			result = sdf.format(date);
		}
		return result;
	}
}
