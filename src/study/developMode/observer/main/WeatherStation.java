package study.developMode.observer.main;

import study.developMode.observer.entity.CurrentConditionDisplay2;
import study.developMode.observer.entity.CurrentConditionsDisplay;
import study.developMode.observer.entity.WeatherData;
import study.developMode.observer.entity.WeatherData2;

/**
 * Created by hadoop on 2016/9/3.
 */
public class WeatherStation {
    public static void main(String[] args) {
        /*使用自定义的观察者接口*/
        WeatherData weatherData = new WeatherData();
        //显示板
        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);


        /*使用内置的Observable类实现*/
        WeatherData2 weatherData2 = new WeatherData2();
        CurrentConditionDisplay2 conditionDisplay2 = new CurrentConditionDisplay2(weatherData2);
        weatherData2.setMeasurements(23,43,42.4F);
    }
}
