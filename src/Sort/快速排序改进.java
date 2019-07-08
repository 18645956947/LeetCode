package Sort;

/**
 * �Ľ���������
 * @author zhx
 */
public class ��������Ľ� {

    public static void quickSort(int[] arr, int L, int R){
        if(L < R){
            swap(arr, L + (int)(Math.random() * (R - L + 1)), R);//�������о����������ʱ�临�Ӷ�ΪO��n*logn��
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0]-1);
            quickSort(arr, p[1]+1, R);
        }
    }

    private static int[] partition(int[] arr, int L, int R){
        //��ʵ����[ <x | =x | >x ]   [less | =x... | more]
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
