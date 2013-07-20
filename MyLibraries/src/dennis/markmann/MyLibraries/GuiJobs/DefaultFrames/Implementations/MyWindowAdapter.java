package dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Self created window adapter. Used to overwrite the windowClosing operation and enable proper closing for instanced fames.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public class MyWindowAdapter extends WindowAdapter {

    private final DefaultFrame frame;

    public MyWindowAdapter(final DefaultFrame frame) {
        this.frame = frame;
    }

    @Override
    public final void windowClosing(final WindowEvent e) {
        this.frame.openClosingDialog("close the window");
    }
}
