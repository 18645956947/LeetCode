package Coding_Interviews;

import java.util.HashMap;
import java.util.Map;

/**
 * ��ָoffer--���������������г��ֵĴ���
 * @author zhx
 */
public class ���������������г��ֵĴ��� {

    public int GetNumberOfK(int [] array , int k) {
        Map<Integer, Integer> map =  new HashMap();
        for(int i = 0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.put(array[i], map.get(array[i]) + 1);
            }
            else {
                map.put(array[i], 1);
            }
        }
        if(map.containsKey(k)){
            return map.get(k);
        }
        else{
            return 0;
        }
    }
}
