package JavaAdvanced.L06_Defining_Classes.P02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

//описвам как ще изглежда всеки един отдел
public class Department {

    //полета -> характеристики
    private String name;
    private List<Employee> employeesList;

    //конструктор
    public Department(String name) {
        //нов празен обект -> отдел
        //name = null
        //employeesList = null
        this.name = name;
        this.employeesList = new ArrayList<>();
    }

    //методи -> действия
    //getters and setters
    public String getName() {
        return this.name;
    }

    public List<Employee> getEmployeesList() {
        return this.employeesList;
    }

    //изчислява средната заплата в отдела
    public double getAverageSalary() {
        double sum = 0;
        for (Employee employee: this.employeesList) {
            sum += employee.getSalary();
        }
        return sum / this.employeesList.size();
    }
}
