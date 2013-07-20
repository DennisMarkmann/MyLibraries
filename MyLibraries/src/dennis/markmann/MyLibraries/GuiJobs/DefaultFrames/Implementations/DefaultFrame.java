package dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations;

import dennis.markmann.MyLibraries.GuiJobs.Builder.GuiBuilder;

/**
 * Interface for frames. Forces to implement default operations and parameters.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public interface DefaultFrame {

    GuiBuilder BUILDER = new GuiBuilder();
    int TEXT_FIELD_SIZE = 5;

    void openClosingDialog(String string);

    void closeWindow();
}
