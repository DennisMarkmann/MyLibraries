package dennis.markmann.MyLibraries.DefaultJobs.IconHelper;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Used to enable the getIcon method for other classes.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class IconHelper {

    public final ImageIcon getIcon(final String path) throws FileNotFoundException {
        try {
            return new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(path)));
        } catch (final IOException e) {
            throw (new FileNotFoundException(e.getStackTrace(), path));
        }
    }

}
