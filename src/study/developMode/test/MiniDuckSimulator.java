package study.developMode.test;

import study.developMode.Duck;
import study.developMode.FlyWithWings;
import study.developMode.MallardDuck;
import study.developMode.ModelDuck;

/**
 * Created by hadoop on 2016/9/2.
 * 测试功能类:改变鸭子的行为
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        //测试用例一
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();

        System.out.println("============测试例子2=======");
        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyWithWings());
    }
}
