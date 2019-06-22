package Coding_Interviews;

/**
 * 剑指offer--连续子数组的最大和
 * @author zhx
 */
public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length <= 0){
            return 0;
        }

        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i < array.length;i++){
            if(sum < 0){
                sum = array[i];
            }
            else{
                sum += array[i];
            }
            if(sum > res){
                res = sum;
            }

        }
        return res;

    }
}
