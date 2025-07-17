package OOP.L06_Solid.solid.products.food;

public class Cloud implements Food{
    @Override
    public double getCalories() {
        throw new UnsupportedOperationException("Clouds can't be eaten!");
    }

    @Override
    public double getKilograms() {
        return 10000000;
    }
}
