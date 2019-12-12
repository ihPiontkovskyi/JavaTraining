package ua.epam.training.piontkovskyi.task2_2.model;

public class DataSource {
    public static final int SIZE = 10;
    public static final String[] BOOKS_NAME = {
            "The book thief",
            "The maze runner",
            "The Witcher:Last Wish",
            "Escape from Freedom",
            "Atlas shrugged",
            "The Painted Bird",
            "Three Comrades",
            "The Black Dahlia",
            "The Minds of Billy Milligan",
            "Flowers for Algernon"
    };
    public static final String[] AUTHORS_NAME = {
            "Markus Zusak",
            "James Dashner",
            "Andrzej Sapkowski",
            "Erich Fromm",
            "Ayn Rand",
            "Jerzy Kosiński",
            "Erich Maria Remark",
            "James Ellroy",
            "Daniel Keyes",
            "Daniel Keyes"
    };
    public static final String[] PUBLISHERS = {
            "Family Leisure Club",
            "Dell Publishing",
            "Family Leisure Club",
            "Farrar & Rinehart",
            "Random House",
            "Houghton Mifflin",
            "Little, Brown and Company ",
            "Family Leisure Club",
            "Family Leisure Club",
            "Family Leisure Club",
    };
    public static final int[] YEARS = {
            2015,
            2009,
            2016,
            1941,
            1957,
            1965,
            1936,
            2019,
            2016,
            2017


    };
    public static final int[] PAGES = {
            584,
            375,
            288,
            257,
            1168,
            288,
            404,
            343,
            374,
            311
    };

    public static Book[] getBookData() {
        Book[] bookList = new Book[BOOKS_NAME.length];
        for (int i = 0; i < SIZE; ++i) {
            bookList[i] = new BookBuilder()
                    .withAuthor(AUTHORS_NAME[i])
                    .withName(BOOKS_NAME[i])
                    .withPublisher(PUBLISHERS[i])
                    .withPublishYear(YEARS[i])
                    .withPagesNumber(PAGES[i])
                    .build();
        }
        return bookList;
    }
}
