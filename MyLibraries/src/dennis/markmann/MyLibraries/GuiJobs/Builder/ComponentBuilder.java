package dennis.markmann.MyLibraries.GuiJobs.Builder;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

/**
 * Used to create GUI elements.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class ComponentBuilder {

    public final JButton createButton(final String name, final String buttonText) {
        final JButton button = new JButton(buttonText);
        button.setName(name);
        return button;
    }

    public final JCheckBox createCheckBox(final String name, final String text) {
        final JCheckBox checkBox = new JCheckBox();
        checkBox.setText(text);
        checkBox.setName(name);
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

        final JPanel combiPanel = new JPanel();

        final JTextField textField = new JTextField(textFieldSize);
        textField.setName(textFieldName);

        final JButton button = new JButton(buttonText);
        button.setName(buttonName);

        combiPanel.add(textField);
        combiPanel.add(button);

        return combiPanel;

    }

    public final JComboBox<Object> createComboBox(final String name, final Object[] content) {
        final JComboBox<Object> comboBox = new JComboBox<Object>(content);
        comboBox.setName(name);

        return comboBox;
    }

    public final JLabel createLabel(final String labelText) {
        return new JLabel(labelText);

    }

    public final JScrollPane createTable(final JTable jTable, final ArrayList<String> buttonRenderCols) {

        final TableCellRenderer buttonRenderer = new JTableButtonRenderer();

        for (final String rowName : buttonRenderCols) {
            jTable.getColumn(rowName).setCellRenderer(buttonRenderer);
        }
        jTable.addMouseListener(new JTableButtonMouseListener(jTable));

        final JScrollPane scrollPane = new JScrollPane(jTable);
        jTable.setFillsViewportHeight(true);

        return scrollPane;

    }

    public final JTextField createTextField(final String name, final int textFieldSize) {
        final JTextField textField = new JTextField(textFieldSize);
        textField.setName(name);

        return textField;
    }

}
