package dennis.markmann.MyLibraries.DefaultJobs.Print;

import javax.swing.JOptionPane;

import dennis.markmann.MyLibraries.Exceptions.ExceptionDialogInterface;
import dennis.markmann.MyLibraries.General.LanguageChooser;

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
        super(LanguageChooser.getMessages("PrintSelectionException"));
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
