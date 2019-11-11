package ţ�����������.������.̰��;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ����һ����������arr��arr���ۼӺʹ���������ܳ��ȣ�arr��ÿ�����������Ҫ�ֳɵĳ��ȡ�
 * �涨����Ϊk�Ľ����ֳ����飬����Ϊk��ͭ�塣���ذѽ����ֳ�arr�е�ÿ��������Ҫ����С���ۡ�
 * @author zhx
 */
public class Less_Money {

    //�ⷨ����ֱ����̰��Ū����
    //����ʹ�ù���������˼��,��һ��С���ѡ�
    //ÿ��ѡ������С�������ϳ�һ��������������Ż�ԭ�ȵĶѡ�
    // �ٴ�ѡȡ������С��������Ӻ�����Żض���ظ�������̣�ֱ����ʣ���һ����
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        //���ѵ���С����
        int sum = 0;
        //��ʱ�洢һ��������С�����ĺ�
        int cur = 0;
        while (pQ.size() > 1){
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }
    public static class MinheapComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;//С����ǰ
        }
    }

    public static class MaxheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1; // �����ǰ
        }

    }
    public static void main(String[] args) {
        //���Է���
        int[] arr = { 6, 7, 8, 9 };
        System.out.println(lessMoney(arr));
        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };
        PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ1.add(arrForHeap[i]);
        }
        while (!minQ1.isEmpty()) {
            System.out.print(minQ1.poll() + " ");
        }
        System.out.println();

        PriorityQueue<Integer> minQ2 = new PriorityQueue<>(new MinheapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ2.add(arrForHeap[i]);
        }
        while (!minQ2.isEmpty()){
            System.out.print(minQ2.poll() + " ");
        }
        System.out.println();


        PriorityQueue<Integer> minQ3 = new PriorityQueue<>(new MaxheapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ3.add(arrForHeap[i]);
        }
        while (!minQ3.isEmpty()){
            System.out.print(minQ3.poll() + " ");
        }
        System.out.println();
    }
}
