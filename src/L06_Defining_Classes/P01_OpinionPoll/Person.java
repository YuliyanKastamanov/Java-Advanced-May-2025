package L06_Defining_Classes.P01_OpinionPoll;

//описвам как ще ми изглежда всеки един човек
public class Person {
    //полета -> характеристики
    private String name;
    private int age;

    //конструктор -> специален метод, който използваме за създаване на обекти от класа

    //1. вграден конструктор / конструктор по подразбиране -> празен обект от класа
    public Person() {
        //нов празен обект от класа
        //name: null
        //age: 0
    }

    //2. конструктор, който сме създали ние
    public Person(String name, int age) {
        //нов празен обект от класа
        //name: null
        //age: 0
        this.name = name;
        this.age = age;
    }

    //методи -> описваме действията, които ще може да прави всеки обект

    //getters -> методи, които ни дават стойността в полетата
    //menu Generate -> Alt + Insert (Windows), Control + Enter (Mac)
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    //setters -> методи, които ни дават възможност да задаваме стойност на поле
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
       this.age = age;
    }
}
