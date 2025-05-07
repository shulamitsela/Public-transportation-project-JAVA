package com.example.my_java_project.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.my_java_project.Convertors.DriverConverter;
import com.example.my_java_project.DTO.DriverDTO;
import com.example.my_java_project.Models.Driver;
import com.example.my_java_project.Rpositories.DriverRpository;

@Service
public class DriverServices {
    @Autowired
    public DriverRpository driverRpository;
    @Autowired
    public DriverConverter driverConverter;
    public Optional<Driver> addDriver(DriverDTO driver){
        try{
           Driver driver2= driverRpository.save(driverConverter.toModel(driver));
            return  Optional.of(driver2); 
        }
        catch(Exception e){
            return Optional.empty();
        }
    }
}
