package dennis.markmann.MyLibraries.DefaultJobs.FileCopy;

import javax.swing.JOptionPane;

import dennis.markmann.MyLibraries.Exceptions.ExceptionDialogInterface;
import dennis.markmann.MyLibraries.General.LanguageChooser;

/**
 * Exception thrown if a file can't be copied.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class CopyOperationException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = 6498733673905740756L;

    CopyOperationException(final String path, final StackTraceElement[] stackTraceElements) {
        super(LanguageChooser.getMessages("CopyOperationException") + path + "\"");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
