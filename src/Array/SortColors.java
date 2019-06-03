package Array;

import java.util.Arrays;

/**
 * 75. 颜色分类
 * @author zhx
 */
public class SortColors {
    //版本一
    public void sortColors(int[] nums) {
        int[] count = new int[]{0, 0, 0};
        for(int i = 0;i<nums.length;i++){
            assert(nums[i] >= 0 && nums[i] <= 2);
            count[nums[i]]++;
        }

        int index = 0;
        for(int i = 0;i<count[0];i++){
            nums[index++] = 0;
        }
        for(int i = 0;i<count[1];i++){
            nums[index++] = 1;
        }
        for(int i = 0;i<count[2];i++){
            nums[index++] = 2;
        }
    }

    //版本二 采用三路快排[0 ... zero 1... two ... n-1]
    public void sortColorz_02(int[] nums) {
        int zero = -1;//nums[0 ... zero]
        int two = nums.length; // nums[two ... n-1]
        for(int i = 0;i<two;){
            if(nums[i] == 1){
                i++;
            }
            else if(nums[i] == 2){
                two--;
                nums[i] = nums[two];
                nums[two] = 2;
            }
            else {
                assert(nums[i] == 0);
                zero++;
                int temp = 0;
                temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors.sortColors(nums);
        System.out.println("nums = " + Arrays.toString(nums));
    }
}
