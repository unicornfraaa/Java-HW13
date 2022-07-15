import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "first magazine", 1000, "Petya");
    Book book2 = new Book(2, "second magazine", 2000, "Olya");
    Book book3 = new Book(3, "third", 3000, "Vasya");

    Smartphone phone1 = new Smartphone(11, "S1 phone", 10000, "Sumsung");
    Smartphone phone2 = new Smartphone(22, "S2 phone", 20000, "Xiaomi");
    Smartphone phone3 = new Smartphone(33, "S3", 30000, "Apple");

    @Test
    public void samePartOfNamePhone() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] actual = manager.searchBy("phone");
        Product[] expected = {phone1, phone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void samePartOfNameBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("magazine");
        Product[] expected = {book1,book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFind1Item() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] actual = manager.searchBy("S1");
        Product[] expected = {phone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void cantFindItem() {
        manager.add(book1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] actual = manager.searchBy("second");
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }
}
