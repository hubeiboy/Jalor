package com.jalor.sinponet;

import java.io.File;

public class seeFiles {

	public static void main(String[] args) {
		String path = "D:\\UnZipOrRar"; // Ҫ������·��
		File file = new File(path); // ��ȡ��file����
		File[] fs = file.listFiles(); // ����path�µ��ļ���Ŀ¼������File������
		for (File f : fs) { // ����File[]����
			if (!f.isDirectory()) // ����Ŀ¼(���ļ�)�����ӡ
				System.out.println(f);
		}
	}

}
