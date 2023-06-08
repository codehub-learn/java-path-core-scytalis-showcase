package gr.codelearn.core.basic;

public interface NotificationService {
	Boolean sendEmail(String recipient, String emailBody);

	Boolean sendSms(String number, String text);

	Boolean sendPush(String number, String text);

}
