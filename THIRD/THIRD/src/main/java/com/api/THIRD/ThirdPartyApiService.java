package com.api.THIRD;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ThirdPartyApiService {
 
 private final String API_BASE_URL = "https://www.baeldung.com";
 private final RestTemplate restTemplate;

 public ThirdPartyApiService(RestTemplate restTemplate) {
     this.restTemplate = restTemplate;
 }

 public String getDataFromThirdPartyAPI() {
     String apiUrl = API_BASE_URL + "/spring-boot";
     return restTemplate.getForObject(apiUrl, String.class);
 }
}

