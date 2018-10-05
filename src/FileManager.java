import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static ArrayList<Car> readFromFile(String filePath) {
        ArrayList<Car> cars = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(new File(filePath));
            ObjectInputStream ois = new ObjectInputStream(fis);
            cars = (ArrayList<Car>) ois.readObject();
            fis.close();
            ois.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            return cars; //if nothing in file...
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cars;
    }

    public static void writeToFile(ArrayList<Car> cars, String filePath) {



        try {
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cars);
            fos.flush();
            oos.flush();
            fos.close();
            oos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
