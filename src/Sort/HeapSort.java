package Sort;

import java.util.Arrays;

/**
 *
 */
public class HeapSort {

    public static void heapSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            //建堆的过程
            heapInsert(arr, i);
        }
        System.out.println("此时堆内的结构就是：");
        for (int i:arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //此时堆的个数就是数组的大小
        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0){
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }

    }

    /**
     * 给一个数组 创建堆
     * @param arr
     * @param index
     */
    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    /**
     *  当堆内元素的大小变小的时候需要调整堆的结构的时候
     * @param arr 给的数组
     * @param index 变化的元素位置
     * @param size 现在保持堆结构的元素个数
     */
    public static void heapify(int[] arr, int index, int size){
        int left = 2 * index +1;
        while (left < size){
            //找到左右两颗子树的最大值
            int largest = left +1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            //比较index 与largest 位置上的元素大小
            largest = arr[largest] > arr[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }
    public static void swap(int[] arr, int i, int j){
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        /*int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);
*/

        int[] aa = new int[]{3, 6, 1, 98, 55, 2};
        HeapSort.heapSort(aa);
        for (int i:aa) {
            System.out.print(i+" ");
        }
    }
}
