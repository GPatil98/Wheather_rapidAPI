package com.rapiddemo.example.rapidAPIExample.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rapiddemo.example.rapidAPIExample.Service.WeatherService;


@RestController
public class WeatherController {

   @Autowired
   private final WeatherService weatherService;

   public WeatherController(WeatherService weatherService) {
       this.weatherService = weatherService;
   }

   @GetMapping("/weather/summary")
   public ResponseEntity<String> getWeatherSummary(@RequestParam String location) throws Exception {
       return weatherService.getWeatherByLocationSummary(location);
   }
   
   @GetMapping("/weather/hourly")
   public ResponseEntity<String> getWeatherHourly(@RequestParam String location) throws Exception {
	   return weatherService.getWeatherByLocationHourly(location);
   }

}
