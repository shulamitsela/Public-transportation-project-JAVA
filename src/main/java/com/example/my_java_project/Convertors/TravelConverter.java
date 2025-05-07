package com.example.my_java_project.Convertors;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.my_java_project.DTO.TravelDTO;
import com.example.my_java_project.Models.Travel;

public class TravelConverter {
@Autowired
public BusConverter busConverter;
@Autowired
public DriverConverter driverConverter;
@Autowired
public LineConverter lineConverter;

    public TravelDTO toDtO(Travel travel) {
    TravelDTO travelDTO= new TravelDTO();
    travelDTO.setBus( busConverter.toDtO(travel.getBus_id()));
    travelDTO.setDriver( driverConverter.toDtO(travel.getDriver_id()));
    travelDTO.setLine( lineConverter.toDtO(travel.getLine_id()));
    travelDTO.setDeparture(travel.getDeparture_time());
    travelDTO.setId(travel.getId());   
    return travelDTO;
  }
  public  Travel toModel(TravelDTO travel) {
    Travel travelModel= new Travel();
    travelModel.setBus_id( busConverter.toModel(travel.getBus()));
    travelModel.setDriver_id( driverConverter.toModel(travel.getDriver()));
    travelModel.setLine_id( lineConverter.toModel(travel.getLine()));
    travelModel.setDeparture_time(travel.getDeparture());
    travelModel.setId(travel.getId());   
    return travelModel;
  }
  public  List<Travel> toListModel(List<TravelDTO> travelsDTo) {
    return travelsDTo.stream().map(travel -> toModel(travel)).collect(Collectors.toList());
  }
  public  List<TravelDTO> toListDTO(List<Travel> travels) {
    return travels.stream().map(travel -> toDtO(travel)).collect(Collectors.toList());
  }  
}
