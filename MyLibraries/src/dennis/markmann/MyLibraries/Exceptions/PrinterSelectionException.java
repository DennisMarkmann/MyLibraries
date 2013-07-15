package dennis.markmann.MyLibraries.Exceptions;

import javax.swing.JOptionPane;

/**
 * Exception thrown if a the print operation fails.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class PrinterSelectionException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public PrinterSelectionException(final StackTraceElement[] stackTraceElements) {
        super("An error appeared while choosing the printer.");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
