package ��ָoffer.���Һ�����;

/**
 * ��ָoffer - ��ת�������С����
 * @author zhx
 */
public class ��ת�������С���� {

    //�ⷨһ��
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < array.length;i++){
            if(array[i] < min){
                min = array[i];            }
        }
        return min;
    }

    //�ⷨ��;
    public int minNumberInRotateArray_01(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        int low = 0;
        int high = array.length-1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(array[mid] > array[high]){
                low = mid+1;
            }
            else if(array[mid] < array[high]){
                high = high -1;
            }
            else{
                high = mid;
            }
        }
        return array[low];
    }
}
