package dennis.markmann.MyLibraries.DefaultJobs;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import dennis.markmann.MyLibraries.Exceptions.SendEmailOperationException;
import dennis.markmann.MyLibraries.MyObjects.EmailObject;

public class EmailJob {

    public final void sendMail(
            final String smtpHost,
            final String username,
            final String password,
            final String senderAddress,
            final String subject,
            final ArrayList<EmailObject> emailList) {

        final Properties properties = new Properties();
        properties.put("mail.smtp.host", smtpHost);
        properties.setProperty("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        final MailAuthenticator auth = new MailAuthenticator(username, password);
        final Session session = Session.getDefaultInstance(properties, auth);

        try {
            final Message msg = new MimeMessage(session);

            msg.setFrom(new InternetAddress(senderAddress));

            msg.setSubject(subject);
            msg.setHeader(subject, subject);
            msg.setSentDate(new Date());

            for (final EmailObject emailObject : emailList) {
                msg.setContent(emailObject.getMailContent());

                for (final String emailAddress : emailObject.getEmailAddressList()) {
                    if (emailAddress != null && !emailAddress.equals("")) {
                        try {
                            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailAddress, false));
                            Transport.send(msg);
                        } catch (final MessagingException e) {
                        }
                    }
                }
            }
        } catch (final Exception e) {
            new SendEmailOperationException(e.getStackTrace()).showDialog();
        }
    }

    private final class MailAuthenticator extends Authenticator {

        private final String user;
        private final String password;

        private MailAuthenticator(final String user, final String password) {
            this.user = user;
            this.password = password;
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.user, this.password);
        }
    }

}
