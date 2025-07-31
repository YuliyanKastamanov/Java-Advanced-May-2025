public class Database {

    //MySql, MariaDB
    private String type;
    private static Database instance = null;


    private Database(){}

    private Database(String type) {
        this.type = type;
    }

    public static Database getInstance(String type){

        //Съществува ли вече такава инстанция(база от данни)
        if(instance != null){
            return instance;
        }

        //instance == null
        instance = new Database(type);
        return instance;
    }

    @Override
    public String toString() {
        return "Database{" +
                "type='" + type + '\'' +
                '}';
    }
}
