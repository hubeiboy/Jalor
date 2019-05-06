package com.jalor.others;

import java.net.URL;

public class ClassDemo {

	public static void main(String[] args) {
		ClassDemo c = new ClassDemo();
		Class cls = c.getClass();
		// finds resource relative to the class location
		URL url = cls.getResource("svnµÿ÷∑.txt");
		System.out.println("Value = " + url);
		// finds resource relative to the class location
		url = cls.getResource("newfolder/a.txt");
		System.out.println("Value = " + url);
	}

}
