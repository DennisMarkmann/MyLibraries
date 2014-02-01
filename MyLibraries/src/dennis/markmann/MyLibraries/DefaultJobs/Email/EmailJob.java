package dennis.markmann.MyLibraries.DefaultJobs.Email;

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

/**
 * Used to send out E-Mails.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EmailJob implements Runnable {

    EmailSettings emailSettings;
    ArrayList<EmailObject> emailList;

    public EmailJob(final EmailSettings emailSettings, final ArrayList<EmailObject> emailList) {
        this.emailSettings = emailSettings;
        this.emailList = emailList;
    }

    @Override
    public void run() {
        // TODO catch exceptions
        try {
            this.sendMail(this.emailSettings, this.emailList);
        } catch (final EmailSendingException e) {
            e.printStackTrace();
        } catch (final EmailAddressException e) {
            e.printStackTrace();
        }
    }

    public final void sendMail(final EmailSettings emailSettings, final ArrayList<EmailObject> emailList)
            throws EmailSendingException, EmailAddressException {

        final Properties properties = new Properties();
        properties.put("mail.smtp.host", emailSettings.getSmtpHost());
        properties.setProperty("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        final MailAuthenticator auth = new MailAuthenticator(emailSettings.getUsername(), emailSettings.getPassword());
        final Session session = Session.getDefaultInstance(properties, auth);

        try {
            final Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(emailSettings.getSenderAddress()));
            final String subject = emailSettings.getSubject();
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
                            throw (new EmailAddressException(e.getStackTrace(), emailAddress));
                        }
                    }
                }
            }
        } catch (final Exception e) {
            throw (new EmailSendingException(e.getStackTrace()));
        }
    }

    /**
     * Used to authentificate with protected E-Mail provider.
     * 
     * @author dennis.markmann
     * @since JDK.1.7.0_21
     * @version 1.0
     */

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
