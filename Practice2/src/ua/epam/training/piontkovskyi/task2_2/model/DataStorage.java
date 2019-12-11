package ua.epam.training.piontkovskyi.task2_2.model;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

public class DataStorage {
    private static final int SIZE = 12;
    private static final String[] BOOKS_NAME = {
            "The book thief", "The maze runner", "The Witcher", "The Harry Potter",
            "Escape from Freedom", "Atlas shrugged", "The Painted Bird",
            "Three Comrades", "My Struggle", "The Black Dahlia",
            "The Minds of Billy Milligan", "Flowers for Algernon"
    };
    private static final String[] AUTHORS_NAME = {
            "Markus Zusak", "James Dashner", "Andrzej Sapkowski", "Joanne Rowling",
            "Erich Fromm", "Ayn Rand", "Jerzy Kosiński",
            "Erich Maria Remark", "Adolf Schicklgruber", "James Ellroy",
            "Daniel Keyes", "Daniel Keyes"
    };
    private static final String[] PUBLISHERS = {"Family Leisure Club",
            "The Old Lion Publishing House",
            "A-ba-ba-ga-la-ma-ga"};

    private Book[] bookList;
    private Random rnd;

    public DataStorage() {
        bookList = new Book[SIZE];
        rnd = new Random();
        fillDataStorage();
    }

    public Book[] getBookList() {
        return bookList;
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

    public String getRandomAuthor() {
        return AUTHORS_NAME[rnd.nextInt(AUTHORS_NAME.length)];
    }

    public String getRandomPublisher() {
        return PUBLISHERS[rnd.nextInt(PUBLISHERS.length)];
    }

    public void sortByPublishers() {
        Arrays.sort(bookList, new BookPublisherComparator());
    }

    private Book[] getBookByFilter(Predicate<Book> predicate) {
        Book[] subList = new Book[SIZE];
        for (int i = 0; i < SIZE; i++) {
            if (predicate.test(bookList[i])) {
                subList[i] = bookList[i];
            }
        }
        int subLength = 0;
        for (Book book : subList) {
            if (book != null) {
                subLength++;
            }
        }
        Book[] result = new Book[subLength];
        for (int i = 0, j = 0; i < SIZE; ++i) {
            if (subList[i] != null) {
                result[j++] = subList[i];
            }
        }
        return result;
    }

    private void fillDataStorage() {
        for (int i = 0; i < SIZE; ++i) {
            bookList[i] = new BookBuilder()
                    .withAuthor(AUTHORS_NAME[i])
                    .withName(BOOKS_NAME[i])
                    .withPublisher(PUBLISHERS[rnd.nextInt(PUBLISHERS.length)])
                    .withPublishYear((rnd.nextInt(2019)))
                    .withPagesNumber(rnd.nextInt(1000))
                    .build();
        }
    }
}
