package dennis.markmann.MyLibraries.GuiJobs.Builder;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Builder for frame components.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public class FrameBuilder extends ComponentBuilder {

    public FrameBuilder() {
        super();
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

    // public final JButton createButton(
    // final JFrame frame,
    // final String buttonName,
    // final String buttonText,
    // final int gridxValue,
    // final int gridyValue) {
    //
    // final JButton button = super.createButton(frame, buttonName, buttonText, gridxValue, gridyValue);
    // this.setPosition(frame, this.getGridBagConstraints(), gridxValue, gridyValue, button);
    //
    // return button;
    // }

    public final JLabel createLabel(final JFrame frame, final String labelText, final int gridxValue, final int gridyValue) {
        final JLabel label = new JLabel(labelText);
        this.setPosition(frame, this.getGridBagConstraints(), gridxValue, gridyValue, label);

        return label;
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

    private void setPosition(
            final JFrame frame,
            final GridBagConstraints c,
            final int gridxValue,
            final int gridyValue,
            final Component object) {

        c.gridx = gridxValue;
        c.gridy = gridyValue;
        frame.add(object, c);
    }
}
