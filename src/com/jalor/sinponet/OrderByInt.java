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
		System.out.println("最大值: " + Collections.max(input));
		System.out.println("最小值: " + Collections.min(input));
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
		Collections.sort(list);// 按字符顺序排序从小到大排序
		sop("Collections.sort(list)=" + list);
		String s = Collections.max(list);// 获取最大值
		sop("max<s>=" + s);
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

	class StrlenComparator implements Comparator<String> {
		public int compare(String s1, String s2)// 按长度排序
		{
			if (s1.length() == s2.length())
				return s1.compareTo(s2);// 长度相等，比较字符顺序
			return s1.length() - s2.length();
		}
	}

}
