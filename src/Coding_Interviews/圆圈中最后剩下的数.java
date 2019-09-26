package Coding_Interviews;

import java.util.LinkedList;

/**
 * 剑指offer -- 圆圈中最后剩下的数
 * @author zhx
 */
public class 圆圈中最后剩下的数 {

    public static int LastRemaining_Solution(int n, int m) {
        if(n <= 0){
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int b = 0;
        while (list.size() > 1){
            b = (b + m - 1) % list.size();
            list.remove(b);
        }
        return list.size() == 1 ? list.get(0):-1;
    }

    public static void main(String[] args) {
        int a = 圆圈中最后剩下的数.LastRemaining_Solution(10, 21);
        System.out.println(a);
    }
}
