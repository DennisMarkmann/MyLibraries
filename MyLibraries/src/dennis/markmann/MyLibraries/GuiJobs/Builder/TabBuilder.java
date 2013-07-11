package dennis.markmann.MyLibraries.GuiJobs.Builder;

import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Builder for tab components.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public class TabBuilder extends ComponentBuilder {

    public TabBuilder() {
        super();
        super.getGridBagConstraints().fill = GridBagConstraints.HORIZONTAL;
    }

    public final void setDefaultGridBackValues() {
        this.gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        this.gridBagConstraints.weightx = 2;
    }

    public final JButton createButton(
            final JPanel jPanel,
            final String buttonName,
            final String buttonText,
            final int gridxValue,
            final int gridyValue) {

        final JButton button = super.createButton(buttonName, buttonText, gridxValue, gridyValue);
        this.setPosition(jPanel, this.gridBagConstraints, gridxValue, gridyValue, button);

        return button;
    }

    public final JScrollPane createTable(final JPanel jPanel, final int gridxValue, final int gridyValue, final JTable jTable) {

        final JScrollPane scrollPane = super.createTable(gridxValue, gridyValue, jTable);
        this.setPosition(jPanel, this.gridBagConstraints, gridxValue, gridyValue, scrollPane);

        return scrollPane;

    }

    private void setPosition(
            final JPanel jPanel,
            final GridBagConstraints c,
            final int gridxValue,
            final int gridyValue,
            final Component object) {

        c.gridx = gridxValue;
        c.gridy = gridyValue;
        jPanel.add(object, c);
    }
}
