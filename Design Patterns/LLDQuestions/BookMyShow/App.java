package LLDQuestions.BookMyShow;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLDQuestions.BookMyShow.Booking.Booking;
import LLDQuestions.BookMyShow.Movie.Movie;
import LLDQuestions.BookMyShow.Movie.MovieManager;
import LLDQuestions.BookMyShow.Seats.Seat;
import LLDQuestions.BookMyShow.Show.Show;
import LLDQuestions.BookMyShow.Show.ShowController;
import LLDQuestions.BookMyShow.Theater.Location;
import LLDQuestions.BookMyShow.Theater.Theater;
import LLDQuestions.BookMyShow.Theater.TheaterController;

public class App {
    private static Timestamp processEndTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(System.currentTimeMillis()));
        calendar.add(Calendar.MINUTE, 120);
        return new Timestamp(calendar.getTime().getTime());
    }

    private static Movie getMovie(String movieName) {
        return new Movie(movieName, 120, "U/A");
    }

    private static void displaySeats(ShowController showController) {
        System.out.println("List of Available Seats Now:");
        for(Seat seat: showController.getShow().getAvailableSeatsList()) {
            System.out.println(seat.getSeatCategory().name() + "-" + seat.getSeatId()  + ", Cost: Rs. " + seat.getSeatCost());
        }
    }

    private static void setupCode(Map<String, MovieManager> map) {
        // Add Entries to Map
        MovieManager bangaloreMovieManager = new MovieManager();

        // Create Movies
        Movie inception = getMovie("Inception");
        Movie shutterIsland = getMovie("Shutter Island");
        Movie sourceCode = getMovie("Source Code");

        // Create 4 Theater Controller

        TheaterController theaterController1 = new TheaterController();
        // Create the Theater
        Location location1 = new Location("4th Crossing J-Street");
        Theater theater1 = new Theater("RSVP Horse Dark Studios", location1);
        // Create the Shows
        Show show1 = new Show(new Timestamp(System.currentTimeMillis()), processEndTime(), inception, 10, location1);
        Show x1show1 = new Show(new Timestamp(System.currentTimeMillis()), processEndTime(), inception, 25, location1);
        theater1.addShow(show1);
        theater1.addShow(x1show1);
        theaterController1.setTheater(theater1);

        TheaterController theaterController2 = new TheaterController();
        Location location2 = new Location("Fox Nutt Grove");
        Theater theater2 = new Theater("Monte Carlo", location2);
        Show show2 = new Show(new Timestamp(System.currentTimeMillis()), processEndTime(), shutterIsland, 8, location2);
        theater2.addShow(show2);
        theaterController2.setTheater(theater2);

        TheaterController theaterController3 = new TheaterController();
        Location location3 = new Location("Silverstone");
        Theater theater3 = new Theater("Noris Cerr Studios", location3);
        Show show3 = new Show(new Timestamp(System.currentTimeMillis()), processEndTime(), sourceCode, 8, location3);
        theater3.addShow(show3);
        theaterController3.setTheater(theater3);

        TheaterController theaterController4 = new TheaterController();
        Location location4 = new Location("Lithuania Strait");
        Theater theater4 = new Theater("Vague Ramblings Firestock", location4);
        Show show4 = new Show(new Timestamp(System.currentTimeMillis()), processEndTime(), inception, 8, location4);
        theater4.addShow(show4);
        theaterController4.setTheater(theater4);

        bangaloreMovieManager.addTheaterController(theaterController1);
        bangaloreMovieManager.addTheaterController(theaterController2);
        bangaloreMovieManager.addTheaterController(theaterController3);
        bangaloreMovieManager.addTheaterController(theaterController4);

        map.put("Bangalore", bangaloreMovieManager);
    }

    public static void main(String[] args) {
        Map<String, MovieManager> map = new HashMap<>();
        setupCode(map);

        // A User Comes In
        User user = new User("Paul Henry");

        // Give me all the movies playing in Bangalore
        MovieManager manager = map.get("Bangalore");
        List<Movie> movies = manager.getListOfRunningMovies();

        System.out.println("Currently Playing Movies in Bangalore");
        for(Movie movie: movies) {
            System.out.println(movie.getMovieName());
        }

        // I'll watch the first movie, show me all the theaters playing this movie
        Movie movie = movies.get(0);
        List<TheaterController> allTheaterControllers = manager.getAllTheatersShowing(movie);

        System.out.println("Here is a list of all the theaters showing this movie");
        for(TheaterController theaterController: allTheaterControllers) {
            Theater localTheater = theaterController.getTheater();
            System.out.println(localTheater.getTheaterName() + ", " + localTheater.getLocation().getLocationString());
        }

        // I'll go with the first theater
        TheaterController theaterController = allTheaterControllers.get(0);

        // Show me all the shows available
        System.out.println("Here all the shows available for movie: " + movie.getMovieName() + " at: " + theaterController.getTheater().getTheaterName());
        List<ShowController> allShowControllers = theaterController.getAllShowsOf(movie);

        for(ShowController showController: allShowControllers) {
            Show show = showController.getShow();
            System.out.println("Show Timings - " + show.getMovie().getMovieName() + ", " + show.getStartTime() + " to " + show.getEndTime());
        }

        // I'll Pick the first Show
        ShowController showController = allShowControllers.get(0);

        // Show me all the available seats
        displaySeats(showController);

        // I'll pick the last seat
        Seat seat = showController.getShow().getAvailableSeatsList().getLast();
        Booking booking = showController.makeBooking(user, seat.getSeatId());

        assert(booking != null);

        System.out.println("Booking Done");
        System.out.println("Username: " + booking.getUser().getUserName());
        System.out.println("Movie Name: " + booking.getShow().getMovie().getMovieName());
        System.out.println("Movie Lenght: " + booking.getShow().getMovie().getMovieLength());
        System.out.println("Show Timings: " + booking.getShow().getStartTime() + " to " +  booking.getShow().getEndTime());
        System.out.println("Address: " + booking.getShow().getLocation().getLocationString());

        System.out.println();
        System.out.println("Seat Details");
        System.out.println("Seat Number: " + booking.getSeat().getSeatId());
        System.out.println("Seat Category: " + booking.getSeat().getSeatCategory().name());

        // Verification this seat should be removed from the show
        displaySeats(showController);
    }
}
