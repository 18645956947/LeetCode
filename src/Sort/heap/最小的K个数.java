package Sort.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 剑指offer - 最小的K个数
 *
 * @author zhx
 */
public class 最小的K个数 {

    //思路1：用最大堆来存储k个数 保持堆的数量不变
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList();
        if(input == null || input.length == 0 || k > input.length || k <= 0){
            return res;
        }
        PriorityQueue<Integer> queue  = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        int i = 0;
        while(queue.size() < k){
            queue.add(input[i++]);
        }
        System.out.println(queue.size());
        for(;i < input.length;i++){
            if(queue.peek() >= input[i]){
                queue.poll();
                queue.add(input[i]);
            }
        }
        for(Integer a : queue){
            res.add(a);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,5,6,7,12,54,1};
        System.out.println(最小的K个数.GetLeastNumbers_Solution(a, 1));
    }
}
