package LLDQuestions.BookMyShow.Theater;

import java.util.List;
import java.util.Set;

import LLDQuestions.BookMyShow.Movie.Movie;
import LLDQuestions.BookMyShow.Show.Show;
import LLDQuestions.BookMyShow.Show.ShowController;

public class TheaterController {
    private Theater theater;

    public TheaterController() {
        
    }

    public void extractRunningMovies(Set<Movie> addMoviesTo) {
        Set<Movie> movies = theater.getAllMoviesRunning();
        for(Movie movie: movies) {
            addMoviesTo.add(movie);
        }
    }

    public boolean isShowing(Movie movie) {
        return theater.isShowing(movie);
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public List<ShowController> getAllShowsOf(Movie movie) {
        return theater.getShowsOf(movie);
    }

    public void addShowOf(Show show) {
        theater.addShow(show);
    }
}
