package LLDQuestions.LibraryManagementSystem.Books;

public class Book {
    private int bookId;
    private int bookCount;
    private String title;
    private String authorName;
    private Genre genre;
    private int pages;
    private int publishedYear;
    private double cost;

    public Book(int bookId, int bookCount, String title, String authorName, Genre genre, int pages, int publishedYear,
            double cost) {
        this.bookId = bookId;
        this.bookCount = bookCount;
        this.title = title;
        this.authorName = authorName;
        this.genre = genre;
        this.pages = pages;
        this.publishedYear = publishedYear;
        this.cost = cost;
    }

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public int getBookCount() {
        return bookCount;
    }
    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public Genre getGenre() {
        return genre;
    }
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public int getPages() {
        return pages;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public int getPublishedYear() {
        return publishedYear;
    }
    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    
}
