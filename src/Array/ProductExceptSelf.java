package Array;

/**
 * 238. 除自身以外数组的乘积
 * @author zhx
 * 一种方法就是求左边的乘积*右边的乘积
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int k = 1;
        int[] res = new int[nums.length];

        for(int i = 0;i < nums.length;i++){
            res[i] = k;   // res[i]存储的是i左边的乘积
            k = k*nums[i];
        }
        k = 1;
        for(int i = nums.length-1;i>=0;i--){
            res[i] *= k; // k为i右边的乘积   res[i]存储的是i左边的乘积*右边的乘积
            k = k*nums[i]; // k为i右边的乘积
        }

        return res;
    }
}
