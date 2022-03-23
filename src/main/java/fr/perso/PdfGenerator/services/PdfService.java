package fr.perso.PdfGenerator.services;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class PdfService {

    public void generatePdf() throws FileNotFoundException {
        System.out.println("===== Start generating pdf =====");


        PdfWriter pdfWriter = new PdfWriter("Invoice.pdf");
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);

        pdfDocument.setDefaultPageSize(PageSize.A4);

        Document document = new Document(pdfDocument);

        // header
        Table headerTable = new Table(2).useAllAvailableWidth();
        headerTable.addCell(
            new Cell()
                .add(new Paragraph("Invoice"))
                .setBorder(Border.NO_BORDER)
                .setBold()
                .setTextAlignment(TextAlignment.LEFT)
        );
        headerTable.addCell(
            new Cell()
                .add(new Paragraph("Lorem Ipsum"))
                .setBorder(Border.NO_BORDER)
                .setTextAlignment(TextAlignment.RIGHT)
        );
        document.add(headerTable);
        document.close();


        System.out.println("===== End generating pdf =====");
    }

}
