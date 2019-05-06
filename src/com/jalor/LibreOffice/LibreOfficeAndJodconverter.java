package com.jalor.LibreOffice;

import java.io.File;
import java.util.Date;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.ExternalOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class LibreOfficeAndJodconverter {

	public static String doDocToFdpLibre() {

		// File inputFile = new File("d:/1.txt");
		// File inputFile = new File("d:/ppt.ppt");
		// File inputFile = new File("d:/pptx.pptx");
		// File inputFile = new File("d:/doc.doc");
		File inputFile = new File("D:/��Ƹģ����ȱ�2018.09.07.docx");
		// File inputFile = new File("d:/xls.xls");
		// File inputFile = new File("d:/jpg.jpg");
		// File inputFile = new File("d:/gif.gif");

		// txt:ʹ��libreOffice��ת��pdf��ת���ɹ�����������������!!!!!
		// doc:����office�е�doc�ĵ�������ת���ɹ�����������û������
		// docx:����office�е�docx�ĵ�������ת���ɹ�����������û������
		// ppt��pptx��ת���ɹ���
		// xls:ת���ɹ���û����������
		// xlsx��ת���ɹ�
		// jpg��png:�ɹ�

		System.out.println("libreOffice��ʼת��..............................");
		Long startTime = new Date().getTime();

		OfficeManager officeManager = null;
		try {
			System.out.println("���������������ķ���...");
			ExternalOfficeManagerConfiguration externalProcessOfficeManager = new ExternalOfficeManagerConfiguration();
			externalProcessOfficeManager.setConnectOnStart(true);
			externalProcessOfficeManager.setPortNumber(8100);
			officeManager = externalProcessOfficeManager.buildOfficeManager();
			officeManager.start();
			System.out.println("ת�����������ɹ�!");
		} catch (Exception e) {
			// ���ʽ��soffice -headless
			// -accept="socket,host=127.0.0.1,port=8100;urp;"
			// -nofirststartwizard
			System.out.println("�����·���!");
			String libreOfficePath = "E:/Program Files/LibreOffice";
			// ������jodconverter-core��3�汾�д��ڣ���2.2.2�汾�в�����
			DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
			// libreOffice�İ�װĿ¼
			configuration.setOfficeHome(new File(libreOfficePath));
			// ���ö˿ں�
			configuration.setPortNumber(8100);
			// ��������ִ�г�ʱΪ5����
			configuration.setTaskExecutionTimeout(1000 * 60 * 5L);
			// ����������г�ʱΪ24Сʱ
			configuration.setTaskQueueTimeout(1000 * 60 * 60 * 24L);

			// ����ת������
			officeManager = configuration.buildOfficeManager();
			officeManager.start();
			System.out.println("���������ɹ�!");
		}
		OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
		System.out.println("===============���ļ����ƽ��д�����=================");
		String inputFileName = String.valueOf(inputFile);
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		// char[] input = inputFileName.trim().toCharArray();
		// ��ȡ�ļ�����
		char[] input = inputFile.getName().trim().toCharArray();
		// ��ȡ�ļ����ڵ�·������
		String pathName = inputFileName.substring(0, inputFileName.lastIndexOf("\\") + 1);
		String outputFileName = "";
		try {
			for (int i = 0; i < input.length; i++) {
				if (Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")) {
					String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
					outputFileName += temp[0];
				} else {
					outputFileName += Character.toString(input[i]);
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
			// Log.v(TAG, "BadHanyuPinyinOutputFormatCombination");
		}
		String fileName = outputFileName.substring(0, outputFileName.lastIndexOf("."));
		System.out.println("=====�������ļ�����======" + fileName);
		File outputFile = new File(pathName + fileName + ".pdf");
		System.out.println("ת�����ļ�����·����" + String.valueOf(outputFile));
		// File outputFile = new File("d:/LibrePDF.pdf");
		converter.convert(inputFile, outputFile);
		// converter.convert(inputFile, outputFile, outputFormat)
		// ת������
		officeManager.stop();
		System.out.println("ת����������������");

		// ת��ʱ��
		long endTime = new Date().getTime();
		long time = endTime - startTime;
		System.out.println("libreOfficeת������ʱ��Ϊ��" + time);

		return outputFile.getPath();
	}

	public static void main(String[] args) {

		doDocToFdpLibre();

	}
}
