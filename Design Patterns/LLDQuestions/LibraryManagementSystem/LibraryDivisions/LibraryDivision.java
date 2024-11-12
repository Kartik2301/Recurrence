package LLDQuestions.LibraryManagementSystem.LibraryDivisions;

import LLDQuestions.LibraryManagementSystem.BookManager.BookManager;
import LLDQuestions.LibraryManagementSystem.Books.Genre;

public abstract class LibraryDivision {
    private String divisionID;
    private BookManager bookManager;
    private Genre currentGenre;

    public LibraryDivision(String divisionID) {
        this.divisionID = divisionID;
    }

    public String getDivisionID() {
        return divisionID;
    }

    public void setDivisionID(String divisionID) {
        this.divisionID = divisionID;
    }

    public BookManager getBookManager() {
        return bookManager;
    }

    public void setBookManager(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    public Genre getCurrentGenre() {
        return currentGenre;
    }

    public void setCurrentGenre(Genre currentGenre) {
        this.currentGenre = currentGenre;
    }

    public abstract void displayStatistics();
}
