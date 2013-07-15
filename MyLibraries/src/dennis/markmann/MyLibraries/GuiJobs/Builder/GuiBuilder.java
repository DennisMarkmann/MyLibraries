package dennis.markmann.MyLibraries.GuiJobs.Builder;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * Builder for many GUI components on GridLayout.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public class GuiBuilder {

    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();

    public GuiBuilder() {
        this.getGridBagConstraints().insets = new Insets(5, 5, 5, 5);
        this.getGridBagConstraints().weightx = 2;
        this.getGridBagConstraints().fill = GridBagConstraints.BOTH;
    }

    public final void setDefaultFrameSettings(final JFrame frame, final String frameName) {

        // frame.addWindowListener(new MyWindowAdapter(frame));
        frame.setTitle("GroupBuilder - " + frameName);
        frame.setSize(new Dimension(400, 200));
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public final void setDefaultTabSettings(final JPanel jPanel) {
        jPanel.setLayout(new GridBagLayout());
        this.getGridBagConstraints().fill = GridBagConstraints.HORIZONTAL;
    }

    public final JLabel createLabel(final JFrame frame, final String labelText, final int gridxValue, final int gridyValue) {
        final JLabel label = new JLabel(labelText);
        this.setPosition(frame, this.getGridBagConstraints(), gridxValue, gridyValue, label);

        return label;
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

    public final JTextField createTextField(
            final JFrame frame,
            final String name,
            final int textFieldSize,
            final int gridxValue,
            final int gridyValue) {

        final JTextField textField = new JTextField(textFieldSize);
        this.setName(textField, name);
        this.setPosition(frame, this.getGridBagConstraints(), gridxValue, gridyValue, textField);

        return textField;
    }

    public final JComboBox<String> createComboBox(
            final JFrame frame,
            final String name,
            final String[] content,
            final int gridxValue,
            final int gridyValue) {

        final JComboBox<String> comboBox = new JComboBox<String>(content);
        this.setName(comboBox, name);
        this.setPosition(frame, this.getGridBagConstraints(), gridxValue, gridyValue, comboBox);

        return comboBox;
    }

    public final JCheckBox createCheckBox(
            final JFrame frame,
            final String name,
            final String text,
            final int gridxValue,
            final int gridyValue) {

        final JCheckBox checkBox = new JCheckBox();
        checkBox.setText(text);
        this.setName(checkBox, name);
        this.setPosition(frame, this.getGridBagConstraints(), gridxValue, gridyValue, checkBox);

        return checkBox;
    }

    public final JScrollPane createTable(final Object panel, final int gridxValue, final int gridyValue, final JTable jTable) {

        final JScrollPane scrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(true);
        this.setPosition(panel, this.getGridBagConstraints(), gridxValue, gridyValue, scrollPane);

        return scrollPane;

    }

    public final GridBagConstraints getGridBagConstraints() {
        return this.gridBagConstraints;

    }

    protected final void setName(final Component object, final String objectName) {
        object.setName(objectName);
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
