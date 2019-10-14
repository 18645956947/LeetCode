package Array;

import javax.print.attribute.standard.NumberUp;

/**
 * 给定一个无序数组，求如果排序之后，相邻两数的最大差值，要求时 间复杂度O(N)，且要求不能用非基于比较的排序。
 * @author zhx
 */
public class MaxGap {

    public static int maxGap(int[] nums){
        if(nums == null || nums.length < 2){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        //找到整个数组的最大最小值
        for (int i = 0; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        //如果最大值与最小值相同的话那么返回值为0
        if(max == min){
            return 0;
        }

        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            System.out.println(bid+" "+min + " " + max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i < len; i++) {
            if(hasNum[i]){
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;

    }

    /**
     * 计算给一个数，看其是属于哪一个桶
     * @param num 给的数
     * @param len 整个数组长度
     * @param min 整个数组的最小值
     * @param max 整个数组的最大值
     * @return 桶号
     */
    public static int bucket(int num, int len, int min, int max){
        return (int)((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,6,9,1};
        System.out.println(maxGap(a));
    }
}
