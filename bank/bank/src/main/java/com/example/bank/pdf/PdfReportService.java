package com.example.bank.pdf;
import com.example.bank.transaction.Transaction;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfReportService {

    public ByteArrayInputStream generatePdfReport(List<Transaction> data) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try (PdfWriter writer = new PdfWriter(outputStream);
             PdfDocument pdfDocument = new PdfDocument(writer);
             Document document = new Document(pdfDocument)) {

            // Add title
            Paragraph title = new Paragraph("TRANSACTION DETAILS");
            title.setTextAlignment(TextAlignment.CENTER);
            document.add(title);

            // Add data to the table
            Table table = new Table(5);
            table.addCell("S.NO");
            table.addCell("ACCOUNT NUMBER");
            table.addCell("AMOUNT");
            table.addCell("TIME");
            table.addCell("TRANSACTION TYPE");
            

            for (Transaction item : data) {
            	table.addCell(String.valueOf(item.getTransaction_id()));
            	table.addCell(item.getAccount());
            	table.addCell(String.valueOf(item.getAmount()));
                table.addCell(String.valueOf(item.getTime()));
                table.addCell(item.getTransactiontype());   
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}

