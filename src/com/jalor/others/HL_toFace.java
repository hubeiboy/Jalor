package com.jalor.others;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class HL_toFace {

	public static void main(String[] args) {
		// 使用java.util.Arrays对象的sort方法排序
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

	// 冒泡排序
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

	// 打印九九乘法表
	public static void nineSort() {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + j * i + "\t");
			}
			System.out.println();
		}
	}

	// 定义一个MAP对循环写入（key为1到10，value为A到J），并循环输出
	public static void mapLoop() {

		// 有序排列
		Map<String, String> map = new LinkedHashMap<>();
		// 无序排列
		// Map<String, String> map = new HashMap<String, String>();

		for (int i = 1; i <= 10; i++) {
			map.put(String.valueOf(i), String.valueOf((char) (65 + i - 1)));
		}
		for (String s : map.keySet()) {
			System.out.println("key: " + s + "\tvalue: " + map.get(s));
		}

	}

	// 打印ascii码表
	public static void outputA(int count) {
		for (int i = 0; i < 26; i++) {
			System.out.print((char) (count + i));
		}
		System.out.println();
	}

}
