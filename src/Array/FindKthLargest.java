package Array;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * @author zhx
 */
public class FindKthLargest {
    //时间复杂度 O(nlgn)
    //先排序  再取
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
