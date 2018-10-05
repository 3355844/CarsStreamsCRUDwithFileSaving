import java.util.ArrayList;
import java.util.Date;

public class CarDAO {

    public void create(String filePath, Date yearCreation, String brand, String model, boolean transIsMechanic) {
        ArrayList<Car> cars = FileManager.readFromFile(filePath);
        Car tmpCar = new Car(yearCreation, brand, model, transIsMechanic);
        cars.add(tmpCar);
        FileManager.writeToFile(cars, filePath);
    }



}
