package Sort;

/**
 * 插入排序
 * @author zhx
 */
public class InsertionSortTest {

    public static void insertSort(int[] arr){
        //假设i前面的已经排好序了，现在要把i位置这个数插入到前面中并且保证前面的数再次排好序
        //i从1开始意思是0~0的位置已经排好序了
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >=0 && arr[j] > arr[j + 1] ; j--) {
                swap(arr, j, j+1);
            }
        }
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{4,2,6,1,3};
        InsertionSortTest.insertSort(a);
        for (int i : a) {
            System.out.print(i);
        }
    }
}
