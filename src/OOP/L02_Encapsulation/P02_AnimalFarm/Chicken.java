package OOP.L02_Encapsulation.P02_AnimalFarm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        //проверяваме дали имаме празен стринг
        if(name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        //проверяваме дали годините отговарят на условието >= 0 && <= 15
        if(age < 0 || age > 15){
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double productPerDay(){
        return  calculateProductPerDay();
    }

    private double calculateProductPerDay() {
        //проверяваме каква е възрастта на пилето и в зависимост от това връщаме колко яйца ще снася
        //•	First 6 years it produces 2 eggs per day [0 - 5].
        //•	Next 6 years it produces 1 egg per day [6 - 11].
        //•	And after that, it produces 0.75 eggs per day.
        if(age <= 5){
            return 2;
        } else if (age <= 11) {
            return 1;
        }else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", name, age, productPerDay());
    }
}
