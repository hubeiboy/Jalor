package com.jalor.sinponet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Image {
	public static void main(String[] args) {
		// 测试从Base64编码转换为图片文件
		String strImg = "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";
		GenerateImage(strImg, "D:\\wangyc.jpg");

		// 测试从图片文件转换为Base64编码
		System.out.println(GetImageStr("D:\\wangyc.jpg"));
	}

	public static String GetImageStr(String imgFilePath) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		byte[] data = null;

		// 读取图片字节数组
		try {
			InputStream in = new FileInputStream(imgFilePath);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}

	public static boolean GenerateImage(String imgStr, String imgFilePath) {// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) // 图像数据为空
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] bytes = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// 调整异常数据
					bytes[i] += 256;
				}
			}
			// 生成jpeg图片
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(bytes);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}