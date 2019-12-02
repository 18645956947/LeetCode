package Coding_Interviews;

/**
 * ��ָoffer - �����е������
 * @author zhx
 */
public class �����е������ {

    public int res = 0;
    public int InversePairs(int [] array) {
        if(array == null || array.length <= 1){
            return 0;
        }
        mergeProcess(array, 0, array.length - 1);
        return res ;
    }
    private void mergeProcess(int[] arr, int L, int R){
        if(L == R){
            return ;
        }
        int mid = L + ((R - L) >> 1);
        mergeProcess(arr, L, mid);
        mergeProcess(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }
    private int merge(int[] arr, int L ,int mid, int R){
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        int[] tem = new int[R - L + 1];
        while(p1 <= mid && p2 <= R){
            res += arr[p1] > arr[p2] ? (mid - p1 + 1) : 0;
            //�ʼ �ҾͿ�������������д���ͺ�ʹ�ˡ�
            res = res > 1000000007? res % 1000000007 : res;
            tem[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while(p1 <= mid){
            tem[i++] = arr[p1++];
        }
        while(p2 <= R){
            tem[i++] = arr[p2++];
        }
        for(int j = 0;j < tem.length;j++){
            arr[L + j] = tem[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int data[] = { 4, 3, 3, 1, 8, 4 };
        �����е������ ss = new �����е������();
        System.out.println(ss.InversePairs(data));
    }
}
