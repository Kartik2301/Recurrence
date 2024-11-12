package LLDQuestions.MovieTicketBooking.Theater;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLDQuestions.MovieTicketBooking.City;
import LLDQuestions.MovieTicketBooking.Movie.Movie;
import LLDQuestions.MovieTicketBooking.Shows.Show;

public class TheaterController {
    private Map<City, List<Theater>> cityTheaters;
    private List<Theater> allTheaters;

    public TheaterController() {
        cityTheaters = new HashMap<>();
        allTheaters = new ArrayList<>();
    }

    public List<Theater> getAllTheaters() {
        return allTheaters;
    }
    
    public void addTheater(Theater theater) {
        allTheaters.add(theater);
        List<Theater> theatersInCity = cityTheaters.getOrDefault(theater.getCity(), new ArrayList<>());
        theatersInCity.add(theater);
        cityTheaters.put(theater.getCity(), theatersInCity);
    }

    public List<Show> getAllShows(City city, Movie movie) {
        List<Theater> cityTheatersList = cityTheaters.get(city);
        List<Show> filteredShows = new ArrayList<>();

        for(Theater theater: cityTheatersList) {
            for(Show show: theater.getShows()) {
                if(show.getMovie().getMovieName() == movie.getMovieName()) {
                    filteredShows.add(show);
                }
            }
        }

        return filteredShows;
    }

}
