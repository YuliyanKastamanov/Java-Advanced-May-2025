package OOP.L04_InterfacesAndAbstraction.demo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Payable payable = new CardPayment();

        List<String> list = new ArrayList<>();



        Pizza margaritha = new Margaritha();

        System.out.println(margaritha.getIngredients());

    }
}
