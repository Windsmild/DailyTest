package mail;

import org.simplejavamail.email.Email;
import org.simplejavamail.mailer.Mailer;

import javax.mail.Message;

/**
 * Created by Stephen Cai on 2017-06-12 10:47.
 */
public class MyMail {
	public static Mailer mailer = new Mailer("smtp.163.com", 25, "mail", "pass");

	public static void main(String[] args) {
	    //mail
		Email email = new Email();
		email.setFromAddress("myself", "mail");
		email.addRecipient("myself", "mail", Message.RecipientType.TO);
		email.setReplyToAddress("myself", "mail");
		email.setSubject("hey,it's test of simple java mail");
		email.setText("We should meet up! ;)");
		email.setTextHTML("<img src='ci :wink1'><b>We should meet up!</b><img src='cid:wink2'>");
		mailer.sendMail(email);
	}

}
