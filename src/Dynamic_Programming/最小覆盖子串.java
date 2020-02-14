package Dynamic_Programming;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. ��С�����Ӵ�
 * @author zhx
 */
public class ��С�����Ӵ� {

    public static String minWindow(String s, String t) {
        //�洢t�е��ַ�
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0;i < t.length();i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int l = 0;
        int r = 0;
        int len = Integer.MAX_VALUE;
        int res_l = 0;
        int res_r = -1;

        while (r < s.length()){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                //�Ѿ�������t��ȫ���ַ���
                while (match(map)) {
                    //��̬������̵ľ���
                    if (len > r - l + 1) {
                        res_l = l;
                        res_r = r;
                        len = r - l + 1;
                    }
                    if (map.containsKey(s.charAt(l))) {
                        map.put(s.charAt(l), map.get(s.charAt(l)) + 1);
                    }
                    l++;
                }
            }
            r++;
        }
        return s.substring(res_l, res_r + 1);
    }

    public static boolean match(Map<Character, Integer> map){
        for (Integer val: map.values()) {
            if(val > 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ABAACBAB";
        String t = "ACB";
        System.out.println(��С�����Ӵ�.minWindow(s, t));
    }
}
