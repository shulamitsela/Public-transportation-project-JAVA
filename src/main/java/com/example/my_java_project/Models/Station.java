package com.example.my_java_project.Models;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name="Stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "Station_id", fetch = FetchType.LAZY)
    private List<Station_Line> TrStation_Lines;
}
