package ObserverDesignPattern.WeatherStation.DisplayObserver;

import ObserverDesignPattern.WeatherStation.WeatherStationSubject.WeatherStationSubject;

public class TVDisplayObserver implements DisplayObserver {
    private WeatherStationSubject weatherStationSubject;

    public TVDisplayObserver(WeatherStationSubject weatherStationSubject) {
        this.weatherStationSubject = weatherStationSubject;
    }

    @Override
    public void update() {
        double temperature = weatherStationSubject.getTemperature();
        int humidity = weatherStationSubject.getHumidity();
        int windPressure = weatherStationSubject.getWindPressure();

        System.out.println("TV Display: temperature: " + temperature + ", humidity: " + humidity + "%, " + windPressure + " knots");
    }
    
}
