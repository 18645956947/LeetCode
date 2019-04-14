package Array;


import java.util.Arrays;

/**
 * 268. 缺失数字
 * @author zhx
 */
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        //冒泡排序竟然超出时间了
//        for(int i = 0;i<nums.length;i++){
//            for(int j = 0;j<nums.length-1-i;j++){
//                if(nums[j]>nums[j+1]){
//                    int temp = nums[j];
//                    nums[j] = nums[j+1];
//                    nums[j+1] = temp;
//                }
//            }
//        }
        if(nums[0] != 0){
            return 0;
        }
        if(nums[nums.length-1] == nums.length-1){
            return nums.length;
        }
        for(int i = 0;i<nums.length;i++){
            if(i != nums[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] a = new int[]{0,4,5,2,3};
        System.out.println(MissingNumber.missingNumber(a));
        System.out.println("-----");
        for(int i = 0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
