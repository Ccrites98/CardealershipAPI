package com.pluralsight.dealership;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CarDao {

    List<Car> getAllCars();

    Car getCarById(Long id);

    Car createCar(Car car);

    void updateCar(Car car);

    void deleteCar(Long id);

    List<Car> getCarsByModel(String input);

    List<Car> getCarsWithFilters(Double minPrice, Double maxPrice, String make, String model, Integer minYear, Integer maxYear, String color, Integer minMiles, Integer maxMiles, String type);
}