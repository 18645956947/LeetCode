package string;

/** 
* @author ZHX
* @date 2019��3��15������2:08:57 
* @Description: 14. �����ǰ׺
* 
*/
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length<=1) {
			return "";
		}
		String temp = strs[0];
		for(int i = 0;i<strs.length;i++) {
			if(temp.length()>strs[i].length()) {
				temp = strs[i];
			}
		}
		for(int i = temp.length();i>0;i--) {
			boolean mz = true;
			temp = temp.substring(0, i);
			for(int j = 0;j<strs.length;j++) {
				mz = mz&&strs[j].substring(0, j).equals(temp);
			}
			if(mz) {
				System.out.println("������" + temp);
				return temp;
			}
		}
		return "";
    }
	public static void main(String[] args) {
		String[] str = new String[] {"flo", "fltty","fl8g"};
		LongestCommonPrefix solution = new LongestCommonPrefix();
		solution.longestCommonPrefix(str);
	}
}
 