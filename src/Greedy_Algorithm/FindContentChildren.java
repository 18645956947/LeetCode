package Greedy_Algorithm;

import java.util.Arrays;

/**
 * 455. ·Ö·¢±ı¸É
 * @author zhx
 */
public class FindContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = g.length-1;
        int si = s.length-1;
        int res = 0;
        while(gi >=0 && si >= 0){
            if(s[si] >= g[gi]){
                si--;
                gi--;
                res++;
            }
            else{
                gi--;
            }
        }
        return res;
    }
}
