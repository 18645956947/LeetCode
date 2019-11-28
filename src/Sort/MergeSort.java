package Sort;

import java.math.RoundingMode;
import java.util.function.IntPredicate;

import javax.print.attribute.standard.MediaName;

/**
 * πÈ≤¢≈≈–Ú
 * @author zhx
 */
public class MergeSort {

    public static void mergeSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        mergePrcess(arr, 0, arr.length - 1);
    }
    public static void mergePrcess(int[] arr, int L, int R){
        if(L == R){
            return;
        }
        int mid = L + ((R - L) >> 1);
        mergePrcess(arr, L, mid);
        mergePrcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    public static void merge(int[] arr, int L, int mid, int R){
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int[] help = new int[R - L + 1];
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }


    public static void main(String[] args) {
        int[] arrays = {1,3,4,2,5};
        MergeSort.mergeSort(arrays);
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i]);
        }

    }
}
 