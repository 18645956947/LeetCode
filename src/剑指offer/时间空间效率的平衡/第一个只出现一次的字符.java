package 剑指offer.时间空间效率的平衡;

import java.util.LinkedHashMap;

/**
 * 剑指offer - 第一个只出现一次的字符
 * @author zhx
 */
public class 第一个只出现一次的字符 {
    public static int FirstNotRepeatingChar(String str) {
        if(str == null || str.length()==0) return -1;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }else{
                map.put(ch, 1);
            }
        }
        if(map.size() <=0) return -1;
        for(int i = 0; i < str.length();i++){
            char ch = str.charAt(i);
            if(map.get(ch) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(第一个只出现一次的字符.FirstNotRepeatingChar("aabcfgvb"));
    }
}
