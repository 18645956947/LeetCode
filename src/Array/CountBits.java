package Array;

/**
 * 338. 比特位计数
 * @author zhx
 */
public class CountBits {
    //分为奇数偶数来说运算，奇数的二进制的1的个数是他前一位也就是偶数的个数
    //偶数的个数是偶数除2的个数
    //详见https://leetcode-cn.com/problems/counting-bits/solution/hen-qing-xi-de-si-lu-by-duadua/ 这位大佬的解题思路
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i = 1;i<=num;i++){
            if(i % 2 == 1){
                //代表为奇数
                res[i] = res[i-1]+1;
            }
            else{
                res[i] = res[i/2];
            }
        }
        return res;

    }
}
