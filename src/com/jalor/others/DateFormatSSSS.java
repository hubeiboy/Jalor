package com.jalor.others;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFormatSSSS {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss:SSS");
			System.out.println(formatter.format(new Date()));
		}
	}
}
