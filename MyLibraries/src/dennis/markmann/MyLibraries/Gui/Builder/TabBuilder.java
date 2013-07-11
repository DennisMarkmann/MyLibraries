package dennis.markmann.MyLibraries.Gui.Builder;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TabBuilder {

    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    public TabBuilder() {
        this.gridBagConstraints.insets = new Insets(5, 5, 5, 5);
        this.setDefaultGridBackValues();
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

        final JButton button = new JButton(buttonText);
        this.setName(button, buttonName);
        this.setPosition(jPanel, this.gridBagConstraints, gridxValue, gridyValue, button);

        return button;
    }

    public JScrollPane createTable(final JPanel jPanel, final int gridxValue, final int gridyValue, final JTable jTable) {

        final JScrollPane scrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(true);
        this.setPosition(jPanel, this.gridBagConstraints, gridxValue, gridyValue, scrollPane);
        return scrollPane;

    }

    private void setName(final Component object, final String objectName) {
        object.setName(objectName);
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

    public final GridBagConstraints getGridBagConstraints() {
        return this.gridBagConstraints;

    }
}
