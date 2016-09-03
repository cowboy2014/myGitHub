package study.developMode.observer.entity;

import study.developMode.observer.Observer;
import study.developMode.observer.Subject;
import java.util.ArrayList;

/**
 * Created by hadoop on 2016/9/3.
 */
public class WeatherData implements Subject{
    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList();
    }

    @Override
    public void registObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(-1 != i) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0 ; i<observers.size();i++){
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    /**
     * 加这样一个方法，可以动态设计通知条件
     */
    public void measurementsChanged(){
        notifyObservers();
    }

    /**
     * 采集传输的数据
     * @param temperature
     * @param humidity
     * @param pressure
     */
    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
