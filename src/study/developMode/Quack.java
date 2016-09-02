package study.developMode;

/**
 * Created by hadoop on 2016/9/2.
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("鸭子呱呱叫");
    }
}
