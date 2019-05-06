package com.jalor.sinponet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderByInt {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>();
		input.add(00001);
		input.add(00002);
		input.add(00007);
		input.add(00010);
		input.add(00112);
		System.out.println(input);
		System.out.println("���ֵ: " + Collections.max(input));
		System.out.println("��Сֵ: " + Collections.min(input));
		System.out.println("--------------------------------------");
		List<String> list = new ArrayList<String>();
		list.add("00001");
		list.add("00002");
		list.add("23410");
		list.add("00007");
		list.add("00010");
		list.add("00112");
		sop(list);
		sop(Collections.max(list));
		Collections.sort(list);// ���ַ�˳�������С��������
		sop("Collections.sort(list)=" + list);
		String s = Collections.max(list);// ��ȡ���ֵ
		sop("max<s>=" + s);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

	class StrlenComparator implements Comparator<String> {
		public int compare(String s1, String s2)// ����������
		{
			if (s1.length() == s2.length())
				return s1.compareTo(s2);// ������ȣ��Ƚ��ַ�˳��
			return s1.length() - s2.length();
		}
	}

}
