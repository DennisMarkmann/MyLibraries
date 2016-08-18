package dennis.markmann.MyLibraries.GuiJobs.DefaultFrames.Implementations;

public enum WindowCloseDialogOptions {

    CLOSE_WINDOW {

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

    EDIT_MEMBER {

        @Override
        public String toString() {
            return "Do you really want to edit that member?";
        }
    },

    WARNING {

        @Override
        public String toString() {
            return "You are closing the window.";
        }
    };
}
