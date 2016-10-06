package dennis.markmann.MyLibraries.DefaultJobs.File;

import java.io.File;
import java.nio.file.Files;

/**
 * Used to create a copy of a given source at a selected output path.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class FileCopy {

    public final void copy(final File sourceFile, final File outputPath, boolean excludeDirectories)
            throws CopyOperationException {
        try {
            if (excludeDirectories && sourceFile.isDirectory()) {
                return;
            }
            Files.copy(sourceFile.toPath(), outputPath.toPath());
            if (sourceFile.isDirectory()) {
                for (File file : sourceFile.listFiles()) {
                    this.copy(file, outputPath, false);
                }
            }
        }
        catch (final Exception e) {
            throw (new CopyOperationException(e.getStackTrace(), sourceFile.toString()));
        }
    }
}
