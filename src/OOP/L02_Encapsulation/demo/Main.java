package OOP.L02_Encapsulation.demo;

public class Main {
    public static void main(String[] args) {

        String name = "Stoyan";

        Person person = new Person();

        //person.name = name;
        //person.length = 30;
        //person.password = "123456!";

        //public -> можем да достъпваме навсякъде в нашия апликейшън
        //private -> можем да достъпваме в рамките на клас-а
        //protected -> можем да го достъпваме в рамките на пакета или в събкласовете, който сме наследили
        //default (package private) -> можем да го достъпваме само в пакета



    }

    private void printName(String name){
        System.out.println(name);
    }
}
