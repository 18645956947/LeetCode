package Coding_Interviews;

import java.util.Stack;

/**
 * 剑指offer -- 用两个栈实现队列
 * @author zhx
 * 方法就是stack1 是用来进队列的，
 * 出队列的话 其实就是先入栈一次  再出栈 入栈进stack2时  再调用pop()方法 就相当于先进先出了。
 */
public class 两个栈实现队列 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        if( stack2.isEmpty() ){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
