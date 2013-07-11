package dennis.markmann.MyLibraries.MyObjects;

import java.util.ArrayList;

import javax.mail.internet.MimeMultipart;

public class EmailObject {

    private MimeMultipart mailContent;
    private final ArrayList<String> emailAddressList = new ArrayList<>();

    public MimeMultipart getMailContent() {
        return this.mailContent;
    }

    public void setMailContent(final MimeMultipart mailContent) {
        this.mailContent = mailContent;
    }

    public ArrayList<String> getEmailAddressList() {
        return this.emailAddressList;
    }

}
