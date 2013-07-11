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
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EmailContentCreator {

    public void createMailContent(final String text, final File attachement, final EmailObject emailObject) {

        try {
            final MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText(text);
            textPart.setDisposition(MimeBodyPart.INLINE);

            final MimeBodyPart attachementPart = new MimeBodyPart();
            attachementPart.setDataHandler(new DataHandler(new FileDataSource(attachement)));
            attachementPart.setFileName(attachement.getName());
            attachementPart.setDisposition(MimeBodyPart.ATTACHMENT);

            final MimeMultipart mailContent = new MimeMultipart();

            mailContent.addBodyPart(textPart);
            mailContent.addBodyPart(attachementPart);

            emailObject.setMailContent(mailContent);

        } catch (final MessagingException e) {
            // TODO
            e.printStackTrace();
        }

    }
}
