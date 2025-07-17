package Reflection.blackBoxInteger;

import blackBoxInteger.BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Constructor<BlackBoxInt> constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field innerValue = blackBoxInt.getClass().getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        Method[] allMethods = blackBoxInt.getClass().getDeclaredMethods();

        while (!input.equals("END")){
            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);

            Method method = Arrays.stream(allMethods)
                    .filter(m -> m.getName().equals(command))
                    .findFirst().orElse(null);

            method.setAccessible(true);
            method.invoke(blackBoxInt, value);
            System.out.println(innerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }





    }
}
