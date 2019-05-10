package Array;

/**
 * 191. 位1的个数
 * @author zhx
 */
public class HammingWeight {
    // you need to treat n as an unsigned value
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
}
