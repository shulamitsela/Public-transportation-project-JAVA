package com.example.my_java_project.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.my_java_project.DTO.TravelDTO;
import com.example.my_java_project.Services.TravelService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/Travel")
public class TravelController {
    @Autowired
    public TravelService travelService;

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody TravelDTO entity) {
        if (travelService.createTravel(entity))
            return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/GetById/{id}")
    public ResponseEntity<TravelDTO> getMethodName(@PathVariable Long id) {
    Optional<TravelDTO> travel= travelService.getById(id);
    if(travel.isPresent())
       return ResponseEntity.ok().body(travel.get());
    return ResponseEntity.notFound().build();
    }
    
}
