package L09_Iterators_and_Comparators.P05_ComparingObjects;

public class Person implements Comparable<Person>{

    private String name;
    private Integer age;
    private String town;

    public Person(String name, Integer age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    //начинът, по който се сравняват два обекта от клас Person
    @Override
    public int compareTo(Person person) {

        //Отговор от сравнението:
        // 0 ->  еднакви стойности
        // 1 или по-голямо положително число -> различни стойности
        // -1 или по-малко отрицателно число -> различни стойности

        // 1. Сравнение по име
        int nameComparingResult = this.name.compareTo(person.name);
        // 2. Сравнение по години
        int ageComparingResult = this.age.compareTo(person.age);
        // 2. Сравнение по градове
        int townComparingResult = this.town.compareTo(person.town);

        if(nameComparingResult != 0){
            //ако двете имена са различни връщаме резултатът от сравнението
            return nameComparingResult;
        } else if (ageComparingResult != 0) {
            //ако двете имена са ендакви сравняваме двата обекта по техните години
            // ако годините са различни връщаме резултатът от сравнението
            return ageComparingResult;
        }else {
            //ако имената са еднакви и годините са еднакви
            //връщаме резултатът от сравнението на техните градове
            return townComparingResult;
        }

    }
}
