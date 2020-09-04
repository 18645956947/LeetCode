package 剑指offer.举例让抽象具体化;

import java.util.Stack;

/**
 * 剑指offer - 包含min函数的栈
 * @author zhx
 */
public class 包含min函数的栈 {
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
