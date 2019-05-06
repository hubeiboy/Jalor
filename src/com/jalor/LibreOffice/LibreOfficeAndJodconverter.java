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
		File inputFile = new File("D:/招聘模块进度表2018.09.07.docx");
		// File inputFile = new File("d:/xls.xls");
		// File inputFile = new File("d:/jpg.jpg");
		// File inputFile = new File("d:/gif.gif");

		// txt:使用libreOffice来转换pdf，转换成功，但是中文有乱码!!!!!
		// doc:这是office中的doc文档，可以转换成功，并且中文没有乱码
		// docx:这是office中的docx文档，可以转换成功，并且中文没有乱码
		// ppt和pptx：转换成功。
		// xls:转换成功，没有中文乱码
		// xlsx：转换成功
		// jpg和png:成功

		System.out.println("libreOffice开始转换..............................");
		Long startTime = new Date().getTime();

		OfficeManager officeManager = null;
		try {
			System.out.println("尝试连接已启动的服务...");
			ExternalOfficeManagerConfiguration externalProcessOfficeManager = new ExternalOfficeManagerConfiguration();
			externalProcessOfficeManager.setConnectOnStart(true);
			externalProcessOfficeManager.setPortNumber(8100);
			officeManager = externalProcessOfficeManager.buildOfficeManager();
			officeManager.start();
			System.out.println("转换服务启动成功!");
		} catch (Exception e) {
			// 命令方式：soffice -headless
			// -accept="socket,host=127.0.0.1,port=8100;urp;"
			// -nofirststartwizard
			System.out.println("启动新服务!");
			String libreOfficePath = "E:/Program Files/LibreOffice";
			// 此类在jodconverter-core中3版本中存在，在2.2.2版本中不存在
			DefaultOfficeManagerConfiguration configuration = new DefaultOfficeManagerConfiguration();
			// libreOffice的安装目录
			configuration.setOfficeHome(new File(libreOfficePath));
			// 设置端口号
			configuration.setPortNumber(8100);
			// 设置任务执行超时为5分钟
			configuration.setTaskExecutionTimeout(1000 * 60 * 5L);
			// 设置任务队列超时为24小时
			configuration.setTaskQueueTimeout(1000 * 60 * 60 * 24L);

			// 开启转换服务
			officeManager = configuration.buildOfficeManager();
			officeManager.start();
			System.out.println("服务启动成功!");
		}
		OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
		System.out.println("===============对文件名称进行处理中=================");
		String inputFileName = String.valueOf(inputFile);
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_V);
		// char[] input = inputFileName.trim().toCharArray();
		// 获取文件名称
		char[] input = inputFile.getName().trim().toCharArray();
		// 获取文件所在的路径名称
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
		System.out.println("=====处理后的文件名称======" + fileName);
		File outputFile = new File(pathName + fileName + ".pdf");
		System.out.println("转换后文件所在路径：" + String.valueOf(outputFile));
		// File outputFile = new File("d:/LibrePDF.pdf");
		converter.convert(inputFile, outputFile);
		// converter.convert(inputFile, outputFile, outputFormat)
		// 转换结束
		officeManager.stop();
		System.out.println("转换结束。。。。。");

		// 转换时间
		long endTime = new Date().getTime();
		long time = endTime - startTime;
		System.out.println("libreOffice转换所用时间为：" + time);

		return outputFile.getPath();
	}

	public static void main(String[] args) {

		doDocToFdpLibre();

	}
}
