package dennis.markmann.MyLibraries.GuiJobs.ComponentHelper;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JCheckBox;

/**
 * Listener allowing checkBoxes to have single selection functionality.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public class CheckBoxSelectionListener implements ItemListener {

    private final List<JCheckBox> checkBoxList;

    public CheckBoxSelectionListener(final List<JCheckBox> checkBoxList) {
        this.checkBoxList = checkBoxList;
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

    private void deselectAllOthers(final String checkBoxName) {
        for (final JCheckBox checkBox : this.checkBoxList) {
            if (!checkBox.getName().equals(checkBoxName)) {
                checkBox.setSelected(false);
            }
        }
    }
}