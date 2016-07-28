package dennis.markmann.MyLibraries.DefaultJobs.IconHelper;

/**
 * Exception thrown if a file can't be found.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class FileNotFoundException extends Exception {

    private static final long serialVersionUID = 6498733673905740756L;
    private String path = "";
    private final String errorTitel = "FileNotFoundException";
    private final String errorMessage = "An error appeared while trying to load the file '" + this.path + "'.";

    private final StackTraceElement[] stackTraceElements;

    FileNotFoundException(final StackTraceElement[] stackTraceElements, final String path) {

        this.stackTraceElements = stackTraceElements;
        this.path = path;
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
