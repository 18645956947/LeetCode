package Coding_Interviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ��ָoffer--�ַ����е�һ�����ظ����ַ�
 * @author zhx
 */
public class �ַ����е�һ�����ظ����ַ� {

    //�÷�������������һ����ϣ�� key���ַ�value�ǳ��ֵĴ���
    //������һ��list�洢���е��ַ� ���ڴ�����ȡ������map���Ԫ����Ƚ�
    //�������һ���ַ���value��1�Ļ�ֱ�� break ����ǵ�һ�����ظ����ַ�
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
