package study.developMode;

/**
 * Created by hadoop on 2016/9/2.
 */
public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("没翅膀看你怎么飞");
    }
}
