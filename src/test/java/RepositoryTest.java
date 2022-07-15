import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Repository repo = new Repository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "first magazine", 1000, "Petya");
    Book book2 = new Book(2, "second magazine", 2000, "Olya");
    Book book3 = new Book(3, "third", 3000, "Vasya");

    Smartphone phone1 = new Smartphone(11, "S1 phone", 10000, "Sumsung");
    Smartphone phone2 = new Smartphone(22, "S2 phone", 20000, "Xiaomi");
    Smartphone phone3 = new Smartphone(33, "S3", 30000, "Apple");

    @Test
    public void shouldAdded() {
        repo.add(book1);
        repo.add(book2);
        repo.add(phone1);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, phone1};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void shouldRemovedById() {
        repo.add(book1);
        repo.add(book2);
        repo.add(phone2);
        repo.add(phone3);

        repo.removeById(1);
        repo.removeById(22);

        Product[] actual = repo.findAll();
        Product [] expected = {book2,phone3};

        assertArrayEquals(actual,expected);
    }

    @Test
    public void shouldShowException() {
        repo.add(book1);
        repo.add(book2);
        repo.add(phone2);
        repo.add(phone3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(-100);
        });
    }
}