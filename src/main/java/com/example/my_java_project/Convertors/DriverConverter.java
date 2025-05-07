package com.example.my_java_project.Convertors;

import java.util.List;
import java.util.stream.Collectors;

import com.example.my_java_project.DTO.DriverDTO;
import com.example.my_java_project.Models.Driver;

public class DriverConverter {
    public  DriverDTO toDtO(Driver driver) {
    DriverDTO driverDTO= new DriverDTO();
    driverDTO.setId(driver.getId());
    driverDTO.setName(driver.getName());
    driverDTO.setPone(driver.getPone());
    return driverDTO;
  }
  public  Driver toModel(DriverDTO driver) {
    Driver driverModel= new Driver();
    driverModel.setId(driver.getId());
    driverModel.setName(driver.getName());
    driverModel.setPone(driver.getPone());
    return driverModel;
  }
  public  List<Driver> toListModel(List<DriverDTO> driversDTo) {
    return driversDTo.stream().map(driver -> toModel(driver)).collect(Collectors.toList());
  }
  public  List<DriverDTO> toListDTO(List<Driver> drivers) {
    return drivers.stream().map(driver -> toDtO(driver)).collect(Collectors.toList());
  }

}
