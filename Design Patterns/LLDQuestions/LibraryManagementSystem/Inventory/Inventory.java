package LLDQuestions.LibraryManagementSystem.Inventory;

import java.util.HashMap;
import java.util.Map;

import LLDQuestions.LibraryManagementSystem.BookManager.BookManager;
import LLDQuestions.LibraryManagementSystem.BookManager.BookManagerFactory;
import LLDQuestions.LibraryManagementSystem.Books.Genre;

public class Inventory {
    private Map<Genre, BookManager> bookManagers;
    private BookManagerFactory bookManagerFactory;

    public Inventory(BookManagerFactory bookManagerFactory) {
        bookManagers = new HashMap<>();
        this.bookManagerFactory = bookManagerFactory;
    }

    public void addBookManager(Genre genre) {
        bookManagers.put(genre, bookManagerFactory.createBookManager(genre));
    }

    public BookManager getBookManager(Genre genre) {
        return bookManagers.get(genre);
    }
}
