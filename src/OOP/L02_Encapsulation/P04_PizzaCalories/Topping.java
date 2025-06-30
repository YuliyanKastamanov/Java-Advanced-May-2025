package OOP.L02_Encapsulation.P04_PizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        //•	Meat – 1.2;
        //•	Veggies – 0.8;
        //•	Cheese – 1.1;
        //•	Sauce  – 0.9;
        switch (toppingType){
            case "Meat", "Veggies", "Cheese", "Sauce" -> this.toppingType = toppingType;
            default -> throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        //•	Meat – 1.2;
        //•	Veggies – 0.8;
        //•	Cheese – 1.1;
        //•	Sauce  – 0.9;
        double toppingCoefficient = 0;
        switch (toppingType){
            case "Meat" -> toppingCoefficient = 1.2;
            case "Veggies" -> toppingCoefficient = 0.8;
            case "Cheese" -> toppingCoefficient = 1.1;
            case "Sauce" -> toppingCoefficient = 0.9;
        }
        return 2 * weight * toppingCoefficient;
    }
}
