package dennis.markmann.MyLibraries.GuiJobs.Builder;

import java.awt.Component;

import javax.swing.JButton;

public class ComponentBuilder {

    public final JButton createButton(final String name, final String buttonText) {
        final JButton button = new JButton(buttonText);
        this.setName(button, name);

        return button;
    }

    protected final void setName(final Component object, final String objectName) {
        object.setName(objectName);
    }

}
