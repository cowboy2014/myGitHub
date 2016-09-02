package study.developMode.strategy;

/**
 * Created by hadoop on 2016/9/2.
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("木头鸭不会叫");
    }
}
