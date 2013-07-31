package dennis.markmann.MyLibraries.DefaultJobs.IconHelper;

import javax.swing.JOptionPane;

import dennis.markmann.MyLibraries.Exceptions.ExceptionDialogInterface;
import dennis.markmann.MyLibraries.General.LanguageChooser;

/**
 * Exception thrown if a file can't be found.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

class FileNotFoundException extends Exception implements ExceptionDialogInterface {

    private static final long serialVersionUID = 6498733673905740756L;

    FileNotFoundException(final String path, final StackTraceElement[] stackTraceElements) {
        super(LanguageChooser.getMessages("FileNotFoundException") + path + "\"");
    }

    @Override
    public final void showDialog() {
        JOptionPane.showMessageDialog(null, this.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
