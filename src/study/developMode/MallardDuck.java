package study.developMode;

/**
 * Created by hadoop on 2016/9/2.
 */
public class MallardDuck extends Duck {

    /**
     * 面向接口编程，利用多态实例化
     */
    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyNoWay();
    }

    //父类中的该方法是抽象类，子类必须对其进行重写
    @Override
    public void display() {
        System.out.println("MallardDark looks beautiful!");
    }

}
