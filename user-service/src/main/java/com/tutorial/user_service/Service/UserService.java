package com.tutorial.user_service.Service;

import com.tutorial.user_service.Entity.User;
import com.tutorial.user_service.Model.Car;
import com.tutorial.user_service.Model.Bike;
import com.tutorial.user_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<User> getALl(){
        return userRepository.findAll();
    }

    public User getUserById(int userId){
        return userRepository.findById(userId).orElse(null);
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public List<Car> getCars(int userId){
        List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/byuser/" + userId, List.class);
        return cars;
    }

    public List<Bike> getBikes(int userId){
        List<Bike> bikes = restTemplate.getForObject("http://localhost:8003/bike/byuser/" + userId, List.class);
        return bikes;
    }
}
