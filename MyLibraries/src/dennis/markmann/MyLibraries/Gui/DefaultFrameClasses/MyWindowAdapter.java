package dennis.markmann.MyLibraries.Gui.DefaultFrameClasses;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowAdapter extends WindowAdapter {

    private final DefaultFrame frame;

    public MyWindowAdapter(final DefaultFrame frame) {
        this.frame = frame;
    }

    @Override
    public final void windowClosing(final WindowEvent e) {
        this.frame.closeWindow();
    }
}
