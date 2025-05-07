package com.example.my_java_project.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.my_java_project.DTO.LineTime;
import com.example.my_java_project.Services.StationService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/Station")
public class StationController {
    public StationService stationService;
    @GetMapping("/getLinesInStation")
    public ResponseEntity<List<LineTime>>  getLinesInStation(@PathVariable char line, @PathVariable Long stationId) {
       Optional<List<LineTime>> taims= stationService.getLinesInStation(line,stationId);
       if(taims.isPresent())
        return ResponseEntity.ok().body(taims.get());
       return ResponseEntity.notFound().build();
    }
    
}
