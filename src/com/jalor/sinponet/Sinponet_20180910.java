package com.jalor.sinponet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Sinponet_20180910 {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = sdf.parse("2018-9-05 15:09:11");
			endDate = sdf.parse("2018-9-05 12:09:11");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(startDate + "\t" + endDate);
		String start = dateByFormat(startDate, "yyyy-MM-dd hh");
		String end = dateByFormat(endDate, "hh");
		System.out.println("确认面试时间：" + start + "~" + end);
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
