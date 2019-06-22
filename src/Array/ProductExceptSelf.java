package Array;

/**
 * 238. ��������������ĳ˻�
 * @author zhx
 * һ�ַ�����������ߵĳ˻�*�ұߵĳ˻�
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int k = 1;
        int[] res = new int[nums.length];

        for(int i = 0;i < nums.length;i++){
            res[i] = k;   // res[i]�洢����i��ߵĳ˻�
            k = k*nums[i];
        }
        k = 1;
        for(int i = nums.length-1;i>=0;i--){
            res[i] *= k; // kΪi�ұߵĳ˻�   res[i]�洢����i��ߵĳ˻�*�ұߵĳ˻�
            k = k*nums[i]; // kΪi�ұߵĳ˻�
        }

        return res;
    }
}
