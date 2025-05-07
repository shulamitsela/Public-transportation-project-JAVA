package com.example.my_java_project.Models;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name ="Lines")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Number;
    private String Sourse;
    private String Destination;
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "Line_id", fetch = FetchType.LAZY)
    private List<Travel> Travels;
    @OneToMany(cascade = CascadeType.ALL ,mappedBy = "Line_id", fetch = FetchType.LAZY)
    private List<Station_Line> TrStation_Lines;
}
