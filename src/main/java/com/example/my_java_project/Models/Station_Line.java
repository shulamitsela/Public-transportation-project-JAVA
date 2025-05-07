package com.example.my_java_project.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name ="Station_Lines")
public class Station_Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long Station_id;
    private Long Line_id;
    private int StationOrder;
}
