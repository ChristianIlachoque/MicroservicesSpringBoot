package com.tutorial.user_service.Model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private String brand;
    private String model;
    private int userId;

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
