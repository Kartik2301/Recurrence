package LLDQuestions.MovieTicketBooking.Movie;

public class Movie {
    private String movieName;
    private int movieID;
    private int movieLen;

    
    public Movie(String movieName, int movieID, int movieLen) {
        this.movieName = movieName;
        this.movieID = movieID;
        this.movieLen = movieLen;
    }

    public String getMovieName() {
        return movieName;
    }
    
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getMovieLen() {
        return movieLen;
    }

    public void setMovieLen(int movieLen) {
        this.movieLen = movieLen;
    }

}
