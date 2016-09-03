package study.developMode.observer;

/**
 * Created by hadoop on 2016/9/3.
 */
public interface Subject {
    public void registObserver(Observer o);
    public void removeObserver(Observer o);

    /**
     * 通知观察者
     */
    public void notifyObservers();
}
