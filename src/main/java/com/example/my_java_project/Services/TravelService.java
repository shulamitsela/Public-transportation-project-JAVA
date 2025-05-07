package com.example.my_java_project.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.my_java_project.Convertors.TravelConverter;
import com.example.my_java_project.DTO.TravelDTO;
import com.example.my_java_project.Models.Travel;
import com.example.my_java_project.Rpositories.TravelRpository;
@Service
public class TravelService {
    @Autowired
    public TravelRpository travelRpository;
    @Autowired
    public TravelConverter travelConverter;
    public boolean createTravel(TravelDTO travel){
        try{
            travelRpository.save(travelConverter.toModel(travel));
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    public Optional<TravelDTO> getById(Long id){
        Optional<Travel> travel = travelRpository.findById(id);
        if(travel.isPresent())
            return Optional.of(travelConverter.toDtO(travel.get()));
        return Optional.empty();      

    }
}
