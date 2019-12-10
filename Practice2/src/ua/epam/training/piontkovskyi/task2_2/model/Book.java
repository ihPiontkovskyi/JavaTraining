package ua.epam.training.piontkovskyi.task2_2.model;

public class Book {
    private String name;
    private String author;
    private String publisher;
    private int publishYear;
    private int pagesNumber;

    public String getName() {
        return name;
    }

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

    public int getPagesNumber() {
        return pagesNumber;
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
                ", pagesNumber=" + pagesNumber;
    }
}
