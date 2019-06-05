package Array;

import java.util.Arrays;

/**
 * 215. 数组中的第K个最大元素
 * @author zhx
 */
public class FindKthLargest {
    //时间复杂度 O(nlgn)
    //先排序  再取
    //方法一
    //4 ms	40.4 MB	java
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //方法二 利用快排的二分性质，首先选取数组的第一个数作为中枢点，中枢点左边的都比它小，右边的都比它大，
    // 假如第一次分开为两部分的时候，右边的长度恰好是K的话那么右边部分的起始位置的值即为所求，如果比K大，那么所求的值一定在右边，再对右边进行递归，同理，比K小 则在
    //左边，再对左边进行递归
    //49 ms	39 MB	java
    //对比可知，还不如人家写的库函数的效率高
    public int findKthLargest_02(int[] nums, int k) {
        return quick(nums, 0, nums.length-1, k);
    }
    public int position(int[] nums, int left, int right){
        int i = left;
        int j = right;
        int pivot = nums[i];
        while(i < j){
            while(nums[j] >= pivot && i < j){
                j--;

            }
            if(i < j){
                nums[i] = nums[j];
            }
            while(nums[i] <= pivot && i < j){
                i++;
            }
            if(i < j){
                nums[j] = nums[i];
            }
        }
        nums[i] = pivot;
        return i;
    }
    public int quick(int[] nums, int left, int right, int k){
        int mid = position(nums, left, right);
        int right_length = right-mid+1;
        if(k == right_length){
            return nums[mid];
        }else if(right_length > k){
            return quick(nums, mid+1, right, k);
        }else{
            return quick(nums, left, mid-1, k - right_length);
        }
    }
}
