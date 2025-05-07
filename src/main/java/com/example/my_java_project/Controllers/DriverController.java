package com.example.my_java_project.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.my_java_project.DTO.DriverDTO;
import com.example.my_java_project.Models.Driver;
import com.example.my_java_project.Services.DriverServices;
@RestController
public class DriverController {
    @Autowired
    public DriverServices driverServices;
    @PostMapping("/add")
public ResponseEntity<Driver> addDriver(@RequestBody DriverDTO driver) {
    Optional<Driver> driver2= driverServices.addDriver(driver);
    if(driver2.isPresent())
        return ResponseEntity.ok().body(driver2.get());
    return ResponseEntity.badRequest().build();
}
}
