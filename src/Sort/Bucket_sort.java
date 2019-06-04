package Sort;

import java.util.Arrays;

/**
 * 简单的桶排序
 * @Description 输入的是成绩  满分十分 一共五个人 new_array[1]存储的是获得1分的人数
 * 对分数排序，加入你有N个数那就需要开个N+1的空间存储
 * @author zhx
 */
public class Bucket_sort {

    public int[] bucket(int[] nums){
        int length = nums.length;
        int[] new_array = new int[11];
        int[] a = new int[nums.length];
        int index = 0;
        for(int i = 0;i<new_array.length;i++){
            new_array[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            new_array[nums[i]]++;
        }
        for (int i = 0; i < new_array.length; i++) {

            if(new_array[i]!=0){
                for (int j = 0; j < new_array[i]; j++) {
                    a[index++] = i;
                    //System.out.println(i);
                }
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{5,3,5,2,8};
        Bucket_sort b1 = new Bucket_sort();
        System.out.println(Arrays.toString(b1.bucket(nums)));

    }
}
