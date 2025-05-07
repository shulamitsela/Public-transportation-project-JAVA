package com.example.my_java_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.my_java_project.Convertors.BusConverter;
import com.example.my_java_project.Convertors.DriverConverter;
import com.example.my_java_project.Convertors.LineConverter;
import com.example.my_java_project.Convertors.StationConverter;
import com.example.my_java_project.Convertors.TravelConverter;

@SpringBootApplication
public class MyJavaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyJavaProjectApplication.class, args);
	}

		@Bean
	public BusConverter getBusConverter() {
		return new BusConverter();
	}
	@Bean
	public DriverConverter getDriverConverter() {
		return new DriverConverter();
	}
	@Bean
	public LineConverter getLineConverter() {
		return new LineConverter();
	}
	@Bean
	public StationConverter getStationConverter() {
		return new StationConverter();
	}
	@Bean
	public TravelConverter getTravelConverter() {
		return new TravelConverter();
	}
	
}
