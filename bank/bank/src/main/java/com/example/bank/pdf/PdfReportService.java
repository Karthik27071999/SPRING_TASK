package com.example.bank.pdf;

import com.example.bank.bankent;
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

    public ByteArrayInputStream generatePdfReport(List<bankent> data) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try (PdfWriter writer = new PdfWriter(outputStream);
             PdfDocument pdfDocument = new PdfDocument(writer);
             Document document = new Document(pdfDocument)) {

            // Add title
            Paragraph title = new Paragraph("ACCOUNT HOLDERS LIST");
            title.setTextAlignment(TextAlignment.CENTER);
            document.add(title);

            // Add data to the table
            Table table = new Table(6);
            table.addCell("ID");
            table.addCell("Name");
            table.addCell("EMAIL");
            table.addCell("PHONE NUMBER");
            table.addCell("ACCOUNT NUMBER");
            table.addCell("BALANCE");

            for (bankent item : data) {
                table.addCell(String.valueOf(item.getId()));
                table.addCell(item.getName());
                table.addCell(item.getEmail());
                table.addCell(item.getPhonenumber());
                table.addCell(item.getAccount());
                table.addCell(String.valueOf(item.getBalance()));
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}

