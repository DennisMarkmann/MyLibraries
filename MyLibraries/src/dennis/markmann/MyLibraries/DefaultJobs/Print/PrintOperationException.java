package dennis.markmann.MyLibraries.DefaultJobs.Print;

/**
 * Exception thrown if a the print operation fails.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class PrintOperationException extends Exception {

    private final String errorTitel = "PrintOperationException";
    private final String errorMessage = "An error appeared while trying to print.";
    private final StackTraceElement[] stackTraceElements;

    private static final long serialVersionUID = -4565962119370664301L;

    PrintOperationException(final StackTraceElement[] stackTraceElements) {

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
