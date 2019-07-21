package Coding_Interviews;

import java.util.Stack;

/**
 * 剑指offer -- 包含min函数的栈
 * @author zhx
 */
public class 包含min函数的栈 {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        data.push(node);
        if(min.isEmpty() || node < min.peek()){
            min.push(node);
        }else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
