package Coding_Interviews;

import java.util.LinkedHashMap;

/**
 * 剑指offer--第一个只出现一次的字符
 * @author zhx
 */
public class 第一个只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                int time = map.get(str.charAt(i));
                map.put(str.charAt(i), ++time);
            }
            else {
                map.put(str.charAt(i), 1);
            }
        }
        int pos = -1;
        int i=0;
        for(;i<str.length();i++){
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf(127) == Integer.valueOf(127));//true
        System.out.println(Integer.valueOf(128) == Integer.valueOf(128));//false
        System.out.println(new Integer(128).equals(128));//true
        System.out.println(Integer.parseInt("128"));//128
        System.out.println(Integer.valueOf(127).getClass());//Integer
        String str = "abcd";
        System.out.println(str.charAt(0));//"a"
        System.out.println(Character.valueOf(str.charAt(0)).getClass());//'a'
    }
}
