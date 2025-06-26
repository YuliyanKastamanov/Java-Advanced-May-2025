package JavaAdvanced.L06_Defining_Classes.P02_CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Department> departmentList = new ArrayList<>();

        int countLines = Integer.parseInt(scanner.nextLine());
        for (int line = 1; line <= countLines; line++) {
            String data = scanner.nextLine();
            //1. data = "{name} {salary} {position} {department} {email} {age}"
            //2. data = "{name} {salary} {position} {department} {age}"
            //3. data = "{name} {salary} {position} {department} {email}"
            //4. data = "{name} {salary} {position} {department}"
            String[] dataParts = data.split("\\s+");
            //dataParts = ["{name}", "{salary}", "{position}", "{department}"]
            String name = dataParts[0];
            double salary = Double.parseDouble(dataParts[1]);
            String position = dataParts[2];
            String departmentName = dataParts[3];
            String email = "n/a";
            int age = -1;

            if (dataParts.length == 6) {
                //dataParts = ["{name}", "{salary}", "{position}", "{department}", "{email}", "{age}"]
                email = dataParts[4];
                age = Integer.parseInt(dataParts[5]);
            } else if (dataParts.length == 5) {
                //dataParts = ["{name}", "{salary}", "{position}", "{department}", "{age}"]
                //или
                //dataParts = ["{name}", "{salary}", "{position}", "{department}", "{email}"]
                //проверка дали е въведен имейл или възраст
                if (dataParts[4].contains("@")) {
                    //dataParts = ["{name}", "{salary}", "{position}", "{department}", "{email}"]
                    email = dataParts[4];
                    //няма въведена възраст: age = -1
                } else {
                   //dataParts = ["{name}", "{salary}", "{position}", "{department}", "{age}"]
                    age = Integer.parseInt(dataParts[4]);
                    //нямаме въведен имейл: email = "n/a"
                }
            }

            //знам име, заплата, позиция, имейл, възраст -> създаваме служител
            Employee employee = new Employee(name, salary, position, email, age);

            //намирам отдела в списъка, в който трябва да добавя служителя
            Department department = getDepartmentByName(departmentList, departmentName);
            //добавяме служителя в отдела
            department.getEmployeesList().add(employee);
        }

        //списък с отдели
        //отдел: име и списък със служители
        //трябва да намерим в списъка с отдели, отделът, който е с най-висока средна заплата
        Collections.sort(departmentList, Comparator.comparing(Department::getAverageSalary).reversed());
        Department highestSalaryDepartment = departmentList.get(0);
        System.out.println("Highest Average Salary: " + highestSalaryDepartment.getName());
        //в най-високоплатения отдел трябва да сортираме служители по заплата в намаляващ ред
        Collections.sort(highestSalaryDepartment.getEmployeesList(), Comparator.comparing(Employee::getSalary).reversed());
        for (Employee employee : highestSalaryDepartment.getEmployeesList()) {
            System.out.println(employee.toString());
        }
    }

    private static Department getDepartmentByName(List<Department> departmentList, String departmentName) {
        //намира и връща отдела в списъка с даденото име
        for (Department department : departmentList) {
            if (department.getName().equals(departmentName)) {
                return department;
            }
        }
        //обходя всички отдели -> нямаме отдел с такова име в списъка
        //създаваме отдела, защото го няма
        Department department = new Department(departmentName);
        departmentList.add(department);
        return department;
    }
}
