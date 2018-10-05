import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Car implements Serializable {
    private long id = UUID.randomUUID().getLeastSignificantBits()*-1;
    private Date yearCreation;
    private String brand;
    private String model;
    private boolean transIsMechanic;

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", yearCreation=" + yearCreation +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", transIsMechanic=" + transIsMechanic +
                '}';
    }

//    public static long LastCarId (){
//        ArrayList<Car> cars = new ArrayList<>();
//        cars = FileManager.readFromFile("fileCars.txt");
//        long max = 0;
//        for (Car car : cars) {
//            if (car.getId() > max){
//                max = car.getId();
//            }
//        }
//
//        return max;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getId() == car.getId() &&
                isTransIsMechanic() == car.isTransIsMechanic() &&
                Objects.equals(getYearCreation(), car.getYearCreation()) &&
                Objects.equals(getBrand(), car.getBrand()) &&
                Objects.equals(getModel(), car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getYearCreation(), getBrand(), getModel(), isTransIsMechanic());
    }

    public Car(Date yearCreation, String brand, String model, boolean transIsMechanic) {
        this.yearCreation = yearCreation;
        this.brand = brand;
        this.model = model;
        this.transIsMechanic = transIsMechanic;
    }

    public void setYearCreation(Date yearCreation) {
        this.yearCreation = yearCreation;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setTransIsMechanic(boolean transIsMechanic) {
        this.transIsMechanic = transIsMechanic;
    }

    public long getId() {
        return id;
    }

    public Date getYearCreation() {
        return yearCreation;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public boolean isTransIsMechanic() {
        return transIsMechanic;
    }
}
