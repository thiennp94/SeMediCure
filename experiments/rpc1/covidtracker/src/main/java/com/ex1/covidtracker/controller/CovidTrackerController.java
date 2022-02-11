package com.ex1.covidtracker.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidTrackerController {
public static String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
		@RequestMapping("/")
		public String fetch() throws IOException, InterruptedException
		{
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(url))
				.build();
			HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(httpResponse.body());
			return httpResponse.body();			
		}
}
