package com.example.my_java_project.Convertors;

import java.util.List;
import java.util.stream.Collectors;

import com.example.my_java_project.DTO.BusDTO;
import com.example.my_java_project.Models.Bus;

public class BusConverter {
  public  BusDTO toDtO(Bus bus) {
    BusDTO busDTO= new BusDTO();
    busDTO.setId(bus.getId());
    busDTO.setLicense_plate(bus.getLicense_plate());
    busDTO.setSeats(bus.getSeats());
    return busDTO;
  }
  public  Bus toModel(BusDTO bus) {
    Bus busModel= new Bus();
    busModel.setId(bus.getId());
    busModel.setLicense_plate(bus.getLicense_plate());
    busModel.setSeats(bus.getSeats());
    return busModel;
  }
  public  List<Bus> toListModel(List<BusDTO> bussDTo) {
    return bussDTo.stream().map(bus -> toModel(bus)).collect(Collectors.toList());
  }
  public  List<BusDTO> toListDTO(List<Bus> buss) {
    return buss.stream().map(bus -> toDtO(bus)).collect(Collectors.toList());
  }

}
