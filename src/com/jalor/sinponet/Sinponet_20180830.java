package com.jalor.sinponet;

import java.io.File;
import java.io.IOException;

public class Sinponet_20180830 {

	public static void main(String[] args) throws IOException {
		File oldFile = new File("D:/apache-tomcat-8081/webapps/TestBaiDu/upload/招聘模块进度表.docx");
		  if(!oldFile.exists())
		  {
		   oldFile.createNewFile();
		  }
		  System.out.println("修改前文件名称是："+oldFile.getName());
		  String rootPath = oldFile.getParent();
		  System.out.println("根路径是："+rootPath);
		  File newFile = new File(rootPath + File.separator + "PMSTmp" + ".docx");
		  System.out.println("修改后文件名称是："+newFile.getName());
		  if (oldFile.renameTo(newFile)) 
		  {
		   System.out.println("修改成功!");
		  } 
		  else 
		  {
		   System.out.println("修改失败");
		  }
	}
	
}
