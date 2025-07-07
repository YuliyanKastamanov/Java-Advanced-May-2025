package OOP.L04_InterfacesAndAbstraction.P06_MilitaryElite;

public class PrivateImpl extends SoldierImpl implements Private{

    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }


    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %s Salary: %.2f", super.getFirstName(), super.getLastName(), super.getId(), this.getSalary());
    }

    //в случай, че генерираме toString в бащия клас
   /* @Override
    public String toString() {
        return String.format("%s Salary: %.2f",  super.toString(),this.getSalary());
    }*/
}
