package dennis.markmann.MyLibraries.DefaultJobs.Email;

/**
 * Exception thrown if a the E-Mail address is not valid.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class EmailAddressException extends Exception {

    private static final long serialVersionUID = -4565962119370664301L;
    private String emailAddress = "";
    private final String errorTitel = "EmailAddressException";
    private final String errorMessage = "An error appeared while trying to send out the E-Mail. The E-Mail address "
            + this.emailAddress + " seems to be invalid.";

    private final StackTraceElement[] stackTraceElements;

    EmailAddressException(final StackTraceElement[] stackTraceElements, final String emailAddress) {

        this.stackTraceElements = stackTraceElements;
        this.emailAddress = emailAddress;

    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public String getErrorTitel() {
        return this.errorTitel;
    }

    public StackTraceElement[] getStackTraceElements() {
        return this.stackTraceElements;
    }
}
