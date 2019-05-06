package com.jalor.sinponet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import com.github.junrar.Archive;
import com.github.junrar.rarfile.FileHeader;

/**
 * 
 * @author liuBf ��˵��:��ѹ�ļ������� *
 */
public class UnZipOrRarUtils {

	public static void main(String[] args) {
		// throw new Exception("ֻ֧��zip��rar��ʽ��ѹ������")
		try {
			// untar("D:\\1.rar", "D:\\png");
			unRarFile("D:\\UnZipOrRar\\1.rar", "D:\\UnZipOrRar\\");
			unzip("D:\\UnZipOrRar\\2.zip", "D:\\UnZipOrRar\\");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*** �����õ���synchronized ��Ҳ���Ƿ�ֹ���ֲ������� ***/
	public static synchronized void untar(String tarFileName, String extPlace) throws Exception {
		unRarFile(tarFileName, extPlace);
	}

	public static synchronized void unzip(String zipFileName, String extPlace) throws Exception {
		unZipFiles(zipFileName, extPlace);
	}

	/**
	 * ��ѹzip��ʽ��ѹ���ļ���ָ��λ��
	 * 
	 * @param zipFileName
	 *            ѹ���ļ�
	 * @param extPlace
	 *            ��ѹĿ¼
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static boolean unZipFiles(String zipFileName, String extPlace) throws Exception {
		System.setProperty("sun.zip.encoding", System.getProperty("sun.jnu.encoding"));
		try {
			(new File(extPlace)).mkdirs();
			File f = new File(zipFileName);
			ZipFile zipFile = new ZipFile(zipFileName, "GBK"); // ���������ļ������������
			if ((!f.exists()) && (f.length() <= 0)) {
				throw new Exception("Ҫ��ѹ���ļ�������!");
			}
			String strPath, gbkPath, strtemp;
			File tempFile = new File(extPlace);
			strPath = tempFile.getAbsolutePath();
			Enumeration<?> e = zipFile.getEntries();
			while (e.hasMoreElements()) {
				ZipEntry zipEnt = (ZipEntry) e.nextElement();
				System.out.println("����һ����zip�н�ѹ�������ļ���" + zipEnt.getName());
				gbkPath = zipEnt.getName();
				if (zipEnt.isDirectory()) {
					strtemp = strPath + File.separator + gbkPath;
					File dir = new File(strtemp);
					dir.mkdirs();
					continue;
				} else { // ��д�ļ�
					InputStream is = zipFile.getInputStream(zipEnt);
					BufferedInputStream bis = new BufferedInputStream(is);
					gbkPath = zipEnt.getName();
					strtemp = strPath + File.separator + gbkPath;// ��Ŀ¼
					String strsubdir = gbkPath;
					for (int i = 0; i < strsubdir.length(); i++) {
						if (strsubdir.substring(i, i + 1).equalsIgnoreCase("/")) {
							String temp = strPath + File.separator + strsubdir.substring(0, i);
							File subdir = new File(temp);
							if (!subdir.exists())
								subdir.mkdir();
						}
					}
					FileOutputStream fos = new FileOutputStream(strtemp);
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					int c;
					while ((c = bis.read()) != -1) {
						bos.write((byte) c);
					}
					bos.close();
					fos.close();
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * ����ԭʼrar·������ѹ��ָ���ļ�����.
	 * 
	 * @param srcRarPath
	 *            ԭʼrar·��
	 * @param dstDirectoryPath
	 *            ��ѹ�����ļ���
	 */
	public static void unRarFile(String srcRarPath, String dstDirectoryPath) {
		if (!srcRarPath.toLowerCase().endsWith(".rar")) {
			System.out.println("��rar�ļ���");
			return;
		}
		File dstDiretory = new File(dstDirectoryPath);
		if (!dstDiretory.exists()) {// Ŀ��Ŀ¼������ʱ���������ļ���
			dstDiretory.mkdirs();
		}
		Archive a = null;
		try {
			a = new Archive(new File(srcRarPath));
			if (a != null) {
				// a.getMainHeader().print(); // ��ӡ�ļ���Ϣ.
				FileHeader fh = a.nextFileHeader();
				while (fh != null) {
					// ��ֹ�ļ���������������Ĵ���
					String fileName = fh.getFileNameW().isEmpty() ? fh.getFileNameString() : fh.getFileNameW();
					System.out.println("����һ����rar��ѹ�������ļ���" + fileName);
					if (fh.isDirectory()) { // �ļ���
						File fol = new File(dstDirectoryPath + File.separator + fileName);
						fol.mkdirs();
					} else { // �ļ�
						File out = new File(dstDirectoryPath + File.separator + fileName.trim());
						try {
							if (!out.exists()) {
								if (!out.getParentFile().exists()) {// ���·�����ܶ༶��������Ҫ������Ŀ¼.
									out.getParentFile().mkdirs();
								}
								out.createNewFile();
							}
							FileOutputStream os = new FileOutputStream(out);
							a.extractFile(fh, os);
							os.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
					fh = a.nextFileHeader();
				}
				a.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}