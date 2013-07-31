package dennis.markmann.MyLibraries.General;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Used to change the language for the application. Default language is English.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_21
 * @version 1.0
 */

public class LanguageChooser {

    private static ResourceBundle messages = ResourceBundle.getBundle(
            "dennis/markmann/MyLibraries/General/LanguageFiles/LanguageFile",
            new Locale("en", "US"));

    public final void chooseLanguage(final String givenLanguage) {

        String language = "";
        String country = "";

        if (givenLanguage.toLowerCase().equals("english")) {
            language = new String("en");
            country = new String("US");
        } else if (givenLanguage.toLowerCase().equals("german")) {
            language = new String("de");
            country = new String("US");
        } else {
            language = new String("en");
            country = new String("US");
        }
        messages = ResourceBundle.getBundle("dennis/markmann/MyLibraries/General/LanguageFiles/LanguageFile", new Locale(
                language,
                country));
    }

    public static String getMessages(final String string) {
        return messages.getString(string);
    }
}
