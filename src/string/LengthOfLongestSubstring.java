package string;

/**
 * 3. 无重复字符的最长子串
 * @author zhx
 */
public class LengthOfLongestSubstring {
    /**
     * 执行用时 :
     * 7 ms
     * , 在所有Java提交中击败了
     * 99.41%
     * 的用户
     * 内存消耗 :
     * 35.2 MB
     * , 在所有Java提交中击败了
     * 99.86%
     * 的用户
     */
    //滑动窗口 为s[l...r]
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = -1;
        int res = 0;
        int[] freq = new int[256];

        while( l < s.length() ){
            if( r+1 < s.length() && freq[s.charAt(r+1)] == 0){
                r++;
                freq[s.charAt(r)] ++;
            }
            else{
                freq[s.charAt(l)] --;
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
