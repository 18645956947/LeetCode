package Sort;

import java.math.RoundingMode;
import java.util.function.IntPredicate;

import javax.print.attribute.standard.MediaName;

/** 
* @author lenovo
* @date 2019年3月14日下午9:38:17 
* @Description: 
*/
public class MergeSort {
    /**
     *
     * @param arrays
     * @param L   指向数组的第一个元素
     * @param R	      指向数组的最后一个元素
     */
    public static void mergeSort(int[] arrays, int L, int R) {
        if(L == R) {
            return;
        }
        else {
            int M = (L + R) / 2;
            mergeSort(arrays, L, M);
            mergeSort(arrays, M+1, R);
            merge(arrays, L, M+1, R);
        }
    }

    /**
     *
     * @param arrays
     * @param L		指向数组的第一个元素
     * @param M		指向数组的中间的元素
     * @param R		指向数组的最后一个元素
     */
    public static void merge(int[] arrays, int L,int M, int R) {
        //左边的数组大小
        int[] leftArrays = new int[M - L];
        //右边的数组大小
        int[] rightArrays = new int[R - M  + 1];
        for (int i = L; i < M; i++) {
            leftArrays[i-L] = arrays[i];
        }
        for (int i = M; i <= R; i++) {
            rightArrays[i-M] = arrays[i];
        }

        int i = 0, j = 0;
        int K = L;
        //比较这两个数组的大小，知直到一个数组为空为止
        while(i < leftArrays.length && j < rightArrays.length) {
            if(leftArrays[i] < rightArrays[j]) {
                arrays[K] = leftArrays[i];
                i++;
                K++;
            }
            else {
                arrays[K] = rightArrays[j];
                K++;
                j++;
            }
        }
        //如果左边没满则把左边的填入数组中
        if(i < leftArrays.length){
            arrays[K] = leftArrays[i];
            i++;
            K++;
        }
        //如果右边的没满则把右边的填入数组中
        if(j < rightArrays.length){
            arrays[K] = rightArrays[j];
            K++;
            j++;
        }

    }


    public static void main(String[] args) {
        int[] arrays = {2, 1, 8};
        MergeSort.mergeSort(arrays,0, arrays.length-1 );
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i]);
        }

    }
}
 