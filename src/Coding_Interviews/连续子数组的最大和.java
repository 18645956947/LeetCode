package Coding_Interviews;

/**
 * ��ָoffer--���������������
 * @author zhx
 */
public class ��������������� {
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
