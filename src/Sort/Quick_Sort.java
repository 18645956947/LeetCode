package Sort;

import java.util.Arrays;

/**
 * ��������
 * @author zhx
 */
public class Quick_Sort {

    //������ֳ�������  ���ַ�Ĭ��Ϊ����ĵ�һ����Ϊ���ֵ��м��
    public int partition(int[] nums, int left, int right){

        int i = left;
        int j = right;

        if(i > j){
            return -1;
        }
        int pivot = nums[left];//�����¼

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
            int mid = partition(nums, left, right);//�������Ϊ������
            quick(nums, left, mid-1);//�ݹ�������������
            quick(nums, mid + 1, right);//�ݹ�������������
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
