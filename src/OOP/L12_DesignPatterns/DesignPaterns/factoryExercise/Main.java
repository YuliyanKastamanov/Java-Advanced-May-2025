package com.company.builderPattern.factoryExercise;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();
        //chocolate, vegan, red-velvet

        Cake chocolateCake = CakeFactory.createCake("chocolate");
        Cake veganCake = CakeFactory.createCake("vegan");
        Cake redVelvetCake = CakeFactory.createCake("red-velvet");



    }
}
