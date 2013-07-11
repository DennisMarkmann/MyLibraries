package dennis.markmann.MyLibraries.Gui.DefaultFrameClasses;

import dennis.markmann.MyLibraries.Gui.Builder.FrameBuilder;

public interface DefaultFrame {

    FrameBuilder BUILDER = new FrameBuilder();
    int TEXT_FIELD_SIZE = 5;

    void closeWindow();

    void dispose();
}
