package com.jalor.others;

import java.io.File;
import java.io.FileNotFoundException;

public class SearchFile {

	public static void main(String[] args) throws FileNotFoundException {
		File files = new File("D:/"); // 创建File对象,指向F盘根目录
		String[] names = files.list(); // 获取F盘根目录所有文件和路径,并以字符串数组返回
		System.out.println(files.getPath() + files.getName());
		for (String s : names) { // 遍历字符串数组
			boolean a = s.startsWith("beyond"); // 文件名前缀带有ja的返回true,没有则返回false
			boolean b = (new File(files.getAbsolutePath() + s)).isFile(); // 判断本次循环的字符串所指向的内容是否是文件,是则返回true.否则返回false
			boolean c = s.contains("va"); // 文件名是否包含"va",包含则返回true,否则false
			if (a && b) { // 此处条件根据需要进行修改
				System.out.println(s); // 打印出符合条件的文件
			}
		}
	}

}