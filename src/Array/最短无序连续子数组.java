package Array;

import java.util.Arrays;

/**
 * Leetcode 581. 最短无序连续子数组
 * 思路就是开辟一个数组 然后找到第一个与最后一个不相同的位置，这个长度就是需要改变的最小长度
 * @author zhx
 */
public class 最短无序连续子数组 {

    public static int findUnsortedSubarray(int[] nums) {
        int[] newNum = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNum);
        int k = 0;
        int t = 0;
        boolean flag = false;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != newNum[i]){
                t = i;
                break;
            }
        }
        for (int j = nums.length - 1; j >0 ; j--) {
            if(nums[j] != newNum[j]){
                k = j;
                break;
            }
        }
        return t == k ? 0:k - t + 1;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,6,4,8,10,9,15};
        System.out.println(最短无序连续子数组.findUnsortedSubarray(a));
    }
}
