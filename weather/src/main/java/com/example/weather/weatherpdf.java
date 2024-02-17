package com.example.weather;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

@Service
public class weatherpdf {

    public ByteArrayInputStream generatePdfReport(List<Weatherent> data) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try (PdfWriter writer = new PdfWriter(outputStream);
             PdfDocument pdfDocument = new PdfDocument(writer);
             Document document = new Document(pdfDocument)) {

            // Add title
            Paragraph title = new Paragraph("WEATHER DETAILS");
            title.setTextAlignment(TextAlignment.CENTER);
            document.add(title);

            // Add data to the table
            Table table = new Table(5);
            table.addCell("ID");
            table.addCell("CITY");
            table.addCell("HUMIDITY");
            table.addCell("PRESSURE");
            table.addCell("TEMPERATUREs");
            

            for (Weatherent item : data) {
            	table.addCell(String.valueOf(item.getId()));
            	table.addCell(item.getCity());
            	table.addCell(String.valueOf(item.getHumidity()));
            	table.addCell(String.valueOf(item.getPressure()));
            	table.addCell(String.valueOf(item.getTemperature()));
            }

            document.add(table);
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(outputStream.toByteArray());
    }
}


