package ObserverDesignPattern.WeatherStation.WeatherStationSubject;

import ObserverDesignPattern.WeatherStation.DisplayObserver.DisplayObserver;

public interface WeatherStationSubject {
    public void registerObserver(DisplayObserver observer);
    public void removeObserver(DisplayObserver observer);
    public void notifyObservers();
    public double getTemperature();
    public int getHumidity();
    public int getWindPressure();
    public void setTemperature(double temperature);
    public void setHumidity(int humidity);
    public void setWindPressure(int windPressure);
}
