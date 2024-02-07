package com.api.THIRD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

 private final ThirdPartyApiService thirdPartyAPIService;

 @Autowired
 public MyController(ThirdPartyApiService thirdPartyAPIService) {
     this.thirdPartyAPIService = thirdPartyAPIService;
 }

 @GetMapping("/data")
 public String getDataFromThirdParty() {
     return thirdPartyAPIService.getDataFromThirdPartyAPI();
 }
}
