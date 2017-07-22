package base;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by twx on 2017/7/6.
 */
public class MyQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        int i = queue.peek();
        System.out.println("MyQueue.main "+ queue.remove());
        for (Integer integer : queue) {
            System.out.println("integer = " + integer);
        }
    }
}
