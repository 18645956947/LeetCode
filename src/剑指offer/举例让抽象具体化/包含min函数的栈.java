package ��ָoffer.�����ó�����廯;

import java.util.Stack;

/**
 * ��ָoffer - ����min������ջ
 * @author zhx
 */
public class ����min������ջ {
    private Stack<Integer> s1 = new Stack();
    private Stack<Integer> s2 = new Stack();
    public void push(int node) {
        s1.push(node);
        if(s2.isEmpty() || node < s2.peek()){
            s2.push(node);
        }else{
            s2.push(s2.peek());
        }
    }
    public void pop() {
        s1.pop();
        s2.pop();
    }
    public int top() {
        return s1.peek();
    }
    public int min() {
        return s2.peek();
    }
}
