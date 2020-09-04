package 剑指offer.时间效率;

public class 连续子数组的最大和 {
    //普通遍历方法
    public static int FindGreatestSumOfSubArray_01(int[] array) {
        if(array == null || array.length <= 0){
            return 0;
        }
        int cur = 0;
        int res = Integer.MIN_VALUE;
        for(int i = 0;i < array.length;i++){
            if(cur <= 0){
                cur = array[i];
            }else {
                cur += array[i];
            }
            if(res < cur){
                res = cur;
            }
        }
        return res;
    }
    //动态规划
    public int FindGreatestSumOfSubArray_02(int[] array) {
        if(array == null || array.length <= 0){
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int cur = array[0];
        for(int i = 1; i< array.length;i++){
            cur = Math.max(cur + array[i], array[i]);
            res = Math.max(cur, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{6,-3,-2,7,-15,1,2,2};
        System.out.println(连续子数组的最大和.FindGreatestSumOfSubArray_01(a));
    }
}
