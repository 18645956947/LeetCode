package Sort;

/**
 * 改进快速排序
 * @author zhx
 */
public class 快速排序改进 {

    public static void quickSort(int[] arr, int L, int R){
        if(L < R){
            swap(arr, L + (int)(Math.random() * (R - L + 1)), R);//加上这行就是随机快排时间复杂度为O（n*logn）
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0]-1);
            quickSort(arr, p[1]+1, R);
        }
    }

    private static int[] partition(int[] arr, int L, int R){
        //其实就是[ <x | =x | >x ]   [less | =x... | more]
        int less = L-1;
        int more = R+1;
        int target = arr[R];
        while (L < more){
            if(arr[L] < target){
                swap(arr, L++, ++less);
            }else if(arr[L] > target){
                swap(arr, L, --more);
            }else{
                L++;
            }
        }
        return new int[]{less + 1, more-1};
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 8, 5, 5, 9, 10, 4, 3};
        quickSort(arr, 0, arr.length-1);
        for (int a:arr) {
            System.out.println(a);
        }
    }
}
