package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * @author zhx
 */
public class MyQueue {
    Deque<Integer> stack;
    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.removeFirst();
    }

    /** Get the front element. */
    public int peek() {
        return stack.getFirst();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}
/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */