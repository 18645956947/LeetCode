package string; 

/** 
* @author ZHX
* @date 2019年3月15日下午2:13:16 
* @Description: 28. 实现strStr()
*/
public class StrStr {
	public int strStr(String haystack, String needle) {
		if(needle.isEmpty()){
            return 0;
        }
		else if(haystack.length() < needle.length()) {
        	return -1;
        }
		int dis = haystack.length() - needle.length();
        for(int i = 0;i<=dis;i++) {
        	if(haystack.substring(i, i+needle.length()).equals(needle)) {
        		System.out.println(i);//"mississippi", "pi"
        		return i;
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		StrStr solution = new StrStr();
		solution.strStr("mississippi", "pi");
	}
}
 