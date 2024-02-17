package com.example.weather;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class weatherservice {
	
	@Autowired
	private Weatherrepo repo;
	
	
    private String apiKey = "dbc9e1852a4ea43dc7fd11594392b500";
    private final String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
    private final RestTemplate restTemplate;

    public weatherservice(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public Weatherent getDataFromThirdPartyAPI(String city) {
        String url = apiUrl + city + "&appid=" + apiKey;
        WeatherData data= restTemplate.getForObject(url, WeatherData.class);
        Weatherent ent=new Weatherent();
        ent.setCity(city);
        ent.setHumidity(data.getMain().getHumidity());
        ent.setPressure(data.getMain().getPressure());
        ent.setTemperature(data.getMain().getTemp());
       return repo.save(ent);
       
    }
    
    public List<Weatherent> getalll(){
    	return repo.findAll();
    }
}

