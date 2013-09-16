package dennis.markmann.MyLibraries.GuiJobs.DefaultFrames;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * Frame to select a directory and return it.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */

public class PathChooser {

	public final String changePath() {
		final JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(final File file) {
				return file.isDirectory();
			}

			@Override
			public String getDescription() {
				return ("Directory");
			}
		});

		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fc.getSelectedFile().getAbsolutePath() + "\\";
		}
		return null;
	}
}