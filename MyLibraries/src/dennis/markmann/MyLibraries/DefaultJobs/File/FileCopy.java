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
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class FileCopy {

    private final long chunckSizeInBytes = 1024 * 1024;

    public final void copyFolder(final String sourceFolder, final String destinationFolder, boolean includeSubfolder)
            throws CopyOperationException {

        for (final File file : new File(sourceFolder).listFiles()) {
            if (!file.isDirectory()) {
                this.copy(file.getPath(), this.changeSourceToDestinationPath(file.getPath(), sourceFolder, destinationFolder));
            } else if (!file.isDirectory() && includeSubfolder) {
                final String destination = this.changeSourceToDestinationPath(file.getPath(), sourceFolder, destinationFolder);
                new File(destination).mkdirs();
                this.copyFolder(file.getAbsolutePath(), destination, includeSubfolder);
            }
        }
    }

    public final void copy(final String source, final String destination) throws CopyOperationException {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {

            final File sourceFile = new File(source);
            fileInputStream = new FileInputStream(sourceFile);
            final FileChannel inputChannel = fileInputStream.getChannel();

            final File copiedFile = new File(destination);
            fileOutputStream = new FileOutputStream(copiedFile);
            final FileChannel outputChannel = fileOutputStream.getChannel();

            this.transfer(inputChannel, outputChannel, sourceFile.length());

        } catch (final Exception e) {
            throw (new CopyOperationException(e.getStackTrace(), source));
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
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

    private String changeSourceToDestinationPath(
            final String filePath,
            final String sourceFolder,
            final String destinationFolder) {
        return destinationFolder + filePath.substring(filePath.indexOf(sourceFolder) + sourceFolder.length());
    }

}
