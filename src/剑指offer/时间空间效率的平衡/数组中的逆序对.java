package 剑指offer.时间空间效率的平衡;

public class 数组中的逆序对 {
    public int count = 0;
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        process(array, 0, array.length - 1);
        return this.count;
    }

    private void process(int[] array, int l, int r){
        if(l == r){
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(array, l, mid);
        process(array, mid + 1, r);
        merge(array, l, mid, r);
    }
    private void merge(int[] array, int l, int mid, int r){
        int i = 0;
        int p1 = l;
        int p2 = mid+1;
        int[] help = new int[r - l + 1];
        while(p1 <= mid && p2 <= r ){
            count += array[p1] > array[p2] ? (mid - p1 + 1) : 0;
            help[i++] = array[p1] > array[p2] ? array[p2++] : array[p1++];
        }
        while(p1<= mid){
            help[i++] = array[p1++];
        }
        while(p2 <= r){
            help[i++] = array[p2++];
        }
        for(int j = 0;j < help.length;j++){
            array[l + j] = help[j];
        }
    }

    public static void main(String[] args) {
        数组中的逆序对 a = new 数组中的逆序对();
        int[] b = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(a.InversePairs(b) % 1000000007);
    }
}
