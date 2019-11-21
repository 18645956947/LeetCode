package Coding_Interviews;

/**
 * 剑指offer - 数组中的逆序对
 * @author zhx
 */
public class 数组中的逆序对 {

    public static int count;
    public static int InversePairs(int [] array) {
        /*
        直观想出的方法：测试用例只通过50%
        int len = array.length;
        int p = 0;
        for(int i = 0;i<len - 1;i++){

            for(int j = i + 1;j<len;j++){
                if(array[j] < array[i]){
                    p++;
                }
            }
        }
        return p % 1000000007;*/
        if(array == null || array.length == 0){
            return 0;
        }
        int len = array.length;
        int[] copy = new int[len];
        sortMerge(array, 0, array.length - 1, copy);
        return count;

    }
    private static void sortMerge(int[] a, int first, int last, int[] temp){
        if(first < last){
            int mid = (first + last) >> 1;
            sortMerge(a, first, mid, temp);
            sortMerge(a, mid + 1, last, temp);
            //最后合并两个有序数组
            mergeArray(a, first, mid, last, temp);
        }
    }
    private static void mergeArray(int[] a, int first, int mid, int last, int[] temp){
        int i = first, j = mid + 1;
        int m = mid, n = last;
        int k = 0;
        while(i <= m && j<=n){
            if(a[i] > a[j]){
                temp[k++] = a[j++];
                count += mid - i + 1;
            }
            else{
                temp[k++] = a[i++];
            }
        }
        while (i <= m){
            temp[k++] = a[i++];
        }
        while (j <= n){
            temp[k++] = a[j++];
        }
        for (int l = 0; l < k; l++) {
            a[first + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int data[] = { 4, 3, 2, 1 };
        System.out.println(数组中的逆序对.InversePairs(data));

    }
}
