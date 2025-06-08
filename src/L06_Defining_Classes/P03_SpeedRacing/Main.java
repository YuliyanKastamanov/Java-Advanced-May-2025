package speedRacing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCars = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>(); //гараж

        for (int count = 1; count <= countCars; count++) {
            String data = scanner.nextLine();
            //data = "{Model} {FuelAmount} {FuelCostFor1km}"
            String[] dataParts = data.split("\\s+");
            //dataParts = ["{Model}", "{FuelAmount}", "{FuelCostFor1km}"]
            String model = dataParts[0];
            double fuel = Double.parseDouble(dataParts[1]);
            double costPerKm = Double.parseDouble(dataParts[2]);

            Car car = new Car(model, fuel, costPerKm);
            cars.add(car);
        }

        //имаме списък с всички въведени коли

        String command = scanner.nextLine();
        while (!command.equals("End")) {
            //command = "Drive BMW-M2 56".split() -> ["Drive", "BMW-M2", "56"]
            String modelToDrive = command.split(" ")[1];
            int kmToDrive = Integer.parseInt(command.split(" ")[2]);

            //намеря колата от списъка, която трябва да карам
            Car carToDrive = getCarByModel(cars, modelToDrive);
            //карам колата определения брой км
            carToDrive.drive(kmToDrive);

            //преминаваме към следващата команда
            command = scanner.nextLine();
        }

        //отпечатваме информация за всички коли в списъка
        for (Car car : cars) {
            //автоматично се извиква метода toString
            System.out.println(car);
        }
    }

    //връща колата от списъка, която е с дадения модел
    private static Car getCarByModel(List<Car> cars, String modelToDrive) {
        for (Car car : cars ) {
            if (car.getModel().equals(modelToDrive)) {
                return car;
            }
        }
        //преминала през всички коли в списъка и не намирам тази, която трябва да карам
        return null;
    }
}
