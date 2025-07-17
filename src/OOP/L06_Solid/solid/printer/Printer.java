package OOP.L06_Solid.solid.printer;

import OOP.L06_Solid.solid.calculator.Calculator;
import OOP.L06_Solid.solid.calculator.CalorieCalculator;
import OOP.L06_Solid.solid.products.Product;

import java.util.List;

public class Printer {

    private static final String SUM = "Sum: %f";
    private static final String AVERAGE = "Average: %f";

  /*  private CalorieCalculator calorieCalculator;

    public Printer(CalorieCalculator calorieCalculator) {
        this.calorieCalculator = calorieCalculator;
    }*/

    private Calculator calculator;

    public Printer(Calculator calculator) {
        this.calculator = calculator;
    }

    public void printSum(List<Product> products) {
        System.out.printf((SUM) + "%n", calculator.sum(products));
    }

    public void printAverage(List<Product> products) {
        System.out.printf((AVERAGE) + "%n", calculator.average(products));
    }
}
