package LLDQuestions.LibraryManagementSystem.BookManager;

import java.util.List;

import LLDQuestions.LibraryManagementSystem.Books.Book;

public abstract class BookManager {
    protected List<Book> books;
    
    public BookManager(List<Book> books) {
        this.books = books;
    }

    public void addBookInstance(Book book) {
        books.add(book);
    }

    public void removeBookInstance(Book book) {
        books.remove(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
