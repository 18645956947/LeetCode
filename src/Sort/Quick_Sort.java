package Sort;

import java.util.Arrays;

/**
 * ¿ìËÙÅÅÐò
 * @author zhx
 */
public class Quick_Sort {

    public int partition(int[] nums, int left, int right){

        int i = left;
        int j = right;

        if(i > j){
            return -1;
        }
        int pivot = nums[left];

        while (i < j){
            while (nums[j] >= pivot && i < j){
                j--;
            }
            nums[i] = nums[j];
            while (nums[i] <= pivot && i < j){
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = pivot;
        return i;

    }
    public void quick(int[] nums, int left, int right){
        if(left < right){
            int mid = partition(nums, left, right);
            quick(nums, left, mid-1);
            quick(nums, mid + 1, right);
        }
    }
    public void swap(int a, int b){
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6 ,1 ,2 ,7 ,9 ,3 ,4 ,5 ,10 ,8};
        Quick_Sort quick_sort = new Quick_Sort();
        quick_sort.quick(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}
