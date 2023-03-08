package kr.or.iei.join.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	public boolean sendMail(String hostmail, String guestmail, String messageText) {
		boolean result = false;
		//1. 이메일 통신 설정
		Properties prop = System.getProperties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", 587); //587번 포트를 사용
		prop.put("mail.smtp.auth", "true"); //메일을 사용
		prop.put("mail.smtp.starttls.enable", "true"); //암호화통신 설정
		prop.put("mail.stmp.ssl.protocols", "TLSv1.2");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com"); //신뢰할 수 있는 주소다
		//인증정보설정(로그인)
		Session session = Session.getDefaultInstance(prop, //session에 접속정보 들어있음
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						PasswordAuthentication pa
						= new PasswordAuthentication(hostmail, "vznvfwtmnqsafifk"); //인증정보
						return pa;
					}
				}
		);
		//위의 접속정보를 가지고
		//이메일 작성해서 전송하는 객체
		MimeMessage msg = new MimeMessage(session);
		
		//이메일 작성
		
		try {
			//메일 전송 날짜 설정
			msg.setSentDate(new Date());
			//보낸사람 정보 설정(보낸이 이메일, 보낸이 이름)
			msg.setFrom(new InternetAddress(guestmail, "참석자"));
			//받는사람 정보
			InternetAddress to = new InternetAddress(hostmail);
			msg.setRecipient(Message.RecipientType.TO, to);
			//이메일 제목 설정
			msg.setSubject("Sprip 문의 메세지", "UTF-8");
			//이메일 내용(본문)
			msg.setContent(messageText, "text/html;charset=utf-8");
			//이메일전송
			Transport.send(msg);
			result = true;
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}