package dennis.markmann.MyLibraries.DefaultJobs.File;

import java.io.File;
import java.util.ArrayList;

public class FileFilter {

    ArrayList<FileType> fileTypes = new ArrayList<>();

    public FileFilter addDocuments() {
        this.fileTypes.add(FileType.TXT);
        this.fileTypes.add(FileType.PDF);
        this.fileTypes.add(FileType.XML);
        this.fileTypes.add(FileType.CSV);
        return this;
    }

    public FileFilter addExecutable() {
        this.fileTypes.add(FileType.EXE);
        return this;
    }

    public FileFilter addFileTypes(ArrayList<FileType> fileTypes) {
        this.fileTypes.addAll(fileTypes);
        return this;
    }

    public FileFilter addMovies() {
        this.fileTypes.add(FileType.MKV);
        this.fileTypes.add(FileType.MP4);
        this.fileTypes.add(FileType.AVI);
        return this;
    }

    public FileFilter addMusic() {
        this.fileTypes.add(FileType.MP3);
        return this;
    }

    public FileFilter addTextFiles() {
        this.fileTypes.add(FileType.TXT);
        return this;
    }

    public ArrayList<File> filter(ArrayList<File> fileList) {
        ArrayList<File> filteredList = new ArrayList<>();

        for (File file : fileList) {
            if (!file.isDirectory()) {
                final String fileName = file.getName().toLowerCase();

                for (FileType type : this.fileTypes) {
                    if (fileName.endsWith(type.toString())) {
                        filteredList.add(file);
                    }
                }
            }
        }
        return filteredList;
    }

    public ArrayList<File> filterByNames(ArrayList<File> fileList, ArrayList<String> nameFilterList) {
        ArrayList<File> filteredList = new ArrayList<>();

        for (File file : fileList) {
            if (!file.isDirectory()) {
                final String fileName = file.getName().toLowerCase();
                for (String name : nameFilterList) {
                    if (fileName.contains(name)) {
                        filteredList.add(file);
                    }
                }
            }
        }
        return filteredList;
    }
}
