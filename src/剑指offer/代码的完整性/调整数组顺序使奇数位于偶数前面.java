package 剑指offer.代码的完整性;

/**
 * 剑指offer - 调整数组顺序使奇数位于偶数前面
 * @author zhx
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public void reOrderArray(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        for(int i = 1;i < array.length;i++){
            for(int j = i - 1;j >= 0;j--){
                int a = array[j] & 1;
                int b = array[j+1] & 1;
                if(a==0 && b==1){
                    swap(array, j, j + 1);
                }
            }
        }
    }
    public void swap(int[] arr, int a, int b){
        int tem = arr[a];
        arr[a] = arr[b];
        arr[b] = tem;
    }

    public static void main(String[] args) {
        int[] a  = new int[2];
        a[0] = 4;
        a[1] = 5;
        System.out.println(a[1] & 1);
    }
}
