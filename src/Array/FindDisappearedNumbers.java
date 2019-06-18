package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 448. �ҵ�������������ʧ������
 * @author zhx
 */
public class FindDisappearedNumbers {

    //��Ϊ����Ҫ���ǡ�1....n����û���ֹ�������
    //������һ������ a[1,5,4,2,1,4]    a[a[i]-1] ��������ĵ�i�������ֹ� ���ֹ��Ͱ�����ɸ�����
    // Ȼ�������ٱ���һ�������д���0������ �±��һ����������ʧ������
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();
        for(int i = 0;i<nums.length;i++){
            int index = Math.abs(nums[i]) - 1;
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        return res;
    }

}
