package 剑指offer.时间效率;

/**
 * 剑指offer - 从1到n整数中1出现的次数
 * @author zhx
 */
public class 从1到n整数中1出现的次数 {
    //最简单基础的方法
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
        System.out.println(从1到n整数中1出现的次数.NumberOf1Between1AndN_Solution_01(12));
    }
}
