package OOP.L03_Inheritance.P06_Animals;

public class Kitten extends Cat{
    private static final String GENDER = "Female";
    private static final String KITTEN_SOUND = "Meow";
    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    public Kitten(String name, int age, String gender) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return KITTEN_SOUND;
    }
}
