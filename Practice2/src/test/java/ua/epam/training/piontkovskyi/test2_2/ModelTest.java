package ua.epam.training.piontkovskyi.test2_2;

import org.junit.Assert;
import org.junit.Test;
import ua.epam.training.piontkovskyi.task2_2.model.Book;
import ua.epam.training.piontkovskyi.task2_2.model.DataStorage;

import java.util.Arrays;
import java.util.Comparator;

public class ModelTest {

    private DataStorage storage = new DataStorage();

    @Test
    public void getBooksTest() {
        Assert.assertNotNull(storage.getBooks());
    }

    @Test
    public void getBookListByAuthor() {
        Assert.assertEquals(2, storage.getBookListByAuthor("Daniel Keyes").length);
    }

    @Test
    public void getBookListByYear() {
        Assert.assertEquals(0, storage.getBookListByPublishYear(2020).length);
    }

    @Test
    public void getBookListByPublisher() {
        Assert.assertEquals(1, storage.getBookListByPublisher("Random House").length);
    }

    @Test
    public void sortTest() {
        Book[] actual = storage.getBooks();
        Arrays.sort(actual, Comparator.comparing(Book::getPublisher));

        Book[] sorted = storage.sortByPublishers();
        Assert.assertArrayEquals(actual, sorted);
    }
}
