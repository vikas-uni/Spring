package my.utils;

import my.model.EmailDTO;
import my.model.NotificationDTO;

public class MailsendTest {
	public static void main(String[] arg){
		MailSender mailSender = new MailSender();
		NotificationDTO  notificationDTO = new NotificationDTO();
		EmailDTO dto = new EmailDTO();
		dto.setFrom("rohit1.aggarwal@infogain.com");
		dto.setTo("vikas.gond@infogain.com");
		dto.setSubject("claim");
		dto.setBody("crteated");
		notificationDTO.setEmail(dto);		
		mailSender.sendNotification(notificationDTO);
	}
}
