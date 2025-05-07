package com.example.my_java_project.DTO;

import java.sql.Time;
import lombok.Data;

@Data
public class TravelDTO {
    private Long Id;
    private BusDTO Bus;
    private DriverDTO Driver;
    private LineDTO Line;
    private Time Departure;
}
