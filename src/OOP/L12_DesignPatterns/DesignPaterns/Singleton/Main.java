
public class Main {
    public static void main(String[] args) {


        //Creational design pattern -> помагат ни за създаване на обекти
        //Structural design pattern -> помагат за структуриране на нашето приложение
        //Behavioral Design Patterns -> по какъв начин ще си взаимодействат нашите обекти, класове и тн.

        //Singleton = един клас може да има само една инстанция
        //private Constructor
        //static method getInstance()

        Database mySql = Database.getInstance("Mysql");
        System.out.println(mySql);
        Database mongo = Database.getInstance("Mongo");
        System.out.println(mongo);
        Database mariaDB = Database.getInstance("MariaDb");
        System.out.println(mariaDB);





    }
}


