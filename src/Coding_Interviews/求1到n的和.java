package Coding_Interviews;

/**
 * ��ָoffer--��1+2+3+...+n
 * @author zhx
 */
public class ��1��n�ĺ� {
    public int Sum_Solution(int n) {
        int sum = (int) Math.pow(n, 2) + n;
        return sum >> 1;

    }
}
