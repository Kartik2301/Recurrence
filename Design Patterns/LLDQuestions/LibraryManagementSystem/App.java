package LLDQuestions.LibraryManagementSystem;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLDQuestions.LibraryManagementSystem.BookManager.BookManager;
import LLDQuestions.LibraryManagementSystem.BookManager.BookManagerFactory;
import LLDQuestions.LibraryManagementSystem.Books.Book;
import LLDQuestions.LibraryManagementSystem.Books.Genre;
import LLDQuestions.LibraryManagementSystem.Inventory.Inventory;
import LLDQuestions.LibraryManagementSystem.Library.Library;
import LLDQuestions.LibraryManagementSystem.LibraryDivisions.FantasyDivision;
import LLDQuestions.LibraryManagementSystem.LibraryDivisions.HistoricDivision;
import LLDQuestions.LibraryManagementSystem.LibraryDivisions.HorrorDivision;
import LLDQuestions.LibraryManagementSystem.LibraryDivisions.LibraryDivision;
import LLDQuestions.LibraryManagementSystem.Reservations.Reservation;
import LLDQuestions.LibraryManagementSystem.Reservations.ReservationManagement;
import LLDQuestions.LibraryManagementSystem.User.User;
import LLDQuestions.LibraryManagementSystem.User.UserController;

public class App {
    private static void setupLibrary(Library library, UserController userController) {
        BookManagerFactory bookManagerFactory = new BookManagerFactory();
        Inventory inventory = new Inventory(bookManagerFactory);

        for(Genre genre: Genre.values()) {
            inventory.addBookManager(genre);
        }

        Book book1 = new Book(1, 50, "Haunting of Hill House", "Farton Nature", Genre.HORROR, 290, 2017, 250.0);
        Book book2 = new Book(2, 32, "A Very Good Story", "Turtle Gabriel", Genre.FANTASY, 143, 2018, 230.0);
        Book book3 = new Book(3, 13, "A Cricket biographics", "Sereal Catflix", Genre.FANTASY, 100, 2022, 100.0);
        Book book4 = new Book(4, 10, "Random Runner", "Teflow Nylon", Genre.HORROR, 450, 2023, 600.0);
        Book book5 = new Book(5, 34, "Techflow Use Cases", "Monty Gyrell", Genre.HISTORIC, 245, 2022, 190.0);
        Book book6 = new Book(6, 23, "What happened in 1889", "Johnas Kahnwald", Genre.HISTORIC, 799, 2003, 560.0);

        inventory.getBookManager(Genre.HISTORIC).addBookInstance(book5);
        inventory.getBookManager(Genre.HISTORIC).addBookInstance(book6);
        inventory.getBookManager(Genre.HORROR).addBookInstance(book1);
        inventory.getBookManager(Genre.HORROR).addBookInstance(book4);
        inventory.getBookManager(Genre.FANTASY).addBookInstance(book2);
        inventory.getBookManager(Genre.FANTASY).addBookInstance(book3);

        Map<Genre, LibraryDivision> libraryDivisions = new HashMap<>();
        LibraryDivision fantasyDivision = new FantasyDivision("Fantasy Division, K-18");
        LibraryDivision horrorDivision = new HorrorDivision("Horror Division, A-33");
        LibraryDivision historicDivision = new HistoricDivision("Historic, Z-4");
        LibraryDivision thrillerDivision = new HistoricDivision("Thriller Division, U-12");

        fantasyDivision.setBookManager(inventory.getBookManager(Genre.FANTASY));
        horrorDivision.setBookManager(inventory.getBookManager(Genre.HORROR));
        historicDivision.setBookManager(inventory.getBookManager(Genre.HISTORIC));
        thrillerDivision.setBookManager(inventory.getBookManager(Genre.THRILLER));

        libraryDivisions.put(Genre.FANTASY, fantasyDivision);
        libraryDivisions.put(Genre.HORROR, horrorDivision);
        libraryDivisions.put(Genre.HISTORIC, historicDivision);
        libraryDivisions.put(Genre.THRILLER, thrillerDivision);

        ReservationManagement reservationManagement = new ReservationManagement();

        library.setInventory(inventory);
        library.setLibraryDivisions(libraryDivisions);
        library.setReservationManagement(reservationManagement);
    }
    
    private static void printInventory(List<Book> books) {
        for(Book book: books) {
            System.out.println("-- " + book.getTitle());
        }
    }

    public static void main(String[] args) {
        Library library = new Library(null, null, null);
        UserController userController = new UserController();

        setupLibrary(library, userController);

        // User comes in
        User user = new User("george", "saml@kenned.com", "325333-8890");

        // User enters the book, and wants to rent a book
        Inventory inventory = library.getInventory();

        // I want to look up the Horror Genre
        BookManager bookManager = inventory.getBookManager(Genre.HORROR);

        // Get all the books in the Horror Genre
        List<Book> books = bookManager.getAllBooks();

        System.out.println("\n\nCurrent Inventory of Horror Books");
        printInventory(books);

        // Wow books[0] is so awesom, i'll rent it
        Book book = books.get(0);
        bookManager.removeBookInstance(book);
        
        List<Book> reservedBooks = new ArrayList<>();
        reservedBooks.add(book);

        ReservationManagement reservationManagement = library.getReservationManagement();

        Timestamp timestampNow = new Timestamp(System.currentTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(System.currentTimeMillis()));
        calendar.add(Calendar.DAY_OF_WEEK, 14);
        Timestamp fortNightTimestamp = new Timestamp(calendar.getTime().getTime());

        Reservation reservation = reservationManagement.createReservation(reservedBooks, user, timestampNow, fortNightTimestamp, book.getCost());

        System.out.println("\n\nCurrent Inventory of Horror Books");
        printInventory(bookManager.getAllBooks());


        // Hello, i am Jackaard I want to know where the fantasy books are kept
        System.out.println("\n\nChecking the Library Divisions");
        LibraryDivision historicLibraryDivision = library.searchDivisionByGenre(Genre.FANTASY);
        System.out.println("Please go to: " + historicLibraryDivision.getDivisionID());
        BookManager historicDivisionBookManager = historicLibraryDivision.getBookManager();
        printInventory(historicDivisionBookManager.getAllBooks());


        // Flood of users coming in, redirect them to the correct division
        System.out.println("\n\nRedirection Point!!");
        for(Genre genre: Genre.values()) {
            LibraryDivision libraryDivision = library.searchDivisionByGenre(genre);
            System.out.println("Please go to: " + libraryDivision.getDivisionID());
        }

    }
}
