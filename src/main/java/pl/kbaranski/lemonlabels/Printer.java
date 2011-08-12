/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kbaranski.lemonlabels;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Collection;

/**
 *
 * @author krzysiek
 */
public class Printer {
    File file;
    Collection<Product> products;
    Font nameFont;
    Font priceFont;
    Font unitFont;
    Font spaceLineFont;
    DecimalFormat priceFormat;
    
    public Printer(Collection<Product> products) throws IOException {
        File homeDir = new File(System.getProperty("user.home"));
        String name = "lemonLabels-" + System.currentTimeMillis() + ",pdf";
        this.file = new File(homeDir, name);
        this.products = products;
        this.priceFormat = new DecimalFormat("\u00A3 #.00");

        FontFactory.registerDirectory("/usr/share/fonts/truetype/ubuntu-font-family");

        BaseFont baseUbuntu = FontFactory.getFont("Ubuntu").getBaseFont();
        this.nameFont = new Font(baseUbuntu, 14, Font.NORMAL);
        this.priceFont = new Font(baseUbuntu, 16, Font.BOLD);
        this.unitFont = new Font(baseUbuntu, 10, Font.BOLD);
        this.spaceLineFont = new Font(baseUbuntu, 10, Font.NORMAL);
    }

    public float pt2mm(float from) {
        // wymiary A4: 210 x 297 [mm] (595.0 x 842.0 [pt])
        return from * 297.0f / 842.0f;
    }
    
    public float mm2pt(float from) {
        return from * 842.0f / 297.0f;
    }

    private void addCell(PdfPTable table, Product product) {
        float h = mm2pt(33.0f);
        Phrase p = new Phrase(product.getName() + "\n", this.nameFont);
        p.add(new Phrase(" \n", this.spaceLineFont));
        p.add(new Phrase(priceFormat.format(product.getPrice()) + "\n", this.priceFont));
        p.add(new Phrase(" \n", this.spaceLineFont));
        p.add(new Phrase(product.getUnit(), this.unitFont));

        PdfPCell cell = new PdfPCell(p);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setNoWrap(false);
        cell.setFixedHeight(h);
        table.addCell(cell);
    }
    
    public void createPdf() {
        Document document = new Document(PageSize.A4, mm2pt(10.0f), mm2pt(10.0f), mm2pt(16.5f), mm2pt(16.5f));

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new int[]{1, 1, 1, 1});
            for (int i = 0; i <= 32; i++) {
                Product p = new Product(i, "nalkjhgfdswecxzme " + i, Float.valueOf(i), "unit " + i);
                addCell(table, p);
            }
            document.add(table);
        } catch (Exception e) { 
            System.err.println(e.getMessage()); 
        }
        document.close(); 
    }

    public static void main(String[] args) throws IOException {
        Printer p = new Printer(null);
        p.createPdf();
    }
}
