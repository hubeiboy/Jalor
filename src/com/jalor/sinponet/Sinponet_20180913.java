package com.jalor.sinponet;

import java.util.ArrayList;
import java.util.List;

public class Sinponet_20180913 {

	public static void main(String[] args) {
		// str是你遍历出来的结果 str=list.get(0);
		String str = "[D:/pic/1.png]";
		String s = str.substring(str.lastIndexOf("/") + 1, str.length() - 1);
		System.out.println(s);
		System.out.println("===================================");
		List<String> list = new ArrayList<>();
		list.add("1.jpg");
		list.add("2.png");
		list.add("3.JEPG");
		list.add("4.gif");
		list.add("1.png");
		list.add("2.png");
		list.add("2.png");
		// int retval = list.indexOf("2.png");
		// System.out.println("The element E is at index " + retval);
		String cell = "2.png";
		if (list.indexOf(cell) != -1) {
			System.out.println("------表示包含2.png------");
		}

	}
}
