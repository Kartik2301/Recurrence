package LLDQuestions.BookMyShow.Theater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import LLDQuestions.BookMyShow.Movie.Movie;
import LLDQuestions.BookMyShow.Show.Show;
import LLDQuestions.BookMyShow.Show.ShowController;

public class Theater {
    private String theaterName;
    private Set<Movie> moviesCurrentlyRunning;
    private Map<Movie, List<ShowController>> movieShows;
    private Location location;

    public Theater(String theaterName, Location location) {
        this.theaterName = theaterName;
        this.location = location;
        moviesCurrentlyRunning = new HashSet<>();
        movieShows = new HashMap<>();
    }

    public Set<Movie> getAllMoviesRunning() {
        return moviesCurrentlyRunning;
    }

    public boolean isShowing(Movie movie) {
        return moviesCurrentlyRunning.contains(movie);
    }

    public List<ShowController> getShowsOf(Movie movie) {
        return movieShows.get(movie);
    }

    public String getTheaterName() {
        return theaterName;
    }

    public Set<Movie> getMoviesCurrentlyRunning() {
        return moviesCurrentlyRunning;
    }

    public Map<Movie, List<ShowController>> getMovieShows() {
        return movieShows;
    }

    public void addShow(Show show) {
        ShowController showController = new ShowController();
        showController.setShow(show);
        List<ShowController> existingShows;

        if(movieShows.containsKey(show.getMovie())) {
            existingShows = movieShows.get(show.getMovie());
        } else {
            existingShows = new ArrayList<>();
        }
        existingShows.add(showController);
        movieShows.put(show.getMovie(), existingShows);
        moviesCurrentlyRunning.add(show.getMovie());
    }

    public Location getLocation() {
        return location;
    }

}
