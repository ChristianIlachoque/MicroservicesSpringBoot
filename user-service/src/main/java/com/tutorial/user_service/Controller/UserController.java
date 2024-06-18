package com.tutorial.user_service.Controller;

import com.tutorial.user_service.Entity.User;
import com.tutorial.user_service.Model.Bike;
import com.tutorial.user_service.Model.Car;
import com.tutorial.user_service.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = userService.getALl();
        if(users.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){
        User user = userService.getUserById(id);
        if(user == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User newUser = userService.save(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);
        if(user == null) return ResponseEntity.notFound().build();
        List<Car> cars = userService.getCars(userId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/bikes/{userId}")
    public ResponseEntity<List<Bike>> getBikes(@PathVariable("userId") int userId){
        User user = userService.getUserById(userId);
        if(user == null) return ResponseEntity.notFound().build();
        List<Bike> bikes = userService.getBikes(userId);
        return ResponseEntity.ok(bikes);
    }
}
