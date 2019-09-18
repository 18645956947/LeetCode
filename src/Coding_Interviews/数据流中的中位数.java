package Coding_Interviews;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指offer -- 数据流中的中位数
 * @author zhx
 */
public class 数据流中的中位数 {

    //小顶堆
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //大顶堆
    private PriorityQueue<Integer> maxHeap = new PriorityQueue(15, new Comparator<Integer>() {
        //默认是小顶堆 排序方法反过来就是大顶堆了
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    //记录偶数个还是奇数个
    int count = 0;
    public void Insert(Integer num) {
        //如果个数为偶数的话，则先插入到大顶堆 然后将大顶堆中最大的数插入到小顶堆中 保持大小顶堆的个数基本一直
        if((count & 1) == 0){
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else{
            //个数为奇数的话 则先插入到小顶堆，然后将小顶堆中最小的数插入到大顶堆中
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        //当前为偶数个，则取小顶堆和大顶堆的堆顶元素求平均
        if((count & 1) == 0){
           return new Double((minHeap.peek() + maxHeap.peek()) / 2);
        }else{
            //如果为奇数个 则直接从小顶堆中取元素
            return new Double(minHeap.peek());
        }
    }

    public static void main(String[] args) {
        数据流中的中位数 b = new 数据流中的中位数();
        int[] a = new int[]{5,2,3,4,1,6,7,0,8};
        for (int i = 0; i < a.length; i++) {
            b.Insert(a[i]);
            double dd = b.GetMedian();
            System.out.println(dd);
        }
        System.out.println(b.maxHeap);

//        Integer x = 5;
//        System.out.println(x.compareTo(3));
//        System.out.println(x.compareTo(5));
//        System.out.println(x.compareTo(8));
    }
}
