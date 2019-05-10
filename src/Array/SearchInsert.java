package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * 35. ��������λ��
 * @author zhx
 */
public class SearchInsert {

    //11 ms	 40.7 MB
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            map.put(i, nums[i]);
        }
        for(int i = 0;i<nums.length;i++){
            if(map.get(i) == target){
                return i;
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(target > nums[nums.length-1]){
                return nums.length;
            }
            else if(target < nums[0]){
                return 0;
            }
            else if(target > nums[i] && target < nums[i+1]){
                return i+1;
            }
        }
        return -1;
    }

    //ִ����ʱ : 1 ms, ��Search Insert Position��Java�ύ�л�����97.18% ���û�
    //�ڴ����� : 38.1 MB, ��Search Insert Position��Java�ύ�л�����74.46% ���û�
    public int searchInsert_01(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }
}
