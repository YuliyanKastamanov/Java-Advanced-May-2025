import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class DatabaseExtendedUnitTest {

    //1. ще тествам add(Person person) -> когато подадем null
    @Test
    public void whenTryToAdNullValue_thenExceptionIsThrown() throws OperationNotSupportedException {

        Person stoyan = new Person(1, "Stoyan");
        Person ivan = new Person(2, "Ivan");

        Person[] people = {stoyan, ivan};
        Database database = new Database(people);

        //очаквам, ако добавя null да получа exception
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.add(null);
        });
    }

    //2. Ако подам човек, който не е null -> очаквам човекът да бъде успешно добавен
    @Test
    public void whenAddPersonToDatabase_thenPersonIsAddedSuccessfullyAndCountIsIncrementedByOne() throws OperationNotSupportedException {


        Person stoyan = new Person(1, "Stoyan");
        Person ivan = new Person(2, "Ivan");

        Person[] people = {stoyan, ivan};
        Database database = new Database(people);
        int initialPeopleCount = database.getElements().length; // 2

        Person pesho = new Person(3, "Pesho");
        database.add(pesho);

        //броя хора ще се увеличи
        int newPeopleCount = database.getElements().length; // 3

        // намирам кой е последния човек в базата данни -> pesho
        Person lastAddedPerson = database.getElements()[newPeopleCount - 1];

        //1. сравнявам дали последния добавен човек е Пешо
        Assertions.assertEquals(lastAddedPerson, pesho);

        //2. сравнявам дали броят на хората се е увеличил с 1
        Assertions.assertEquals(newPeopleCount, initialPeopleCount + 1);


    }


    @Test
    public void whenTryToRemovePeopleFromEmptyDatabase_thenExceptionIsThrown() throws OperationNotSupportedException {

        Person stoyan = new Person(1, "Stoyan");

        Person[] people = {stoyan};
        Database database = new Database(people);
        database.remove();

        Assertions.assertThrows(OperationNotSupportedException.class, database::remove);

    }

    @Test
    public void whenTryToRemovePersonFromDatabase_thenPeopleCountDecrementedByOne() throws OperationNotSupportedException {
        Person stoyan = new Person(1, "Stoyan");
        Person ivan = new Person(2, "Ivan");

        Person[] people = {stoyan, ivan};
        Database database = new Database(people);

        int initialCount = database.getElements().length;
        database.remove();
        int newPeopleCount = database.getElements().length;

        Assertions.assertEquals(newPeopleCount, initialCount - 1);

    }

    @Test
    public void whenTryToFindPersonByUsernameNull_thenExceptionIsThrown() throws OperationNotSupportedException {
        Person stoyan = new Person(1, "Stoyan");
        Person ivan = new Person(2, "Ivan");

        Person[] people = {stoyan, ivan};
        Database database = new Database(people);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.findByUsername(null);
        });

    }


    @Test
    public void whenTryToFindPersonByUnknownUsername_thenExceptionIsThrown() throws OperationNotSupportedException {
        Person stoyan = new Person(1, "Stoyan");
        Person ivan = new Person(2, "Ivan");

        Person[] people = {stoyan, ivan};
        Database database = new Database(people);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.findByUsername("Gosho");
        });

    }

    @Test
    public void whenTryToFindExistingUserByUsername_thenThePersonIsReturned() throws OperationNotSupportedException {

        Person stoyan = new Person(1, "Stoyan");
        Person ivan = new Person(2, "Ivan");

        Person[] people = {stoyan, ivan};
        Database database = new Database(people);

        Person findedPerson = database.findByUsername("Stoyan");

        Assertions.assertEquals(findedPerson.getId(), 1);
        Assertions.assertEquals(findedPerson.getUsername(), "Stoyan");
        Assertions.assertEquals(findedPerson, stoyan);

    }

    @Test
    public void whenTryToFindExistingUserById_thenThePersonIsReturned() throws OperationNotSupportedException {

        Person stoyan = new Person(1, "Stoyan");
        Person ivan = new Person(2, "Ivan");

        Person[] people = {stoyan, ivan};
        Database database = new Database(people);

        Person findedPerson = database.findById(2);

        Assertions.assertEquals(findedPerson.getId(), 2);
        Assertions.assertEquals(findedPerson.getUsername(), "Ivan");
        Assertions.assertEquals(findedPerson, ivan);

    }

    @Test
    public void whenSearchPersonByUnknownId_thenExceptionIsThrown() throws OperationNotSupportedException {

        Person stoyan = new Person(1, "Stoyan");
        Person ivan = new Person(2, "Ivan");

        Person[] people = {stoyan, ivan};
        Database database = new Database(people);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.findById(3);
        });
    }

    @Test
    public void whenCreateDatabaseWithMoreThanSixteenElements_thenExceptionIsThrown(){
        //създаваме масив с повече от 16 човека
        Person[] people = new Person[17];

        //Очаквам да получа exception когато се опитам да създам базата данни
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {

            Database database = new Database(people);
        });



    }












}
