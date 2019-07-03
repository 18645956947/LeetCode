package Coding_Interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指offer--字符流中第一个不重复的字符
 * @author zhx
 */
public class 字符流中第一个不重复的字符 {

    //该方法就是先利用一个哈希表 key是字符value是出现的次数
    //再利用一个list存储所有的字符 用于从里面取出来跟map里的元素相比较
    //如果碰到一个字符的value是1的话直接 break 这就是第一个不重复的字符
    //Insert one char from stringstream
    Map<Character, Integer> map = new HashMap();
    List<Character> list = new ArrayList();

    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            map.put(ch, map.get(ch)+1);
        }else{
            map.put(ch, 1);
        }
        list.add(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char c = '#';
        for(char cc : list){
            if(map.get(cc) == 1){
                c = cc;
                break;
            }
        }
        return c;
    }
}
