package 牛客左神初级班.二叉树.贪心;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个正数数组arr，arr的累加和代表金条的总长度，arr的每个数代表金条要分成的长度。
 * 规定长度为k的金条分成两块，费用为k个铜板。返回把金条分出arr中的每个数字需要的最小代价。
 * @author zhx
 */
public class Less_Money {

    //解法就是直接用贪心弄出来
    //这里使用哈夫曼树的思想,用一个小顶堆。
    //每次选两个最小的数，合成一个数，把这个数放回原先的堆。
    // 再次选取两个最小的数，相加后的数放回堆里，重复这个过程，直到还剩最后一个数
    public static int lessMoney(int[] arr) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        //花费的最小代价
        int sum = 0;
        //临时存储一下两个最小的数的和
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
            return o1 - o2;//小的在前
        }
    }

    public static class MaxheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1; // 大的在前
        }

    }
    public static void main(String[] args) {
        //测试方法
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
