package com.jalor.others;


public class AAAA {
	public static void main(String[] args) {

		outputA(65);
	    outputA(97);
	      
	}

	// ´òÓ¡asciiÂë±í
	public static void outputA(int count){
		for (int i = 0; i < 26; i++) {
			System.out.print((char)(count+ i));
		}
		System.out.println();
	}
}
