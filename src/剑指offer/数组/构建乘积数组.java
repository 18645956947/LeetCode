package 剑指offer.数组;

/**
 * 剑指offer - 构建乘积数组
 * @author zhx
 */
public class 构建乘积数组 {
    public int[] multiply(int[] A) {
        int k = 1;
        int[] res = new int[A.length];

        for(int i = 0;i < A.length;i++){
            res[i] = k;
            k = k * A[i];
        }
        k = 1;
        for(int i = A.length - 1;i >=0;i--){
            res[i] *= k;
            k = k * A[i];
        }

        return res;
    }
}
