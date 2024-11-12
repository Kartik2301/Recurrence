package ObserverDesignPattern.WeatherStation.WeatherStationSubject;

import java.util.ArrayList;
import java.util.List;

import ObserverDesignPattern.WeatherStation.DisplayObserver.DisplayObserver;

public class IndianWeatherStationSubject implements WeatherStationSubject {
    private double temperature;
    private int humidity;
    private int windPressure;

    private List<DisplayObserver> observers;

    public IndianWeatherStationSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(DisplayObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(DisplayObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(DisplayObserver observer: observers) {
            observer.update();
        }
    }

    @Override
    public double getTemperature() {
        return temperature;
    }

    @Override
    public int getHumidity() {
        return humidity;
    }

    @Override
    public int getWindPressure() {
        return windPressure;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
        notifyObservers();
    }

    public void setWindPressure(int windPressure) {
        this.windPressure = windPressure;
        notifyObservers();
    }
    
}
