package com.jalor.tky;

public class TKY_20180626 {

	public static void main(String[] args) {
		String str = " lenian ";
		String st = "le nian  ";
		System.out.println(str.substring(1));
		
		System.out.println(System.currentTimeMillis()-1000*60*60);
		
		System.out.println("AAAAA"+str.trim()+"BBBBB");
		System.out.println("AAAAA"+st.replaceAll(" ", "")+"BBBBB");
		
	}
}
