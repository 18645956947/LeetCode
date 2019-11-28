package Sort;

/**
 * ��������
 * @author zhx
 */
public class InsertionSortTest {

    public static void insertSort(int[] arr){
        //����iǰ����Ѿ��ź����ˣ�����Ҫ��iλ����������뵽ǰ���в��ұ�֤ǰ������ٴ��ź���
        //i��1��ʼ��˼��0~0��λ���Ѿ��ź�����
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
