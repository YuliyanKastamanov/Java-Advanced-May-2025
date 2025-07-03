package OOP.L03_Inheritance.P06_Animals;

public class Cat extends Animal{
    private static final String CAT_SOUND = "Meow meow";
    public Cat(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return CAT_SOUND;
    }
}
