package com.jalor.others;

import java.io.File;
import java.io.FileNotFoundException;

public class SearchFile {

	public static void main(String[] args) throws FileNotFoundException {
		File files = new File("D:/"); // ����File����,ָ��F�̸�Ŀ¼
		String[] names = files.list(); // ��ȡF�̸�Ŀ¼�����ļ���·��,�����ַ������鷵��
		System.out.println(files.getPath() + files.getName());
		for (String s : names) { // �����ַ�������
			boolean a = s.startsWith("beyond"); // �ļ���ǰ׺����ja�ķ���true,û���򷵻�false
			boolean b = (new File(files.getAbsolutePath() + s)).isFile(); // �жϱ���ѭ�����ַ�����ָ��������Ƿ����ļ�,���򷵻�true.���򷵻�false
			boolean c = s.contains("va"); // �ļ����Ƿ����"va",�����򷵻�true,����false
			if (a && b) { // �˴�����������Ҫ�����޸�
				System.out.println(s); // ��ӡ�������������ļ�
			}
		}
	}

}