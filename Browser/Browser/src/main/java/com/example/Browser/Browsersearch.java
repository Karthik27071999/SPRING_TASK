package com.example.Browser;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
class Browsersearch {

    @GetMapping("/{term}")
    public ResponseEntity<String> search(@PathVariable String term) {
        String searchResults = performSearch(term);
        return ResponseEntity.ok(searchResults);
    }

    private String performSearch(String term) {
        try {
            Document doc = Jsoup.connect("https://www.google.com/search?q=" + term).get();
            return doc.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while searching";
        }
    }
}
