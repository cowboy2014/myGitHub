package study.developMode.observer.entity;

import study.developMode.observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by hadoop on 2016/9/4.
 */
public class CurrentConditionDisplay2 implements Observer,DisplayElement{
    Observable observable;
    private float temprature;
    private float humidity;

    public CurrentConditionDisplay2(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前温度："+temprature+" 当前湿度："+humidity+"%");
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData2){
            WeatherData2 weatherData2 = (WeatherData2) o;
            this.temprature = weatherData2.getTemperature();
            this.humidity = weatherData2.getHumidity();
            display();
        }
    }
}
