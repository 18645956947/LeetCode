package Coding_Interviews;

import java.util.Stack;

/**
 * ��ָoffer -- ����min������ջ
 * @author zhx
 */
public class ����min������ջ {

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
