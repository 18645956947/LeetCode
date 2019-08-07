package Coding_Interviews;

import java.util.Stack;

/**
 * ��ָoffer -- ������ջʵ�ֶ���
 * @author zhx
 * ��������stack1 �����������еģ�
 * �����еĻ� ��ʵ��������ջһ��  �ٳ�ջ ��ջ��stack2ʱ  �ٵ���pop()���� ���൱���Ƚ��ȳ��ˡ�
 */
public class ����ջʵ�ֶ��� {

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
