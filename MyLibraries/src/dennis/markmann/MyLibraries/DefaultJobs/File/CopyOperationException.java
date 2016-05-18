package dennis.markmann.MyLibraries.DefaultJobs.File;

/**
 * Exception thrown if a file can't be copied.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class CopyOperationException extends Exception {

    private final String path;
    private final String errorTitel = "CopyOperationException";
    private final String errorMessage = "An error appeared while trying to copy the file '" + this.path + "'.";
    private final StackTraceElement[] stackTraceElements;

    private static final long serialVersionUID = 6498733673905740756L;

    CopyOperationException(final StackTraceElement[] stackTraceElements, final String path) {

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
