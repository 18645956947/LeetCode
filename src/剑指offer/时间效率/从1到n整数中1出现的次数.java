package ��ָoffer.ʱ��Ч��;

/**
 * ��ָoffer - ��1��n������1���ֵĴ���
 * @author zhx
 */
public class ��1��n������1���ֵĴ��� {
    //��򵥻����ķ���
    public static int NumberOf1Between1AndN_Solution_01(int n) {
        if(n <= 0){
            return 0;
        }
        int res = 0;
        for(int i = 1;i <= n;i++){
            res += get(i);
        }
        return res;
    }
    private static int get(int n){
        int num = 0;
        while(n != 0){
            if(n % 10 == 1){
                num++;
            }
            n = n / 10;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(��1��n������1���ֵĴ���.NumberOf1Between1AndN_Solution_01(12));
    }
}
