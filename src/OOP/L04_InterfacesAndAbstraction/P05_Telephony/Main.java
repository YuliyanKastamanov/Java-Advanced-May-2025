package OOP.L04_InterfacesAndAbstraction.P05_Telephony;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> numbers = new ArrayList<>();
        numbers.add("088A88");
        numbers.add("0888888888");

        List<String> urls = new ArrayList<>();
        urls.add("yuli.com");
        urls.add("abv.bg");
        urls.add("123.bg");


        Smartphone smartphone = new Smartphone(numbers, urls);


        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());

    }
}
