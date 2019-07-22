package Coding_Interviews;

/**
 * 剑指offer -- 二进制中1的个数
 * @author zhx
 */
public class 二进制中1的个数 {

    public static int NumberOf1(int n) {
        String str = Integer.toBinaryString(n);
        int t = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i) == '1'){
                t++;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        System.out.println(二进制中1的个数.NumberOf1(234));
    }
}
