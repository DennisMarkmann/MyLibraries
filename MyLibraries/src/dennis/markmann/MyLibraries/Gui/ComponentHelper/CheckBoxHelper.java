package dennis.markmann.MyLibraries.Gui.ComponentHelper;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

import dennis.markmann.MyLibraries.Gui.Builder.GuiFrameBuilder;

public class CheckBoxHelper {

    private final List<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
    private final CheckBoxSelectionListener checkBoxListener = new CheckBoxSelectionListener(this.checkBoxList);

    public final JCheckBox createSingleSelectionCheckBox(
            final JFrame frame,
            final String name,
            final String text,
            final int gridxValue,
            final int gridyValue) {
        final JCheckBox checkBox = new GuiFrameBuilder().createCheckBox(frame, name, text, gridxValue, gridyValue);
        this.checkBoxList.add(checkBox);
        checkBox.addItemListener(this.checkBoxListener);

        return checkBox;
    }
}
