package Array;
/**
 * 268. 缺失数字
 * 该方法 无敌！！！
 * 求和，然后和1到n项的和对比，相减的结果就是缺的这个数
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
