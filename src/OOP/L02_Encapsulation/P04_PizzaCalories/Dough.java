package OOP.L02_Encapsulation.P04_PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        //•	White – 1.5;
        //•	Wholegrain – 1.0;

        switch (flourType) {
            case "White", "Wholegrain" -> this.flourType = flourType;
            default -> throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {

        //•	Crispy – 0.9;
        //•	Chewy – 1.1;
        //•	Homemade – 1.0;
        switch (bakingTechnique){
            case "Crispy", "Chewy", "Homemade" -> this.bakingTechnique = bakingTechnique;
            default -> throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    private void setWeight(double weight) {
        //•	If dough weight is outside of the range [1..200] throw an exception with the message
        // "Dough weight should be in the range [1..200]."
        if(weight > 0 && weight <= 200){
            this.weight = weight;
        }else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories(){
        //•	White – 1.5;
        //•	Wholegrain – 1.0;
        //намираме коефициентът за типа брашно
        double flourTypeCoefficient = 0;
        switch (flourType){
            case "White" -> flourTypeCoefficient = 1.5;
            case "Wholegrain" -> flourTypeCoefficient = 1.0;
        }

        //•	Crispy – 0.9;
        //•	Chewy – 1.1;
        //•	Homemade – 1.0;
        //намираме коефициентът за техниката на изпичане
        double backingTechnicCoefficient = 0;
        switch (bakingTechnique){
            case "Crispy" -> backingTechnicCoefficient = 0.9;
            case "Chewy" -> backingTechnicCoefficient = 1.1;
            case "Homemade" -> backingTechnicCoefficient = 1.0;
        }

        //100 grams will have (2 * 100) * 1.5 * 1.1 = 330.00 total calories.
        return 2 * weight * backingTechnicCoefficient * flourTypeCoefficient;
    }
}
