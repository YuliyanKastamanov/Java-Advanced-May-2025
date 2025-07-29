import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ChainblockUnitTest {
    private Chainblock database;//база от данни с транзакции
    private Transaction transaction1;// транзакция1, с която работим в тестовете
    private Transaction transaction2;// транзакция2, с която работим в тестовете

    @BeforeEach
    public void setUp(){
        //преди всеки тест се създава празна база данни и две транзакции
        this.database = new ChainblockImpl();
        this.transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Yuli", "Stoyan", 100.00);
        this.transaction2 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Ivan", "Pesho", 300.00);
    }

    //void add(Transaction transaction)
    @Test
    public void whenAddMultipleTransactions_thenStoreUniqueTransactions(){
        //Transaction transaction3 = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Ivan", "Pesho", 300.00);

        Assertions.assertEquals(0 , database.getCount());
        database.add(transaction1);
        database.add(transaction2);
        //database.add(transaction3);
        Assertions.assertEquals(2 , database.getCount());

    }

    //void changeTransactionStatus(int id, TransactionStatus newStatus)
    //1. Когато се опитам да променя статуса на съществуваща транзакция -> статуса се променя


    @Test
    public void whenTransactionExist_thenChangeStatus(){
        database.add(transaction1);
        database.changeTransactionStatus(1, TransactionStatus.FAILED);
        Assertions.assertEquals(TransactionStatus.FAILED, transaction1.getStatus());
    }

    //2. Когато се опитам да променя статуса на несъществуваща транзакция -> throw IllegalArgumentException
    @Test
    public void whenTransactionNotExist_thenExceptionIsThrown(){
        database.add(transaction1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.changeTransactionStatus(99, TransactionStatus.ABORTED);
        });
    }

    //boolean contains(Transaction transaction) -> true ако имаме такава транзакция, false ако нямаме такава транзакция
    //boolean contains(int id) -> true ако имаме такава транзакция, false ако нямаме такава транзакция

    @Test
    public void whenTransactionExistByIdOrTransactionObject_thenReturnTrue(){

        database.add(transaction1);
        Assertions.assertTrue(database.contains(1));
        Assertions.assertTrue(database.contains(transaction1));
    }

    @Test
    public void whenTransactionNotExistByIdOrTransactionObject_thenReturnTrue(){

        Transaction transactionToCheck = new TransactionImpl(9,TransactionStatus.SUCCESSFUL, "Niki", "Yuli", 100);
        Assertions.assertFalse(database.contains(9));
        Assertions.assertFalse(database.contains(transactionToCheck));
    }


    //sum >= min && sum <= max
    @Test
    public void whenThereAreTransactionsInTheRange_thenReturnAllTheTransactions(){
        database.add(transaction1);
        database.add(transaction2);
        Iterable<Transaction> result = database.getAllInAmountRange(100, 300);

        List<Transaction> transactionList = new ArrayList<>();
        result.forEach(transactionList::add);

        Assertions.assertEquals(2, transactionList.size());
        Assertions.assertEquals(1, transactionList.get(0).getId());

    }


    @Test
    public void whenThereAreNoTransactionsInTheRange_thenReturnEmptyCollection(){
        database.add(transaction1);
        database.add(transaction2);
        Iterable<Transaction> result = database.getAllInAmountRange(600, 1000);

        List<Transaction> transactionList = new ArrayList<>();
        result.forEach(transactionList::add);

        Assertions.assertEquals(0, transactionList.size());

    }

    //getAllOrderedByAmountDescendingThenById()
    //1. Ако има транзакции -> връщаме подредени по сума в намаляващ ред и по ID
    //2. Aко нямаме транзакции -> IllegalArgumentException IllegalArgumentException

    @Test
    public void whenThereAreMultipleTransactions_thenReturnThemOrderedDescendingByAmount(){
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krasi", "Lyubo", 500.00);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL, "Yuli", "Lyubo", 500.00);
        Transaction transaction5 = new TransactionImpl(5, TransactionStatus.SUCCESSFUL, "Rosi", "Dani", 1000.00);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        database.add(transaction4);
        database.add(transaction5);

        Iterable<Transaction> result = database.getAllOrderedByAmountDescendingThenById();
        List<Transaction> transactionList = new ArrayList<>();
        result.forEach(transactionList::add);

        Assertions.assertEquals(5, transactionList.size());

        //1000, 500, 300, 100
        Assertions.assertEquals(5, transactionList.get(0).getId());
        Assertions.assertEquals(3, transactionList.get(1).getId());
        Assertions.assertEquals(4, transactionList.get(2).getId());
        Assertions.assertEquals(2, transactionList.get(3).getId());
        Assertions.assertEquals(1, transactionList.get(4).getId());

    }


    @Test
    public void whenThereAreNoTransactions_thenExceptionIsThrown(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getAllOrderedByAmountDescendingThenById();
        });
    }


    //•	getAllReceiversWithTransactionStatus(status)
    //1. Ако имаме такива транзакции -> връщаме имената на получателите
    //2. Ако нямаме такива транзакции -> IllegalArgumentException

    @Test
    public void whenTransactionsExistGetAllReceiversWithTransactionStatus_thenReturnThem(){
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krasi", "Lyubo", 500.00);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.ABORTED, "Yuli", "Ivan", 1000.00);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        database.add(transaction4);

        Iterable<String> result = database.getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> names = new ArrayList<>();
        result.forEach(names::add);

        //проверяваме дали имаме 3 имена на получатели
        Assertions.assertEquals(3, names.size());
        //1. Stoyan
        //2. Pesho
        //3. Lyubo

        //проверявам подредбата на имената
        String nameLyubo = names.get(0);
        String namePesho = names.get(1);
        String nameStoyan = names.get(2);

        Assertions.assertEquals("Stoyan", nameStoyan);
        Assertions.assertEquals("Pesho", namePesho);
        Assertions.assertEquals("Lyubo", nameLyubo);

    }

    @Test
    public void whenTransactionsNotExistGetAllReceiversWithTransactionStatus_thenExceptionIsThrown(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getAllReceiversWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
        });
    }


    @Test
    public void whenTransactionsExistGetAllSendersWithTransactionStatus_thenReturnThem(){
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krasi", "Lyubo", 500.00);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.ABORTED, "Yuli", "Ivan", 1000.00);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        database.add(transaction4);

        Iterable<String> result = database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> names = new ArrayList<>();
        result.forEach(names::add);

        //проверяваме дали имаме 3 имена на получатели
        Assertions.assertEquals(3, names.size());
        //1. Krasi
        //2. Ivan
        //3. Yuli

        //проверявам подредбата на имената
        String nameKrasi = names.get(0);
        String nameIvan = names.get(1);
        String nameYuli = names.get(2);

        Assertions.assertEquals("Krasi", nameKrasi);
        Assertions.assertEquals("Ivan", nameIvan);
        Assertions.assertEquals("Yuli", nameYuli);

    }

    @Test
    public void whenTransactionsNotExistGetAllSendersWithTransactionStatus_thenExceptionIsThrown(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
        });
    }

    //•	getById(id)
    //1. ако имаме транзакция с такова id -> връщаме транзакция
    //2. ако нямаме транзакция с такова id -> IllegalArgumentException

    @Test
    public void whenTransactionExistById_thenReturnTransaction(){

        database.add(transaction1);

        Transaction result = database.getById(1);

        //Вариант 1
        Assertions.assertEquals(transaction1, result);

        //Вариант 2
        Assertions.assertDoesNotThrow(() -> {
            database.getById(1);
        });

    }

    @Test
    public void whenTransactionDoesNotExistById_thenReturnTransaction(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getById(99);
        });
    }

    //•	removeTransactionById(id)
    //1. Ако имаме транзакция с това Id -> премахваме транзакцията
    //2. Ако нямаме такава транзакция -> IllegalArgumentException

    @Test
    public void whenTryToRemoveExistingTransaction_thenTransactionRemoved(){
        database.add(transaction1);
        //имаме една транзакция
        Assertions.assertEquals(1, database.getCount());
        //Премахваме транзакцията
        database.removeTransactionById(1);
        //Очаквам да имам 0 транзакции
        Assertions.assertEquals(0, database.getCount());

    }

    @Test
    public void whenTryToRemoveNotExistingTransaction_thenExceptionIsThrown(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.removeTransactionById(99);
        });
    }

    //to do

    @Test
    public void whenThereAreTransactionsAndGetBySenderAndMinimumAmountDescending_thenReturnThemOrdered() {
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Yuli", "Yuli", 500.00);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.ABORTED, "Yuli", "Yuli", 1000.00);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        database.add(transaction4);

        Iterable<Transaction> result = database.getBySenderAndMinimumAmountDescending("Yuli", 700.00);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(1, transactions.size());
        Assertions.assertEquals(4, transactions.get(0).getId());
    }

    @Test
    public void whenThereAreNoTransactionsGetBySenderAndMinimumAmountDescending_thenThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getBySenderAndMinimumAmountDescending("Kolio", 30.00);
        });
    }

    // Ако има такива транзакции с такъв изпращач - връща транзакциите подредени
    // Ако няма такива транзакции с такъв изпращач - throws IllegalArgumentException

    @Test
    public void whenTransactionsExistsGetBySenderOrderedByAmountDescending_thenReturnThemOrdered() {

        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krasi", "Yuli", 500.00);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.ABORTED, "Yuli", "Ivo", 1000.00);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        database.add(transaction4);

        Iterable<Transaction> result = database.getBySenderOrderedByAmountDescending("Yuli");
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(2, transactions.size());
        Assertions.assertEquals(4, transactions.get(0).getId());
        Assertions.assertEquals(1, transactions.get(1).getId());
    }

    @Test
    public void whenTransactionsDoesNotExistsWithGivenSender_thenThrowsException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getBySenderOrderedByAmountDescending("Kolio");
        });
    }

    // 1. Ако имам транзакции с този статус и сума по-малка или равна на позволената сума - връщам тези транзакции
    // 2. Ако нямам транзакции с този статус и сума по-малка или равна на позволената сума - връщам празна колекция

    @Test
    public void whenTransactionsExistWithThisStatusAndAmountLessThanMaxAllowed_thenReturnThem() {


        database.add(transaction1);
        database.add(transaction2);

        Iterable<Transaction> result = database.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 200.00);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(1, transactions.size());
        Assertions.assertEquals(1, transactions.get(0).getId());
    }

    @Test
    public void whenTransactionsDoesNotExistWithThisStatusAndAmountLessThanMaxAllowed_thenReturnEmptyCollection() {

        Iterable<Transaction> result = database.getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 30.00);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(0, transactions.size());
    }

    //getByTransactionStatus(status)
    // 1. Ако има такива транзакции с този статус - получавам всичките транзакции
    // 2. Ако няма такива транзакции с този статус - throw IllegalArgumentException

    @Test
    public void whenTransactionExistWithThisStatus_thenReturnThem() {

        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krasi", "Yuli", 500.00);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.ABORTED, "Rosi", "Yuli", 1000.00);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        database.add(transaction4);

        Iterable<Transaction> result = database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        // Проверявам дали точно 3 на брой транзакции съм получил
        Assertions.assertEquals(3, transactions.size());

        // Проверявам подредбата
        Transaction firstTransaction = transactions.get(0); // C - 200 lv
        Transaction secondTransaction = transactions.get(1);// B - 100 lv
        Transaction thirdTransaction = transactions.get(2); // A - 20 lv
        Assertions.assertEquals(transaction3, firstTransaction);
        Assertions.assertEquals(transaction2, secondTransaction);
        Assertions.assertEquals(transaction1, thirdTransaction);
    }

    @Test
    public void whenTransactionDoesNotExistWithThisStatus_thenThrownException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getByTransactionStatus(TransactionStatus.FAILED);
        });
    }

    @Test
    public void whenTransactionsExistsWithGivenSender_thenReturnThemOrdered() {

        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krasi", "Yuli", 500.00);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.ABORTED, "Rosi", "Yuli", 1000.00);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        database.add(transaction4);

        Iterable<Transaction> result = database.getByReceiverOrderedByAmountThenById("Yuli");
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(2, transactions.size());
        Assertions.assertEquals(4, transactions.get(0).getId());
        Assertions.assertEquals(3, transactions.get(1).getId());
    }

    @Test
    public void whenTransactionsDoesNotExistsWithGivenReceiver_thenThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getByReceiverOrderedByAmountThenById("Kolio");
        });
    }

    // сума >= min && сума < max && получател

    @Test
    public void whenThereAreTransactionsGetByReceiverAndAmountRange_thenReturned() {
        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Krasi", "Yuli", 500.00);
        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.ABORTED, "Rosi", "Yuli", 1000.00);
        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        database.add(transaction4);

        Iterable<Transaction> result = database.getByReceiverAndAmountRange("Yuli", 400, 2000);
        List<Transaction> transactions = new ArrayList<>();
        result.forEach(transactions::add);

        Assertions.assertEquals(2, transactions.size());
        Assertions.assertEquals(4, transactions.get(0).getId());
        Assertions.assertEquals(3, transactions.get(1).getId());
    }

    @Test
    public void whenThereAreNoTransactions_throwsException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getByReceiverAndAmountRange("Yuli", 10, 30);
        });
    }


}






