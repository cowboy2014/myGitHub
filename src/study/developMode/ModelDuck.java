package study.developMode;

/**
 * Created by hadoop on 2016/9/2.
 */
public class ModelDuck extends Duck {
    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }
    @Override
    public void display() {
        System.out.println("我是一只模型鸭");
    }
}
