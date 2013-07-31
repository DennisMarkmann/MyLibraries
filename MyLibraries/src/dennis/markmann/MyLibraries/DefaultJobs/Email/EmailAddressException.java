package dennis.markmann.MyLibraries.DefaultJobs.Email;

import javax.swing.JOptionPane;

import dennis.markmann.MyLibraries.Exceptions.ExceptionDialogInterface;
import dennis.markmann.MyLibraries.General.LanguageChooser;

/**
 * Exception thrown if a the E-Mail address is not valid.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class EmailAddressException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = -4565962119370664301L;

    EmailAddressException(final StackTraceElement[] stackTraceElements, final String emailAddress) {
        super(LanguageChooser.getMessages("EmailAddressExceptionLineOne") + emailAddress
                + LanguageChooser.getMessages("EmailAddressExceptionLineTwo"));
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
