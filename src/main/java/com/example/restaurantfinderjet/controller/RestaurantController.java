package com.example.restaurantfinderjet.controller;

import com.example.restaurantfinderjet.model.Restaurant;
import com.example.restaurantfinderjet.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@CrossOrigin(origins = "*") // For development - restrict in production
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getRestaurantsByPostcode(@RequestParam String postcode) {
        return restaurantService.findRestaurantsByPostcode(postcode);
    }
}