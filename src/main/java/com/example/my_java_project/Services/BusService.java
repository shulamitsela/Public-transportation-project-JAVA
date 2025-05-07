package com.example.my_java_project.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.my_java_project.Convertors.BusConverter;
import com.example.my_java_project.DTO.BusDTO;
import com.example.my_java_project.Models.Bus;
import com.example.my_java_project.Rpositories.BusRpository;
@Service
public class BusService {
    @Autowired
    public BusRpository busRpository;
    @Autowired
    public BusConverter busConverter;
    
    public Optional<Bus> addBus(BusDTO bus){
        try{
           Bus bus2= busRpository.save(busConverter.toModel(bus));
            return  Optional.of(bus2); 
        }
        catch(Exception e){
            return Optional.empty();
        }
    }
     public Optional<List<BusDTO>> getBySeats(int seats){
        Bus busEx= new Bus();
        busEx.setSeats(seats);
        List<Bus> buss=busRpository.findAll(Example.of(busEx));
        if(buss.size()>0)
            return Optional.of(busConverter.toListDTO(buss));
        return Optional.empty();
     }

}
