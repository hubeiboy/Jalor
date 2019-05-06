package com.jalor.others;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Everything {

	// 保存要匹配的文件名
	private static String fileNamePatch = "";

	// 储存匹配结果,考虑到可能会出现同名的文件夹和文件，所以这里用一个List来存放检索出来的File对象
	private static List<File> compareResultList = new ArrayList<File>();

	/**
	 * 测试时候用的接口方法，用的时候可以删除
	 */
	public static void main(String[] args) {

		// 要匹配的文件名，测试用,修改的时候应该改成外面传进来的
		String tempFileNamePatch = "ABC";
		// 指定的要搜索的盘符，测试用
		String tempDiskPath = "D:";

		Everything.exc(tempFileNamePatch, tempDiskPath);

	}

	/**
	 * 处理开始
	 */
	public static void exc(String tempFileNamePatch, String tempDiskPath) {

		// 初始化
		fileNamePatch = tempFileNamePatch;

		// 如果没有指定盘符的话
		if (tempDiskPath == null || tempDiskPath.trim().length() == 0) {

			// 取得电脑所有的盘符路径
			File[] roots = File.listRoots();
			// 循环电脑的所有盘符进行匹配检索
			for (File root : roots) {
				Everything.readFolder(root);
			}

		} else {
			// 如果指定盘符的话，只对指定的盘符进行检索

			if (tempDiskPath == null || tempDiskPath.trim().length() == 0) {
				return;
			}

			// 给定的盘符路径不是正确的盘符路径的场合，推出程序
			File checkFile = new File(tempDiskPath);
			if (!checkFile.isDirectory())
				return;

			// if all check ok, then begin to search
			Everything.readFolder(new File(tempDiskPath));
		}

		// 检索完以后，输出检索结果(文件名： 路径)
		for (File fileResult : compareResultList) {
			System.out.println(fileResult.getName() + ":   " + fileResult.getAbsolutePath());
		}
	}

	/**
	 * @param file:
	 *            file or folder
	 */
	public static void readFolder(File file) {

		System.out.println(file.getName());

		if (file == null)
			return;

		//
		File[] subFile = file.listFiles();

		for (File fileTemp : subFile) {

			// 指定文件名的匹配比较
			compareFile(fileTemp);

			// 如果这个file是文件夹，不是文件的时候，搜索其子文件
			if (!fileTemp.isFile()) {
				readFolder(fileTemp);
			}
		}

	}

	/**
	 * @param file:
	 *            file or folder
	 */
	public static void compareFile(File file) {

		if (file == null)
			return;

		// 文件名取得
		String fileName = file.getName();

		// 如果是文件的话，取文件名的时候把文件类型扩展名去掉
		if (file.isFile()) {

			int lastIndex = (fileName.lastIndexOf(".") == -1 ? fileName.length() : fileName.lastIndexOf("."));

			fileName = fileName.substring(0, lastIndex);
		}

		// 匹配文件名,匹配的场合，将当前的文件添加到compareResultList中
		if (fileName.contains(fileNamePatch)) {
			compareResultList.add(file);
		}

	}

}
