package my.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import my.model.NotificationDTO;


public class MailSender {
	/*public static void main(String[] arg){
		MailSender mailSender = new MailSender();
		NotificationDTO  notificationDTO = new NotificationDTO();
		EmailDTO dto = new EmailDTO();
		dto.setFrom("renu1.gupta@infogain.com");
		dto.setTo("vikas.gond@infogain.com");
		dto.setSubject("claim");
		dto.setBody("crteated");
		notificationDTO.setEmail(dto);		
		mailSender.sendNotification(notificationDTO);
	}*/

	public boolean sendNotification(NotificationDTO notificationDTO){
		 Properties properties = new Properties();
		 	final String user = "vikas.gond@infogain.com";   // username on mail server
	        final String password = ""; // user password

	        String fromAddress = notificationDTO.getEmail().getFrom();//"vikas.gond@infogain.com"; // newlycreateduser@localhost
	        String toAddress = notificationDTO.getEmail().getTo();//"vikas.gond@infogain.com";
	        String cc = notificationDTO.getEmail().getCc();
	        String subject = notificationDTO.getEmail().getSubject();
	        String body = notificationDTO.getEmail().getBody();
	        
	        properties.put("mail.smtp.host", "NODMX.igglobal.com");
	        properties.put("mail.transport.protocol", "smtp");
	        properties.put("mail.smtp.socketFactory.port", "25");
	       // properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	        properties.put("mail.smtp.socketFactory.fallback", "true"); 
	        //properties.put("mail.smtp.auth", "true"); // this works sometimes
	        //properties.put("mail.smtp.auth", "false");
	        properties.put("mail.smtp.port", "25");
		 
		 //code below works-----------------
		 	/*final String user = "gwmailer.infogain@gmail.com";   // username on mail server
	        final String password = "mailer@infogain"; // user password

	        String fromAddress = "vikas.uni@gmail.com"; // newlycreateduser@localhost
	        String toAddress = "vikas.gond@infogain.com";
	        
	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        properties.put("mail.smtp.socketFactory.port", "465");
	        properties.put("mail.smtp.socketFactory.class",
	                "javax.net.ssl.SSLSocketFactory");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.port", "465");*/
	        //-------------------------------------------
	        
	        
	        Authenticator authenticator = new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(user, password);
	            }
	        };
	        
	        Session session = Session.getDefaultInstance(properties, authenticator);
	        
	        try 
	        {
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(fromAddress));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));

	            if (cc != null && cc.contains("@")) {
	            	message.addRecipient(Message.RecipientType.CC, new InternetAddress(
		                    cc));
				}
	            System.out.println("from======"+fromAddress);
	            
	            message.setSubject(subject);
	            message.setText(body);
	            Transport.send(message);

	            System.out.println("Email sent successfully");
	            return true;
	        }
	        catch (MessagingException e) 
	        {
	            e.printStackTrace();
	        }
			return false;
	    }
}
