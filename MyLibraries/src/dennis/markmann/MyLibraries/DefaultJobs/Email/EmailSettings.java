package dennis.markmann.MyLibraries.DefaultJobs.Email;

/**
 * E-Mail object containing the mail content and the list of addresses the mail has to be send to.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EmailSettings {

    private String username;
    private String password;
    private String senderAddress;
    private String subject;
    private String smtpHost;

    public EmailSettings(
            final String username,
            final String password,
            final String senderAddress,
            final String subject,
            final String smtpHost) {

        this.username = username;
        this.password = password;
        this.senderAddress = senderAddress;
        this.subject = subject;
        this.smtpHost = smtpHost;

    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getSenderAddress() {
        return this.senderAddress;
    }

    public void setSenderAddress(final String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(final String subject) {
        this.subject = subject;
    }

    public String getSmtpHost() {
        return this.smtpHost;
    }

    public void setSmtpHost(final String smtpHost) {
        this.smtpHost = smtpHost;
    }

}
