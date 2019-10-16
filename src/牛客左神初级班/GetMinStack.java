package 牛客左神初级班;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 请实现一个基本栈  有一个getMin()函数 可以实现再O（1）时间内查询出栈内最小的值
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
