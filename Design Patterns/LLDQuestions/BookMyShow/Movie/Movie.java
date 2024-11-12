package LLDQuestions.BookMyShow.Movie;

public class Movie {
    private String movieName;
    private int movieLength;
    private String certification;

    
    public Movie(String movieName, int movieLength, String certification) {
        this.movieName = movieName;
        this.movieLength = movieLength;
        this.certification = certification;
    }
    
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public int getMovieLength() {
        return movieLength;
    }
    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }
    public String getCertification() {
        return certification;
    }
    public void setCertification(String certification) {
        this.certification = certification;
    }

    
}
