package com.example.my_java_project.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.my_java_project.DTO.BusDTO;
import com.example.my_java_project.Models.Bus;
import com.example.my_java_project.Services.BusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/Bus")
public class BusController {
    @Autowired
    public BusService busService;
@PostMapping("/add")
public ResponseEntity<Bus> addBus(@RequestBody BusDTO bus) {
    Optional<Bus> bus2= busService.addBus(bus);
    if(bus2.isPresent())
        return ResponseEntity.ok().body(bus2.get());
    return ResponseEntity.badRequest().build();
}

    @GetMapping("/getBySeats/{seats}")
    public ResponseEntity<List<BusDTO>> getBySeats(@PathVariable int seats) {
        Optional<List<BusDTO>>bus =busService.getBySeats(seats);
        if(bus.isPresent())
            return ResponseEntity.ok().body(bus.get()); 
        return ResponseEntity.notFound().build();
    }
    
}
