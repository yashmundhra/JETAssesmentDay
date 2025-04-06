package com.example.restaurantfinderjet.service;

import com.example.restaurantfinderjet.model.Restaurant;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${restaurant.api.url}")
    private String restaurantApiUrl;

    public RestaurantService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
    }

    public List<Restaurant> findRestaurantsByPostcode(String postcode) {
        // Call the external restaurant API
        String url = restaurantApiUrl + postcode;
        String response = restTemplate.getForObject(url, String.class);

        List<Restaurant> filteredRestaurants = new ArrayList<>();

        try {
            // Parse the JSON response
            JsonNode rootNode = objectMapper.readTree(response);

            // Extract restaurant data - adjust this based on the actual API response structure
            JsonNode restaurantsNode = rootNode.path("restaurants");

            if (restaurantsNode.isArray()) {
                for (int i = 0; i < Integer.min(10, restaurantsNode.size()); i++) {
                    JsonNode restaurantNode = restaurantsNode.get(i);
                    // Extract only the fields we need
                    String name = restaurantNode.path("name").asText("Unknown");

                    List<String> cuisines = new ArrayList<>();
                    JsonNode cuisinesNode = restaurantNode.path("cuisines");
                    if (cuisinesNode.isArray()) {
                        for (JsonNode cuisine : cuisinesNode) {
                            cuisines.add(cuisine.path("name").asText("Unknown"));
                        }
                    }

                    double rating = restaurantNode.path("rating").path("starRating").asDouble(0.0);
                    String address = restaurantNode.path("address").path("firstLine").asText() + ", " + restaurantNode.path("address").path("postalCode").asText() + ", " + restaurantNode.path("address").path("city").asText();

                    // Create a new Restaurant object with only the required fields
                    Restaurant restaurant = new Restaurant(name, cuisines, rating, address);
                    filteredRestaurants.add(restaurant);
                }
            }
        } catch (Exception e) {
            // Log the error and return an empty list
            e.printStackTrace();
        }

        return filteredRestaurants;
    }
}