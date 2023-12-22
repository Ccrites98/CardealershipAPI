package com.pluralsight.dealership;
import java.math.BigDecimal;
public class Car {
    private int id;
    private String model;
    private String color;
    private double price;
    private int mileage;
    private int year;
    private String type;
    public Car() {
    }
    public Car(String value, String value1, String value2, String value3, String value4, String value5) {
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(price);
    }
    public int getMileage() {
        return mileage;
    }
    public int getYear() {
        return year;
    }
    public String getType() {
        return type;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setId(Long generatedId) {
    }
    public Object getId() {
        return null;
    }

    public Object getMake() {
        return null;
    }
}