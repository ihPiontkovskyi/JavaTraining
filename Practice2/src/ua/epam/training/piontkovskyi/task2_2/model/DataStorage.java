package ua.epam.training.piontkovskyi.task2_2.model;

import java.util.Arrays;
import java.util.function.Predicate;

public class DataStorage {
    private Book[] books;

    public DataStorage() {
        books = DataSource.getBookData();
    }

    public Book[] getBooks() {
        return books;
    }

    public Book[] getBookListByAuthor(String author) {
        return getBookByFilter(book -> book.getAuthor().equals(author));
    }

    public Book[] getBookListByPublisher(String publisher) {
        return getBookByFilter(book -> book.getPublisher().equals(publisher));
    }

    public Book[] getBookListByPublishYear(int year) {
        return getBookByFilter(book -> book.getPublishYear() > year);
    }

    public Book[] sortByPublishers() {
        Book[] booksCopy = Arrays.copyOf(books, books.length);
        Arrays.sort(booksCopy, Book.getBookByPublisherComparator());
        return booksCopy;
    }

    private Book[] getBookByFilter(Predicate<Book> predicate) {
        Book[] subList = new Book[books.length];
        for (int i = 0; i < books.length; i++) {
            if (predicate.test(books[i])) {
                subList[i] = books[i];
            }
        }
        int subLength = 0;
        for (Book book : subList) {
            if (book != null) {
                subLength++;
            }
        }
        Book[] result = new Book[subLength];
        for (int i = 0, j = 0; i < books.length; ++i) {
            if (subList[i] != null) {
                result[j++] = subList[i];
            }
        }
        return result;
    }


}
