package Array;

/**
 * 给定一个数跟数组，将小于该数的数组元素放在左边，等于的放在中间 大于该数的数组元素放在右边
 * @author zhx
 */
public class 荷兰国旗 {

    public static void partition(int[] arr, int L, int R, int num){
        int less = L - 1;
        int more = R + 1;

        while (L < more){
            if(arr[L] == num){
                L++;
            }else if(arr[L] < num){
                swap(arr, L++, ++less);
            }else{
                swap(arr, L, --more);
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 8, 5, 5, 9, 10, 4, 3};
        partition(arr, 0, arr.length-1, 5);

        for (int a:arr) {
            System.out.println(a);
        }
    }
}
