package Sort;

import com.sun.org.apache.bcel.internal.generic.SWAP;

/**
 * 快速排序
 * @author zhx
 */
public class QuickSort {

    public static void quickSort(int[] arr, int L, int R){
        if(L < R){
//            swap(arr, L + (int)(Math.random() * (R - L + 1)), R);//加上这行就是随机快排时间复杂度为O（n*logn）
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }
    public static int[] partition(int[] arr, int L, int R){
        int cur = L;
        int less = L - 1;
        int more = R +1;
        while (cur < more){
           if(arr[cur] > arr[R]){
               swap(arr, cur, --more);
           } else if(arr[cur] < arr[R]){
               swap(arr, cur++, ++less);
           }else{
               cur++;
           }
        }
        swap(arr, R, more);
        return new int[]{less + 1, more - 1};

    }
    public static void swap(int[] arr, int i, int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 7, 8, 5, 5, 9, 10, 4, 3};
        QuickSort.quickSort(a, 0, a.length - 1);
        for (int i:a) {
            System.out.print(i);
        }
    }
}
