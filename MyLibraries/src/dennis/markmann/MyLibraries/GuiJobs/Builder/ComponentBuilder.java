package dennis.markmann.MyLibraries.GuiJobs.Builder;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Super builder for main GUI components.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public class ComponentBuilder {

    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    public ComponentBuilder() {
        this.getGridBagConstraints().insets = new Insets(5, 5, 5, 5);
        this.getGridBagConstraints().weightx = 2;
        this.getGridBagConstraints().fill = GridBagConstraints.BOTH;

    }

    public final JButton createButton(
            final Object panel,
            final String name,
            final String buttonText,
            final int gridxValue,
            final int gridyValue) {

        final JButton button = new JButton(buttonText);
        this.setName(button, name);
        this.setPosition(panel, this.getGridBagConstraints(), gridxValue, gridyValue, button);

        return button;
    }

    public final JScrollPane createTable(final Object panel, final int gridxValue, final int gridyValue, final JTable jTable) {

        final JScrollPane scrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(true);
        this.setPosition(panel, this.getGridBagConstraints(), gridxValue, gridyValue, scrollPane);

        return scrollPane;

    }

    protected final void setName(final Component object, final String objectName) {
        object.setName(objectName);
    }

    public final GridBagConstraints getGridBagConstraints() {
        return this.gridBagConstraints;

    }

    private void setPosition(
            final Object panel,
            final GridBagConstraints c,
            final int gridxValue,
            final int gridyValue,
            final Component object) {

        c.gridx = gridxValue;
        c.gridy = gridyValue;
        if (panel.toString().toLowerCase().contains("tab")) {
            ((JPanel) panel).add(object, c);
        } else if (panel.toString().toLowerCase().contains("frame")) {
            ((JFrame) panel).add(object, c);
        }
    }
}
