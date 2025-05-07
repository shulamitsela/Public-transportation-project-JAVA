package com.example.my_java_project.Rpositories;

 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

import com.example.my_java_project.Models.Station;
    
 @Repository
 public interface StationRpository extends JpaRepository<Station, Long>{
        
}
     

