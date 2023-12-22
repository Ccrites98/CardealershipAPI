package com.pluralsight.dealership;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcCarDAO implements CarDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCarDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Car> getAllCars() {
        String sql = "SELECT * FROM Cars";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Car.class));
    }

    @Override
    public Car getCarById(Long id) {
        String sql = "SELECT * FROM Cars WHERE Id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Car.class));
    }

    @Override
    public List<Car> getCarsByModel(String model) {
        String sql = "SELECT * FROM Cars WHERE Model = ?";
        return jdbcTemplate.query(sql, new Object[]{model}, new BeanPropertyRowMapper<>(Car.class));
    }

    @Override
    public List<Car> getCarsWithFilters(Double minPrice, Double maxPrice, String make, String model, Integer minYear, Integer maxYear, String color, Integer minMiles, Integer maxMiles, String type) {
        return null;
    }

    @Override
    public List<Car> getCarsByColor(String color) {
        String sql = "SELECT * FROM Cars WHERE Color = ?";
        return jdbcTemplate.query(sql, new Object[]{color}, new BeanPropertyRowMapper<>(Car.class));
    }

    @Override
    public List<Car> getCarsByPriceRange(double minPrice, double maxPrice) {
        String sql = "SELECT * FROM Cars WHERE Price >= ? AND Price <= ?";
        return jdbcTemplate.query(sql, new Object[]{minPrice, maxPrice}, new BeanPropertyRowMapper<>(Car.class));
    }

    @Override
    public List<Car> getCarsByMileageRange(int minMileage, int maxMileage) {
        String sql = "SELECT * FROM Cars WHERE Mileage >= ? AND Mileage <= ?";
        return jdbcTemplate.query(sql, new Object[]{minMileage, maxMileage}, new BeanPropertyRowMapper<>(Car.class));
    }

    @Override
    public List<Car> getCarsByYear(int year) {
        String sql = "SELECT * FROM Cars WHERE Year = ?";
        return jdbcTemplate.query(sql, new Object[]{year}, new BeanPropertyRowMapper<>(Car.class));
    }

    @Override
    public List<Car> getCarsByType(String type) {
        String sql = "SELECT * FROM Cars WHERE Type = ?";
        return jdbcTemplate.query(sql, new Object[]{type}, new BeanPropertyRowMapper<>(Car.class));
    }

    @Override
    public void createCar(Car car) {
        String sql = "INSERT INTO Cars (Make, Model, Price, Mileage, Year, Color, Type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getMake(), car.getModel(), car.getPrice(), car.getMileage(), car.getYear(), car.getColor(), car.getType());
    }

    @Override
    public void updateCar(Car car) {
        String sql = "UPDATE Cars SET Make = ?, Model = ?, Price = ?, Mileage = ?, Year = ?, Color = ?, Type = ? WHERE Id = ?";
        jdbcTemplate.update(sql, car.getMake(), car.getModel(), car.getPrice(), car.getMileage(), car.getYear(), car.getColor(), car.getType(), car.getId());
    }

    @Override
    public void deleteCar(Long id) {
        String sql = "DELETE FROM Cars WHERE Id = ?";
        jdbcTemplate.update(sql, id);
    }