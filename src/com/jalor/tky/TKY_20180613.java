package com.jalor.tky;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TKY_20180613 {

	public static void main(String[] args) {
		String time="2ʱ00��00��";
    	long s=Integer.parseInt(time.substring(0,time.indexOf("ʱ")))*3600;    //Сʱ
    	s+=Integer.parseInt(time.substring(time.indexOf("ʱ")+1,time.indexOf("��")))*60;    //����
    	s+=Integer.parseInt(time.substring(time.indexOf("��")+1,time.indexOf("��")));    //��
    	System.out.println(s+"��");
    	int seconds = Integer.parseInt(String.valueOf(s));
    	int temp=0;
    	StringBuffer sb=new StringBuffer();
    	temp = seconds/3600;
    	sb.append((temp<10)?"0"+temp+":":""+temp+":");

    	temp=seconds%3600/60;
    	sb.append((temp<10)?"0"+temp+":":""+temp+":");

    	temp=seconds%3600%60;
    	sb.append((temp<10)?"0"+temp:""+temp);

    	System.out.println(sb.toString());
    	System.out.println("==================================================================");
    	/*Date date = null;
    	SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
		Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher aMatcher = pattern.matcher(time);
		try {
			if (aMatcher.find() == true) {
				date = hms.parse(time);
			} else {
				date = hms.parse(time);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println(date.toLocaleString());*/
    	
    	System.out.println("*****************************************************************");
    	SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
    	String str = time.replace("ʱ", ":").replace("��", ":").replace("��", "");
    	String[] hmsArray = str.split(":");
    	long count = Long.valueOf(hmsArray[0])*3600 + Long.valueOf(hmsArray[1])*60 + Long.valueOf(hmsArray[2]);
    	System.out.println("ʱ������"+ count +" �룡");
    	Date date = null;
    	try {
			date = hms.parse(str);//�������ʹ洢ʱ��
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	System.out.println("ʱ�����ʽ����"+hms.format(date));
	}
}
