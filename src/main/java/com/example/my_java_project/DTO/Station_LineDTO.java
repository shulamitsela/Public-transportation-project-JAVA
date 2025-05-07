package com.example.my_java_project.DTO;

import lombok.Data;

@Data
public class Station_LineDTO {
    private Long Id;
    private Long Station_id;
    private Long Line_id;
    private int StationOrder;
}
