package Array;

/**
 * leetcode - 88. 合并两个有序数组
 * @author zhx
 */
public class 合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int len = m + n - 1;
        int len1 = m - 1;
        int len2 = n - 1;
        while(len1 >= 0 && len2 >= 0){
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        if(len2 + 1 > 0){
            System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        }
    }
}
