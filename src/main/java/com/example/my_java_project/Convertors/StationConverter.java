package com.example.my_java_project.Convertors;

import java.util.List;
import java.util.stream.Collectors;

import com.example.my_java_project.DTO.StationDTO;
import com.example.my_java_project.Models.Station;

public class StationConverter {
    public  StationDTO toDtO(Station station) {
    StationDTO stationDTO= new StationDTO();
    stationDTO.setId(station.getId());
    stationDTO.setName(station.getName());
    return stationDTO;
  }
  public  Station toModel(StationDTO station) {
    Station stationModel= new Station();
    stationModel.setId(station.getId());
    stationModel.setName(station.getName());
    return stationModel;
  }
  public  List<Station> toListModel(List<StationDTO> stationsDTo) {
    return stationsDTo.stream().map(station -> toModel(station)).collect(Collectors.toList());
  }
  public  List<StationDTO> toListDTO(List<Station> stations) {
    return stations.stream().map(station -> toDtO(station)).collect(Collectors.toList());
  }  
}
