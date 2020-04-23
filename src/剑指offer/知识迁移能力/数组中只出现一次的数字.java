package 剑指offer.知识迁移能力;

/**
 * 剑指offer - 数组中只出现一次的数字
 * @author zhx
 */
public class 数组中只出现一次的数字 {
    public int[] num1 = new int[0];
    public int[] num2 = new int[0];
    public int[] FindNumsAppearOnce(int [] array) {
        int[] aa = new int[2];
        if(array == null || array.length == 0){
            return aa;
        }
        if(array.length == 2){
            aa[0] = array[0];
            aa[1] = array[1];
            return aa;
        }
        int res = 0;
        for(int i = 0;i < array.length;i++){
            res ^= array[i];
        }
        int index = findFirst(res);
        for(int i = 0;i < array.length;i++){
            if(isBit1(array[i], index)){
                aa[0] ^= array[i];
            }else{
                aa[1] ^= array[i];
            }
        }
        return aa;
    }
    public int findFirst(int num){
        int bitIndex = 0;
        while( ((num & 1) == 0) && bitIndex < 32){
            num = num >> 1;
            bitIndex++;
        }
        return bitIndex;

    }
    public boolean isBit1(int num, int index){
        num = num >> index;
        return (num & 1) == 1;
    }
    public static void main(String[] args) {
        int[] a = new int[]{2,3,6,7,2,7,1,3};
        数组中只出现一次的数字 bb = new 数组中只出现一次的数字();
        int[] res = bb.FindNumsAppearOnce(a);
        for (int i:res) {
            System.out.println(i);
        }
        System.out.println(1 << 0);
        System.out.println(1 << 1);
        System.out.println(1 << 1);
    }
}
