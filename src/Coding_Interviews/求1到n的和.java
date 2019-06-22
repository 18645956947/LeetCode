package Coding_Interviews;

/**
 * 剑指offer--求1+2+3+...+n
 * @author zhx
 */
public class 求1到n的和 {
    public int Sum_Solution(int n) {
        int sum = (int) Math.pow(n, 2) + n;
        return sum >> 1;

    }
}
