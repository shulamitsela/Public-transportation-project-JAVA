package com.example.my_java_project.Models;

import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name ="Drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private String Pone;
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "Driver_id", fetch = FetchType.LAZY)
    private List<Travel> Travels;
}
