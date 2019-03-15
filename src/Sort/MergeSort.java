package Sort;

import java.math.RoundingMode;
import java.util.function.IntPredicate;

import javax.print.attribute.standard.MediaName;

/** 
* @author lenovo
* @date 2019��3��14������9:38:17 
* @Description: 
*/
public class MergeSort {
    /**
     *
     * @param arrays
     * @param L   ָ������ĵ�һ��Ԫ��
     * @param R	      ָ����������һ��Ԫ��
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
     * @param L		ָ������ĵ�һ��Ԫ��
     * @param M		ָ��������м��Ԫ��
     * @param R		ָ����������һ��Ԫ��
     */
    public static void merge(int[] arrays, int L,int M, int R) {
        //��ߵ������С
        int[] leftArrays = new int[M - L];
        //�ұߵ������С
        int[] rightArrays = new int[R - M  + 1];
        for (int i = L; i < M; i++) {
            leftArrays[i-L] = arrays[i];
        }
        for (int i = M; i <= R; i++) {
            rightArrays[i-M] = arrays[i];
        }

        int i = 0, j = 0;
        int K = L;
        //�Ƚ�����������Ĵ�С��ֱ֪��һ������Ϊ��Ϊֹ
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
        //������û�������ߵ�����������
        if(i < leftArrays.length){
            arrays[K] = leftArrays[i];
            i++;
            K++;
        }
        //����ұߵ�û������ұߵ�����������
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
 