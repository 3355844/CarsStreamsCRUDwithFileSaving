import java.util.ArrayList;
import java.util.Date;

public class CarDAO {

    public void create(String filePath, Date yearCreation, String brand, String model, boolean transIsMechanic) {
        ArrayList<Car> cars = FileManager.readFromFile(filePath);
        Car tmpCar = new Car(yearCreation, brand, model, transIsMechanic);
        cars.add(tmpCar);
        FileManager.writeToFile(cars, filePath);
    }

    public void delete(Car car, String filePath) {
        ArrayList<Car> cars = FileManager.readFromFile(filePath);
        cars.remove(car);
        FileManager.writeToFile(cars, filePath);
    }

    public void update(int index, Car car, String filePath) {
        ArrayList<Car> cars = FileManager.readFromFile(filePath);
        cars.set(index, car);
        FileManager.writeToFile(cars, filePath);
    }

    public Car readByIndex(int index, String filePath) {
        ArrayList<Car> cars = FileManager.readFromFile(filePath);
        return cars.get(index);
    }

    public ArrayList<Car> readAll(String filePath) {
        return FileManager.readFromFile(filePath);
    }
}
