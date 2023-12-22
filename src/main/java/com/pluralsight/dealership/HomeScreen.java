package com.pluralsight.dealership;
import org.apache.commons.dbcp2.BasicDataSource;
import java.util.List;
import java.util.Scanner;
public class HomeScreen {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/cardealership";
        String user = "root";
        String password = "password1";
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        CarDao CarDao;
        CarDao = new JdbcCarDAO(dataSource);
        System.out.println("What are you looking for?");
        System.out.println("1. Search by Model");
        System.out.println("2. Search by Color");
        System.out.println("3. Search by Price");
        System.out.println("4. Search by Mileage");
        System.out.println("5. Search by Year");
        System.out.println("6. Search by Type");
        System.out.println("7. Add a Vehicle");
        System.out.println("8. Remove a Vehicle");
        System.out.print("State thy choice: ");
        int choice = keyboard.nextInt();
        keyboard.nextLine();
        switch (choice) {
            case 1:
                searchByModel(CarDao, keyboard);
                System.out.println();
                break;
            case 2:
                searchByColor(CarDao, keyboard);
                System.out.println();
                break;
            case 3:
                searchByPrice(CarDao, keyboard);
                System.out.println();
                break;
            case 4:
                searchByMileage(CarDao, keyboard);
                System.out.println();
                break;
            case 5:
                searchByYear(CarDao, keyboard);
                System.out.println();
                break;
            case 6:
                searchByType(CarDao, keyboard);
                System.out.println();
                break;
            default:
                System.out.println("Thou speak madness. Try again, knave.");
        }
    }

    private static void searchByType(CarDao carDao, Scanner keyboard) {
    }

    private static void searchByYear(CarDao carDao, Scanner keyboard) {

    }

    private static void searchByMileage(CarDao carDao, Scanner keyboard) {

    }

    private static void searchByPrice(CarDao carDao, Scanner keyboard) {
    }

    private static void searchByColor(CarDao carDao, Scanner keyboard) {
    }

    private static void searchByModel(CarDao carDao, Scanner keyboard) {
        System.out.println("State thy model: ");
        String input = keyboard.nextLine();
        List<Car> searchResults = carDao.getCarsByModel(input);
        displaySearchResults(searchResults);
    }

    private static void displaySearchResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println("These be the cars thou seeketh");
    }
}