package Array;

import java.util.Arrays;

/**
 * 215. �����еĵ�K�����Ԫ��
 * @author zhx
 */
public class FindKthLargest {
    //ʱ�临�Ӷ� O(nlgn)
    //������  ��ȡ
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
