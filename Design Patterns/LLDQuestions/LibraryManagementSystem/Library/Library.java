package LLDQuestions.LibraryManagementSystem.Library;

import java.util.Map;

import LLDQuestions.LibraryManagementSystem.Books.Genre;
import LLDQuestions.LibraryManagementSystem.Inventory.Inventory;
import LLDQuestions.LibraryManagementSystem.LibraryDivisions.LibraryDivision;
import LLDQuestions.LibraryManagementSystem.Reservations.ReservationManagement;

public class Library {
    private Inventory inventory;
    private Map<Genre, LibraryDivision> libraryDivisions;
    private ReservationManagement reservationManagement;

    public Library(Inventory inventory, Map<Genre, LibraryDivision> libraryDivisions,
            ReservationManagement reservationManagement) {
        this.inventory = inventory;
        this.libraryDivisions = libraryDivisions;
        this.reservationManagement = reservationManagement;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Map<Genre, LibraryDivision> getLibraryDivisions() {
        return libraryDivisions;
    }

    public ReservationManagement getReservationManagement() {
        return reservationManagement;
    }

    public void setReservationManagement(ReservationManagement reservationManagement) {
        this.reservationManagement = reservationManagement;
    }

    public void setLibraryDivisions(Map<Genre, LibraryDivision> libraryDivisions) {
        this.libraryDivisions = libraryDivisions;
    }

    public LibraryDivision searchDivisionByGenre(Genre genre) {
        return libraryDivisions.get(genre);
    }
}
