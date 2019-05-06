package com.jalor.mail;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * �����ʼ�������
 * 
 * @author tp
 *
 */
public class SendMailAcceUtils {

	public static void main(String[] args) {

		start();

	}

	public static void start() {
		String receive = "lenian@perfect-cn.cn";
		String subject = "�ʼ����⣺��������";
		String msg = "����һ�����Ե��ʼ�,�����ת��<a href='http://www.baidu.com'>�ٶ�</a>";
		String filename = "D:\\A.xlsx";
		try {
			SendMailAcceUtils.sendMail(receive, subject, msg, filename);
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ʹ��������ʼ�
	 * 
	 * @param receive
	 *            �ռ���
	 * @param subject
	 *            �ʼ�����
	 * @param msg
	 *            �ʼ�����
	 * @param filename
	 *            ������ַ
	 * @return
	 * @throws GeneralSecurityException
	 */
	public static boolean sendMail(String receive, String subject, String msg, String filename)
			throws GeneralSecurityException {
		if (null == receive) {
			return false;
		}

		// "lenian@perfect-cn.cn", "Abcd1234"
		// �����˵�������
		final String from = "fm103097@163.com";
		// �����˵�����������
		final String pass = "lenian123";

		// ָ�������ʼ�������Ϊ smtp.qq.com
		String host = "smtp.163.com"; // �ʼ�������

		// ��ȡϵͳ����
		Properties properties = System.getProperties();

		// �����ʼ�������
		properties.setProperty("mail.smtp.host", host);

		properties.put("mail.smtp.auth", "true");
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.ssl.socketFactory", sf);
		// ��ȡĬ��session����
		Session session = Session.getDefaultInstance(properties, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() { // qq����������˻�����������¼��Ȩ��
				return new PasswordAuthentication(from, pass); // �������ʼ��û���������
			}
		});

		try {
			// ����Ĭ�ϵ� MimeMessage ����
			MimeMessage message = new MimeMessage(session);

			// Set From: ͷ��ͷ�ֶ�
			message.setFrom(new InternetAddress(from));

			// Set To: ͷ��ͷ�ֶ�
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receive));

			// Set Subject: ��������
			message.setSubject(subject);

			// ������Ϣ����
			BodyPart messageBodyPart = new MimeBodyPart();

			// ��Ϣ
			// messageBodyPart.setText(msg);
			messageBodyPart.setContent(msg, "text/html;charset=UTF-8");

			// ����������Ϣ
			Multipart multipart = new MimeMultipart();

			// �����ı���Ϣ����
			multipart.addBodyPart(messageBodyPart);

			// ��������
			messageBodyPart = new MimeBodyPart();
			// ����Ҫ���͸������ļ�·��
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));

			// messageBodyPart.setFileName(filename);
			// �������������ģ������ļ�·������������
			messageBodyPart.setFileName(MimeUtility.encodeText(filename));
			multipart.addBodyPart(messageBodyPart);

			// ����������Ϣ
			message.setContent(multipart);

			// ������Ϣ
			Transport.send(message);
			System.out.println("Sent message successfully....");
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}
}