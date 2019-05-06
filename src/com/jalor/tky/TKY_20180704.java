package com.jalor.tky;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TKY_20180704 {

	public static void main(String[] args) {
		String idCard = "142401196008310352��ð�";
		
		// ������֤�Ƿ�������� 
		Pattern pattern = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher aMatcher = pattern.matcher(idCard);
		boolean isZH = aMatcher.find();
		
		System.out.println(isZH);
		
		// ������֤λ���Ƿ��������Ƿ���λ����15��17��18��
		boolean amount = (idCard.length() == 15 || idCard.length() == 17 || idCard.length() == 18);
		
		System.out.println(amount);
		
		// ����������������ʱ������true
		final boolean existed = (isZH == false) && (amount == true);
		
		System.out.println(existed);
		
		
		
	}
	
}
