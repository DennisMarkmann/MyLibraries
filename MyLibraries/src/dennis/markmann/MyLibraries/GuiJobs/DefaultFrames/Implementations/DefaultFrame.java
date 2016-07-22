package dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations;

/**
 * Interface for frames. Forces to implement default operations and parameters.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public interface DefaultFrame extends DefaultTab {

    void closeWindow();

    void openClosingDialog(WindowCloseDialogOptions request);
}
