package dennis.markmann.MyLibraries.GuiJobs.Builder;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

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
 * @version 1.0
 */

public class GuiBuilder {

    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();
    private final ComponentBuilder componentBuilder = new ComponentBuilder();

    public GuiBuilder() {
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

        final JButton button = this.componentBuilder.createButton(name, buttonText);
        this.setPosition(panel, this.getGridBagConstraints(), gridxValue, gridyValue, button);

        return button;
    }

    public final JCheckBox createCheckBox(
            final Object panel,
            final String name,
            final String text,
            final int gridxValue,
            final int gridyValue) {

        final JCheckBox checkBox = this.componentBuilder.createCheckBox(name, text);
        this.setPosition(panel, this.getGridBagConstraints(), gridxValue, gridyValue, checkBox);

        return checkBox;
    }

    public final JPanel createCombiPanel(
            final Object panel,
            final String buttonName,
            final String buttonText,
            final String textFieldName,
            final int textFieldSize,
            final int gridxValue,
            final int gridyValue) {

        final JPanel combiPanel = this.componentBuilder
                .createCombiPanel(panel, buttonName, buttonText, textFieldName, textFieldSize, gridxValue, gridyValue);

        this.getGridBagConstraints().gridwidth = 2;
        this.setPosition(panel, this.getGridBagConstraints(), gridxValue, gridyValue, combiPanel);
        this.getGridBagConstraints().gridwidth = 1;

        return combiPanel;

    }

    public final JComboBox<String> createComboBox(
            final Object panel,
            final String name,
            final String[] content,
            final int gridxValue,
            final int gridyValue) {

        final JComboBox<String> comboBox = this.componentBuilder.createComboBox(name, content);
        this.setPosition(panel, this.getGridBagConstraints(), gridxValue, gridyValue, comboBox);

        return comboBox;
    }

    public final JLabel createLabel(final Object panel, final String labelText, final int gridxValue, final int gridyValue) {
        final JLabel label = this.componentBuilder.createLabel(labelText);
        this.setPosition(panel, this.getGridBagConstraints(), gridxValue, gridyValue, label);

        return label;
    }

    public final JPanel createPanel(final Object panel, final int gridxValue, final int gridyValue, final int width) {

        final int tmpWidth = this.getGridBagConstraints().gridwidth;
        this.getGridBagConstraints().gridwidth = width;
        final JPanel newPanel = new JPanel();
        this.setPosition(panel, this.getGridBagConstraints(), gridxValue, gridyValue, newPanel);
        this.getGridBagConstraints().gridwidth = tmpWidth;

        return newPanel;

    }

    public final JScrollPane createTable(
            final Object panel,
            final int gridxValue,
            final int gridyValue,
            final JTable jTable,
            final ArrayList<String> buttonRenderCols) {

        final JScrollPane scrollPane = this.componentBuilder.createTable(jTable, buttonRenderCols);
        this.setPosition(panel, this.getGridBagConstraints(), gridxValue, gridyValue, scrollPane);

        return scrollPane;

    }

    public final JTextField createTextField(
            final Object panel,
            final String name,
            final int textFieldSize,
            final int gridxValue,
            final int gridyValue) {

        final JTextField textField = this.componentBuilder.createTextField(name, textFieldSize);
        this.setPosition(panel, this.getGridBagConstraints(), gridxValue, gridyValue, textField);

        return textField;
    }

    public final GridBagConstraints getGridBagConstraints() {
        return this.gridBagConstraints;

    }

    public final void setDefaultFrameSettings(final JFrame frame, final String title) {
        // frame.addWindowListener(new MyWindowAdapter(frame));
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setTitle(title);
        frame.setSize(new Dimension(400, 200));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new GridBagLayout());
    }

    public final void setDefaultTabSettings(final JPanel jPanel) {
        jPanel.setLayout(new GridBagLayout());
        this.getGridBagConstraints().fill = GridBagConstraints.HORIZONTAL;
    }

    public void setPosition(
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
