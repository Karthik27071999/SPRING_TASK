package com.example.vote.pdf;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.vote.entity.election;
import com.example.vote.entity.gamers;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
@Service
public class pdfconfig {
	 public ByteArrayInputStream generatePdfReport(List<gamers> data) {
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	        try (PdfWriter writer = new PdfWriter(outputStream);
	             PdfDocument pdfDocument = new PdfDocument(writer);
	             Document document = new Document(pdfDocument)) {

	            // Add title
	            Paragraph title = new Paragraph("ELECTION RESULTS");
	            title.setTextAlignment(TextAlignment.CENTER);
	            document.add(title);

	            // Add data to the table
	            Table table = new Table(4);
	            table.addCell("S.NO");
	            table.addCell("NAME");
	            table.addCell("VOTES");
	            table.addCell("RESULT");
	        
	            

	            for (gamers item : data) {
	            	table.addCell(String.valueOf(item.getGid()));
	            	table.addCell(item.getName());
	            	table.addCell(String.valueOf(item.getVotes()));
	                table.addCell(item.getResult());   
	            }

	            document.add(table);
	            document.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return new ByteArrayInputStream(outputStream.toByteArray());
	    }
	 
	 public ByteArrayInputStream generatevotersPdfReport(List<election> data) {
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	        try (PdfWriter writer = new PdfWriter(outputStream);
	             PdfDocument pdfDocument = new PdfDocument(writer);
	             Document document = new Document(pdfDocument)) {

	            // Add title
	            Paragraph title = new Paragraph("ELECTION RESULTS");
	            title.setTextAlignment(TextAlignment.CENTER);
	            document.add(title);

	            // Add data to the table
	            Table table = new Table(3);
	            table.addCell("ID");
	            table.addCell("EMAIL");
	            table.addCell("VOTED FOR");
	        
	            

	            for (election item : data) {
	            	table.addCell(String.valueOf(item.getId()));
	            	table.addCell(item.getEmail());
	                table.addCell(item.getName());   
	            }

	            document.add(table);
	            document.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return new ByteArrayInputStream(outputStream.toByteArray());
	    }
	}


