package dennis.markmann.MyLibraries.DefaultJobs.Print;

import java.awt.GraphicsEnvironment;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

/**
 * Used select the printService for the print operation.
 * 
 * @author dennis.markmann
 * @version 1.0
 */

public final class PrinterSelector {

    private PrintService service = null;
    private static PrinterSelector instance = null;

    public PrintService selectPrinter() {
        final PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        final DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        final PrintService[] printService = PrintServiceLookup.lookupPrintServices(flavor, pras);
        final PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();

        return this.service = ServiceUI.printDialog(
                GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration(),
                200,
                200,
                printService,
                defaultService,
                flavor,
                pras);

    }

    public void setPrinter(final PrintService printService) {
        this.service = printService;
    }

    public static PrinterSelector getInstance() {
        if (instance == null) {
            instance = new PrinterSelector();
        }
        return instance;
    }

    public PrintService getService() {
        return this.service;
    }
}
