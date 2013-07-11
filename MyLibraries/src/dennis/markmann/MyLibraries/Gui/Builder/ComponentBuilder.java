package dennis.markmann.MyLibraries.Gui.Builder;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ComponentBuilder {

    /**
     * Super builder for main GUI components.
     * 
     * @author dennis.markmann
     * @since jdk1.7.0_21
     * @version 1.0
     */

    protected final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    public ComponentBuilder() {
        this.gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        this.gridBagConstraints.weightx = 2;
    }

    public JButton createButton(final String name, final String buttonText, final int gridxValue, final int gridyValue) {

        final JButton button = new JButton(buttonText);
        this.setName(button, name);

        return button;
    }

    public JScrollPane createTable(final int gridxValue, final int gridyValue, final JTable jTable) {

        final JScrollPane scrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(true);
        return scrollPane;

    }

    protected void setName(final Component object, final String objectName) {
        object.setName(objectName);
    }

    public GridBagConstraints getGridBagConstraints() {
        return this.gridBagConstraints;

    }
}
