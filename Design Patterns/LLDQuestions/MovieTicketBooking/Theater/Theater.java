package LLDQuestions.MovieTicketBooking.Theater;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.MovieTicketBooking.City;
import LLDQuestions.MovieTicketBooking.Screen.Screen;
import LLDQuestions.MovieTicketBooking.Shows.Show;

public class Theater {
    private int theaterID;
    private String address;
    private City city;
    private List<Screen> screens;
    private List<Show> shows;

    public Theater(int theaterID, String address, City city) {
        this.theaterID = theaterID;
        this.address = address;
        this.city = city;

        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public void setUpScreen(int screenCount) {
        for(int i = 0; i < screenCount; i++) {
            Screen screen = new Screen(i + 1, null);
            screen.setUpSeats();
            screens.add(screen);
        }
    }

    public void setUpShow(Show show) {
        shows.add(show);
    }

}
