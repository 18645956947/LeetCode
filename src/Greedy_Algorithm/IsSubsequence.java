package Greedy_Algorithm;

/**
 * 392. 判断子序列
 * @author zhx
 * 类似贪心算法，每次比较当前的索引下的值
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
