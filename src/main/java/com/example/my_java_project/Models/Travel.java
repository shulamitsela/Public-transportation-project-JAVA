package com.example.my_java_project.Models;
import java.sql.Time;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name="Travels")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Time Departure_time;
    @ManyToOne
    @JoinColumn(name = "Bus_id")
    private Bus Bus_id;
    @ManyToOne
    @JoinColumn(name = "Driver_id")
    private Driver Driver_id;
    @ManyToOne
    @JoinColumn(name = "Line_id")
    private Line Line_id;
}
