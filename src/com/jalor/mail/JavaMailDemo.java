package com.jalor.mail;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPSSLTransport;

public class JavaMailDemo {

	public static void main(String[] args) throws MessagingException {
		// 配置发送邮件的环境属性
		final Properties props = new Properties();

		/**
		 * 可用的属性： mail.store.protocol / mail.transport.protocol / mail.host /
		 * mail.user / mail.from
		 */
		// 表示SMTP发送邮件，需要进行身份验证
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.163.com");
		// 发件人的账号也是你在qq邮箱中开启smtp服务的邮箱地址
		props.put("mail.user", "fm103097@163.com");
		// 访问SMTP服务时需要提供的密码(授权码)
		props.put("mail.password", "lenian123");

		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// 使用环境属性和授权信息，创建邮件会话
		Session mailSession = Session.getInstance(props, authenticator);
		// 创建邮件消息
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
		message.setFrom(form);
		// 设置收件人
		InternetAddress to = new InternetAddress("lenian@perfect-cn.cn");
		message.setRecipient(RecipientType.TO, to);
		// 设置邮件标题
		message.setSubject("测试邮件");

		File file = new File("D:\\A.xlsx");

		// 设置邮件的内容体
		message.setContent("这是一个测试的邮件,点击跳转到<a href='http://www.baidu.com'>百度</a>", "text/html;charset=UTF-8");

		// 发送邮件
		Transport transport = new SMTPSSLTransport(mailSession, null);
		// 这个步很重要，不能省略
		transport.connect("smtp.163.com", props.getProperty("mail.user"), props.getProperty("mail.password"));
		System.out.println("邮件是否发送成功？" + transport.isConnected());
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
}
