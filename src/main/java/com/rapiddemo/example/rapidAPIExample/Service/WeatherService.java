package com.rapiddemo.example.rapidAPIExample.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
	@Value("${rapidapi.weather.api.url}")
	private String apiHost;

	@Value("${rapidapi.api.key}")
	private String apiKey;


	public  ResponseEntity<String> getWeatherByLocationSummary(String location) throws Exception {

		String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/" + location + "/summary/";

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("X-RapidAPI-Key", apiKey)
				.header("X-RapidAPI-Host", apiHost)
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

		
		return new ResponseEntity<>(response.body(), HttpStatus.OK);

	}
	
	public ResponseEntity<String> getWeatherByLocationHourly(String location) throws Exception {

		String url = "https://forecast9.p.rapidapi.com/rapidapi/forecast/" + location + "/hourly/";

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.header("X-RapidAPI-Key", apiKey)
				.header("X-RapidAPI-Host", apiHost)
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

		return new ResponseEntity<>(response.body(), HttpStatus.OK);

	}

}
