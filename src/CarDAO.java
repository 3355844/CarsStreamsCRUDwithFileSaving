import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class CarDAO {

    public static void create(String filePath, Date yearCreation, String brand, String color, boolean transIsMechanic) {
        ArrayList<Car> cars = FileManager.readFromFile(filePath);
        Car tmpCar = new Car(yearCreation, brand, color, transIsMechanic);
        cars.add(tmpCar);
        FileManager.writeToFile(cars, filePath);
    }

    public static void delete(Car car, String filePath) {
        ArrayList<Car> cars = FileManager.readFromFile(filePath);
        cars.remove(car);
        FileManager.writeToFile(cars, filePath);
    }

    public static void update(int index, Car car, String filePath) {
        ArrayList<Car> cars = FileManager.readFromFile(filePath);
        cars.set(index, car);
        FileManager.writeToFile(cars, filePath);
    }

    public static Car readByIndex(int index, String filePath) {
        ArrayList<Car> cars = FileManager.readFromFile(filePath);
        return cars.get(index);
    }

    public static void sortDate(String filePath){
        ArrayList<Car> cars = FileManager.readFromFile(filePath);
        Collections.sort(cars, new CarSorterByDate());
        FileManager.writeToFile(cars,filePath);
    }

    public static ArrayList<Car> readAll(String filePath) {
        return FileManager.readFromFile(filePath);
    }
}
