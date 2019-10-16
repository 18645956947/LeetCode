package 牛客左神初级班;

import java.io.InputStream;

/**
 * 数组实现固定大小的栈与队列
 */
public class Array_To_Stack_Queue {

    /**
     * 数组实现固定大小的栈
     */
    public static class ArrayStack{
        public int index;
        public Integer[] arr;
        public ArrayStack(int capactiy){
            if (capactiy < 0) {
                throw new IllegalArgumentException("The init size is less than 0");
            }
            this.arr = new Integer[capactiy];
            index = 0;
        }
        public void push(int val){
            if(index == arr.length){
                throw new ArrayIndexOutOfBoundsException("stack is full");
            }
            arr[index++] = val;
        }
        public Integer pop(){
            if(index <= 0){
                throw new ArrayIndexOutOfBoundsException("stack is empty");
            }
            Integer tem = arr[--index];
            return tem;
        }
        public void printElement(){
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }

    /**
     * 数组实现固定大小的队列
     */
    public static class ArrayQueue{
        private Integer arr[];
        private int end;
        private int start;
        private int size;

        public ArrayQueue(int capacity){
            this.arr = new Integer[capacity];
            this.end = 0;
            this.start = 0;
            this.size = 0;
        }

        public Integer peek(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("queue is empty");
            }
            return arr[start];
        }
        public Integer pop(){
            if(size == 0){
                throw new ArrayIndexOutOfBoundsException("queue is empty");
            }
            size--;
            Integer tem = arr[start];
            start = start == arr.length - 1 ? 0 : start + 1;
            return tem;
        }
        public void push(int val){
            if(size == arr.length){
                throw new ArrayIndexOutOfBoundsException("queue is full");
            }
            size++;
            arr[end] = val;
            end = end == arr.length - 1 ? 0:end + 1;
        }
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
//        Integer a = arrayStack.pop();
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());

        System.out.println("==================");

        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
        Integer a = arrayQueue.peek();
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
        System.out.println(arrayQueue.pop());
    }
}
