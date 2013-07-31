package dennis.markmann.MyLibraries.DefaultJobs.Email;

import javax.swing.JOptionPane;

import dennis.markmann.MyLibraries.Exceptions.ExceptionDialogInterface;
import dennis.markmann.MyLibraries.General.LanguageChooser;

/**
 * Exception thrown if a the sendEmail operation fails.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class SendEmailOperationException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    public SendEmailOperationException(final StackTraceElement[] stackTraceElements) {
        super(LanguageChooser.getMessages("SendEmailOperationExceptionLineOne")
                + LanguageChooser.getMessages("SendEmailOperationExceptionLineTwo"));
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
