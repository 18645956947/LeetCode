package Coding_Interviews;

import java.util.LinkedList;

/**
 * ��ָoffer -- ԲȦ�����ʣ�µ���
 * @author zhx
 */
public class ԲȦ�����ʣ�µ��� {

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
        int a = ԲȦ�����ʣ�µ���.LastRemaining_Solution(10, 21);
        System.out.println(a);
    }
}
