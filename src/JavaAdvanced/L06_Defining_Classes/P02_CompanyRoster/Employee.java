package JavaAdvanced.L06_Defining_Classes.P02_CompanyRoster;

//описвам как ще изглежда всеки един служител
public class Employee {
    //полета -> характеристики (name, salary, position, department, email, and age)
    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;

    //конструктори -> методи, които изпозлваме за създаване на обекти
    public Employee(String name, double salary, String position, String email, int age) {
        //нов празен обект
        //name = null
        //salary = 0.0
        //position = null
        //email = null
        //age = 0
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = email;
        this.age = age;
    }

    //методи -> действия
    //getters -> методи, чрез които ще достъпваме стойностите на полетата
    //setters -> методи, чрез които задаваме стойност на полетата
    public double getSalary() {
        return this.salary;
    }

    //toString -> връща обекта под формата на текст
    //"{package}.{class}@{address}"
    @Override
    public String toString() {
        //"{name1} {salary1} {email1} {age1}"
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
