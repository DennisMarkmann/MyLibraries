package dennis.markmann.MyLibraries.DefaultJobs.FileCopy;

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
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class FileCopy {

    private final long chunckSizeInBytes = 1024 * 1024;

    public final void copyFolder(final String sourceFolder, final String destinationFolder) throws CopyOperationException {

        for (final File file : new File(sourceFolder).listFiles()) {
            if (!file.isDirectory()) {
                this.copy(file.getPath(), this.changeSourceToDestinationPath(file.getPath(), sourceFolder, destinationFolder));
            } else {
                final String destination = this.changeSourceToDestinationPath(file.getPath(), sourceFolder, destinationFolder);
                new File(destination).mkdirs();
                this.copyFolder(file.getAbsolutePath(), destination);
            }
        }
    }

    public final void copy(final String source, final String destination) throws CopyOperationException {
        try {

            final File sourceFile = new File(source);
            final File copiedFile = new File(destination);

            final FileInputStream fileInputStream = new FileInputStream(sourceFile);
            final FileOutputStream fileOutputStream = new FileOutputStream(copiedFile);

            final FileChannel inputChannel = fileInputStream.getChannel();
            final FileChannel outputChannel = fileOutputStream.getChannel();

            this.transfer(inputChannel, outputChannel, sourceFile.length());

            fileInputStream.close();
            fileOutputStream.close();

        } catch (final Exception e) {
            throw (new CopyOperationException(e.getStackTrace(), source));
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

    private String changeSourceToDestinationPath(
            final String filePath,
            final String sourceFolder,
            final String destinationFolder) {
        return destinationFolder + filePath.substring(filePath.indexOf(sourceFolder) + sourceFolder.length());
    }

}
