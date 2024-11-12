package LLDQuestions.LibraryManagementSystem.Reservations;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import LLDQuestions.LibraryManagementSystem.Books.Book;
import LLDQuestions.LibraryManagementSystem.Invoice.Invoice;
import LLDQuestions.LibraryManagementSystem.User.User;

public class ReservationManagement {
    private List<Reservation> reservations;
    private static int reservationID = 0;

    public ReservationManagement() {
        reservations = new ArrayList<>();
    }

    public Reservation createReservation(List<Book> books, User user, Timestamp bookedFrom, Timestamp bookedTo, double cost) {
        Reservation reservation = new Reservation(user, books, bookedFrom, bookedTo, ++reservationID, new Invoice(cost));
        reservations.add(reservation);
        System.out.println(reservation);
        return reservation;
    }
}
