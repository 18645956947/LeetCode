package ��ָoffer.ʱ��ռ�Ч�ʵ�ƽ��;

import java.util.LinkedHashMap;

/**
 * ��ָoffer - ��һ��ֻ����һ�ε��ַ�
 * @author zhx
 */
public class ��һ��ֻ����һ�ε��ַ� {
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
        System.out.println(��һ��ֻ����һ�ε��ַ�.FirstNotRepeatingChar("aabcfgvb"));
    }
}
