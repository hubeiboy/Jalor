package com.jalor.others;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Everything {

	// ����Ҫƥ����ļ���
	private static String fileNamePatch = "";

	// ����ƥ����,���ǵ����ܻ����ͬ�����ļ��к��ļ�������������һ��List����ż���������File����
	private static List<File> compareResultList = new ArrayList<File>();

	/**
	 * ����ʱ���õĽӿڷ������õ�ʱ�����ɾ��
	 */
	public static void main(String[] args) {

		// Ҫƥ����ļ�����������,�޸ĵ�ʱ��Ӧ�øĳ����洫������
		String tempFileNamePatch = "ABC";
		// ָ����Ҫ�������̷���������
		String tempDiskPath = "D:";

		Everything.exc(tempFileNamePatch, tempDiskPath);

	}

	/**
	 * ����ʼ
	 */
	public static void exc(String tempFileNamePatch, String tempDiskPath) {

		// ��ʼ��
		fileNamePatch = tempFileNamePatch;

		// ���û��ָ���̷��Ļ�
		if (tempDiskPath == null || tempDiskPath.trim().length() == 0) {

			// ȡ�õ������е��̷�·��
			File[] roots = File.listRoots();
			// ѭ�����Ե������̷�����ƥ�����
			for (File root : roots) {
				Everything.readFolder(root);
			}

		} else {
			// ���ָ���̷��Ļ���ֻ��ָ�����̷����м���

			if (tempDiskPath == null || tempDiskPath.trim().length() == 0) {
				return;
			}

			// �������̷�·��������ȷ���̷�·���ĳ��ϣ��Ƴ�����
			File checkFile = new File(tempDiskPath);
			if (!checkFile.isDirectory())
				return;

			// if all check ok, then begin to search
			Everything.readFolder(new File(tempDiskPath));
		}

		// �������Ժ�����������(�ļ����� ·��)
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

			// ָ���ļ�����ƥ��Ƚ�
			compareFile(fileTemp);

			// ������file���ļ��У������ļ���ʱ�����������ļ�
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

		// �ļ���ȡ��
		String fileName = file.getName();

		// ������ļ��Ļ���ȡ�ļ�����ʱ����ļ�������չ��ȥ��
		if (file.isFile()) {

			int lastIndex = (fileName.lastIndexOf(".") == -1 ? fileName.length() : fileName.lastIndexOf("."));

			fileName = fileName.substring(0, lastIndex);
		}

		// ƥ���ļ���,ƥ��ĳ��ϣ�����ǰ���ļ���ӵ�compareResultList��
		if (fileName.contains(fileNamePatch)) {
			compareResultList.add(file);
		}

	}

}
