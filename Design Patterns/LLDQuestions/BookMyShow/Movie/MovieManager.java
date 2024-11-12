package LLDQuestions.BookMyShow.Movie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import LLDQuestions.BookMyShow.Theater.TheaterController;

public class MovieManager {
    private List<TheaterController> theaterControllers;

    public MovieManager() {
        theaterControllers = new ArrayList<>();
    }

    public List<Movie> getListOfRunningMovies() {
        Set<Movie> runningMovies = new HashSet<>();

        for(TheaterController theaterController: theaterControllers) {
            theaterController.extractRunningMovies(runningMovies);
        }

        return new ArrayList<>(runningMovies);
    }

    public List<TheaterController> getAllTheatersShowing(Movie movie) {
        List<TheaterController> theaters = new ArrayList<>();
        for(TheaterController theaterController: theaterControllers) {
            if(theaterController.isShowing(movie)) {
                theaters.add(theaterController);
            }
        }

        return theaters;
    }

    public void addTheaterController(TheaterController theaterController) {
        theaterControllers.add(theaterController);
    }
}
