public class CarsMenu {

    public static void printToConsole(String filePath) {
        int index = 0;
        for (Car car : CarDAO.readAll(filePath)) {
            System.out.println("INDEX for actions: " + index + " " + car.toString());
            index++;
        }
    }
}
