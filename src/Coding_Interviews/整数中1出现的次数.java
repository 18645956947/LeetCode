package Coding_Interviews;

/**
 * ��ָoffer -- ������1���ֵĴ���
 * @author zhx
 */
public class ������1���ֵĴ��� {
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
        int a = ������1���ֵĴ���.NumberOf1Between1AndN_Solution(10);
        System.out.println(a);
    }
}
