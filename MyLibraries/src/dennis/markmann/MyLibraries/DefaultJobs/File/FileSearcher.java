package dennis.markmann.MyLibraries.DefaultJobs.File;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileSearcher {

    private List<File> fileList;

    private boolean isFileMatching(File file, String fileName, Date date, FileType fileType, int fileSize) {
        // TODO implement date and fileSize
        if (fileName != null && file.getName().contains(fileName)) {
            return true;
        }
        if (fileType != null && file.getName().endsWith("." + fileType.toString())) {
            return true;
        }
        return false;
    }

    private void searchFolder(
            File folder,
            boolean includeSubfolder,
            String fileName,
            Date date,
            FileType fileType,
            int fileSize) {

        for (final File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                if (isFileMatching(file, fileName, date, fileType, fileSize)) {
                    fileList.add(file);
                }
            } else if (file.isDirectory() && includeSubfolder) {
                file.mkdirs();
                this.searchFolder(file, true, fileName, date, fileType, fileSize);
            }
        }
    }

    public List<File> startFileSearch(
            File folder,
            boolean includeSubfolder,
            Date date,
            String fileName,
            FileType fileType,
            int fileSize) {
        fileList = new ArrayList<File>();
        searchFolder(folder, includeSubfolder, fileName, date, fileType, fileSize);
        return fileList;
    }

    public List<File> startFileSearch(
            String path,
            boolean includeSubfolder,
            Date date,
            String fileName,
            FileType fileType,
            int fileSize) {
        return startFileSearch(new File(path), includeSubfolder, date, fileName, fileType, fileSize);
    }
}
