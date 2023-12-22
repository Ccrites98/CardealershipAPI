package com.pluralsight.dealership;
import com.pluralsight.dealership.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/cars")
public class CarController {

    @Autowired
    private CarDao carDao;

    @GetMapping
    public List<Car> getCars(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) String make,
            @RequestParam(required = false) String model,
            @RequestParam(required = false) Integer minYear,
            @RequestParam(required = false) Integer maxYear,
            @RequestParam(required = false) String color,
            @RequestParam(required = false) Integer minMiles,
            @RequestParam(required = false) Integer maxMiles,
            @RequestParam(required = false) String type
    ) {

        return carDao.getCarsWithFilters(minPrice, maxPrice, make, model, minYear, maxYear, color, minMiles, maxMiles, type);
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carDao.createCar(car);
    }

    @PutMapping("/{id}")
    public void updateCar(@PathVariable Long id, @RequestBody Car car) {

        car.setId(id);
        carDao.updateCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carDao.deleteCar(id);
    }
}