package string;

import java.util.LinkedHashMap;
import java.util.Map;

/** 
* @author ZHX
* @date 2019年3月15日下午2:10:00 
* @Description: 387. 字符串中的第一个唯一字符
* 
*/
public class FirstUniqChar {
	public int firstUniqChar(String s) {
		char[] ch = s.toCharArray();
		for(int i = 0;i<ch.length;i++) {
			boolean isUnique = true;
			for(int j = 0;j<ch.length;j++) {
				if(i != j&&ch[i] == ch[j]) {
					isUnique = false;
					break;
				}
			}
			if(isUnique) {
				return i;
			}
		}
		
		return -1;
	}
	
	//Map实现字符串中的第一个唯一字符
	public int firstUniqChar_(String s) {
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		char[] ch=s.toCharArray();
		for(int i = 0;i<ch.length;i++) {
			if(!map.containsKey(ch[i])) {
				map.put(ch[i], i);
			}
			map.put(ch[i], -1);
		}
		for(Map.Entry<Character,Integer> entry : map.entrySet()) {
			if(entry.getValue() != -1) {
				System.out.println(entry.getKey());
				return entry.getKey();
			}
		}
		return -1;    
    }
}
 