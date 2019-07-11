package Coding_Interviews;

/**
 * 剑指offer -- 旋转数组的最小数字
 * @author zhx
 */
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
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
