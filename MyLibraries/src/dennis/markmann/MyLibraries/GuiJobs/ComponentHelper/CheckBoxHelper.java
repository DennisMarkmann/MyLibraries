package dennis.markmann.MyLibraries.GuiJobs.ComponentHelper;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

import dennis.markmann.MyLibraries.GuiJobs.Builder.FrameBuilder;

/**
 * Helper class to create new checkBoxes with single select functionality.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public class CheckBoxHelper {

    private final List<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
    private final CheckBoxSelectionListener checkBoxListener = new CheckBoxSelectionListener(this.checkBoxList);

    public final JCheckBox createSingleSelectionCheckBox(
            final JFrame frame,
            final String name,
            final String text,
            final int gridxValue,
            final int gridyValue) {
        final JCheckBox checkBox = new FrameBuilder().createCheckBox(frame, name, text, gridxValue, gridyValue);
        this.checkBoxList.add(checkBox);
        checkBox.addItemListener(this.checkBoxListener);

        return checkBox;
    }
}
