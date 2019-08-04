package Coding_Interviews;

/**
 * 剑指offer -- 构建乘积数组
 * @author
 * zhx
 */
public class 构建乘积数组 {

    public int[] multiply(int[] A) {
        int k = 1;
        int[] res = new int[A.length];

        for(int i = 0;i < A.length;i++){
            res[i] = k;   // res[i]存储的是i左边的乘积
            k = k*A[i];
        }
        k = 1;
        for(int i = A.length-1;i>=0;i--){
            res[i] *= k; // k为i右边的乘积   res[i]存储的是i左边的乘积*右边的乘积
            k = k*A[i]; // k为i右边的乘积
        }
        return res;
    }
}
