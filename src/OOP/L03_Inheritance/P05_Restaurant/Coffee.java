package OOP.L03_Inheritance.P05_Restaurant;

import java.math.BigDecimal;

public class Coffee extends HotBeverage{

    public static double COFFEE_MILLILITERS = 50;
    public static BigDecimal COFFEE_PRICE = new BigDecimal(3.50);
    private double caffeine;

    public Coffee(String name, double caffeine) {
        super(name, COFFEE_PRICE, COFFEE_MILLILITERS);
        this.caffeine = caffeine;
    }

    public double getCaffeine() {
        return caffeine;
    }
}
