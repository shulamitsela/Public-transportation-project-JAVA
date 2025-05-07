package com.example.my_java_project.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.my_java_project.DTO.LineTime;
import com.example.my_java_project.Models.Station_Line;
import com.example.my_java_project.Models.Travel;
import com.example.my_java_project.Rpositories.StationLineRpository;
import com.example.my_java_project.Rpositories.TravelRpository;

@Service
public class StationService {
    public StationLineRpository stationLineRpository;
    public TravelRpository travelRpository;

    public Optional<List<LineTime>> getLinesInStation(char line, Long stationId){
    List<LineTime> times= new ArrayList<LineTime>(); 
    Station_Line sl=new Station_Line();
    sl.setLine_id(stationId); 
    if(Character.isDigit(line)){
            sl.setLine_id(Long.parseLong(line+""));
    }
    List<Station_Line> linse= stationLineRpository.findAll(Example.of(sl));
    for (Station_Line station_Line : linse) {
        List<Travel> travels=travelRpository.findAll().stream().filter(t->t.getLine_id().getId()==station_Line.getLine_id()).toList();
        for (Travel temp : travels) {
            LineTime lt=new LineTime();
            lt.LineId=station_Line.getLine_id();
            lt.StationId=station_Line.getStation_id();
            lt.ArraiveTime= temp.getDeparture_time().toLocalTime().plusMinutes(station_Line.getStationOrder());
            times.add(lt);
        }
    }
    if(times.size()>0)
    return Optional.of(times);
    return Optional.empty();
    }
}
