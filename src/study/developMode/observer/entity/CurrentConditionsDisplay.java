package study.developMode.observer.entity;

import study.developMode.observer.DisplayElement;
import study.developMode.observer.Observer;
import study.developMode.observer.Subject;

/**
 * Created by hadoop on 2016/9/3.
 */
public class CurrentConditionsDisplay implements Observer,DisplayElement {
    private Subject weatherData;
    private float temprature;
    private float humidity;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions:"+temprature
                        + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temprature = temp;
        this.humidity = humidity;
        display();
    }
}
