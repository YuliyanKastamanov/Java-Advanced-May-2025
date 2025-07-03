package OOP.L03_Inheritance.P06_Animals;

public class Animal {

    private static final String INVALID_INPUT = "Invalid input!";

    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
       setName(name);
        setAge(age);
        setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        if(name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        this.gender = gender;
    }

    public String produceSound(){
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s%n", this.getClass().getSimpleName()));
        builder.append(String.format("%s %d %s%n", this.name, this.age, this.gender));
        builder.append(this.produceSound());

        return builder.toString();
    }
}
