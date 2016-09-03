package study.developMode.observer.main;

import study.developMode.observer.entity.CurrentConditionsDisplay;
import study.developMode.observer.entity.WeatherData;

/**
 * Created by hadoop on 2016/9/3.
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        //显示板
        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
    }
}
