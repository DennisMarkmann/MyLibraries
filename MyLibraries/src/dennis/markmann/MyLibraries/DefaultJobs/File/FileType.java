package dennis.markmann.MyLibraries.DefaultJobs.File;

public enum FileType {

    TXT {

        @Override
        public String toString() {
            return "txt";
        }
    },

    PDF {

        @Override
        public String toString() {
            return "pdf";
        }
    },

    EXE {

        @Override
        public String toString() {
            return "exe";
        }
    },

    MKV {

        @Override
        public String toString() {
            return "mkv";
        }
    },

    AVI {

        @Override
        public String toString() {
            return "avi";
        }
    },

    MP3 {

        @Override
        public String toString() {
            return "mp3";
        }
    },

    CSV {

        @Override
        public String toString() {
            return "csv";
        }
    },

    XML {

        @Override
        public String toString() {
            return "xml";
        }
    }
}