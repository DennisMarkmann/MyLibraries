package dennis.markmann.MyLibraries.Gui.DefaultFrameClasses;

import dennis.markmann.MyLibraries.Gui.Builder.GuiFrameBuilder;

public interface DefaultFrame {

    GuiFrameBuilder BUILDER = new GuiFrameBuilder();
    int TEXT_FIELD_SIZE = 5;

    void closeWindow();

    void dispose();
}
