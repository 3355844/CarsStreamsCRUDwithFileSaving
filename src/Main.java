import java.util.Date;

public class Main {

    private static final String FILE_PATH = "fileCars.txt";

    public static void main(String[] args) {

        while (true){
         CarsMenu.mainMenu();
         CarsMenu.routeCar(FILE_PATH);
        }
    }
}
