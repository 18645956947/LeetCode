package Coding_Interviews;

/**
 * 剑指offer -- 调整数组顺序使奇数位于偶数前面
 * @author zhx
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public static void reOrderArray(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i ; j--) {
                if(array[j] % 2 != 0 && array[j - 1] % 2 == 0){
                    swap(array, j-1, j);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reOrderArray02(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        int[] res = new int[array.length];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] %2 != 0){
                res[j++] = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] %2 == 0){
                res[j++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,2,6,8,5};
        调整数组顺序使奇数位于偶数前面.reOrderArray02(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
