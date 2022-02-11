package com.ex1.covidtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CovidtrackerApplication {
	public static String url = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	
	public static void main(String[] args) {
		SpringApplication.run(CovidtrackerApplication.class, args);
	}

	
}
