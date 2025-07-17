package OOP.L06_Solid.solid.calculator;



import OOP.L06_Solid.solid.products.Product;
import java.util.List;

public class CalorieCalculator implements Calculator{

    public double sum(List<Product> products) {
        double sum = 0;

        for (Product product : products) {
            sum += product.getCalories();
        }
        return sum;
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }


}
