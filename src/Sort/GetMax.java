package Sort;

/**
 * 从一个数组中得到最大的数
 * @author zhx
 */
public class GetMax {
    public static int getMax(int[] arr, int L, int R){
        if(L == R){
            return arr[L];
        }
        int mid = (L + R) >> 1;
        int leftMax = getMax(arr, L, mid);
        int rightMax = getMax(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,4,3, 7};
        System.out.println(GetMax.getMax(a, 0, 3));
    }
}
