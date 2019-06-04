package Sort;

import java.util.Arrays;

/**
 * �򵥵�Ͱ����
 * @Description ������ǳɼ�  ����ʮ�� һ������� new_array[1]�洢���ǻ��1�ֵ�����
 * �Է������򣬼�������N�����Ǿ���Ҫ����N+1�Ŀռ�洢
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
