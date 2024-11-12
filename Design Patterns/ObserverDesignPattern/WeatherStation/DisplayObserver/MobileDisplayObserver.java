package ObserverDesignPattern.WeatherStation.DisplayObserver;

import ObserverDesignPattern.WeatherStation.WeatherStationSubject.WeatherStationSubject;

public class MobileDisplayObserver implements DisplayObserver {
    WeatherStationSubject weatherStationSubject;

    public MobileDisplayObserver(WeatherStationSubject weatherStationSubject) {
        this.weatherStationSubject = weatherStationSubject;
    }

    @Override
    public void update() {
        double temperature = weatherStationSubject.getTemperature();
        int humidity = weatherStationSubject.getHumidity();
        int windPressure = weatherStationSubject.getWindPressure();

        System.out.println("Mobile Display: temperature: " + temperature + ", humidity: " + humidity + "%, " + windPressure + " knots");
    }
    
}
