package ObserverDesignPattern.WeatherStation;

import ObserverDesignPattern.WeatherStation.DisplayObserver.DisplayObserver;
import ObserverDesignPattern.WeatherStation.DisplayObserver.MobileDisplayObserver;
import ObserverDesignPattern.WeatherStation.DisplayObserver.TVDisplayObserver;
import ObserverDesignPattern.WeatherStation.WeatherStationSubject.IndianWeatherStationSubject;
import ObserverDesignPattern.WeatherStation.WeatherStationSubject.WeatherStationSubject;

public class Main {
    public static void main(String[] args) {
        WeatherStationSubject indianWeatherStationSubject = new IndianWeatherStationSubject();
        DisplayObserver mobileDisplayObserver = new MobileDisplayObserver(indianWeatherStationSubject);
        DisplayObserver tvDisplayObserver = new TVDisplayObserver(indianWeatherStationSubject);


        indianWeatherStationSubject.registerObserver(mobileDisplayObserver);
        indianWeatherStationSubject.registerObserver(tvDisplayObserver);

        indianWeatherStationSubject.setTemperature(33.8);
        indianWeatherStationSubject.setHumidity(68);
        indianWeatherStationSubject.setWindPressure(5);
    }
}
