package LLDQuestions.LibraryManagementSystem.Reservations;

import java.sql.Timestamp;
import java.util.List;

import LLDQuestions.LibraryManagementSystem.Books.Book;
import LLDQuestions.LibraryManagementSystem.Invoice.Invoice;
import LLDQuestions.LibraryManagementSystem.User.User;

public class Reservation {
    private User user;
    private List<Book> books;
    private Timestamp reservedFrom;
    private Timestamp reservedUntil;
    private Timestamp createdAt;
    private int reservationID;
    private Invoice invoice;

    public Reservation(User user, List<Book> books, Timestamp reservedFrom, Timestamp reservedUntil, int reservationID,
            Invoice invoice) {
        this.user = user;
        this.books = books;
        this.reservedFrom = reservedFrom;
        this.reservedUntil = reservedUntil;
        this.reservationID = reservationID;
        this.invoice = invoice;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Timestamp getReservedFrom() {
        return reservedFrom;
    }

    public void setReservedFrom(Timestamp reservedFrom) {
        this.reservedFrom = reservedFrom;
    }

    public Timestamp getReservedUntil() {
        return reservedUntil;
    }

    public void setReservedUntil(Timestamp reservedUntil) {
        this.reservedUntil = reservedUntil;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public int getReservationID() {
        return reservationID;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();
        description.append("\n//////// RESERVATION DETAILS /////////");
        description.append("\nReservation ID is: " + reservationID);
        description.append("\nBooking made On: " + createdAt);
        description.append("\nMade By: " + user.getUserName());
        description.append("\nFor the book: " + books.get(0).getTitle());
        description.append("\nReturn date is: " + reservedUntil);

        return description.toString();
    }
    
}
