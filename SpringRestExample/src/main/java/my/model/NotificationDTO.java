package my.model;

public class NotificationDTO {
	protected EmailDTO email;
	protected SmsDTO sms;
	
	public EmailDTO getEmail() {
		return email;
	}
	public void setEmail(EmailDTO email) {
		this.email = email;
	}
	public SmsDTO getSms() {
		return sms;
	}
	public void setSms(SmsDTO sms) {
		this.sms = sms;
	}
	
}
