package LLDQuestions.MovieTicketBooking;

import java.util.List;

import LLDQuestions.MovieTicketBooking.Movie.Movie;
import LLDQuestions.MovieTicketBooking.Movie.MovieController;
import LLDQuestions.MovieTicketBooking.Seats.Seat;
import LLDQuestions.MovieTicketBooking.Shows.Show;
import LLDQuestions.MovieTicketBooking.Theater.Theater;
import LLDQuestions.MovieTicketBooking.Theater.TheaterController;

public class Driver {
    private static MovieController movieController = new MovieController();
    private static TheaterController theaterController = new TheaterController();


    public static void setUpApplication() {

        // Create movies
        Movie movie1 = new Movie("Hippo Dog", 1, 121);
        Movie movie2 = new Movie("Superstar Cat", 2, 100);
        Movie movie3 = new Movie("Dogmon", 3, 145);

        movieController.addMovies(City.BANGALORE, movie1);
        movieController.addMovies(City.DELHI, movie1);
        movieController.addMovies(City.MUMBAI, movie1);
        movieController.addMovies(City.BANGALORE, movie2);
        movieController.addMovies(City.DUBAI, movie2);
        movieController.addMovies(City.DUBAI, movie3);

        // Create theaters
        Theater theater1 = new Theater(1, "Jupoy nagar", City.BANGALORE);
        theater1.setUpScreen(5);
        theater1.setUpShow(new Show(1, 100, movie1, theater1.getScreens().get(0)));

        Theater theater2 = new Theater(2, "Kaddy", City.DELHI);
        theater2.setUpScreen(5);
        theater2.setUpShow(new Show(1, 100, movie2, theater2.getScreens().get(0)));

        Theater theater3 = new Theater(3, "agh", City.MUMBAI);
        theater3.setUpScreen(2);
        theater3.setUpShow(new Show(1, 100, movie1, theater3.getScreens().get(0)));

        Theater theater4 = new Theater(4, "qwerty", City.BANGALORE);
        theater4.setUpScreen(2);
        theater4.setUpShow(new Show(1, 100, movie2, theater4.getScreens().get(0)));

        Theater theater5 = new Theater(5, "Dubai Plaza", City.DUBAI);
        theater5.setUpScreen(1);
        theater5.setUpShow(new Show(1, 100, movie1, theater5.getScreens().get(0)));

        Theater theater6 = new Theater(6, "Dharavi", City.MUMBAI);
        theater6.setUpScreen(9);
        theater6.setUpShow(new Show(1, 100, movie3, theater6.getScreens().get(0)));

        theaterController.addTheater(theater1);
        theaterController.addTheater(theater2);
        theaterController.addTheater(theater3);
        theaterController.addTheater(theater4);
        theaterController.addTheater(theater5);
        theaterController.addTheater(theater6);
    }
    public static void main(String[] args) {
        setUpApplication();

        // Start Accepting Reservations
        // User provides City and Movie name

        List<Movie> cityMovies = movieController.getCityMovies(City.BANGALORE);

        System.out.println("Here is a list of all the movies available in this city");
        for(int i = 0; i < cityMovies.size(); i++) {
            System.out.println(cityMovies.get(i).getMovieName());
        }

        if(cityMovies.size() == 0) {
            System.out.println("No Movies in this city");
        } else {
            Movie movie = cityMovies.get(0);
            List<Show> allMatchingShows = theaterController.getAllShows(City.BANGALORE, movie);
            
            System.out.println("Here is a list of all the shows available:");
            for(int i = 0; i < allMatchingShows.size(); i++) {
                System.out.println(allMatchingShows.get(i).getShowID() + " " + allMatchingShows.get(i).getShowStartingTime());
            }

            // User selects a show
            Show show = allMatchingShows.get(0);
            List<Seat> availableSeats = show.getAvailableSeats();
            System.out.println(show.getAvailableSeats().size());

            // User selects a seat
            Seat seat = availableSeats.get(67);

            // Reserve this seat
            show.bookSeat(seat);

            System.out.println(show.getAvailableSeats().size());

            Booking booking = new Booking(show);
            booking.addBookedSeats(seat);

            System.out.println("Your bill is: " + booking.computeBill());
        }

    }
}
