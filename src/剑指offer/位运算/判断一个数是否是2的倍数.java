package 剑指offer.位运算;

/**
 * 剑指offer - 判断一个数是否是2的倍数
 * @author zhx
 * 自己与自己-1进行与位与操作，如果结果与自己-1相等那么就不是2的倍数
 */
public class 判断一个数是否是2的倍数 {
    public static boolean isTwo(int n){
        int m = n - 1;
        n = n & m;
        if(n == m){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(判断一个数是否是2的倍数.isTwo(99));
        System.out.println(new Float(0));
        System.out.println(Math.abs(-1));
    }
}
