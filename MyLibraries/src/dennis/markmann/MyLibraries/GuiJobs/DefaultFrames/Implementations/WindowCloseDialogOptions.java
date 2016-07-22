package dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations;

public enum WindowCloseDialogOptions {

    REQUEST {

        @Override
        public String toString() {
            return "Do you really want to close the window?";
        }
    },

    NONE {

        @Override
        public String toString() {
            return null;
        }
    },

    WARNING {

        @Override
        public String toString() {
            return "You are closing the window.";
        }
    };
}
