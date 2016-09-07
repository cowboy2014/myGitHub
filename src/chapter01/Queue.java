package chapter01;

import java.util.LinkedList;

/**
 *
 * Created by hadoop on 2016/8/27.
 */
public class Queue {
//    使用链表实现队列
    private LinkedList queue = new LinkedList();
    //入队列
    public void enQueue(Object t){
        queue.addLast(t);
    }
    //出队列
    public Object deQueue(){
        return queue.removeFirst();
    }
    //判断队列是否为空
    public boolean isQueueEmpty(){
        return queue.isEmpty();
    }
    //判断队列是否包含t
    public boolean isContain(Object t){
        return queue.contains(t);
    }
}
