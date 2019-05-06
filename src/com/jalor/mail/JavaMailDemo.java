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
		// ���÷����ʼ��Ļ�������
		final Properties props = new Properties();

		/**
		 * ���õ����ԣ� mail.store.protocol / mail.transport.protocol / mail.host /
		 * mail.user / mail.from
		 */
		// ��ʾSMTP�����ʼ�����Ҫ���������֤
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.163.com");
		// �����˵��˺�Ҳ������qq�����п���smtp����������ַ
		props.put("mail.user", "fm103097@163.com");
		// ����SMTP����ʱ��Ҫ�ṩ������(��Ȩ��)
		props.put("mail.password", "lenian123");

		// ������Ȩ��Ϣ�����ڽ���SMTP���������֤
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// �û���������
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};
		// ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
		Session mailSession = Session.getInstance(props, authenticator);
		// �����ʼ���Ϣ
		MimeMessage message = new MimeMessage(mailSession);
		// ���÷�����
		InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
		message.setFrom(form);
		// �����ռ���
		InternetAddress to = new InternetAddress("lenian@perfect-cn.cn");
		message.setRecipient(RecipientType.TO, to);
		// �����ʼ�����
		message.setSubject("�����ʼ�");

		File file = new File("D:\\A.xlsx");

		// �����ʼ���������
		message.setContent("����һ�����Ե��ʼ�,�����ת��<a href='http://www.baidu.com'>�ٶ�</a>", "text/html;charset=UTF-8");

		// �����ʼ�
		Transport transport = new SMTPSSLTransport(mailSession, null);
		// ���������Ҫ������ʡ��
		transport.connect("smtp.163.com", props.getProperty("mail.user"), props.getProperty("mail.password"));
		System.out.println("�ʼ��Ƿ��ͳɹ���" + transport.isConnected());
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();
	}
}
