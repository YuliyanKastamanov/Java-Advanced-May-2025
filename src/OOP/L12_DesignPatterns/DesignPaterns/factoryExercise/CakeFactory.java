package com.company.builderPattern.factoryExercise;

public class CakeFactory {

    private final static String CHOCOLATE = "chocolate" ;
    private final static String VEGAN = "vegan" ;
    private final static String RED_VELVET = "red-velvet" ;

    public static Cake createCake(String type){
        Cake cake = null;

        switch (type){
            case CHOCOLATE -> cake = new Cake(30, 50, 16);
            case VEGAN -> cake = new Cake(20, 60, 8);
            case RED_VELVET -> cake = new Cake(30, 70, 16);
        }


        return cake;
    }
}
