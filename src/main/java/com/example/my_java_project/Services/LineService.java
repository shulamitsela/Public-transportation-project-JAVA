package com.example.my_java_project.Services;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.my_java_project.Convertors.LineConverter;
import com.example.my_java_project.Convertors.StationConverter;
import com.example.my_java_project.DTO.LineDTO;
import com.example.my_java_project.DTO.LineTime;
import com.example.my_java_project.DTO.StationDTO;
import com.example.my_java_project.Models.Line;
import com.example.my_java_project.Models.Station;
import com.example.my_java_project.Models.Station_Line;
import com.example.my_java_project.Models.Travel;
import com.example.my_java_project.Rpositories.LineRpository;
import com.example.my_java_project.Rpositories.StationLineRpository;
import com.example.my_java_project.Rpositories.StationRpository;
import com.example.my_java_project.Rpositories.TravelRpository;

@Service
public class LineService {
    @Autowired
    public LineRpository lineRpository;
    @Autowired
    public LineConverter lineConverter;
    @Autowired
    public StationConverter stationConverter;
    @Autowired
    public StationRpository stationRpository;
    @Autowired
    public TravelRpository travelRpository;
    @Autowired
    public StationLineRpository stationLineRpository;

       public Optional<Line> addLine(LineDTO line){
        try{
           Line line2= lineRpository.save(lineConverter.toModel(line));
            return  Optional.of(line2); 
        }
        catch(Exception e){
            return Optional.empty();
        }
    }

    public Optional<List<LineTime>> getTravels(Long lineId){
        List<LineTime> lineTimes=new ArrayList<LineTime>();
        List<Travel> travels= travelRpository.findAll().stream().filter(t->t.getLine_id().getId()==lineId && LocalTime.now().isAfter(t.getDeparture_time().toLocalTime())).toList();
    List<Station_Line> station_Lines=stationLineRpository.findAll().stream().filter(sl->sl.getLine_id()==lineId).toList();
        for (Travel temp : travels) {
        Long min=Duration.between(LocalTime.now(), temp.getDeparture_time().toLocalTime()).toMinutes();
        Optional<Station_Line> stationLine=station_Lines.stream().filter(sl->sl.getStationOrder()==min).findFirst();
            if(stationLine.isPresent())
             {
                LineTime lt=new LineTime();
                lt.LineId=temp.getLine_id().getId();
                lt.StationId=stationLine.get().getStation_id();
                lineTimes.add(lt);
             }
    }
    if(lineTimes.size()>0)
        return Optional.of(lineTimes);
    return Optional.empty();
    }
   public Optional<List<StationDTO>> getStations(Long id){
    Optional<Line> line=lineRpository.findById(id);
    if(line.isPresent()){
        List<Station> stations=new ArrayList<Station>();
        line.get().getTrStation_Lines().stream().sorted((a,b)->a.getStationOrder()-b.getStationOrder()).forEach(sl-> stations.add(stationRpository.findById(sl.getStation_id()).get()) );
        return Optional.of(stationConverter.toListDTO(stations));
    }
    return Optional.empty();      
   } 
   public Optional<Void> addStationInLine(Long id,Long stationId,int Index){
    Station_Line station_Line=new Station_Line();
    station_Line.setLine_id(id);
    station_Line.setStationOrder(Index);
    station_Line.setStation_id(stationId);
    List<Station_Line> station_Lines=lineRpository.findById(id).get().getTrStation_Lines();
    station_Lines.sort((a,b)->a.getStationOrder()-b.getStationOrder());
    for (Station_Line temp : station_Lines) {
        if(temp.getStationOrder()>Index){
            temp.setStationOrder(temp.getStationOrder()+1);
        }
    }
    station_Lines.add(station_Line);
    lineRpository.findById(id).get().setTrStation_Lines(station_Lines);
    return  Optional.empty();  
   }
   public Optional<Void> deleteStationInLine(Long id,Long stationId){
    List<Station_Line> station_Lines=lineRpository.findById(id).get().getTrStation_Lines();
    Station_Line station_Line=station_Lines.stream().filter(sl->sl.getStation_id()==stationId).findFirst().get();
    station_Lines.remove(station_Line);
    for (Station_Line temp : station_Lines) {
        if(temp.getStationOrder()>station_Line.getStationOrder()){
            temp.setStationOrder(temp.getStationOrder()-1);
        }
    }
    lineRpository.findById(id).get().setTrStation_Lines(station_Lines);
    return Optional.empty();   
}
   
}
