package Sort;

/**
 * 大于Num的放左边  等于放中间 大于放右边
 * @author zhx
 */
public class 荷兰国旗 {

    public static int[] partition(int[] arr, int L, int R, int num){
        int less = L - 1;
        int more= R + 1;
        int cur = L;
        while (cur < more){
            if(arr[cur] < num){
                swap(arr, cur++, ++less);
            }else if(arr[cur] > num){
                swap(arr, cur, --more);
            }else{
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }
    public static void swap(int[] arr, int i, int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 4,1, 5, 7, 3, 4};
        荷兰国旗.partition(a, 0, a.length - 1, 4);
        for (int i:a) {
            System.out.print(i);
        }
    }
}
