package com.course.hospitalms;

import com.course.hospitalms.model.ApiResult;
import com.course.hospitalms.model.Weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HospitalmsApplication {

  public static void main(String[] args) {
    SpringApplication.run(HospitalmsApplication.class, args);
  }

  @Bean
  @Scope(scopeName = "prototype")
  public Weather weather() {
    final String uri =
      "https://api.collectapi.com/weather/getWeather?data.lang=tr&data.city=ankara";

    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.add(
      "authorization",
      "apikey 47cl609MP43dkrsEkfU6hF:5ewbzG4QyjWUlI02BZE7sx"
    );
    HttpEntity<String> entity = new HttpEntity<>("body", headers);
    ApiResult result = restTemplate.postForObject(uri, entity, ApiResult.class);

    Weather today = result.getResult().get(0);
    return today;
  }
}
