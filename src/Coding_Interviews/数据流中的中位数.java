package Coding_Interviews;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ��ָoffer -- �������е���λ��
 * @author zhx
 */
public class �������е���λ�� {

    //С����
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    //�󶥶�
    private PriorityQueue<Integer> maxHeap = new PriorityQueue(15, new Comparator<Integer>() {
        //Ĭ����С���� ���򷽷����������Ǵ󶥶���
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    //��¼ż��������������
    int count = 0;
    public void Insert(Integer num) {
        //�������Ϊż���Ļ������Ȳ��뵽�󶥶� Ȼ�󽫴󶥶������������뵽С������ ���ִ�С���ѵĸ�������һֱ
        if((count & 1) == 0){
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else{
            //����Ϊ�����Ļ� ���Ȳ��뵽С���ѣ�Ȼ��С��������С�������뵽�󶥶���
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        //��ǰΪż��������ȡС���Ѻʹ󶥶ѵĶѶ�Ԫ����ƽ��
        if((count & 1) == 0){
           return new Double((minHeap.peek() + maxHeap.peek()) / 2);
        }else{
            //���Ϊ������ ��ֱ�Ӵ�С������ȡԪ��
            return new Double(minHeap.peek());
        }
    }

    public static void main(String[] args) {
        �������е���λ�� b = new �������е���λ��();
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
