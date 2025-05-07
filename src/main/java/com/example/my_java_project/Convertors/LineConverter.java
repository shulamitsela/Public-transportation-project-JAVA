package com.example.my_java_project.Convertors;

import java.util.List;
import java.util.stream.Collectors;


import com.example.my_java_project.DTO.LineDTO;
import com.example.my_java_project.Models.Line;

public class LineConverter {
    public  LineDTO toDtO(Line line) {
    LineDTO lineDTO= new LineDTO();
    lineDTO.setDestination(line.getDestination());
    lineDTO.setId(line.getId());
    lineDTO.setNumber(line.getNumber());
    lineDTO.setSourse(line.getSourse());
    return lineDTO;
  }
  public  Line toModel(LineDTO line) {
    Line lineModel= new Line();
    lineModel.setDestination(line.getDestination());
    lineModel.setId(line.getId());
    lineModel.setNumber(line.getNumber());
    lineModel.setSourse(line.getSourse());
    return lineModel;
  }
  public  List<Line> toListModel(List<LineDTO> linesDTo) {
    return linesDTo.stream().map(line -> toModel(line)).collect(Collectors.toList());
  }
  public  List<LineDTO> toListDTO(List<Line> lines) {
    return lines.stream().map(line -> toDtO(line)).collect(Collectors.toList());
  }  
}
