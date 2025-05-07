package com.example.my_java_project.Rpositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.my_java_project.Models.Bus;
@Repository
public interface BusRpository extends JpaRepository<Bus ,Long>{
    
}
