package Coding_Interviews;

/**
 * 剑指offer -- 整数中1出现的次数
 * @author zhx
 */
public class 整数中1出现的次数 {
    public static int NumberOf1Between1AndN_Solution(int n) {
        int ones = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n/m, b = n%m;
            if(a%10 == 0)
                ones += a / 10 * m;
            else if(a%10 == 1)
                ones += (a/10*m) + (b+1);
            else
                ones += (a/10+1)* m;
        }
        return ones;
    }

    public static void main(String[] args) {
        int a = 整数中1出现的次数.NumberOf1Between1AndN_Solution(10);
        System.out.println(a);
    }
}
