package Greedy_Algorithm;

/**
 * 392. �ж�������
 * @author zhx
 * ����̰���㷨��ÿ�αȽϵ�ǰ�������µ�ֵ
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int s_index = 0;
        int t_index = 0;
        int res = 0;
        while (s_index < s.length() && t_index < t.length()) {
            if (s.charAt(s_index) == t.charAt(t_index)) {
                t_index++;
                s_index++;
                res++;
            } else {
                t_index++;
            }
        }
        if (res == s.length()) {
            return true;
        }
        return false;
    }
}
