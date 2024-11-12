package LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.Location;

public class Location {
    private String cityName;
    private String stateName;
    private String countryName;
    private int pinCode;

    public Location(String cityName, String stateName, String countryName, int pinCode) {
        this.cityName = cityName;
        this.stateName = stateName;
        this.countryName = countryName;
        this.pinCode = pinCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    
}
