package ţ�����������;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * ��ʵ��һ������ջ  ��һ��getMin()���� ����ʵ����O��1��ʱ���ڲ�ѯ��ջ����С��ֵ
 * @author zhx
 */
public class GetMinStack {

    public Stack<Integer> dataStack;
    public Stack<Integer> helpStack;

    public GetMinStack(){
        this.dataStack = new Stack<>();
        this.helpStack = new Stack<>();

    }

    public void push(Integer val){
        if (this.dataStack.isEmpty()){
            helpStack.push(val);
        }else if(this.helpStack.peek() <= val){
            this.helpStack.push(helpStack.peek());
        }else{
            this.helpStack.push(val);
        }
        this.dataStack.push(val);
    }

    public Integer pop(){
        if(dataStack.isEmpty()){
            throw new EmptyStackException();
        }
        this.helpStack.pop();
        Integer a = this.dataStack.pop();
        return a;
    }

    public Integer getMin(){
        if(helpStack.isEmpty()){
            throw new EmptyStackException();
        }
        return this.helpStack.peek();
    }

}
