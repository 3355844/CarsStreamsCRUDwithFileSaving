import java.util.Date;

public class Main {

    private static final String FILE_PATH = "fileCars.txt";

    public static void main(String[] args) {
        CarDAO.create(FILE_PATH, new Date(), "AUDI", "green", false);
        CarDAO.create(FILE_PATH, new Date(), "AUDI", "black", false);
        CarsMenu.printToConsole(FILE_PATH);
    }
}
