package com.pluralsight.dealership;
import javax.sql.DataSource;
import java.util.List;
public class DataManager {
    private CarDao carDao;
    public DataManager(DataSource dataSource) {
        this.carDao = new JdbcCarDAO(dataSource);
    }
    public List<Car> getVehicleInfo(String model) {
        return carDao.getCarsByModel(model);
    }
    public void insertData(String tableName, String columnNames, String[] values) {
        carDao.createCar(new Car(values[0], values[1], values[2], values[3], values[4], values[5]));
    }
    public void deleteData(String tableName, String columnName, String[] values) {
        carDao.deleteCar(Long.parseLong(values[0]));
    }
}