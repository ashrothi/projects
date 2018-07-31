/**
 * This package contains the model class and class to implement the process of sending email to users.
 */


import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * This class is useful to send email to user by creating smtp connection and
 * session. Credentials like
 *
 */
public class SendEmail {
	/**
	 * This method will craete smtp session and check if authentication validate
	 * then send email.
	 * 
	 * @param uname,
	 *            Requires user name.
	 * @param pass,
	 *            Requires password.
	 * @param socketPort,
	 *            Requires socket port.
	 * @param socketClass,
	 *            Requires socket class name.
	 * @param authEmail,
	 *            Requires authenticate email.
	 * @param emailHost,
	 *            Requires authenticate email host name.
	 * @param emailPort,
	 *            Requires authenticate email port.
	 * @param builder,
	 *            Requires builder name.
	 * @param to,
	 *            Requires email id of recipient.
	 * @param bcc,
	 *            Requires email id of blind carbon copy.
	 * @param cc,
	 *            Requires email id of carbon copy.
	 * @param attachment,
	 *            Requires attachment path.
	 * @param sub,
	 *            Requires subject
	 * @param msgEmail,
	 *            Requires message to be sent
	 * @param msgFromStatus,
	 *            Requires from status
	 * @param from,
	 *            Requires email id of sender
	 * @param msgTo,
	 *            Requires email id to
	 * @param printStream,
	 *            Requires print stream object.
	 * 
	 * 			@return, boolean true or false status.
	 */
	public static boolean email(String uname, String pass, String socketPort, String socketClass, String authEmail,
			String emailHost, String emailPort, StringBuilder builder, String[] to, String[] bcc, String[] cc,
			String attachment, String sub, String msgEmail, String msgFromStatus, String from, String msgTo,
			PrintStream printStream) {
		try {/*
				 * To get session of smtp connection.
				 */
			long a = new Date().getTime();
			Session session = getSession(uname, pass, authEmail, emailHost, emailPort, socketPort, socketClass, builder,
					printStream);
			long b = new Date().getTime();
			long c = b - a;
			System.out.println("time " + c);
			/*
			 * Check if session is not null.
			 */
			if (session != null) {
				long d = new Date().getTime();
				boolean flag = sendEmail(session, to, bcc, cc, attachment, sub, msgEmail, builder, msgFromStatus, from,
						msgTo, printStream);
				long e = new Date().getTime();
				long f = e - d;

				System.out.println("time " + f);
				/*
				 * Check flaf is true
				 */

				if (flag) {
					/*
					 * Return response as true
					 */
					return true;
				}

			} else {

				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return false;
	}

	/**
	 * This method will send email from sender id to recipients.
	 * 
	 * @param session,
	 *            Requires session detail
	 * @param to,
	 *            Requires email id of recipient.
	 * @param bcc,
	 *            Requires email id of blind carbon copy.
	 * @param cc,
	 *            Requires email id of carbon copy.
	 * @param attachment,
	 *            Requires attachment path.
	 * @param sub,
	 *            Requires subject
	 * @param msgEmail,
	 *            Requires message to be sent
	 * @param msgFromStatus,
	 *            Requires from status
	 * @param from,
	 *            Requires email id of sender
	 * @param msgTo,
	 *            Requires email id to
	 * @param printStream,
	 *            Requires print stream object.
	 * 
	 * 			@return, boolean true or false status.
	 */
	public static boolean sendEmail(Session session, String[] to, String[] bcc, String[] cc, String attachment,
			String sub, String msgEmail, StringBuilder builder, String msgFromStatus, String from, String msgTo,
			PrintStream printStream) {

		try {
			/*
			 * Set values to local variables.
			 */

			String toEmail[] = to;
			String bccEmail[] = bcc;
			String ccEmail[] = cc;
			String attachments = attachment;
			String subject = sub;
			String message = msgEmail;
			String email_log = "TO :" + toEmail + " " + "CC :" + ccEmail + " " + "BCC :" + bccEmail + " " + "subject :"
					+ subject + " " + "message :" + message + " " + "attachmentName :" + attachments;

			// maintaining information is the log file data send email
			builder.append("email :- " + email_log + "\n");

			MimeMessage msg = new MimeMessage(session);
			// set message headers
			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.addHeader("format", "flowed");
			msg.addHeader("Content-Transfer-Encoding", "8bit");
			// set message from address
			msg.setFrom(new InternetAddress(from, msgFromStatus));
			// set message from address setReplyTo
			msg.setReplyTo(InternetAddress.parse(msgTo, false));
			// set Subject using class MimeMessage object reference msg
			msg.setSubject(subject, "UTF-8");
			// set setSentDate using class MimeMessage object reference msg
			msg.setSentDate(new Date());

			msg.setText(message);

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();
			// Fill the message
			// messageBodyPart.setText(message);
			messageBodyPart.setContent(message, "text/html");

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();
			// checking attachment data attachments != null.
			if (attachments != null) {
				String[] splits = attachments.split(",");
				// builder.append("splits.size: " + splits.length+ "\n");
				for (String attachment_name : splits) {
					MimeBodyPart attachPart = new MimeBodyPart();
					try {
						attachPart.attachFile(attachment_name);
					} catch (IOException ex) {
						builder.append(ex.getMessage());
					}
					multipart.addBodyPart(attachPart);
				}
			}
			// sets the multi-part as e-mail's content
			msg.setContent(multipart);
			// Set text message part
			multipart.addBodyPart(messageBodyPart);
			// Send Email only to email ids
			InternetAddress[] addressTo = new InternetAddress[toEmail.length];
			for (int i = 0; i < toEmail.length; i++) {
				addressTo[i] = new InternetAddress(toEmail[i]);
			}
			msg.setRecipients(Message.RecipientType.TO, addressTo);
			// Send Email only cc email ids
			InternetAddress[] addressCC = new InternetAddress[ccEmail.length];
			for (int i = 0; i < ccEmail.length; i++) {
				addressCC[i] = new InternetAddress(ccEmail[i]);
			}
			msg.setRecipients(Message.RecipientType.CC, addressCC);
			// Send Email only BCC email ids
			InternetAddress[] addressBCC = new InternetAddress[bccEmail.length];
			for (int i = 0; i < bccEmail.length; i++) {
				addressBCC[i] = new InternetAddress(bccEmail[i]);
			}
			msg.setRecipients(RecipientType.BCC, addressBCC);
			// builder.append("Message is ready"+ "\n");

			/**
			 * Transport class using to send function default SMTP Protocal for sending
			 * email with MimeMessage
			 */

			long a = new Date().getTime();

			Transport.send(msg);
			long b = new Date().getTime();
			long c = b - a;
			System.out.println("mail send time " + c);
			builder.append("Message Send Successfully" + "\n");

			return true;
		} catch (Exception e) {

			if (printStream != null) {
				e.printStackTrace();
				e.printStackTrace(printStream);
			}
			e.printStackTrace();
			builder.append(e.getMessage() + "\n");

			return false;
		}

	}

	/**
	 * This method will return the session for sending email.
	 * 
	 * @param uname,
	 *            Requires user name.
	 * @param pass,
	 *            Requires password.
	 * @param socketPort,
	 *            Requires socket port.
	 * @param socketClass,
	 *            Requires socket class name.
	 * @param authEmail,
	 *            Requires authenticate email.
	 * @param emailHost,
	 *            Requires authenticate email host name.
	 * @param emailPort,
	 *            Requires authenticate email port.
	 * @param builder,
	 *            Requires builder name. @return, Session details
	 */
	public static Session getSession(String uname, String pass, String authEmail, String emailHost, String emailPort,
			String socketPort, String socketClass, StringBuilder builder, PrintStream printStream) {

		try {
			/*
			 * Set local variables values from parameters.
			 */
			final String username = uname;

			final String password = pass;

			final String auth = authEmail;
			final String host = emailHost;
			final String port = emailPort;

			final String sockePort = socketPort;

			final String sockeClass = socketClass;

			builder.append("Email Session Details:-  " + username + "/" + password + "/" + auth + "/" + host + "/"
					+ port + "/" + sockeClass + "/" + sockePort + "\n");
			/*
			 * Set properties values.
			 */
			Properties props = new Properties();
			props.put("mail.smtp.auth", auth);
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", port);
			props.put("mail.smtp.starttls.enable", "true");
			
			

			if (sockePort == null || sockeClass == null) {

			} else {
				props.put("mail.smtp.socketFactory.port", sockePort);
				props.put("mail.smtp.socketFactory.class", sockeClass);
			}

			// Get the Session object.
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			/*
			 * Properties props = new Properties(); props.put("mail.smtp.host",
			 * "smtp.gmail.com"); props.put("mail.smtp.socketFactory.port", "465");
			 * props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			 * props.put("mail.smtp.auth", "true"); props.put("mail.smtp.port", "465");
			 * 
			 * Session session = Session.getDefaultInstance(props, new
			 * javax.mail.Authenticator() { protected PasswordAuthentication
			 * getPasswordAuthentication() { return new
			 * PasswordAuthentication("dushyant@teramatrix.co","d4s19o15n14i9"); } });
			 */
			/*
			 * Return the session.
			 */
			return session;
		} catch (Exception e) {
			e.printStackTrace();
			if (printStream != null) {
				e.printStackTrace(printStream);
			}

			builder.append(e.getMessage() + "\n");
			return null;
		}
	}

}
