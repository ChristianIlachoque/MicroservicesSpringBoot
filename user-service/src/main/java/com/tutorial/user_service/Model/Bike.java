package com.tutorial.user_service.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bike {
    private String brand;
    private String model;
    private int userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
