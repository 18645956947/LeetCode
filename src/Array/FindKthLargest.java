package Array;

import java.util.Arrays;

/**
 * 215. �����еĵ�K�����Ԫ��
 * @author zhx
 */
public class FindKthLargest {
    //ʱ�临�Ӷ� O(nlgn)
    //������  ��ȡ
    //����һ
    //4 ms	40.4 MB	java
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //������ ���ÿ��ŵĶ������ʣ�����ѡȡ����ĵ�һ������Ϊ����㣬�������ߵĶ�����С���ұߵĶ�������
    // �����һ�ηֿ�Ϊ�����ֵ�ʱ���ұߵĳ���ǡ����K�Ļ���ô�ұ߲��ֵ���ʼλ�õ�ֵ��Ϊ���������K����ô�����ֵһ�����ұߣ��ٶ��ұ߽��еݹ飬ͬ����KС ����
    //��ߣ��ٶ���߽��еݹ�
    //49 ms	39 MB	java
    //�Աȿ�֪���������˼�д�Ŀ⺯����Ч�ʸ�
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
