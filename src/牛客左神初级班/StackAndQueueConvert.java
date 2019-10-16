package 牛客左神初级班;

import org.omg.CORBA.DATA_CONVERSION;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈实现队列或者用俩个队列实现栈
 * @author zhx
 */
public class StackAndQueueConvert {

    /**
     * 用两个队列实现栈
     * 思路就是：
     * 找两个队列，一个data队列用来存储数据，一个help队列是辅助
     * 在push的时候 直接插入到data中，在poll或者peek的时候先把data队列的前n-1个元素push到help中
     * 这时候data剩下的一个就是我们需要的，满足栈先进后出的元素
     * 然后我们再把help变为空 这时候只需要把data 与help的引用互相交换即可,
     * 注意在peek()的时候，需要你把data也poll出去然后再push进help里面
     */
    public static class TwoQueuesStack{

        Queue<Integer> queueData;
        Queue<Integer> queueHelp;
        public TwoQueuesStack(){
            this.queueData = new LinkedList<>();
            this.queueHelp = new LinkedList<>();
        }

        public Integer poll(){
            if(queueData.isEmpty()){
               throw new RuntimeException("queue is empty");
            }
            while (queueData.size() > 1){
                this.queueHelp.add(this.queueData.poll());
            }
            Integer a = this.queueData.poll();
            swap();
            return a;
        }

        public Integer peek(){
            if(queueData.isEmpty()){
                throw new RuntimeException("queue is empty");
            }
            while (queueData.size() > 1){
                this.queueHelp.add(this.queueData.poll());
            }
            Integer a = this.queueData.poll();
            this.queueHelp.add(a);
            swap();
            return a;
        }

        public void push(int val){
            this.queueData.add(val);
        }
        public void swap(){
            Queue temp = this.queueHelp;
            this.queueHelp = this.queueData;
            this.queueData = temp;
        }
    }

    /**
     * 用两个栈模拟队列
     * 思路就是 一个data 一个help
     * push 的时候直接push进data
     * pop 或者peek的时候先从data里面拿出去放到help中 再从help使用pop() 方法就是先进先出的顺序了
     */
    public static class TwoStaccksQueue{

        Stack<Integer> data;
        Stack<Integer> help;

        public TwoStaccksQueue(){
            this.data = new Stack<>();
            this.help = new Stack<>();
        }

        public void push(int val){
            data.push(val);
        }
        public Integer pop(){
            if (data.isEmpty() && help.isEmpty()){
                throw  new RuntimeException("queue is null");
            }else if(help.isEmpty()){
                while (!data.isEmpty()){
                    help.push(data.pop());
                }
            }
            return help.pop();
        }
    }
}
