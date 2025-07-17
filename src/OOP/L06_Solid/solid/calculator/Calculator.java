package OOP.L06_Solid.solid.calculator;

import OOP.L06_Solid.solid.products.Product;

import java.util.List;

public interface Calculator {

    double sum(List<Product> products);

    double average(List<Product> products);
}
