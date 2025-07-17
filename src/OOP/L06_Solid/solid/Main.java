package OOP.L06_Solid.solid;

import OOP.L06_Solid.solid.calculator.Calculator;
import OOP.L06_Solid.solid.calculator.CalorieCalculator;
import OOP.L06_Solid.solid.calculator.QuantityCalculator;
import OOP.L06_Solid.solid.printer.Printer;

public class Main {

    public static void main(String[] args) {


        Calculator calorieCalculator = new CalorieCalculator();
        Calculator quantityCalculator = new QuantityCalculator();

        Printer printer1 = new Printer(calorieCalculator);
        Printer printer2 = new Printer(quantityCalculator);


    }
}
