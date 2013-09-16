package dennis.markmann.MyLibraries.DefaultJobs.IconHelper;

/**
 * Exception thrown if a file can't be found.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class FileNotFoundException extends Exception {

	private final String path;
	private final String errorTitel = "FileNotFoundException";
	private final String errorMessage = "An error appeared while trying to load the file '"
			+ this.path + "'.";
	private final StackTraceElement[] stackTraceElements;

	private static final long serialVersionUID = 6498733673905740756L;

	FileNotFoundException(final StackTraceElement[] stackTraceElements,
			final String path) {

		this.stackTraceElements = stackTraceElements;
		this.path = path;
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
