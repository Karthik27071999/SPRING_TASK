package com.example.weather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class weatherservice {
    private String apiKey = "dbc9e1852a4ea43dc7fd11594392b500";
    private final String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
    private final RestTemplate restTemplate;

    public weatherservice(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getDataFromThirdPartyAPI(String city) {
        String url = apiUrl + city + "&appid=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }
}

