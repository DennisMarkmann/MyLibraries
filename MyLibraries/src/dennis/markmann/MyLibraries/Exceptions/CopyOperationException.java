package dennis.markmann.MyLibraries.Exceptions;

import javax.swing.JOptionPane;

/**
 * Exception thrown if a file can't be copied.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class CopyOperationException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = 6498733673905740756L;

    public CopyOperationException(final String path, final StackTraceElement[] stackTraceElements) {
        super("An error occured while copying the file: \"" + path + "\"");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
