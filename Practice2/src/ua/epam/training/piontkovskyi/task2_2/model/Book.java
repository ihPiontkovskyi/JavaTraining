package ua.epam.training.piontkovskyi.task2_2.model;

import java.util.Comparator;

public class Book {
    private String name;
    private String author;
    private String publisher;
    private int publishYear;
    private int pagesNumber;

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void setPagesNumber(int pagesNumber) {
        this.pagesNumber = pagesNumber;
    }

    @Override
    public String toString() {
        return "Book:" +
                "name=" + name +
                ", author=" + author +
                ", publisher=" + publisher +
                ", publishYear=" + publishYear +
                ", pagesNumber=" + pagesNumber + "\n";
    }

    public static Comparator<Book> getBookByPublisherComparator() {
        return new BookByPublisherComparator();
    }

    private static class BookByPublisherComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getPublisher().compareTo(o2.getPublisher());
        }
    }

}
