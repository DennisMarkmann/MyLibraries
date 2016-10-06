package dennis.markmann.MyLibraries.DefaultJobs.File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {

    public void writeTextIntoFile(String text, File file, boolean overwrite) {
        try (FileWriter writer = new FileWriter(file, overwrite)) {
            writer.write(text);
        }
        catch (IOException e) {
            // use own exception
            e.printStackTrace();
        }
    }

}
