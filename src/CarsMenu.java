import javafx.scene.input.DataFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CarsMenu {

   private static Date date = null;
   private static String brand = null;
   private static String color = null;
   private static String strTransIsMechanic = null;
   private static boolean transIsMechanic;
   private static String strDate = null;
   private static int index ;
   public static boolean theEndProgram = true;

    public static void routeCar(String filePath) {
        String command = readConsoleValue();

        if (command.equalsIgnoreCase("c")) {
            createCar(filePath);
        } else if (command.equalsIgnoreCase("r")) {
//            CarDAO.readAll(filePath);
            CarsMenu.printToConsole(filePath);
        } else if (command.equalsIgnoreCase("u")) {
            updateCar(filePath);
        } else if (command.equalsIgnoreCase("d")) {
            System.out.println("Enter index for delete Car:");
            index = Integer.parseInt(readConsoleValue());
            CarDAO.delete(CarDAO.readByIndex(index, filePath),filePath);
//        } else if (command.equalsIgnoreCase("s")) {
        } else if (command.equalsIgnoreCase("exit")) {
            System.out.println("You exit from program: ");
            theEndProgram = false;
        } else {
            System.out.println("Incorrect command try again : ");
        }
    }

    private static void updateCar(String filePath) {
        System.out.println("Enter index for update Car:");
        index = Integer.parseInt(readConsoleValue());
        Car tmpCar = CarDAO.readByIndex(index,filePath);
        System.out.println("Enter new color:");
        color = readConsoleValue();
        tmpCar.setColor(color);
        CarDAO.update(index,tmpCar,filePath);
    }

    private static void createCar(String filePath) {

        System.out.println("Enter Date in format: dd/MM/yyyy");
        try {
            strDate = readConsoleValue();
            date = new SimpleDateFormat("dd/MM/yyyy").parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Enter brand:");
        brand = readConsoleValue();
        System.out.println("Enter color:");
        color = readConsoleValue();
        System.out.println("Enter 'Y' if transmission is mechanic or 'N' if NOT");
        strTransIsMechanic = readConsoleValue();
        if (strTransIsMechanic.equalsIgnoreCase("y")) {
            transIsMechanic = true;
        } else {
            transIsMechanic = false;
        }
        CarDAO.create(filePath, date, brand, color, transIsMechanic);
    }

    private static void printToConsole(String filePath) {
        int index = 0;
        for (Car car : CarDAO.readAll(filePath)) {
            System.out.println("INDEX for actions: " + index + " " + car.toString());
            index++;
        }
    }

    public static void mainMenu() {
        System.out.println("MENU: \n" +
                "please enter command for action \n" +
                "c - create \n" +
                "r - read \n" +
                "u - update \n" +
                "d - delete \n" +
                "s - sort by id \n" +
                "exit - for finish program");
    }

    private static String readConsoleValue() {
        String value;
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextLine();
        return value;
    }
}