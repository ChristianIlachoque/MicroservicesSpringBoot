package com.tutorial.bike_service.Service;

import com.tutorial.bike_service.Entity.Bike;
import com.tutorial.bike_service.Repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {
    @Autowired
    BikeRepository bikeRepository;

    public List<Bike> getAll(){
        return bikeRepository.findAll();
    }

    public Bike getByBikeId(int id){
        return bikeRepository.findById(id).orElse(null);
    }

    public Bike save(Bike bike){
        return bikeRepository.save(bike);
    }

    public List<Bike> findByUserId(int userId){
        return bikeRepository.findByUserId(userId);
    }
}
