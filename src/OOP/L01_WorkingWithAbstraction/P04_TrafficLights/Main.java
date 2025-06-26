package OOP.L01_WorkingWithAbstraction.P04_TrafficLights;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //GREEN RED YELLOW
        Lights[] lights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(light -> Lights.valueOf(light))
                .toArray(Lights[]::new);

        int numberOfUpdates = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= numberOfUpdates ; i++) {
            //update the lights
            updateLights(lights);

            //print the lights
            printLights(lights);

        }
        
    }

    private static void updateLights(Lights[] lights) {

        //red -> green -> yellow -> red
        //Lights light -> променливата е копие на реалната стойност в тази структура от данни
        //ако се опитаме да променим копието то тази промяна няма да се отрази в структурата от данни
        /*for (Lights light : lights){
            switch (light){
                case RED -> light = Lights.GREEN;
                case GREEN -> light = Lights.YELLOW;
                case YELLOW -> light = Lights.RED;
            }

        }*/

        for (int index = 0; index < lights.length; index++) {
            switch (lights[index]){
                case RED -> lights[index] = Lights.GREEN;
                case GREEN -> lights[index] = Lights.YELLOW;
                case YELLOW -> lights[index] = Lights.RED;
            }
        }
    }

    private static void printLights(Lights[] lights) {
        Arrays.stream(lights).forEach(light -> System.out.print(light + " "));
        System.out.println();

    }
}
