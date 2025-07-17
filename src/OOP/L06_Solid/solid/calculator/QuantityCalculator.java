package OOP.L06_Solid.solid.calculator;

import OOP.L06_Solid.solid.products.Product;
import OOP.L06_Solid.solid.products.drink.Drink;
import OOP.L06_Solid.solid.products.food.Food;

import java.util.List;

public class QuantityCalculator implements Calculator{
    @Override
    public double sum(List<Product> products) {
        double sum = 0;
        for (Product product : products){
            if(product instanceof Drink){
                sum += ((Drink) product).getLitres();
            } else if (product instanceof Food) {
                sum += ((Food) product).getKilograms();
            }

        }
        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return 0;
    }
}
