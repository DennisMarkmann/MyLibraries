package dennis.markmann.MyLibraries.DefaultJobs.File;

import java.io.File;
import java.util.ArrayList;

public class FileLister {

    public ArrayList<File> listFilesForFolder(File folder, boolean includeSubfolder) {
        ArrayList<File> fileList = new ArrayList<>();
        for (File file : folder.listFiles()) {
            if (includeSubfolder && file.isDirectory()) {
                this.listFilesForFolder(file, true);
            }
            else {
                fileList.add(file);
            }
        }
        return fileList;
    }

    public ArrayList<File> listFilesInFolderList(final ArrayList<File> folderList, boolean includeSubfolder) {
        final ArrayList<File> fileList = new ArrayList<>();
        for (final File folder : folderList) {
            fileList.addAll(this.listFilesForFolder(folder, includeSubfolder));
        }
        return fileList;
    }

    public ArrayList<File> listFolderAtPath(final File path) {
        final ArrayList<File> fileList = new ArrayList<>();
        for (final File file : path.listFiles()) {
            if (file.isDirectory()) {
                fileList.add(file);
            }
        }
        return fileList;
    }
}
