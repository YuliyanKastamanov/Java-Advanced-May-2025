package OOP.L03_Inheritance.demo;

public class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        setName(name);
        this.salary = salary;
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public void present(){
        System.out.printf("My name is %s and my salary is %.2f", name, salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
