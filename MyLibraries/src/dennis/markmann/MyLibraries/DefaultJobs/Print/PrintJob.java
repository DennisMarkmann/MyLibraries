package dennis.markmann.MyLibraries.DefaultJobs.Print;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;

import javax.print.PrintServiceLookup;
import javax.swing.JTextArea;
import javax.swing.JWindow;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;

/**
 * Used to print out texts.
 * 
 * @author dennis.markmann
 * @since jdk1.7.0_21
 * @version 1.0
 */
public class PrintJob implements Printable, Runnable {

    private final PrinterJob printerJob = PrinterJob.getPrinterJob();
    private Font font = new Font("Arial", Font.PLAIN, 16 * CONS);
    private final List<String> textPassages = new ArrayList<String>();
    private String textPassage;
    private final JTextArea textareaForPrint = new JTextArea();
    private FontMetrics fontMetrics;
    private Dimension pageDim;
    private int currentLines;
    private int maxLines;
    private static final int CONS = 2;
    private int numberOfPages = 0;

    private String printText = "";

    public PrintJob(final String printText) {
        this.printText = printText;
    }

    @Override
    public void run() {
        // TODO catch exceptions
        try {
            this.printText(this.printText);
        } catch (final PrinterSelectionException e) {
            e.printStackTrace();
        } catch (final PrintOperationException e) {
            e.printStackTrace();
        }
    }

    public final void printText(final String printText) throws PrinterSelectionException, PrintOperationException {
        if (printText != null) {
            this.setPrintSettings(printText);
            for (int i = 0; i < this.numberOfPages; i++) {
                this.printPage(i);
            }
        }
    }

    public final void changeFont(final String name, final int style, final int size) {
        this.font = new Font(name, style, size);
    }

    private void setPrintSettings(final String printText) throws PrinterSelectionException, PrintOperationException {

        final PageFormat pageFormat = new PageFormat();

        this.pageDim = new Dimension(
                ((int) pageFormat.getImageableWidth() - 10) * CONS,
                ((int) pageFormat.getImageableHeight()) * CONS);

        this.getPrintService();
        this.setTextAreaValues(printText);
        this.wrapText(pageFormat);
        this.getNumberOfPages();
        this.calculateStartEndofPages();
        this.printerJob.setPrintable(this, pageFormat);
    }

    // get defaultPrinter or opens printerSelectionDialog
    private void getPrintService() throws PrinterSelectionException {
        final PrinterSelector instance = PrinterSelector.getInstance();
        try {
            if (instance.getService() != null) {
                this.printerJob.setPrintService(instance.getService());
            } else {
                this.printerJob.setPrintService(instance.selectPrinter());
            }
        } catch (final PrinterException e) {
            instance.setPrinter(PrintServiceLookup.lookupDefaultPrintService());
            this.getPrintService();
            throw (new PrinterSelectionException(e.getStackTrace()));
        }
    }

    // Calculate specifications of TextArea
    private void setTextAreaValues(final String printText) {

        this.textareaForPrint.setFont(this.font);
        this.fontMetrics = this.textareaForPrint.getFontMetrics(this.font);
        this.textareaForPrint.setLineWrap(true);
        this.textareaForPrint.setWrapStyleWord(true);
        this.textareaForPrint.setPreferredSize(this.pageDim);
        this.textareaForPrint.setTabSize(4);
        this.textareaForPrint.setText(printText);
    }

    // Wrapp text and give to TextArea
    private void wrapText(final PageFormat pageFormat) throws PrintOperationException {

        final JWindow windowForPrint = new JWindow();
        windowForPrint.add(this.textareaForPrint);
        windowForPrint.pack();
        this.textareaForPrint.setText(this.getWrappedText(this.textareaForPrint));
        this.pageDim = new Dimension((int) pageFormat.getImageableWidth() * CONS, (int) pageFormat.getImageableHeight() * CONS);
        this.textareaForPrint.setPreferredSize(this.pageDim);
        windowForPrint.pack();
    }

    private void getNumberOfPages() {
        this.currentLines = this.textareaForPrint.getLineCount();
        this.maxLines = this.textareaForPrint.getHeight() / this.fontMetrics.getHeight();
        this.numberOfPages = (int) Math.ceil(this.currentLines / (double) this.maxLines);
    }

    // Calculate Start and End of the pages and store in pageBorders
    // And split text in passages and store in textPassages
    private void calculateStartEndofPages() throws PrintOperationException {

        final int[][] pageBorders = new int[999][2];

        try {
            for (int i = 0; i < this.numberOfPages; i++) {
                pageBorders[i][0] = this.textareaForPrint.getLineStartOffset(i * this.maxLines);
            }
            for (int i = 0; i < this.numberOfPages - 1; i++) {
                pageBorders[i][1] = pageBorders[i + 1][0] - 1;
            }
            pageBorders[this.numberOfPages - 1][1] = this.textareaForPrint.getLineEndOffset(this.currentLines - 1);
            for (int i = 0; i < this.numberOfPages; i++) {
                this.textPassages.add(this.textareaForPrint.getText(pageBorders[i][0], pageBorders[i][1] - pageBorders[i][0]));
            }
        } catch (final BadLocationException e) {
            throw (new PrintOperationException(e.getStackTrace()));
        }
    }

    private boolean printPage(final int page) throws PrintOperationException {
        if (page < 0 | page > this.numberOfPages - 1) {
            return false;
        }
        this.textPassage = this.textPassages.get(page);
        try {
            this.printerJob.print();
        } catch (final PrinterException e) {
            throw (new PrintOperationException(e.getStackTrace()));
        }
        return true;
    }

    @Override
    public final int print(final Graphics g, final PageFormat pFormat, final int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }

        final Graphics2D g2 = (Graphics2D) g;

        g2.translate((int) pFormat.getImageableX(), (int) pFormat.getImageableY());
        g2.scale(1.0 / CONS, 1.0 / CONS);

        this.textareaForPrint.setText(this.textPassage);
        BufferedImage bufferedImage = null;
        bufferedImage = new BufferedImage(this.pageDim.width, this.pageDim.height, BufferedImage.TYPE_BYTE_GRAY);
        this.textareaForPrint.paint(bufferedImage.getGraphics());

        g2.drawImage(bufferedImage, 0, 0, this.textareaForPrint);
        g2.dispose();

        return Printable.PAGE_EXISTS;
    }

    private String getWrappedText(final JTextComponent c) throws PrintOperationException {
        final int length = c.getDocument().getLength();
        int offset = 0;
        final StringBuffer sb = new StringBuffer((int) (length * 1.30));
        String s = "";
        try {
            while (offset < length) {
                int end = Utilities.getRowEnd(c, offset);
                if (end < 0) {
                    break;
                }
                end = Math.min(end + 1, length);
                s = c.getDocument().getText(offset, end - offset);
                sb.append(s);
                if (!s.endsWith("\n")) {
                    sb.append('\n');
                }
                offset = end;
            }
        } catch (final BadLocationException e) {
            throw (new PrintOperationException(e.getStackTrace()));
        }
        return sb.toString();
    }

}
