package OOP.L01_WorkingWithAbstraction.demo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Role role = Role.ADMIN;

        System.out.println(role.isAccessAllowed());

        User user = new User("Ivan", role);




        System.out.println();

    }
}
