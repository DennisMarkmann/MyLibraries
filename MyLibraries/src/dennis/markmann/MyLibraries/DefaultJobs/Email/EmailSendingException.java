package dennis.markmann.MyLibraries.DefaultJobs.Email;

/**
 * Exception thrown if a the sendEmail operation fails.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class EmailSendingException extends Exception {

	private final String errorTitel = "EmailSendingException";
	private final String errorMessage = "An error appeared while trying to send out the E-Mail. Please check your network and firewall settings.";
	private final StackTraceElement[] stackTraceElements;

	private static final long serialVersionUID = 935078749864541766L;

	EmailSendingException(final StackTraceElement[] stackTraceElements) {
		this.stackTraceElements = stackTraceElements;
	}

	public String getErrorTitel() {
		return this.errorTitel;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public StackTraceElement[] getStackTraceElements() {
		return this.stackTraceElements;
	}

}
