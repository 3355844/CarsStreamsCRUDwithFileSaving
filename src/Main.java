import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        String filePath = "fileCars.txt";
        ArrayList<Car> cars = FileManager.readFromFile(filePath);


        cars.add(new Car());
        cars.add(new Car(new Date(), "BMW", "X6", false));

        FileManager.writeToFile(cars, filePath);
        ArrayList<Car> carsFromFile = FileManager.readFromFile(filePath);
        for (Car car : carsFromFile) {
            System.out.println(car.toString());
        }

    }
}
