package string;

/**
 * 3. ���ظ��ַ�����Ӵ�
 * @author zhx
 */
public class LengthOfLongestSubstring {
    /**
     * ִ����ʱ :
     * 7 ms
     * , ������Java�ύ�л�����
     * 99.41%
     * ���û�
     * �ڴ����� :
     * 35.2 MB
     * , ������Java�ύ�л�����
     * 99.86%
     * ���û�
     */
    //�������� Ϊs[l...r]
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
