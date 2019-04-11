package Dynamic_Programming;

import java.util.*;

/**
 * 279. 完全平方数
 * @author zhx
 */
public class NumSquares {

    public int numSquares(int n) {
        if(n<=0)
            return 0;
        int[] a = new int[n+1];
        Arrays.fill(a, Integer.MAX_VALUE);
        a[0]=0;
        for(int i=0;i<=n;i++)
        {
            for(int j=1;j*j<=i;j++)
            {
                a[i]=Math.min(a[i], a[i-j*j]+1);
            }
        }
        return a[n];
    }
    public static void main(String[] args){
        NumSquares numSquares = new NumSquares();
        int a = numSquares.numSquares(5);
        System.out.println(a);
    }
}
