package OOP.L05_Polymorphism.P02_VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");

        //Create car
        Vehicle car = createVehicle(tokens);

        tokens = scanner.nextLine().split("\\s+");

        //Create truck
        Vehicle truck = createVehicle(tokens);

        tokens = scanner.nextLine().split("\\s+");

        //Create bus
        Vehicle bus = createVehicle(tokens);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);

        int countCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countCommands; i++) {

            tokens = scanner.nextLine().split("\\s+");

            String commandName = tokens[0];
            String vehicleType = tokens[1];

            switch (commandName){

                //Drive Car {distance}
                case "Drive" -> {
                    double distance = Double.parseDouble(tokens[2]);
                    String driveMessage = vehicles.get(vehicleType).drive(distance);//Car as object -> drive()
                    System.out.println(driveMessage);
                }
                //Refuel Car {liters}
                case "Refuel" -> {
                    double fuelAmount = Double.parseDouble(tokens[2]);
                    vehicles.get(vehicleType).refuel(fuelAmount);
                }
                case "DriveEmpty" -> {
                    double distance = Double.parseDouble(tokens[2]);
                    Bus busToDrive = (Bus) vehicles.get(vehicleType);
                    String driveMessage = busToDrive.driveEmpty(distance);//Car as object -> drive()
                    System.out.println(driveMessage);
                }
            }

        }

        vehicles.values().forEach(System.out::println);



    }

    private static Vehicle createVehicle(String[] tokens) {

        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double fuelTankCapacity = Double.parseDouble(tokens[3]);

        Vehicle vehicle = null;
        switch (vehicleType){
            case "Car" -> vehicle = new Car(fuelQuantity, fuelConsumption, fuelTankCapacity);
            case "Truck" -> vehicle = new Truck(fuelQuantity, fuelConsumption, fuelTankCapacity);
            case "Bus" -> vehicle = new Bus(fuelQuantity, fuelConsumption, fuelTankCapacity);
        }

        return vehicle;
    }
}
