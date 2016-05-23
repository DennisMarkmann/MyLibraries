package dennis.markmann.MyLibraries.DefaultJobs.Email;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/**
 * Used to create the content of an E-Mail.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public class EmailContentCreator {

    public final void createMailContent(final String text, final File attachement, final EmailObject emailObject) {

        // Create the email text
        final MimeBodyPart textPart = new MimeBodyPart();
        try {
            textPart.setText(text);
            textPart.setDisposition(MimeBodyPart.INLINE);

            // Create the attachement for the email
            final MimeBodyPart attachementPart = new MimeBodyPart();
            if (attachement != null) {
                attachementPart.setDataHandler(new DataHandler(new FileDataSource(attachement)));
                attachementPart.setFileName(attachement.getName());
                attachementPart.setDisposition(MimeBodyPart.ATTACHMENT);
            }

            final MimeMultipart mailContent = new MimeMultipart();
            mailContent.addBodyPart(textPart);

            if (attachement != null) {
                mailContent.addBodyPart(attachementPart);
            }
            emailObject.setMailContent(mailContent);
        } catch (MessagingException e) {
//            throw (new EmailAddressException(e.getStackTrace(), emailAddress));
            e.printStackTrace();
        }
    }
}
