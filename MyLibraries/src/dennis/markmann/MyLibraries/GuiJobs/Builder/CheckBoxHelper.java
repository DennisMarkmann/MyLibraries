package dennis.markmann.MyLibraries.GuiJobs.Builder;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

/**
 * Helper class to create new checkBoxes.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class CheckBoxHelper {

    /**
     * Used to enable single select functionality for checkBoxes.
     *
     * @author dennis.markmann
     * @version 1.0
     */

    private class CheckBoxSelectionListener implements ItemListener {

        private final List<JCheckBox> checkBoxList;

        private CheckBoxSelectionListener(final List<JCheckBox> checkBoxList) {
            this.checkBoxList = checkBoxList;
        }

        private void deselectAllOthers(final String checkBoxName) {
            for (final JCheckBox checkBox : this.checkBoxList) {
                if (!checkBox.getName().equals(checkBoxName)) {
                    checkBox.setSelected(false);
                }
            }
        }

        @Override
        public final void itemStateChanged(final ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                final String sourceName = e.getItemSelectable().toString();

                for (final JCheckBox checkBox : this.checkBoxList) {
                    if (sourceName.contains(checkBox.getName())) {
                        this.deselectAllOthers(checkBox.getName());
                    }
                }
            }
        }
    }

    private final List<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();

    private final CheckBoxSelectionListener checkBoxListener = new CheckBoxSelectionListener(this.checkBoxList);

    public final JCheckBox createSingleSelectionCheckBox(
            final JFrame frame,
            final String name,
            final String text,
            final int gridxValue,
            final int gridyValue) {
        final JCheckBox checkBox = new GuiBuilder().createCheckBox(frame, name, text, gridxValue, gridyValue);
        this.checkBoxList.add(checkBox);
        checkBox.addItemListener(this.checkBoxListener);

        return checkBox;

    }
}
