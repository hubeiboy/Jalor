package com.jalor.sinponet;

import java.io.File;
import java.io.IOException;

public class Sinponet_20180830 {

	public static void main(String[] args) throws IOException {
		File oldFile = new File("D:/apache-tomcat-8081/webapps/TestBaiDu/upload/��Ƹģ����ȱ�.docx");
		  if(!oldFile.exists())
		  {
		   oldFile.createNewFile();
		  }
		  System.out.println("�޸�ǰ�ļ������ǣ�"+oldFile.getName());
		  String rootPath = oldFile.getParent();
		  System.out.println("��·���ǣ�"+rootPath);
		  File newFile = new File(rootPath + File.separator + "PMSTmp" + ".docx");
		  System.out.println("�޸ĺ��ļ������ǣ�"+newFile.getName());
		  if (oldFile.renameTo(newFile)) 
		  {
		   System.out.println("�޸ĳɹ�!");
		  } 
		  else 
		  {
		   System.out.println("�޸�ʧ��");
		  }
	}
	
}
