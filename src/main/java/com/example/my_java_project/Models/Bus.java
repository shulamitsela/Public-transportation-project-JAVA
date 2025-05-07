package com.example.my_java_project.Models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Buses")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String License_plate;
    private int Seats;
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "Bus_id", fetch = FetchType.LAZY)
    private List<Travel> Travels;
}
