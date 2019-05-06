package com.jalor.others;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class HL_toFace {

	public static void main(String[] args) {
		// ʹ��java.util.Arrays�����sort��������
		int[] arr = { 1, 4, 6, 333, 8, 2 };
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}

		System.out.println();
		// Bubble(arr);

		System.out.println();
		// nineSort();

		System.out.println();
		outputA(65);
		outputA(97);

		System.out.println();
		mapLoop();

	}

	// ð������
	public static void Bubble(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int t = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = t;
				}
			}
		}
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	// ��ӡ�žų˷���
	public static void nineSort() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + j * i + "\t");
			}
			System.out.println();
		}
	}

	// ����һ��MAP��ѭ��д�루keyΪ1��10��valueΪA��J������ѭ�����
	public static void mapLoop() {

		// ��������
		Map<String, String> map = new LinkedHashMap<>();
		// ��������
		// Map<String, String> map = new HashMap<String, String>();

		for (int i = 1; i <= 10; i++) {
			map.put(String.valueOf(i), String.valueOf((char) (65 + i - 1)));
		}
		for (String s : map.keySet()) {
			System.out.println("key: " + s + "\tvalue: " + map.get(s));
		}

	}

	// ��ӡascii���
	public static void outputA(int count) {
		for (int i = 0; i < 26; i++) {
			System.out.print((char) (count + i));
		}
		System.out.println();
	}

}
