package fr.perso.PdfGenerator.services;

import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static javax.swing.text.StyleConstants.FontFamily;

@Service
public class PdfService {

    public void generatePdf() throws FileNotFoundException {
        System.out.println("===== Start generating pdf =====");

        Document document = new Document();
        PdfWriter.getInstance(document,
            new FileOutputStream("Invoice.pdf"));
        document.open();

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(90);

        // ===== Header =====
        PdfPCell headerLeftCell = new PdfPCell(new Paragraph("STACKINSAT"));
        headerLeftCell.setBorder(0);
        headerLeftCell.setHorizontalAlignment(Element.ALIGN_LEFT);

        PdfPCell headerRightCell = new PdfPCell(new Paragraph("FACTURE"));
        headerRightCell.setBorder(0);
        headerRightCell.setHorizontalAlignment(Element.ALIGN_RIGHT);

        table.addCell(headerLeftCell);
        table.addCell(headerRightCell);

        // ===== Sub header =====
        // 1)
        PdfPCell invoiceIdCell = new PdfPCell();
        invoiceIdCell.setColspan(2);
        invoiceIdCell.setBorder(0);

        Paragraph invoiceIdP = new Paragraph();
        invoiceIdP.setAlignment(Element.ALIGN_RIGHT);

        Chunk idLabel = new Chunk("Numéro : ");
        Chunk idValue = new Chunk("FC-2022-26981", new Font(Font.BOLD));
        invoiceIdP.add(idLabel);
        invoiceIdP.add(idValue);

        invoiceIdCell.addElement(invoiceIdP);
        table.addCell(invoiceIdCell);

        // 2)
        PdfPCell dateCell = new PdfPCell();
        dateCell.setColspan(2);
        dateCell.setBorder(0);

        Paragraph dateP = new Paragraph();
        dateP.setAlignment(Element.ALIGN_RIGHT);

        Chunk dateLabel = new Chunk("Date : ");
        Chunk dateValue = new Chunk("21/02/2022", new Font(Font.BOLD));
        dateP.add(dateLabel);
        dateP.add(dateValue);

        dateCell.addElement(dateP);
        table.addCell(dateCell);

        // 3)
        PdfPCell refCell = new PdfPCell();
        refCell.setColspan(2);
        refCell.setBorder(0);

        Paragraph refP = new Paragraph();
        refP.setAlignment(Element.ALIGN_RIGHT);

        Chunk refLabel = new Chunk("REF : ");
        Chunk refValue = new Chunk("kiratklb98301-sbSFWH2hYh8S3gd", new Font(Font.BOLD));
        refP.add(refLabel);
        refP.add(refValue);

        refCell.addElement(refP);
        table.addCell(refCell);

        // ===== Sub header 2 =====
        // 1)
        PdfPCell forCell = new PdfPCell(new Paragraph("A :"));
        forCell.setPaddingTop(50);
        forCell.setPaddingBottom(10);
        forCell.setColspan(2);
        forCell.setBorder(0);

        table.addCell(forCell);

        // 2)
        PdfPCell nameCell = new PdfPCell(new Paragraph("Mehdi Hamerlaine"));
        nameCell.setColspan(2);
        nameCell.setBorder(0);

        table.addCell(nameCell);

        // 3)
        PdfPCell emailCell = new PdfPCell(new Paragraph("mehdi@stackinsat.com"));
        emailCell.setColspan(2);
        emailCell.setBorder(0);

        table.addCell(emailCell);

        // 4)
        PdfPCell addressCell = new PdfPCell(new Paragraph("1218 Lieu-dit Las Baillargues"));
        addressCell.setColspan(2);
        addressCell.setBorder(0);

        table.addCell(addressCell);

        // 5)
        PdfPCell cityCell = new PdfPCell(new Paragraph("32330 Mouchan"));
        cityCell.setColspan(2);
        cityCell.setBorder(0);

        table.addCell(cityCell);

        // 6)
        PdfPCell countryCell = new PdfPCell(new Paragraph("France"));
        countryCell.setColspan(2);
        countryCell.setBorder(0);

        table.addCell(countryCell);

        // 7)
        PdfPCell phoneCell = new PdfPCell(new Paragraph("0695127488"));
        phoneCell.setColspan(2);
        phoneCell.setBorder(0);

        table.addCell(phoneCell);

        // ===== body =====
        // TODO


        document.add(table);
        document.close();

        System.out.println("===== End generating pdf =====");
    }

}
