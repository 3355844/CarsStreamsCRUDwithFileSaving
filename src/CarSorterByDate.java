import java.util.Comparator;

public class CarSorterByDate implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getYearCreation().compareTo(o2.getYearCreation());
    }
}
