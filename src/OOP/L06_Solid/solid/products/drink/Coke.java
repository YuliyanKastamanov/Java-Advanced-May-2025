package OOP.L06_Solid.solid.products.drink;

public class Coke implements Drink{

    public static final double CALORIES_PER_100_GRAMS = 44.0;
    public static final double DENSITY = 0.6;

    private double milliliters;

    public Coke(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getMilliliters() {
        return milliliters;
    }

    @Override
    public double getCalories() {

        double grams = getMilliliters() * DENSITY;
        return CALORIES_PER_100_GRAMS / 100 * grams;
    }

    @Override
    public double getLitres() {
        return milliliters / 1000;
    }
}
