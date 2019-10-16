package ţ�����������;

import org.omg.CORBA.DATA_CONVERSION;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ������ջʵ�ֶ��л�������������ʵ��ջ
 * @author zhx
 */
public class StackAndQueueConvert {

    /**
     * ����������ʵ��ջ
     * ˼·���ǣ�
     * ���������У�һ��data���������洢���ݣ�һ��help�����Ǹ���
     * ��push��ʱ�� ֱ�Ӳ��뵽data�У���poll����peek��ʱ���Ȱ�data���е�ǰn-1��Ԫ��push��help��
     * ��ʱ��dataʣ�µ�һ������������Ҫ�ģ�����ջ�Ƚ������Ԫ��
     * Ȼ�������ٰ�help��Ϊ�� ��ʱ��ֻ��Ҫ��data ��help�����û��ཻ������,
     * ע����peek()��ʱ����Ҫ���dataҲpoll��ȥȻ����push��help����
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
     * ������ջģ�����
     * ˼·���� һ��data һ��help
     * push ��ʱ��ֱ��push��data
     * pop ����peek��ʱ���ȴ�data�����ó�ȥ�ŵ�help�� �ٴ�helpʹ��pop() ���������Ƚ��ȳ���˳����
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
