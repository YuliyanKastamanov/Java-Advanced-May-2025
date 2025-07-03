package OOP.L03_Inheritance.P06_Animals;

public class Frog extends Animal{
    private static final String FROG_SOUND = "Ribbit";
    public Frog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return FROG_SOUND;
    }
}
