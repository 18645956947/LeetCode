package Array;
/**
 * 268. ȱʧ����
 * �÷��� �޵У�����
 * ��ͣ�Ȼ���1��n��ĺͶԱȣ�����Ľ������ȱ�������
 * @author zhx
 */
public class MissingNumber_01 {
    public int missingNumber(int[] nums){
        int sum = 0;
        for(int i = 0;i<=nums.length;i++){
            sum += i;
        }
        int num = 0;
        for(int i=0;i<nums.length;i++){
            num += nums[i];
        }
        return sum - num;
    }
}
