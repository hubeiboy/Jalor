package com.jalor.others;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CalculateHours {
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // ����ĸ�ʽ�����Լ�����
	// �����ϰ�ʱ�䣺�ô�ʱ����Ը���ʵ��������е���
	int abh = 9;// �����ϰ�ʱ��,Сʱ
	int abm = 00;// �����ϰ�ʱ��,����
	int aeh = 12;// �����°�ʱ�䣬Сʱ
	int aem = 0;// �����°�ʱ�䣬����
	int pbh = 13;// �����ϰ�ʱ�䣬Сʱ
	int pbm = 00;// �����ϰ�ʱ�䣬����
	int peh = 18;// �����°�ʱ�䣬Сʱ
	int pem = 0;// �����°�ʱ�䣬����
	float h1 = abh + (float) abm / 60;
	float h2 = aeh + (float) aem / 60;
	float h3 = pbh + (float) pbm / 60;
	float h4 = peh + (float) pem / 60;
	float hoursPerDay = h2 - h1 + (h4 - h3);// ÿ���ϰ�Сʱ��
	int daysPerWeek = 5;// ÿ�ܹ�������
	long milsecPerDay = 1000 * 60 * 60 * 24;// ÿ��ĺ�����
	float hoursPerWeek = hoursPerDay * daysPerWeek;// ÿ����Сʱ��

	public float calculateHours(String beginTime, String endTime) {
		// ��������ַ�����ʽ��ʱ�����ת��
		Date t1 = stringToDate(beginTime);// ��ʵ��ʼʱ��
		Date t2 = stringToDate(endTime);// ��ʵ����ʱ��
		// ��ʱ�����Ԥ����
		t1 = processBeginTime(t1);
		t2 = processEndTime(t2);
		// ����ʼʱ�����ڽ���ʱ�䣬����0
		if (t1.getTime() > t2.getTime()) {
			return 0;
		}
		// ��ʼʱ�䵽����ʱ�������������
		int weekCount = (int) ((t2.getTime() - t1.getTime()) / (milsecPerDay * 7));
		float totalHours = 0;
		totalHours += weekCount * hoursPerWeek;
		// ��������ʱ�䣬ʹ��ʼʱ��ͽ���ʱ����һ�����ڵ�����֮��
		t2.setTime(t2.getTime() - weekCount * 7 * milsecPerDay);
		int dayCounts = 0;// ��¼��ʼʱ��ͽ���ʱ��֮�乤��������
		// ������ʼʱ�䣬ʹ�ÿ�ʼʱ��ͽ���ʱ����ͬһ�죬�������ڵĹ������ڡ�
		while (t1.getTime() <= t2.getTime()) {
			Date temp = new Date(t1.getTime() + milsecPerDay);
			temp = processBeginTime(temp);
			temp.setHours(t1.getHours());
			temp.setMinutes(t1.getMinutes());
			if (temp.getTime() > t2.getTime()) {
				break;
			} else {
				t1 = temp;
				dayCounts++;
			}
		}
		totalHours += dayCounts * hoursPerDay;
		float hh1 = t1.getHours() + (float) t1.getMinutes() / 60;
		float hh2 = t2.getHours() + (float) t2.getMinutes() / 60;
		// ����ʼ������ͬһ������
		if (t1.getDay() == t2.getDay()) {
			float tt = 0;
			tt = hh2 - hh1;
			if (hh1 >= h1 && hh1 <= h2 && hh2 >= h3) {
				tt = tt - (h3 - h2);
			}
			totalHours += tt;
		} else {
			// ����ʼ��������ͬһ������
			float tt1 = h4 - hh1;
			float tt2 = hh2 - h1;
			if (hh1 <= h2) {
				tt1 = tt1 - (h3 - h2);
			}
			if (hh2 >= h3) {
				tt2 = tt2 - (h3 - h2);
			}
			totalHours += (tt1 + tt2);
		}
		return totalHours;
	}

	/**
	 * ��ʽ�����ʱ�䣺 yyyy-mm-dd hh:mm:ss ����x
	 * 
	 * @param t
	 * @return
	 */
	private String printDate(Date t) {
		String str;
		String xingqi = null;
		switch (t.getDay()) {
		case 0:
			xingqi = "������";
			break;
		case 1:
			xingqi = "����һ";
			break;
		case 2:
			xingqi = "���ڶ�";
			break;
		case 3:
			xingqi = "������";
			break;
		case 4:
			xingqi = "������";
			break;
		case 5:
			xingqi = "������";
			break;
		case 6:
			xingqi = "������";
			break;
		default:
			break;
		}
		str = format.format(t) + "  " + xingqi;
		return str;
	}

	/**
	 * �Խ���ʱ�����Ԥ����ʹ�䴦�ڹ������ڵĹ���ʱ�����
	 * 
	 * @param t
	 * @return
	 */
	private Date processEndTime(Date t) {
		float h = t.getHours() + (float) t.getMinutes() / 60;
		// ������ʱ�����������°�ʱ�䣬��������Ϊ�����°�ʱ��
		if (h >= h4) {
			t.setHours(peh);
			t.setMinutes(pem);
		} else {
			// ������ʱ�����������Ϣʱ�䣬��ô����Ϊ�����°�ʱ��
			if (h >= h2 && h <= h3) {
				t.setHours(aeh);
				t.setMinutes(aem);
			} else {
				// ������ʱ�����������ϰ�ʱ�䣬������ǰ��һ�죬����ʱ������Ϊ�����°�ʱ��
				if (t.getHours() <= h1) {
					t.setTime(t.getTime() - milsecPerDay);
					t.setHours(peh);
					t.setMinutes(pem);
				}
			}
		}
		// ������ʱ������ĩ����ô������ʱ����ǰ���Ƶ�����Ĺ����յ������°�ʱ��
		if (t.getDay() == 0) {
			t.setTime(t.getTime() - milsecPerDay * (t.getDay() == 6 ? 1 : 2));
			t.setHours(peh);
			t.setMinutes(pem);
		}
		if (t.getDay() == 6) {
			t.setTime(t.getTime() - milsecPerDay * (t.getDay() == 6 ? 1 : 2));
			t.setHours(peh);
			t.setMinutes(pem);
		}
		return t;
	}

	/**
	 * �Կ�ʼʱ�����Ԥ����
	 * 
	 * @param t1
	 * @return
	 */
	private Date processBeginTime(Date t) {
		float h = t.getHours() + (float) t.getMinutes() / 60;
		// ����ʼʱ�����������°�ʱ�䣬����ʼʱ�������һ��
		if (h >= h4) {
			t.setTime(t.getTime() + milsecPerDay);
			t.setHours(abh);
			t.setMinutes(abm);
		} else {
			// ����ʼʱ�����������Ϣʱ�䣬��ô����Ϊ�����ϰ�ʱ��
			if (h >= h2 && h <= h3) {
				t.setHours(pbh);
				t.setMinutes(pbm);
			} else {
				// ����ʼʱ�����������ϰ�ʱ�䣬��hour����Ϊ�����ϰ�ʱ��
				if (t.getHours() <= h1) {
					t.setHours(abh);
					t.setMinutes(abm);
				}
			}
		}
		// ����ʼʱ������ĩ����ô����ʼʱ��������Ƶ�����Ĺ����յ������ϰ�ʱ��
		if (t.getDay() == 0) {
			t.setTime(t.getTime() + milsecPerDay * (t.getDay() == 6 ? 2 : 1));
			t.setHours(abh);
			t.setMinutes(abm);
		}
		if (t.getDay() == 6) {
			t.setTime(t.getTime() + milsecPerDay * (t.getDay() == 6 ? 2 : 1));
			t.setHours(abh);
			t.setMinutes(abm);
		}
		return t;
	}

	/**
	 * ���ַ�����ʽ��ʱ��ת����Date��ʽ��ʱ��
	 * 
	 * @param time
	 * @return
	 */
	private Date stringToDate(String time) {
		try {
			return format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ȥ����ĩ�ڼ��չ���Сʱ
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 * @throws ParseException
	 */
	public static float CalculateHour(String beginTime, String endTime) throws ParseException {
		CalculateHours ch = new CalculateHours();
		float a = ch.calculateHours(beginTime, endTime);
		Calendar startDay = Calendar.getInstance();
		Calendar endDay = Calendar.getInstance();
		startDay.setTime(FORMATTER.parse(beginTime));
		endDay.setTime(FORMATTER.parse(endTime));
		String[] workday = printDay(startDay, endDay);
		String[] holiday = new String[] { "01-01", "01-02", "01-03", "05-01", "05-02", "05-03", "10-01", "10-02",
				"10-03", "10-04", "10-05", "10-06", "02-08", "02-09", "02-10" };
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR); // ��ȡ��ǰ���
		List<String> list = new ArrayList<String>();
		for (String string : holiday) {
			string = year + "-" + string;
			list.add(string);
		}
		String[] arr = list.toArray(new String[0]);
		int holidays = arrContrast(workday, arr);
		int holidayHous = holidays * 8;
		float b = (float) (Math.round(a * 10)) / 10;
		float workHours = b - holidayHous;
		return workHours;
	}

	public static void main(String[] args) throws ParseException {
		String beginTime = "2018-11-21 10:00:00";
		String endTime = "2018-11-26 90:00:00";
		CalculateHours ch = new CalculateHours();
		float b = ch.calculateHours(beginTime, endTime);
		System.out.println(b);
		float a = CalculateHours.CalculateHour(beginTime, endTime);
		System.out.println(a);
	}

	/**
	 * ȥ����������ͬ����
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	private static int arrContrast(String[] arr1, String[] arr2) {
		int count = 0;
		List<String> list = new LinkedList<String>();
		for (String str : arr1) { // �����һ������,list�����ֵΪ1,2,3,4
			if (!list.contains(str)) {
				list.add(str);
			}
		}
		for (String str : arr2) { // ����ڶ���������ں͵�һ��������ͬ��ֵ����ɾ��
			if (list.contains(str)) {
				list.remove(str);
				++count;
			}
		}
		return count;
	}

	private static final DateFormat FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

	private static String[] printDay(Calendar startDay, Calendar endDay) {
		List<String> list = new ArrayList<String>();
		// ���������ڿ�ʼ�ձ������մ���ִ�д�ӡ
		if (startDay.compareTo(endDay) >= 0) {
			return new String[] {};
		}
		// ���ڴ�ӡ�е�����
		Calendar currentPrintDay = startDay;
		while (true) {
			// ���ڼ�һ
			currentPrintDay.add(Calendar.DATE, 1);
			// ���ڼ�һ���ж��Ƿ�ﵽ�����գ��ﵽ����ֹ��ӡ
			if (currentPrintDay.compareTo(endDay) == 0) {
				break;
			}
			list.add(FORMATTER.format(currentPrintDay.getTime()));
		}
		String[] arr = list.toArray(new String[0]);
		return arr;
	}
}
