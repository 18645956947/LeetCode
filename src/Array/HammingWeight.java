package Array;

/**
 * 191. 位1的个数
 * @author zhx
 */
public class HammingWeight {


    //5 ms	33.1 MB
    public int hammingWeight(int n) {
        int num = 0;
        String s = Integer.toBinaryString(n);
        int a = s.length();
        for(int i = 0;i<a;i++){
            if(s.charAt(i) == '1'){
                num += 1;
            }

        }
        return num;
    }

    //4 ms	33.7 MB
    public int hammingWeight_02(int n) {
        if(n == 0){
            return 0;
        }
        int count = 0;
        while((n & (n - 1)) != 0){//如果n & (n - 1)不等于0，说明n中还有1
            count++;
            n = n & (n - 1);
        }
        count++;//若原整数只有一个1，那么没进入循环体就结束了，所以此处要count++
        return count;
    }

    //位运算
    //执行用时 : 3 ms, 在Number of 1 Bits的Java提交中击败了94.90% 的用户
    //内存消耗 : 32.8 MB, 在Number of 1 Bits的Java提交中击败了51.16% 的用户
    public int hammingWeight_03(int n) {
        int count = 0;
        for(int i = 0; i < 32; i++) {
            if((n & (1 << i - 1)) != 0)
                count++;
        }
        return count;
    }

}
