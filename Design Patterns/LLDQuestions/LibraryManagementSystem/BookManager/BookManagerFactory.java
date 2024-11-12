package LLDQuestions.LibraryManagementSystem.BookManager;

import LLDQuestions.LibraryManagementSystem.Books.Genre;

public class BookManagerFactory {
    public BookManager createBookManager(Genre genre) {
        BookManager bookManager = null;

        switch (genre) {
            case FANTASY:
                bookManager = new FantasyBookManager();
                break;
            case HORROR:
                bookManager = new HorrorBookManager();
                break;
            case THRILLER:
                bookManager = new ThrillerBookManager();
                break;
            case HISTORIC:
                bookManager = new HistoricBookManager();
                break;
        }

        return bookManager;
    }
}
