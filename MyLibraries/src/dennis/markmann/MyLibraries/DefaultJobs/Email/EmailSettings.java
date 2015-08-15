package dennis.markmann.MyLibraries.DefaultJobs.Email;

import java.util.Properties;

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
    private Properties properties;
    private boolean authentificate;
    private String smtpHost;

    public EmailSettings(
            final String username,
            final String password,
            final String senderAddress,
            final String subject,
            String smtpHost,
            String smtpPort,
            boolean authentificate) {

        this.username = username;
        this.password = password;
        this.senderAddress = senderAddress;
        this.subject = subject;
        this.specifyProperties(smtpHost, smtpPort, authentificate);
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(final String username) {
        this.username = username;
    }

    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }

    public final String getSenderAddress() {
        return this.senderAddress;
    }

    public final void setSenderAddress(final String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public final String getSubject() {
        return this.subject;
    }

    public final void setSubject(final String subject) {
        this.subject = subject;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public boolean isAuthentificate() {
        return authentificate;
    }
    
    public String getSmtpHost() {
        return smtpHost;
    }

    public void specifyProperties(String smtpHost, String smtpPort, boolean authentificate) {
        properties = new Properties();
        this.authentificate = authentificate;
        this.smtpHost = smtpHost;

        properties.put("mail.smtp.host", smtpHost);
        if (smtpPort != null && !smtpPort.equals("")) {
            properties.setProperty("mail.smtp.port", smtpPort);
        } else {
            properties.setProperty("mail.smtp.port", "587");
        }
        properties.put("mail.smtp.auth", authentificate);
    }

}
