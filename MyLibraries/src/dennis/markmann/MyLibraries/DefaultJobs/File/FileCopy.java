package dennis.markmann.MyLibraries.DefaultJobs.File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * Used to create a copy of a given source at a selected destination.
 *
 * @author dennis.markmann
 * @version 1.0
 */

public class FileCopy {

    private final long chunckSizeInBytes = 1024 * 1024;

    private File changeSourceToDestinationPath(final File file, final File sourceFolder, final File destinationFolder) {
        return new File(
                destinationFolder.getAbsolutePath() + file.getPath()
                        .substring(file.getPath().indexOf(sourceFolder.getPath()) + sourceFolder.getPath().length()));
    }

    public final void copy(final File sourceFile, final File copiedFile) throws CopyOperationException {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {

            fileInputStream = new FileInputStream(sourceFile);
            final FileChannel inputChannel = fileInputStream.getChannel();

            fileOutputStream = new FileOutputStream(copiedFile);
            final FileChannel outputChannel = fileOutputStream.getChannel();

            this.transfer(inputChannel, outputChannel, sourceFile.length());

        }
        catch (final Exception e) {
            throw (new CopyOperationException(e.getStackTrace(), sourceFile.toString()));
        }
        finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            }
            catch (IOException e) {
            }
        }
    }

    public final void copyFolder(final File sourceFolder, final File destinationFolder, boolean includeSubfolder)
            throws CopyOperationException {

        for (final File file : sourceFolder.listFiles()) {
            if (!file.isDirectory()) {
                this.copy(file, this.changeSourceToDestinationPath(file, sourceFolder, destinationFolder));
            }
            else if (!file.isDirectory() && includeSubfolder) {
                final File destination = this.changeSourceToDestinationPath(file, sourceFolder, destinationFolder);
                destination.mkdirs();
                this.copyFolder(file, destination, includeSubfolder);
            }
        }
    }

    private void transfer(final FileChannel inputChannel, final ByteChannel outputChannel, final long lengthInBytes)
            throws IOException {

        long overallBytesTransfered = 0L;

        while (overallBytesTransfered < lengthInBytes) {
            long bytesTransfered = 0L;

            bytesTransfered = inputChannel.transferTo(
                    overallBytesTransfered,
                    Math.min(this.chunckSizeInBytes, lengthInBytes - overallBytesTransfered),
                    outputChannel);

            overallBytesTransfered += bytesTransfered;
        }
    }

}
