package LLDQuestions.MovieTicketBooking.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLDQuestions.MovieTicketBooking.City;

public class MovieController {
    private Map<City, List<Movie>> cityMovies;
    private List<Movie> allMovies;

    public MovieController() {
        cityMovies = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public List<Movie> getCityMovies(City city) {
        return cityMovies.get(city);
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }
    
    public void addMovies(Movie movie) {
        allMovies.add(movie);
    }

    public void addMovies(City city, Movie movie) {
        allMovies.add(movie);

        List<Movie> movies = cityMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityMovies.put(city, movies);
    }

}
