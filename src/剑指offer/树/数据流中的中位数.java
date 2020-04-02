package ��ָoffer.��;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ��ָoffer - �������е���λ��
 * @author zhx
 */
public class �������е���λ�� {
    //С����
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    //�󶥶�
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int count = 0;
    public void Insert(Integer num) {
        if((count & 1) == 0){
            maxHeap.offer(num);
            int cur = maxHeap.poll();
            minHeap.offer(cur);
        }else{
            minHeap.offer(num);
            int cur = minHeap.poll();
            maxHeap.offer(cur);
        }
        count++;
    }

    public Double GetMedian() {
        if((count & 1) == 0){
            return new Double(minHeap.peek()+maxHeap.peek())/2;
        }else{
            return new Double(minHeap.peek());
        }
    }
}
