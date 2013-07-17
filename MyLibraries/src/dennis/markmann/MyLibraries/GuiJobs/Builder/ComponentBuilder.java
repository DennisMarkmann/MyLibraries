package dennis.markmann.MyLibraries.GuiJobs.Builder;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

public class ComponentBuilder {

    public final JButton createButton(final String name, final String buttonText) {
        final JButton button = new JButton(buttonText);
        this.setName(button, name);
        return button;
    }

    public final JTextField createTextField(final String name, final int textFieldSize) {
        final JTextField textField = new JTextField(textFieldSize);
        this.setName(textField, name);
        return textField;
    }

    public final JComboBox<String> createComboBox(final String name, final String[] content) {
        final JComboBox<String> comboBox = new JComboBox<String>(content);
        this.setName(comboBox, name);
        return comboBox;
    }

    public final JCheckBox createCheckBox(final String name, final String text) {
        final JCheckBox checkBox = new JCheckBox();
        checkBox.setText(text);
        this.setName(checkBox, name);
        return checkBox;
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

    private final void setName(final Component object, final String objectName) {
        object.setName(objectName);
    }

}
