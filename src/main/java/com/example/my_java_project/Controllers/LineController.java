package com.example.my_java_project.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.my_java_project.DTO.LineDTO;
import com.example.my_java_project.DTO.LineTime;
import com.example.my_java_project.DTO.StationDTO;
import com.example.my_java_project.Models.Line;
import com.example.my_java_project.Services.LineService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/Line")
public class LineController {
    public LineService lineService;

@PostMapping("/add")
public ResponseEntity<Line> addLine(@RequestBody LineDTO line) {
    Optional<Line> line2= lineService.addLine(line);
    if(line2.isPresent())
        return ResponseEntity.ok().body(line2.get());
    return ResponseEntity.badRequest().build();
}
@GetMapping("/getStations/{id}")
public ResponseEntity<List<StationDTO>> getStations(@RequestParam Long id) {
    Optional<List<StationDTO>> stations= lineService.getStations(id);
    if(stations.isPresent())
        return ResponseEntity.ok().body(stations.get());
    return ResponseEntity.notFound().build();
}
@GetMapping("/getTravels/{lineId}")
public ResponseEntity<List<LineTime>> getTravels(@PathVariable Long lineId) {
    Optional<List<LineTime>> lines=lineService.getTravels(lineId);
    if(lines.isPresent())
        return ResponseEntity.ok().body(lines.get());
        return ResponseEntity.notFound().build();
}

@PutMapping("addStatiion/{id}/{stationId}/{index}")
public ResponseEntity<Void> addStation(@PathVariable Long id,@PathVariable Long stationId,@PathVariable int index) {
    Optional<Void> line=lineService.addStationInLine(id,stationId,index);
    if(line.isPresent())
      return ResponseEntity.ok().build();
    return ResponseEntity.notFound().build();
    
}
@PutMapping("deleteStatiion/{id}/{stationId}")
public ResponseEntity<Void> deleteStation(@PathVariable Long id,@PathVariable Long stationId) {
    Optional<Void> line=lineService.deleteStationInLine(id,stationId);
    if(line.isPresent())
      return ResponseEntity.ok().build();
    return ResponseEntity.notFound().build();  
}

 
}
