package com.example.weather;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class weathercontrol {
    @Autowired
    private weatherservice service;
    @Autowired
    private weatherpdf pdf;

    @GetMapping("/weather/{city}")
    public ResponseEntity<Weatherent> getWeather(@PathVariable String city) {
        try {
            Weatherent weatherResponse = service.getDataFromThirdPartyAPI(city);
            return ResponseEntity.ok(weatherResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @GetMapping("/report")
    public ResponseEntity<InputStreamResource> generatePdfReport() {
        List<Weatherent> data = service.getalll();// Assume you have a method to fetch data from database
        ByteArrayInputStream pdfReport =pdf.generatePdfReport(data);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(pdfReport));
 }
}