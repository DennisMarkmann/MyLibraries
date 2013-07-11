package dennis.markmann.MyLibraries.Gui.DefaultFrameClasses;

import dennis.markmann.MyLibraries.Gui.Builder.FrameBuilder;

/**
 * Interface for frames. Forces to implement default operations and parameters.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public interface DefaultFrame {

    FrameBuilder BUILDER = new FrameBuilder();
    int TEXT_FIELD_SIZE = 5;

    void closeWindow();

    void dispose();
}
