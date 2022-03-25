package fr.perso.PdfGenerator.services;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class PdfService {

    public void generatePdf() throws FileNotFoundException {
        System.out.println("===== Start generating pdf =====");


//        PdfWriter pdfWriter = new PdfWriter("Invoice.pdf");
//        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
//
//        pdfDocument.setDefaultPageSize(PageSize.A4);
//
//        Document document = new Document(pdfDocument);
//
//        // header
//        Table table = new Table(2).useAllAvailableWidth();
//        table.addCell(
//            new Cell()
//                .add(new Paragraph("Invoice"))
//                .setBorder(Border.NO_BORDER)
//                .setBold()
//                .setTextAlignment(TextAlignment.LEFT)
//        );
//        table.addCell(
//            new Cell()
//                .add(new Paragraph("Lorem Ipsum"))
//                .setBorder(Border.NO_BORDER)
//                .setTextAlignment(TextAlignment.RIGHT)
//        );
//        document.add(table);
//        document.close();

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
        PdfPCell subHeaderRightCell = new PdfPCell(new Paragraph("numéro : "));

        table.addCell(subHeaderRightCell);

        document.add(table);

        document.close();

        System.out.println("===== End generating pdf =====");
    }

}
